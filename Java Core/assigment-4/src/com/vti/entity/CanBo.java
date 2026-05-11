package com.vti.entity;
import com.vti.enums.Gender;
public class CanBo {
    private String name;
    private int age;
    private Gender gender;
    private String address;

    public CanBo(){

    }

    public CanBo(String name, int age, Gender gender, String address) {
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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