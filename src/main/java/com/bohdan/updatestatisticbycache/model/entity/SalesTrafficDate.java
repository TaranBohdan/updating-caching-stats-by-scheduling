package com.bohdan.updatestatisticbycache.model.entity;

import com.bohdan.updatestatisticbycache.model.entity.abstracts.SalesTraffic;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Document(collection = "salesAndTrafficByDate")
public class SalesTrafficDate extends SalesTraffic {
    private String date;
    private SalesByDate salesByDate;
    private TrafficByDate trafficByDate;
}
