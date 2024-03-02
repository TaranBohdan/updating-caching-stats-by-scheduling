package com.bohdan.updatestatisticbycache.model.entity;

import com.bohdan.updatestatisticbycache.model.entity.abstracts.ProductStatistic;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AverageSellingPrice extends ProductStatistic {
    @Override
    public String toString() {
        return "AverageSellingPrice{" +
                "amount=" + amount +
                ", currencyCode='" + currencyCode + '\'' +
                '}';
    }
}
