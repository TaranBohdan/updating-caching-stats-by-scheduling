package com.bohdan.updatestatisticbycache.controller;

import com.bohdan.updatestatisticbycache.model.entity.SalesTrafficAsin;
import com.bohdan.updatestatisticbycache.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/statistic")
@RequiredArgsConstructor
public class StatisticController {

    private final StatisticService statisticService;

    @GetMapping("/byDate")
    @Cacheable(value = "statistics", key = "{#startDate, #endDate}", unless = "#result == null")
    public ResponseEntity<?> getByDate(@RequestParam @DateTimeFormat(pattern="yyyy-mm-dd") String startDate,
                                       @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-mm-dd") String endDate) {

        if (startDate != null && endDate == null) {
            var statisticByDate = statisticService.getByDate(startDate);
            return ResponseEntity.ok(statisticByDate);
        } else {
            return ResponseEntity
                    .ok(statisticService.getByDateRange(startDate, endDate));
        }
    }

    @GetMapping("/byAsin")
    @Cacheable(value = "statistics", key = "#asins", unless = "#result == null")
    public ResponseEntity<?> getByAsin(@RequestBody List<String> asins) {

        List<SalesTrafficAsin> statisticByAsins = new ArrayList<>();

        for (String asin : asins) {
            statisticByAsins.add(statisticService.getByAsin(asin));
        }

        return ResponseEntity
                .ok(statisticByAsins);
    }

    @GetMapping("/byDateAll")
    @CachePut(value = "statistics", unless = "#result == null")
    public ResponseEntity<?> getAllByDate() {
        return ResponseEntity.ok(statisticService.getByDateAll());
    }

    @GetMapping("/byAsinAll")
    @CachePut(value = "statistics", unless = "#result == null")
    public ResponseEntity<?> getAllByAsin() {
        return ResponseEntity.ok(statisticService.getByAsinAll());
    }
}