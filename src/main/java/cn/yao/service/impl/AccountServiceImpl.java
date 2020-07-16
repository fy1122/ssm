package cn.yao.service.impl;

import cn.yao.dao.AccountDao;
import cn.yao.domain.Account;
import cn.yao.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao dao;
    @Override
    public List<Account> findAll() {
        System.out.println("查询所有");
        return  dao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        dao.saveAccount(account);
    }
}
