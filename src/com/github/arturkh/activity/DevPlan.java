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
        for (Activity activity : activities) {
            for (LocalDate date : dates){
                activity.tryToApply(student, date);
            }
        }
    }

    private Schedule joinSchedules(List<Schedule> schedules) {
        Schedule firstSchedule = null;
        Schedule nextSchedule = null;
        for (int i = 0; i < schedules.size(); i++){
           firstSchedule = schedules.get(i);
           nextSchedule = schedules.get(+0);
        }
        return new ScheduleComposite(firstSchedule, nextSchedule);
    }

    public void addActivity(KnowledgeSource knowledgeSource, List<Schedule> schedules) {
        activities.add(new Activity(knowledgeSource, joinSchedules(schedules)));
    }
}
