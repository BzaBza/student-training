package com.github.arturkh.activity.knowledgeSource;

import com.github.arturkh.activity.Student;

public class Mitup implements KnowledgeSource{
    private int KnowledgeOfOneDay = 5;
    private int PracticeOfOneDay = 3;

    @Override
    public void educate(Student student){
        student.setKnowledge(KnowledgeOfOneDay);
        if(student.getIsHasLaptop()){
            student.setPractice(PracticeOfOneDay);
        }
    }
}
