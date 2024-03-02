package com.bohdan.updatestatisticbycache.service;

import com.bohdan.updatestatisticbycache.model.entity.*;
import com.bohdan.updatestatisticbycache.repository.SalesTrafficByAsinRepository;
import com.bohdan.updatestatisticbycache.repository.SalesTrafficByDateRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatisticService {

    private final SalesTrafficByDateRepository salesTrafficByDateRepository;
    private final SalesTrafficByAsinRepository salesTrafficByAsinRepository;
    private final MongoTemplate mongoTemplate;
    private final ObjectMapper objectMapper;
    private final CacheManager cacheManager;

    public SalesTrafficDate getByDate(String startDate) {
        return salesTrafficByDateRepository.findByDate(startDate);
    }

    public List<SalesTrafficDate> getByDateRange(String startDate, String endDate) {
        return salesTrafficByDateRepository.findByDateRange(startDate, endDate);
    }

    public SalesTrafficAsin getByAsin(String asin) {
        return salesTrafficByAsinRepository.findByParentAsin(asin).orElseThrow();
    }

    public List<SalesTrafficDate> getByDateAll() {
        return salesTrafficByDateRepository.findAll();
    }

    public List<SalesTrafficAsin> getByAsinAll() {
        return salesTrafficByAsinRepository.findAll();
    }

    @Scheduled(cron = "0 * * * * *")
    @CachePut("statistics")
    public void update() throws IOException {
        log.info("-------------------------------------------------------");
        log.info("Updating data...");
        clearCache("statistics");

        File jsonFile = new File("test_report.json");

        SalesAndTrafficReport salesAndTrafficReport = objectMapper.readValue(jsonFile, SalesAndTrafficReport.class);

        List<SalesTrafficDate> salesTrafficDates = salesAndTrafficReport.getSalesTrafficDates();
        List<SalesTrafficAsin> salesTrafficAsins = salesAndTrafficReport.getSalesTrafficAsins();

        for (SalesTrafficDate data : salesTrafficDates) {
            String date = data.getDate();
            Query query = new Query(Criteria.where("date").is(date));
            mongoTemplate.findAndReplace(query, data);
        }

        for (SalesTrafficAsin data : salesTrafficAsins) {
            String parentAsin = data.getParentAsin();
            Query query = new Query(Criteria.where("parentAsin").is(parentAsin));
            mongoTemplate.findAndReplace(query, data);
        }

        log.info("Data was updated");
    }

    public void clearCache(String cacheName) {
        cacheManager.getCache(cacheName).clear();
    }
}
