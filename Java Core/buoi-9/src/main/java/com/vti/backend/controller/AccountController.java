package com.vti.backend.controller;

import com.vti.backend.service.IAccountService;
import com.vti.backend.service.impl.AccountServiceImpl;
import com.vti.entity.Account;;import java.util.List;

public class AccountController {
    private IAccountService accountService = new AccountServiceImpl();
    public List<Account> findAll(){
        List<Account> accounts = accountService.findAll();
        return accounts;
    }
    public boolean create(Account acc){
        boolean check = accountService.create(acc);
        return check;
    }
    public boolean update(Account acc){
        boolean check = accountService.update(acc);
        return check;
    }
    public boolean delete(int id){
        boolean check = accountService.delete(id);
        return check;
    }

    public boolean checkExistUsernameAndIdNot(String username, Integer id) {
        boolean check = accountService.checkExistUsernameAndIdNot(username,id);
        return check;
    }

    public boolean checkExistEmailAndIdNot(String email, Integer id) {
        boolean check = accountService.checkExistEmailAndIdNot(email,id);
        return check;
    }

    public boolean checkExistPositionID(int posId) {
        boolean check = accountService.checkExistPositionID(posId);
        return check;
    }

    public boolean checkExistID(int id) {
        boolean check = accountService.checkExistID(id);
        return check;
    }

    public boolean checkExistDepartmentID(int depId) {
        boolean check = accountService.checkExistDepartmentID(depId);
        return check;
    }

    public boolean updateUsername(int id, String newUsername) {
        boolean check = accountService.updateUsername(id, newUsername);
        return check;
    }
}
