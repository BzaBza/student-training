package com.github.arturkh.activity.knowledgeSource;

import com.github.arturkh.activity.Student;

public class Internship implements KnowledgeSource {
    private int KnowledgeOfOneDay = 2;
    private int PracticeOfOneDay = 7;

    @Override
    public void educate(Student student) {
        int dailyPortionOfKnowledge = (int) (KnowledgeOfOneDay * student.getLearningRate());
        int dailyPortionOfPractice = (int) (PracticeOfOneDay * student.getLearningRate());
        student.setKnowledge(dailyPortionOfKnowledge);
        student.setPractice(dailyPortionOfPractice);
    }
}
