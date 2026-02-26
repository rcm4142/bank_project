package com.pie.app.service;

import com.pie.app.model.AccountDTO;

public interface AccountService {
    AccountDTO getAccountById(String accountId);
    AccountDTO  openAccount(AccountDTO accountDto);
}
