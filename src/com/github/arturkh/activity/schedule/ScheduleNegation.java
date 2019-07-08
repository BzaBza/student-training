package com.github.arturkh.activity.schedule;

import java.time.LocalDate;

public class ScheduleNegation implements Schedule {
    @Override
    public boolean isActive(LocalDate localDate) {
        return true;
    }
}
