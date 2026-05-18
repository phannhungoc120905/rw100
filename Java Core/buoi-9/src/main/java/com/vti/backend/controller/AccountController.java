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
}
