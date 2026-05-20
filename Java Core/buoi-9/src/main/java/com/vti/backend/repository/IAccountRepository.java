package com.vti.backend.repository;

import com.vti.entity.Account;

import java.util.List;

public interface IAccountRepository {
    List<Account> findAll();
    Boolean create(Account acc);
    Boolean update(Account acc);
    Boolean delete(int id);
    boolean checkExistUsernameAndIdNot(String username, Integer id);
    boolean checkExistEmailAndIdNot(String email, Integer id);
    boolean checkExistPositionID(int posId);
    boolean checkExistID(int id);
    boolean checkExistDepartmentID(int depId);
    boolean updateUsername(int id, String newUsername);
}
