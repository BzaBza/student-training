package com.github.arturkh.activity.schedule;

import java.time.LocalDate;
import java.time.Month;

public class ScheduleHolidays implements Schedule {
    private Month month;
    public ScheduleHolidays(Month month) {
        this.month = month;
    }

    @Override
    public boolean isActive(LocalDate localDate) {
        return month != localDate.getMonth();
    }
}
