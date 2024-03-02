package com.bohdan.updatestatisticbycache.model.entity;

import com.bohdan.updatestatisticbycache.model.entity.abstracts.ProductStatistic;
import lombok.*;

@AllArgsConstructor
public class AverageSalesPerOrderItem extends ProductStatistic {
    @Override
    public String toString() {
        return "AverageSalesPerOrderItem{" +
                "amount=" + amount +
                ", currencyCode='" + currencyCode + '\'' +
                '}';
    }
}
