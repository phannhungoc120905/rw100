package com.vti.entity;

public class NhanVien extends CanBo {
    private String job;

    public NhanVien(String name, int age, String gender, String address, String job) {
       // super(name, age, gender, address);
        this.job = job;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Công việc: " + job);
    }
}