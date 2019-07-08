package com.github.arturkh.activity.schedule;

import java.time.Period;

public class ScheduleWeekend implements Schedule {
    public ScheduleWeekend(Period period) {
    }

    @Override
    public boolean isActive(Period localDate) {
        return true;
    }
}
