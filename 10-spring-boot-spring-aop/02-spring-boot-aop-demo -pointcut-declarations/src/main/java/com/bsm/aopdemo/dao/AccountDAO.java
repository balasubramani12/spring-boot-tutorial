package com.bsm.aopdemo.dao;

import com.bsm.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account theAccount, boolean vipFlag);
    boolean doWork();
    String getName();
    void setName(String name);
    String getServiceCode();
    void setServiceCode(String serviceCode);
    
    
}
