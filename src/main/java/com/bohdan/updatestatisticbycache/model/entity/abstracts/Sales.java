package com.bohdan.updatestatisticbycache.model.entity.abstracts;

import com.bohdan.updatestatisticbycache.model.entity.OrderedProductSales;
import com.bohdan.updatestatisticbycache.model.entity.OrderedProductSalesB2B;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public abstract class Sales {
    protected int unitsOrdered;
    protected int unitsOrderedB2B;
    protected OrderedProductSales orderedProductSales;
    protected OrderedProductSalesB2B orderedProductSalesB2B;
    protected int totalOrderItems;
    protected int totalOrderItemsB2B;
}
