package com.vti.backend.repository;

import com.vti.entity.Account;

import java.util.List;

public interface IAccountRepository {
    List<Account> findAll();
    Boolean create(Account acc);
    Boolean update(Account acc);
    Boolean delete(int id);
}
