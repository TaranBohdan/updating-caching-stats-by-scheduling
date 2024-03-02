package com.bohdan.updatestatisticbycache.repository;

import com.bohdan.updatestatisticbycache.model.entity.SalesTrafficDate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SalesTrafficByDateRepository extends MongoRepository<SalesTrafficDate, String> {
    @Query(value = "{'date' : ?0}")
    SalesTrafficDate findByDate(String date);

    @Query("{ 'date' : { $gte: ?0, $lte: ?1 } }")
    List<SalesTrafficDate> findByDateRange(String startDate, String endDate);
}
