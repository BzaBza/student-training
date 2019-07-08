package com.github.arturkh.activity;

public class Student {
    private int knowledge;
    private int practice;
    private String name;
    private boolean isHasLaptop;
    private double learningRate;
    private boolean insuranceInUniversity;
    private boolean insuranceInInternship;

    public Student(boolean isHasLaptop, String name, double learningRate, boolean insuranceInUniversity, boolean insuranceInInternship) {
        this.isHasLaptop = isHasLaptop;
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
        this.knowledge = knowledge;
    }

    public void setPractice(int practice) {
        this.practice = practice;
    }

    public int getKnowledge() {
        return knowledge;
    }

    public int getPractice() {
        return practice;
    }

    public boolean getIsHasLaptop() {
        return isHasLaptop;
    }

    String getName() {
        return name;
    }

}
