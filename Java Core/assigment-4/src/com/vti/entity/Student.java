package com.vti.entity;

public class Student {
    private int id;
    private String name;
    private String hometown;
    private float score;

    public Student(String name, String hometown) {
        this.name = name;
        this.hometown = hometown;
        this.score = 0;
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