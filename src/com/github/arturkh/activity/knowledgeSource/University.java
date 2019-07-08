package com.github.arturkh.activity.knowledgeSource;

import com.github.arturkh.activity.Student;

public class University implements KnowledgeSource {
    private int oneDayKnowledge = 2;
    private int oneDayPractice = 1;
    public University() {
    }

    @Override
    public void educate(Student student) {
        if (student.isInsuranceInUniversity()){
            int dailyPortionOfKnowledge = (int) (oneDayKnowledge * student.getLearningRate());
            int dailyPortionOfPractice = (int) (oneDayPractice * student.getLearningRate());
            student.setKnowledge(dailyPortionOfKnowledge);
            student.setPractice(dailyPortionOfPractice);
        }
    }
}
