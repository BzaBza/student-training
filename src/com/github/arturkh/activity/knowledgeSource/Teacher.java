package com.github.arturkh.activity.knowledgeSource;

import com.github.arturkh.activity.Student;

public class Teacher implements KnowledgeSource {
    private int KnowledgeOfOneDay = 5;
    private int PracticeOfOneDay = 5;

    @Override
    public void educate(Student student) {
        student.setKnowledge(KnowledgeOfOneDay);
        student.setPractice(PracticeOfOneDay);
    }
}
