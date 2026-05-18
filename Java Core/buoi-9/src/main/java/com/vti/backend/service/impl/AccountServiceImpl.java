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

}
