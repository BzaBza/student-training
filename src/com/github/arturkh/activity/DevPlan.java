package com.github.arturkh.activity;

import com.github.arturkh.activity.knowledgeSource.KnowledgeSource;
import com.github.arturkh.activity.schedule.SchedulePeriod;

import java.time.Period;
import java.util.HashMap;
import java.util.Map;

class DevPlan {
    private Activity activity;

    DevPlan(HashMap<KnowledgeSource, SchedulePeriod> plan) {
        for(Map.Entry<KnowledgeSource, SchedulePeriod> entry: plan.entrySet())
            this.activity = new Activity(entry.getKey(), entry.getValue());
    }

    void perform(HashMap<Student, Period> studentPlan) {
        for(Map.Entry<Student, Period> entry: studentPlan.entrySet())
            activity.tryToApply(entry.getKey(), entry.getValue());
    }
}
