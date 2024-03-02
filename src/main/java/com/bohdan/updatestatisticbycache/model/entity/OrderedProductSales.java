package com.bohdan.updatestatisticbycache.model.entity;

import com.bohdan.updatestatisticbycache.model.entity.abstracts.ProductStatistic;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderedProductSales extends ProductStatistic {
    @Override
    public String toString() {
        return "OrderedProductSales{" +
                "amount=" + amount +
                ", currencyCode='" + currencyCode + '\'' +
                '}';
    }
}
