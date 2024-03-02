package com.bohdan.updatestatisticbycache.model.entity;

import com.bohdan.updatestatisticbycache.model.entity.abstracts.ProductStatistic;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AverageSalesPerOrderItemB2B extends ProductStatistic {
    @Override
    public String toString() {
        return "AverageSalesPerOrderItemB2B{" +
                "amount=" + amount +
                ", currencyCode='" + currencyCode + '\'' +
                '}';
    }
}
