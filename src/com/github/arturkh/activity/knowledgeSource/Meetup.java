package com.github.arturkh.activity.knowledgeSource;

import com.github.arturkh.activity.Student;

public class Meetup implements KnowledgeSource {
    private int knowledgeOfOneDay;
    private int practiceOfOneDay;
    private boolean isWithPractice;

    public Meetup(int knowledgeOfOneDay, int practiceOfOneDay, boolean isWithPractice) {
        this.knowledgeOfOneDay = knowledgeOfOneDay;
        this.practiceOfOneDay = practiceOfOneDay;
        this.isWithPractice = isWithPractice;
    }

    @Override
    public void educate(Student student) {
        student.toStudy(knowledgeOfOneDay);
        if (isWithPractice && student.hasLaptop()) {
            student.toPractice(practiceOfOneDay);
        }
    }
}
