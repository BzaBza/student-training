package com.github.arturkh.activity.schedule;

import java.time.LocalDate;
import java.util.List;

public class SchedulePeriod implements Schedule {
    List<LocalDate> period;

    public SchedulePeriod(List<LocalDate> period) {
        this.period = period;
    }

    @Override
    public boolean isActive(LocalDate localDate) {
        boolean isThisDayInPeriod = false;
        for (int i = 0 ; i < period.size(); i++){
            isThisDayInPeriod = period.get(i) == localDate;
        }
        return isThisDayInPeriod;
    }
}
