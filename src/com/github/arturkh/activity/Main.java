package com.github.arturkh.activity;

import com.github.arturkh.activity.knowledgeSource.Internship;
import com.github.arturkh.activity.knowledgeSource.KnowledgeSource;
import com.github.arturkh.activity.knowledgeSource.University;
import com.github.arturkh.activity.schedule.Schedule;
import com.github.arturkh.activity.schedule.SchedulePeriod;
import com.github.arturkh.activity.schedule.ScheduleWeekend;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        LocalDate dateFrom = LocalDate.now();
        HashMap<KnowledgeSource, ArrayList<Schedule>> plan = new HashMap<>();
        HashMap<Student, List<LocalDate>> studentPlan = new HashMap<>();
        ArrayList<Schedule> listOfSchedules = new ArrayList<>();

        Student grisha = new Student(false, "Grisha", 0.4, true, false);
        Student vasiliy = new Student(false, "Vasiliy", 0.6, false, true);
        Student oksana = new Student(false, "Oksana", 0.8, true, false);

        List<LocalDate> period = dateFrom.datesUntil(LocalDate.of(2024, Month.JANUARY, 21)).collect(Collectors.toList());

        listOfSchedules.add(new SchedulePeriod(period));
        listOfSchedules.add(new ScheduleWeekend());

        plan.put(new Internship(), listOfSchedules);
        plan.put(new University(), listOfSchedules);

        studentPlan.put(grisha, period);
        studentPlan.put(vasiliy, period);
        studentPlan.put(oksana, period);

        DevPlan consciousStudent = new DevPlan();
        consciousStudent.setDevPlan(plan);
        consciousStudent.perform(studentPlan);

        System.out.println("Student name - " + oksana.getName() + " Student knowledge " + oksana.getKnowledge() + " Student practice  " + oksana.getPractice());
    }
}
