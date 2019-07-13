package com.github.arturkh.activity.schedule;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ScheduleWeekend implements Schedule {
    private DayOfWeek saturday = DayOfWeek.SATURDAY;
    private DayOfWeek sunday = DayOfWeek.SUNDAY;

    @Override
    public boolean isActive(LocalDate localDate) {
        return sunday != localDate.getDayOfWeek() && saturday != localDate.getDayOfWeek();
    }
}

