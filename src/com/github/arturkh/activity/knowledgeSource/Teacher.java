package com.github.arturkh.activity.knowledgeSource;

import com.github.arturkh.activity.Student;

public class Teacher implements KnowledgeSource {
    private int KnowledgeOfOneDay = 5;
    private int PracticeOfOneDay = 5;

    @Override
    public void educate(Student student) {
        int dailyPortionOfKnowledge = (int) (KnowledgeOfOneDay * student.getLearningRate());
        int dailyPortionOfPractice = (int) (PracticeOfOneDay * student.getLearningRate());
        student.setKnowledge(dailyPortionOfKnowledge);
        student.setPractice(dailyPortionOfPractice);
    }
}
