package com.github.arturkh.activity;

import com.github.arturkh.activity.knowledgeSource.KnowledgeSource;
import com.github.arturkh.activity.schedule.Schedule;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DevPlan {

    private List<Activity> activities = new ArrayList<>();

    public void perform(Student student, LocalDate date) {
        for (Activity activity : activities) {
            activity.tryToApply(student, date);
        }
    }

    private Schedule joinSchedules(List<Schedule> schedules) {
        return schedules.get(0);
    }

    public void addActivity(KnowledgeSource knowledgeSource, List<Schedule> schedules) {
        activities.add(new Activity(knowledgeSource, joinSchedules(schedules)));
    }
}
