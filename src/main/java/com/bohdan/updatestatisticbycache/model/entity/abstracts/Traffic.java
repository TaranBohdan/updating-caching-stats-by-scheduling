package com.bohdan.updatestatisticbycache.model.entity.abstracts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class Traffic {
    protected int browserSessions;
    protected int browserSessionsB2B;
    protected int mobileAppSessions;
    protected int mobileAppSessionsB2B;
    protected int mobileAppPageViews;
    protected int mobileAppPageViewsB2B;
    protected int sessions;
    protected int sessionsB2B;
    protected int browserPageViews;
    protected int browserPageViewsB2B;
    protected int pageViews;
    protected int pageViewsB2B;
    protected double buyBoxPercentage;
    protected double buyBoxPercentageB2B;
    protected double unitSessionPercentage;
    protected int unitSessionPercentageB2B;
}
