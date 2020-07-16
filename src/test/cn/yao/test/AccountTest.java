package cn.yao.test;


import cn.yao.dao.AccountDao;
import cn.yao.domain.Account;
import cn.yao.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AccountTest {
    @Autowired
    private AccountService as;
    @Test
    public void test(){
       as.findAll();
    }
    @Test
    public void testMybatis(){
        try {
            //加载配置文件
            InputStream is = Resources.getResourceAsStream("SqlMapperConfig.xml");
            //创建工厂
            SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
            //创建SqlSession对象
            SqlSession sqlSession = factory.openSession();
            //创建代理对象
            AccountDao dao = sqlSession.getMapper(AccountDao.class);
            //运行方法
            List<Account> accounts = dao.findAll();
            for(Account account:accounts){
                System.out.println(account);
            }
            sqlSession.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
