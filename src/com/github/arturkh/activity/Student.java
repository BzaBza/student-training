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

    public void setKnowledge(int knowledge) {
        if (knowledge > 0)
            this.knowledge += (int) (knowledge * learningRate);
    }

    public void setPractice(int practice) {
        if (practice > 0)
            this.practice += (int) (practice * learningRate);
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

    String getName() {
        return name;
    }

}
