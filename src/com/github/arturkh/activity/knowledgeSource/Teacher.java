package com.github.arturkh.activity.knowledgeSource;

import com.github.arturkh.activity.Student;

public class Teacher implements KnowledgeSource {
    private int oneDayKnowledge = 1;
    private int oneDayPractice = 1;

    @Override
    public void educate(Student student) {
        int dailyPortionOfKnowledge = (int) (oneDayKnowledge * student.getLearningRate());
        int dailyPortionOfPractice = (int) (oneDayPractice * student.getLearningRate());
        student.setKnowledge(dailyPortionOfKnowledge);
        student.setPractice(dailyPortionOfPractice);
    }
}
