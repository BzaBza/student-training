package com.github.arturkh.activity;

import com.github.arturkh.activity.knowledgeSource.Internship;
import com.github.arturkh.activity.knowledgeSource.KnowledgeSource;
import com.github.arturkh.activity.knowledgeSource.University;
import com.github.arturkh.activity.schedule.SchedulePeriod;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        LocalDate dateFrom = LocalDate.now();
        HashMap<KnowledgeSource, SchedulePeriod> plan = new HashMap<>();
        HashMap<Student, Period> studentPlan = new HashMap<>();

        Student grisha = new Student(false, "Grisha", 0.4, true, false);
        Student vasiliy = new Student(false, "Vasiliy", 0.6, false, true);
        Student oksana = new Student(false, "Oksana", 0.8, true, false);

        Period afterFiveYears = Period.between(dateFrom, LocalDate.of(2024, Month.JANUARY, 21));
        plan.put(new Internship(), new SchedulePeriod(afterFiveYears));
        plan.put(new University(), new SchedulePeriod(afterFiveYears));
        studentPlan.put(grisha, afterFiveYears);
        studentPlan.put(vasiliy, afterFiveYears);
        studentPlan.put(oksana, afterFiveYears);

        DevPlan consciousStudent = new DevPlan(plan);
        consciousStudent.perform(studentPlan);

        System.out.println("Student name - "+oksana.getName() +" Student knowledge " + oksana.getKnowledge() + " Student practice  " + oksana.getPractice());
    }
}
