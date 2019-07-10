package com.github.arturkh.activity.schedule;

import java.time.LocalDate;

public class SchedulePeriod implements Schedule {
    private LocalDate firstDay;
    private LocalDate lastDay;

    public SchedulePeriod(LocalDate firstDay, LocalDate lastDay) {
        this.firstDay = firstDay;
        this.lastDay = lastDay;
    }

    @Override
    public boolean isActive(LocalDate localDate) {
        return !localDate.isBefore(firstDay) && !localDate.isAfter(lastDay);
    }
}
