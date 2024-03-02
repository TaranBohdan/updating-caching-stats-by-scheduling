package com.bohdan.updatestatisticbycache.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class SalesAndTrafficReport {
    @JsonProperty("salesAndTrafficByDate")
    private List<SalesTrafficDate> salesTrafficDates;
    @JsonProperty("salesAndTrafficByAsin")
    private List<SalesTrafficAsin> salesTrafficAsins;
}
