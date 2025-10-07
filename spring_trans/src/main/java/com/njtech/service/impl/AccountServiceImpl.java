package com.njtech.service.impl;

import com.njtech.mapper.AccountMapper;
import com.njtech.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountMapper accountMapper;

    @Override
    @Transactional
    public void transferMoney(String outAccount, String inAccount, Integer money) {
        accountMapper.decrMoney(outAccount,money);
        //int i = 1/0;
        accountMapper.incrMoney(inAccount,money);
    }
}
