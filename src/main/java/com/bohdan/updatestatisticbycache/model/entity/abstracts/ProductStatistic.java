package com.bohdan.updatestatisticbycache.model.entity.abstracts;

import com.bohdan.updatestatisticbycache.model.enumeration.CurrencyCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public abstract class ProductStatistic {
    protected double amount;
    protected CurrencyCode currencyCode;
}
