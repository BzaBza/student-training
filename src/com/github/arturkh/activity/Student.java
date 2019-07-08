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

    public double getLearningRate() {
        return learningRate;
    }

    public void setKnowledge(int knowledge) {
        this.knowledge += knowledge;
    }

    public void setPractice(int practice) {
        this.practice += practice;
    }

    public int getKnowledge() {
        return knowledge;
    }

    public int getPractice() {
        return practice;
    }

    public boolean getIsHasLaptop() {
        return hasLaptop;
    }

    String getName() {
        return name;
    }

}
