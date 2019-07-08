package com.github.arturkh.activity;

public class Student {
    private int knowledge = 0;
    private int practice = 0;
    private String name;
    private boolean hasLaptop;
    private double learningRate;
    private boolean insuranceInUniversity;
    private boolean insuranceInInternship;

    public Student(boolean hasLaptop, String name, double learningRate, boolean insuranceInUniversity, boolean insuranceInInternship) {
        this.hasLaptop = hasLaptop;
        this.name = name;
        this.learningRate = learningRate;
        this.insuranceInUniversity = insuranceInUniversity;
        this.insuranceInInternship = insuranceInInternship;
    }

    public double getLearningRate() {
        return learningRate;
    }

    public boolean isInsuranceInUniversity() {
        return insuranceInUniversity;
    }

    public boolean isInsuranceInInternship() {
        return insuranceInInternship;
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
