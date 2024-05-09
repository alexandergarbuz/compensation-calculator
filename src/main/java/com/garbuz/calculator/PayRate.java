package com.garbuz.calculator;

import java.util.HashMap;
import java.util.Map;

public class PayRate {
    private static final Map<JobType, Double> hourlyRates = new HashMap<JobType, Double>();
    private static final Map<JobType, Double> bonusRate = new HashMap<JobType, Double>();

    static {
        hourlyRates.put(JobType.INTERN, 10.0);
        hourlyRates.put(JobType.FLOOR_WORKER, 20.0);
        hourlyRates.put(JobType.SUPERVISOR, 25.0);
        hourlyRates.put(JobType.MANAGER, 35.0);
        hourlyRates.put(JobType.EXECUTIVE, 50.0);
        
        bonusRate.put(JobType.MANAGER, 50.0);
        bonusRate.put(JobType.EXECUTIVE, 50.0);
    }

    public static Double getHourlyRate(final JobType jobType) {
        return hourlyRates.getOrDefault(jobType, 0.0);
    }
    public static Double getBonusRate(final JobType jobType) {
        return bonusRate.getOrDefault(jobType, 0.0);
    }
}
