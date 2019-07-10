package com.github.arturkh.activity.schedule;

import java.time.LocalDate;

public class ScheduleComposite implements Schedule {
    private Schedule first;
    private Schedule second;

    public ScheduleComposite(Schedule first, Schedule second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean isActive(LocalDate localDate) {
        return first.isActive(localDate) && second.isActive(localDate);
    }
}
