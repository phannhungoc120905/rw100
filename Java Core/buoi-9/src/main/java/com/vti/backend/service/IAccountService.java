package com.vti.backend.service;

import com.vti.entity.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();
    Boolean create(Account acc);
    Boolean update(Account acc);
    Boolean delete(int id);
}
