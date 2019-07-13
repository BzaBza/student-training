package com.github.arturkh.activity.knowledgeSource;
import com.github.arturkh.activity.Student;

public class Teacher implements KnowledgeSource {
    private int knowledgeOfOneDay;
    private int practiceOfOneDay;
    public Teacher(int knowledgeOfOneDay, int practiceOfOneDay){
        this.knowledgeOfOneDay = knowledgeOfOneDay;
        this.practiceOfOneDay = practiceOfOneDay;
    }

    @Override
    public void educate(Student student){
        if (knowledgeOfOneDay > student.getKnowledge()){
            student.toStudy(knowledgeOfOneDay / 10);
        }
        if (practiceOfOneDay > student.getPractice()){
            student.toPractice(practiceOfOneDay / 10);
        }
    }
}
