package com.github.arturkh.activity;

import com.github.arturkh.activity.knowledgeSource.KnowledgeSource;
import com.github.arturkh.activity.schedule.Schedule;

import java.time.LocalDate;

class Activity {
    private Schedule schedule;
    private KnowledgeSource knowledgeSource;

    Activity(KnowledgeSource knowledgeSource, Schedule schedule) {
        this.knowledgeSource = knowledgeSource;
        this.schedule = schedule;
    }

    void tryToApply(Student student, LocalDate date) {
        if (schedule.isActive(date)) {
            knowledgeSource.educate(student);
        }
    }
}
