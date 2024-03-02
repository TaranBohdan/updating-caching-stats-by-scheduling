package com.bohdan.updatestatisticbycache.model.entity.abstracts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public abstract class SalesTraffic {
    @Id
    private String id;
}
