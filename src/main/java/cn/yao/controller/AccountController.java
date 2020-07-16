package cn.yao.controller;

import cn.yao.domain.Account;
import cn.yao.service.AccountService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService as;
    @RequestMapping("/testMVC")
    public String testMvc(Model model){
        List<Account> accounts = as.findAll();
        model.addAttribute("accounts",accounts);
        return "success";
    }
    @RequestMapping("/save")
    public void save(Account account, HttpServletResponse response, HttpServletRequest request){
        as.saveAccount(account);
        try {
            response.sendRedirect(request.getContextPath()+"/account/testMVC");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }
}
