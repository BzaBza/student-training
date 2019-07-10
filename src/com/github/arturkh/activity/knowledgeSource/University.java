package com.github.arturkh.activity.knowledgeSource;

import com.github.arturkh.activity.Student;

public class University implements KnowledgeSource {
    private int knowledgeOfOneDay;
    private int practiceOfOneDay;
    public void setKnowledgeOfOneDay(int knowledgeOfOneDay){
        this.knowledgeOfOneDay = knowledgeOfOneDay;
    }
    public void setPracticeOfOneDay(int practiceOfOneDay){
        this.practiceOfOneDay = practiceOfOneDay;
    }
    @Override
    public void educate(Student student) {
        student.setKnowledge(knowledgeOfOneDay);
        student.setPractice(practiceOfOneDay);
    }
}
