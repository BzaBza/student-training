package com.github.arturkh.activity;

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
    public void educate(Student student){
        if (this.knowledge > student.getKnowledge()){
            student.toStudy(this.knowledge / 100);
        }
        if (this.practice > student.getPractice()){
            student.toPractice(this.practice / 100);
        }
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
