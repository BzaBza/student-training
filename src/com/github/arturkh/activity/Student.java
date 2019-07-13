package com.github.arturkh.activity;

import com.github.arturkh.activity.knowledgeSource.KnowledgeSource;
import com.github.arturkh.activity.knowledgeSource.Teacher;

public class Student {
    private int knowledge = 0;
    private int practice = 0;
    private String name;
    private boolean hasLaptop;
    private double learningRate;

    public Student(String name, boolean hasLaptop, double learningRate) {
        this.hasLaptop = hasLaptop;
        this.name = name;
        this.learningRate = learningRate;
    }

    public void toStudy(int knowledge) {
        if (knowledge > 0)
            this.knowledge += (int) (knowledge * learningRate);
    }

    public void toPractice(int practice) {
        if (practice > 0)
            this.practice += practice;
    }
    public KnowledgeSource educate(Student student){
        Teacher teacher = new Teacher(knowledge, practice);
        teacher.educate(student);
        return teacher;
    }

    public int getKnowledge() {
        return knowledge;
    }

    public int getPractice() {
        return practice;
    }

    public boolean hasLaptop() {
        return hasLaptop;
    }

    public String getName() {
        return name;
    }

}
