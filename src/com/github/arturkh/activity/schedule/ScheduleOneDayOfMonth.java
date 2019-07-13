package com.github.arturkh.activity.schedule;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class ScheduleOneDayOfMonth implements Schedule {
    private DayOfWeek day;

    public ScheduleOneDayOfMonth(DayOfWeek day) {
        this.day = day;
    }

    @Override
    public boolean isActive(LocalDate localDate) {
        if (localDate.getDayOfMonth() > 21){
            return localDate.getDayOfWeek() == day;
        }
        return false;
    }
}
