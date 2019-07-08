package com.github.arturkh.activity.knowledgeSource;

import com.github.arturkh.activity.Student;

public class Internship implements KnowledgeSource {
    private int oneDayKnowledge = 1;
    private int oneDayPractice = 2;

    @Override
    public void educate(Student student){
        if(student.isInsuranceInInternship()){
            int dailyPortionOfKnowledge = (int) (oneDayKnowledge * student.getLearningRate());
            int dailyPortionOfPractice = (int) (oneDayPractice * student.getLearningRate());
            student.setKnowledge(dailyPortionOfKnowledge);
            student.setPractice(dailyPortionOfPractice);
        }
    }
}
