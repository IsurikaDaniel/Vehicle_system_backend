package edu.icet.crm.service;

import edu.icet.crm.dto.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAll();
    void addAccount(Account account);
    Boolean validateLogin(Account login);
}
