package com.github.arturkh.activity.schedule;

import java.time.LocalDate;
import java.util.List;

public class SchedulePeriod implements Schedule {

    public SchedulePeriod(List<LocalDate> period) {
    }

    @Override
    public boolean isActive(LocalDate localDate) {
        return true;
    }
}
