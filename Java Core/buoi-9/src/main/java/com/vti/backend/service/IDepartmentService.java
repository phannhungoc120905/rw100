package com.vti.backend.service;

import com.vti.entity.Department;

import java.util.List;

public interface IDepartmentService {
    List<Department> findAll();
    Boolean createDepartment(String name);

    boolean delete(int id);
    boolean update(int id, String updateName);
    boolean checkExistID(Integer id);
    boolean checkExistNameAndIdNot(String name, Integer id);
}
