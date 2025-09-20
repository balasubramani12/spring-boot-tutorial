package com.bsm.aopdemo.dao;

import java.util.List;

import com.bsm.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account theAccount, boolean vipFlag);
    boolean doWork();
    String getName();
    void setName(String name);
    String getServiceCode();
    void setServiceCode(String serviceCode);

    // After advice
    List<Account> findAccounts();
    List<Account> findAccounts(boolean tripWire);
    
    
}
