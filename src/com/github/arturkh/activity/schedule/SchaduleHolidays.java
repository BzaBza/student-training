package com.github.arturkh.activity.schedule;

import java.time.LocalDate;

public class SchaduleHolidays implements Schedule  {
    private LocalDate month;
    public SchaduleHolidays(LocalDate month){
        this.month = month;
    }
    @Override
    public boolean isActive(LocalDate localDate) {

        return false;
    }
}
