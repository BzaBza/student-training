package com.github.arturkh.activity.knowledgeSource;

import com.github.arturkh.activity.Student;

public class SelfEducation implements KnowledgeSource {
    private int KnowledgeOfOneDay = 4;
    private int oneDayPractice = 4;

    @Override
    public void educate(Student student){
        student.setKnowledge(KnowledgeOfOneDay);
        student.setPractice(oneDayPractice);
    }
}
