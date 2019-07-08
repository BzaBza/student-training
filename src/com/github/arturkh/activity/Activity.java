package com.github.arturkh.activity;

import com.github.arturkh.activity.knowledgeSource.KnowledgeSource;
import com.github.arturkh.activity.schedule.Schedule;
import com.github.arturkh.activity.schedule.SchedulePeriod;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;

class Activity {
    private Schedule schedule;
    private KnowledgeSource knowledgeSource;

    Activity(KnowledgeSource knowledgeSource, SchedulePeriod schedule) {
        this.knowledgeSource = knowledgeSource;
        this.schedule = schedule;
    }

    void tryToApply(Student student, Period period){
        if (schedule.isActive(period)){
            knowledgeSource.educate(student);
        }
    }
}
