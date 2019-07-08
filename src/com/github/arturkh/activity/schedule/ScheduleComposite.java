package com.github.arturkh.activity.schedule;

import java.time.LocalDate;

public class ScheduleComposite implements Schedule {
    private Schedule prevSchedule;
    private Schedule nextSchedule;


    public ScheduleComposite(Schedule prevSchedule, Schedule nextSchedule) {
        this.prevSchedule = prevSchedule;
        this.nextSchedule = nextSchedule;
    }

    @Override
    public boolean isActive(LocalDate localDate) {
        boolean isActive = false;
        if (prevSchedule.isActive(localDate) && nextSchedule.isActive(localDate)) isActive = true;
        return isActive;
    }
}
