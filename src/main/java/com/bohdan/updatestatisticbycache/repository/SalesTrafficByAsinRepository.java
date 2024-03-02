package com.bohdan.updatestatisticbycache.repository;

import com.bohdan.updatestatisticbycache.model.entity.SalesTrafficAsin;
import com.bohdan.updatestatisticbycache.model.entity.SalesTrafficDate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface SalesTrafficByAsinRepository extends MongoRepository<SalesTrafficAsin, String> {

    @Query("{'parentAsin' : ?0}")
    Optional<SalesTrafficAsin> findByParentAsin(String asin);
}
