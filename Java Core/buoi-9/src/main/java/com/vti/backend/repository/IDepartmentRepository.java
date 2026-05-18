package com.vti.backend.repository;

import com.vti.entity.Department;

import java.util.List;

public interface IDepartmentRepository {
    List<Department> findAll();
    Boolean createDepartment(String name);
    Boolean delete(int id);
    Boolean update(int id, String updateName);
}
