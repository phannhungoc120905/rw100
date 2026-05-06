package com.vti.entity;

public class CanBo {
    private String name;
    private int age;
    private String gender;
    private String address;

    public CanBo(String name, int age, String gender, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    // Getter
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    // Hiển thị
    public void display() {
        System.out.println("Tên: " + name +
                ", Tuổi: " + age +
                ", Giới tính: " + gender +
                ", Địa chỉ: " + address);
    }
}