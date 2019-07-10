package com.github.arturkh.activity.schedule;

import java.time.LocalDate;

public class ScheduleWeekend implements Schedule {
    @Override  public boolean isActive(LocalDate localDate) {
        return true;
    }
}

