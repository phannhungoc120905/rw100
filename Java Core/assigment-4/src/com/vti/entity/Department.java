package com.vti.entity;

public class Department {
    private int departmentId;
    private String departmentName;

    // Tạo constructor cho department:
    // không có parameters
    public Department() {
    }

    // Có 1 parameter là nameDepartment và default id của Department = 0
    public Department(String nameDepartment) {
        this.departmentId = 0;
        this.departmentName = nameDepartment;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}