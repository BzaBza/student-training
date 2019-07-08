package com.github.arturkh.activity.knowledgeSource;

import com.github.arturkh.activity.Student;

public class SelfEducation implements KnowledgeSource {
    private int KnowledgeOfOneDay = 4;
    private int oneDayPractice = 4;

    @Override
    public void educate(Student student){
        int dailyPortionOfKnowledge = (int) (KnowledgeOfOneDay * student.getLearningRate());
        int dailyPortionOfPractice = (int) (oneDayPractice * student.getLearningRate());
        student.setKnowledge(dailyPortionOfKnowledge);
        student.setPractice(dailyPortionOfPractice);
    }
}
