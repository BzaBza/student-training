package com.github.arturkh.activity;

import com.github.arturkh.activity.knowledgeSource.Internship;
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
        HashMap<Student, List<LocalDate>> studentPlan = new HashMap<>();
        ArrayList<Schedule> listOfSchedules = new ArrayList<>();

        Student grisha = new Student("Grisha", false, 0.4);
        Student vasiliy = new Student("Vasiliy", false, 0.6);
        Student oksana = new Student("Oksana", false, 1.0);

        List<LocalDate> period = dateFrom.datesUntil(LocalDate.of(2019, Month.JULY, 10)).collect(Collectors.toList());

        listOfSchedules.add(new SchedulePeriod(period));
        listOfSchedules.add(new ScheduleWeekend());

        studentPlan.put(grisha, period);
        studentPlan.put(vasiliy, period);
        studentPlan.put(oksana, period);

        DevPlan consciousStudent = new DevPlan();
        consciousStudent.addActivity(new Internship(), listOfSchedules);
        consciousStudent.addActivity(new University(), listOfSchedules);

        System.out.println("Student name - " + oksana.getName() + " Student knowledge " + oksana.getKnowledge() + " Student practice  " + oksana.getPractice());
    }
}
