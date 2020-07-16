package cn.yao.service;

import cn.yao.domain.Account;

import java.util.List;

public interface AccountService {
    //查询所有
    List<Account> findAll();
    //保存
    void saveAccount(Account account);
}
