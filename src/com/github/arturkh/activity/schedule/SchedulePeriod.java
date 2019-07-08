package com.github.arturkh.activity.schedule;

import java.time.Period;

public class SchedulePeriod implements Schedule {

    public SchedulePeriod(Period afterFiveYears) {
    }

    @Override
    public boolean isActive(Period localDate) {
        return true;
    }
}
