package com.github.arturkh.activity;

import com.github.arturkh.activity.knowledgeSource.KnowledgeSource;
import com.github.arturkh.activity.schedule.Schedule;
import com.github.arturkh.activity.schedule.ScheduleComposite;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DevPlan {

    private HashMap<KnowledgeSource, ArrayList<Schedule>> plan;

    void setDevPlan(HashMap<KnowledgeSource, ArrayList<Schedule>> plan) {
        this.plan = plan;
    }

    void perform(HashMap<Student, List<LocalDate>> studentPlan) {
        for (Map.Entry<KnowledgeSource, ArrayList<Schedule>> entry : plan.entrySet()) {
            Schedule schedule = null;
            for (int z = 0; z < entry.getValue().size(); z++) {
                Schedule prevSchedule = entry.getValue().get(z);
                Schedule nextSchedule = entry.getValue().get(z < entry.getValue().size() ? +1 : +0);
                schedule = new ScheduleComposite(prevSchedule, nextSchedule);
            }

            Activity activity = new Activity(entry.getKey(), schedule);

            for (Map.Entry<Student, List<LocalDate>> inside : studentPlan.entrySet()) {
                for (int i = 0; i <= inside.getValue().size(); i++) {
                    activity.tryToApply(inside.getKey(), inside.getValue().get(i != inside.getValue().size() ? +0 : +0));
                }
            }
        }
    }
}
