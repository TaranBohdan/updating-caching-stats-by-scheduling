package com.bohdan.updatestatisticbycache.model.entity;

import com.bohdan.updatestatisticbycache.model.entity.abstracts.ProductStatistic;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderedProductSalesB2B extends ProductStatistic {
    @Override
    public String toString() {
        return "OrderedProductSalesB2B{" +
                "amount=" + amount +
                ", currencyCode='" + currencyCode + '\'' +
                '}';
    }
}
