package com.github.arturkh.activity.knowledgeSource;

import com.github.arturkh.activity.Student;

public class Mitup implements KnowledgeSource{
    private int oneDayKnowledge = 1;
    private int oneDayPractice = 1;

    @Override
    public void educate(Student student){
        student.setKnowledge(oneDayKnowledge);
        if(student.getIsHasLaptop()){
            student.setPractice(oneDayPractice);
        }
    }
}
