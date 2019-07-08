package com.github.arturkh.activity.schedule;

import java.time.LocalDate;

public interface Schedule {
    boolean isActive(LocalDate localDate);
}
