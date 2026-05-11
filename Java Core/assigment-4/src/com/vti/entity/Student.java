package com.vti.entity;

public class Student {
    private int id;
    private String name;
    private String hometown;
    private float score;

    public Student(){

    }
    public Student(String name, String hometown) {
        this.name = name;
        this.hometown = hometown;
        this.score = 0;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public void addScore(float add) {

        this.score += add;
    }

    public void printInfo() {
        System.out.println("Tên: " + name);
        System.out.println("Quê: " + hometown);
        System.out.println("Điểm: " + score);

        if (score < 4.0) {
            System.out.println("Xếp loại: Yếu");
        } else if (score < 6.0) {
            System.out.println("Xếp loại: Trung bình");
        } else if (score < 8.0) {
            System.out.println("Xếp loại: Khá");
        } else {
            System.out.println("Xếp loại: Giỏi");
        }
    }
    public int getId() {
        return id;
    }
}