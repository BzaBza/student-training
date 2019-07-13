package com.github.arturkh.activity.knowledgeSource;

import com.github.arturkh.activity.Student;

import java.util.ArrayList;
import java.util.List;

public class Institutions implements KnowledgeSource {
    private int knowledgeOfOneDay;
    private int practiceOfOneDay;
    private List<Student> enrolledStudents = new ArrayList<>();

    public Institutions(int knowledgeOfOneDay, int practiceOfOneDay) {
        this.knowledgeOfOneDay = knowledgeOfOneDay;
        this.practiceOfOneDay = practiceOfOneDay;
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    @Override
    public void educate(Student student) {
        enrolledStudents.forEach(s -> {
            if (s == student) {
                student.toStudy(knowledgeOfOneDay);
                student.toPractice(practiceOfOneDay);
            }
        });
    }
}
