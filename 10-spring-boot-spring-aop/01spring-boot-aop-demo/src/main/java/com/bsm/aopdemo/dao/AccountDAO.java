package com.bsm.aopdemo.dao;

import com.bsm.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account theAccount, boolean vipFlag);
    
}
