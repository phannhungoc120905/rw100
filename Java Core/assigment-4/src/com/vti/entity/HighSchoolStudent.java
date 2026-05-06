package com.vti.entity;

public class HighSchoolStudent extends StudentEx5 {
    private String clazz;
    private String desiredUniversity;

    public HighSchoolStudent(int id, String name,
                             String clazz, String desiredUniversity) {

        super(id, name);
        this.clazz = clazz;
        this.desiredUniversity = desiredUniversity;
    }

    public void display() {
        System.out.println("ID: " + getId() +
                ", Name: " + getName() +
                ", Class: " + clazz +
                ", University: " + desiredUniversity);
    }
}