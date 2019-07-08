package com.github.arturkh.activity.schedule;

import java.time.LocalDate;
import java.time.Period;

public class ScheduleNegation implements Schedule {
    public ScheduleNegation(LocalDate date) {
    }

    @Override
    public boolean isActive(Period localDate) {
        return true;
    }
}
