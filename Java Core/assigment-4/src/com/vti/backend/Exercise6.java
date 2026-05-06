package com.vti.backend;

import com.vti.entity.*;

public class Exercise6 {

    // ================= Q1 =================
    public void question1() {

        VietnamesePhone phone = new VietnamesePhone();

        phone.insertContact("Nam", "123");
        phone.insertContact("Lan", "456");

        System.out.println("=== Tìm Nam ===");
        phone.searchContact("Nam");

        System.out.println("=== Update Nam ===");
        phone.updateContact("Nam", "999");
        phone.searchContact("Nam");

        System.out.println("=== Xóa Lan ===");
        phone.removeContact("Lan");
        phone.searchContact("Lan");
    }

    // ================= Q2 + Q3 =================
    public void question2_3() {

        User e = new Employee("Employee A", 2.0);
        User m = new Manager("Manager B", 2.0);
        User w = new Waiter("Waiter C", 2.0);

        System.out.println("=== Salary ===");
        e.displayInfor();
        m.displayInfor();
        w.displayInfor();
    }
}