package com.vti.backend;

import com.vti.entity.Student;

public class Exercise4 {

    public void question1() {

        // Tạo student
        Student s1 = new Student("Ngọc", "Đà Nẵng");

        // Set điểm
        s1.setScore(5);

        // Cộng điểm
        s1.addScore(2.5f);

        // In thông tin
        s1.printInfo();
    }
}