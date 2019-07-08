package com.github.arturkh.activity.schedule;

import java.time.Period;

public interface Schedule {
    boolean isActive(Period localDate);
}
