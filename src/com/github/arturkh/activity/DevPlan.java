package com.github.arturkh.activity;

import com.github.arturkh.activity.knowledgeSource.KnowledgeSource;
import com.github.arturkh.activity.schedule.Schedule;
import com.github.arturkh.activity.schedule.ScheduleComposite;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DevPlan {

    private List<Activity> activities = new ArrayList<>();

    public void perform(Student student, List<LocalDate> dates) {
        for (LocalDate date : dates) {
            for (Activity activity : activities) {
                activity.tryToApply(student, date);
            }
        }
    }

    public void addActivity(KnowledgeSource knowledgeSource, List<Schedule> schedules) {
        activities.add(new Activity(knowledgeSource, joinSchedules(schedules)));
    }

    private Schedule joinSchedules(List<Schedule> schedules) {
        return schedules.stream().reduce(d -> true, ScheduleComposite::new);
    }
}
