package com.vti.backend.service.impl;

import com.vti.backend.repository.IAccountRepository;
import com.vti.backend.repository.impl.AccountRepositoryIplm;
import com.vti.backend.service.IAccountService;
import com.vti.entity.Account;

import java.util.List;

public class AccountServiceImpl implements IAccountService {
    private IAccountRepository accountRepository = new AccountRepositoryIplm();
    @Override
    public List<Account> findAll() {
       List<Account> accounts = accountRepository.findAll();
       return accounts;
    }

    @Override
    public Boolean create(Account acc) {
        boolean check = accountRepository.create(acc);
        return check;
    }

    @Override
    public Boolean update(Account acc) {
        boolean check = accountRepository.update(acc);
        return check;
    }

    @Override
    public Boolean delete(int id) {
        boolean check = accountRepository.delete(id);
        return check;
    }

    @Override
    public boolean checkExistUsernameAndIdNot(String username, Integer id) {
        boolean check = accountRepository.checkExistUsernameAndIdNot(username, id);
        return check;
    }

    @Override
    public boolean checkExistEmailAndIdNot(String email, Integer id) {
        boolean check = accountRepository.checkExistEmailAndIdNot(email, id);
        return check;
    }

    @Override
    public boolean checkExistPositionID(int posId) {
        boolean check = accountRepository.checkExistPositionID(posId);
        return check;
    }

    @Override
    public boolean checkExistID(int id) {
        boolean check = accountRepository.checkExistID(id);
        return check;
    }

    @Override
    public boolean checkExistDepartmentID(int depId) {
        boolean check = accountRepository.checkExistDepartmentID(depId);
        return check;
    }

    @Override
    public boolean updateUsername(int id, String newUsername) {
        boolean check = accountRepository.updateUsername(id, newUsername);
        return check;
    }

}
