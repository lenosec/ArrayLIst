package com.company;

public class Student {
    private int rollno;
    private String name;

    public Student(String name, int rollno) {
        this.rollno = rollno;
        this.name = name;
    }

    public int getRollno() {
        return rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
