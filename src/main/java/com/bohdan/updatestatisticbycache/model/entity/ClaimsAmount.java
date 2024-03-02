package com.bohdan.updatestatisticbycache.model.entity;

import com.bohdan.updatestatisticbycache.model.entity.abstracts.ProductStatistic;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ClaimsAmount extends ProductStatistic {
    @Override
    public String toString() {
        return "ClaimsAmount{" +
                "amount=" + amount +
                ", currencyCode='" + currencyCode + '\'' +
                '}';
    }
}
