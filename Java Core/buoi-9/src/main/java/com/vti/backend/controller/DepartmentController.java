package com.vti.backend.controller;

import com.vti.backend.service.IDepartmentService;
import com.vti.backend.service.impl.DepartmentServiceImpl;
import com.vti.entity.Department;

import java.util.List;

public class DepartmentController {
    // khởi tạo departmentService
    private IDepartmentService departmentService = new DepartmentServiceImpl();
    public List<Department> findAll(){
        //lấy danh sách từ service
        List<Department> departments = departmentService.findAll();
        return departments;
    }
    public boolean createDepartment(String name){
        boolean check = departmentService.createDepartment(name);
        return check;
    }

    public boolean delete(int id) {
        boolean check = departmentService.delete(id);
        return check;
    }
    public boolean update(int id, String name){
        boolean check = departmentService.update(id, name);
        return check;
    }
    public boolean checkExistNameAndIdNot(String name, Integer id) {
        return departmentService.checkExistNameAndIdNot(name, id);
    }

    public boolean checkExistID(Integer id) {
        return departmentService.checkExistID(id);
    }
}
