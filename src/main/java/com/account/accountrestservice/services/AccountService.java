package com.account.accountrestservice.services;

import com.account.accountrestservice.models.Account;
import com.account.accountrestservice.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    //Create Account
    public Account createAccount(Account account){
      return accountRepository.save(account);
    }

    //Read Account
    public Account getAccount(int accountId){
        Optional<Account> accountOptional= accountRepository.findById(accountId);
        return accountOptional.get();
    }

    //Delete Account
    public void deleteAccount(int accountId){
        accountRepository.deleteById(accountId);
    }

    //Update Account
    public Account updateAccount(Account account){
        if(accountRepository.existsById(account.getAccountId())){
            this.deleteAccount(account.getAccountId());
        }
        return this.createAccount(account);


    }


}
