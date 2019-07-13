package com.github.arturkh.activity.knowledgeSource;

import com.github.arturkh.activity.Student;

public class SelfEducation implements KnowledgeSource {
    private int knowledgeOfOneDay;
    private int practiceOfOneDay;
    public SelfEducation(int knowledgeOfOneDay, int practiceOfOneDay){
        this.knowledgeOfOneDay = knowledgeOfOneDay;
        this.practiceOfOneDay = practiceOfOneDay;
    }

    @Override
    public void educate(Student student){
        student.toStudy(knowledgeOfOneDay);
        student.toPractice(practiceOfOneDay);
    }
}
