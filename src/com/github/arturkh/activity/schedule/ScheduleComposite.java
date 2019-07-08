package com.github.arturkh.activity.schedule;

import java.time.Period;

public class ScheduleComposite implements Schedule {
    @Override
    public boolean isActive(Period localDate) {
        return false;
    }
}
