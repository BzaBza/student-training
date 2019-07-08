package com.github.arturkh.activity;

import com.github.arturkh.activity.knowledgeSource.KnowledgeSource;
import com.github.arturkh.activity.schedule.Schedule;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DevPlan {

    private HashMap<KnowledgeSource, List<Schedule>> plan = new HashMap<>();

    public void perform(HashMap<Student, List<LocalDate>> studentPlan) {
        for (Map.Entry<KnowledgeSource, List<Schedule>> entry : plan.entrySet()) {
            List<Schedule> schedules = entry.getValue();

            Schedule schedule = joinSchedules(schedules);

            Activity activity = new Activity(entry.getKey(), schedule);

            for (Map.Entry<Student, List<LocalDate>> inside : studentPlan.entrySet()) {
                for (int i = 0; i < inside.getValue().size(); i++) {
                    Student student = inside.getKey();
                    inside.getValue().size();
                    LocalDate day = inside.getValue().get(+0);
                    activity.tryToApply(student, day);
                }
            }
        }
    }

    private Schedule joinSchedules(List<Schedule> schedules) {
        return schedules.get(0);
    }

    public void addActivity(KnowledgeSource knowledgeSource, List<Schedule> schedules) {
        plan.put(knowledgeSource, schedules);
    }
}
