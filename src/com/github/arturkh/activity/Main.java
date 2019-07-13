package com.github.arturkh.activity;

import com.github.arturkh.activity.knowledgeSource.Institutions;
import com.github.arturkh.activity.knowledgeSource.Meetup;
import com.github.arturkh.activity.knowledgeSource.SelfEducation;
import com.github.arturkh.activity.schedule.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
        Student oksana = new Student("Oksana", false, 1.0);
        Student grisha = new Student("Grisha", true, 1.0);
        LocalDate today = LocalDate.now();
        LocalDate firstDay = today;
        LocalDate lastDay = today.plusYears(5);
        LocalDate afterTwoYears = today.plusYears(2);

        List<LocalDate> period = today.datesUntil(lastDay).collect(Collectors.toList());

        SchedulePeriod universityPeriod = new SchedulePeriod(firstDay, lastDay);
        SchedulePeriod schedulePeriod = new SchedulePeriod(firstDay, afterTwoYears);
        ScheduleHolidays summer = new ScheduleHolidays(Month.JULY);
        ScheduleHolidays winter = new ScheduleHolidays(Month.DECEMBER);
        ScheduleWeekend scheduleWeekend = new ScheduleWeekend();
        Institutions university = new Institutions(2, 1);
        DevPlan pacifist = new DevPlan();
        university.enrollStudent(oksana);

        pacifist.addActivity(university, asList(universityPeriod, summer, winter, scheduleWeekend));
        pacifist.addActivity(university, asList(schedulePeriod, summer, winter, scheduleWeekend));
        pacifist.perform(oksana, period);

        System.out.println(oksana.getKnowledge() + "   " + oksana.getPractice());


        LocalDate firstDayInternship = today;
        LocalDate lastDayInternship = today.plusMonths(3);
        Meetup meetup = new Meetup(1,1, true);
        SelfEducation selfEducation = new SelfEducation(1,1);
        Institutions internship = new Institutions(1,1);
        internship.enrollStudent(grisha);
        DevPlan selfTaught = new DevPlan();

        ScheduleOneDayOfMonth scheduleOneDayOfMonth = new ScheduleOneDayOfMonth(DayOfWeek.FRIDAY);
        SchedulePeriod schedulePeriodInternship = new SchedulePeriod(firstDayInternship, lastDayInternship);
        selfTaught.addActivity(meetup, asList(scheduleOneDayOfMonth));
        selfTaught.addActivity(selfEducation, asList());
        selfTaught.addActivity(internship, asList(schedulePeriodInternship, scheduleWeekend));

        selfTaught.perform(grisha, period);

        System.out.println(grisha.getKnowledge() + "   " + grisha.getPractice());

    }
}
