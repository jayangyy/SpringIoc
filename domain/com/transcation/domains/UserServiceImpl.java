package com.transcation.domains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.domain.services.PersonService;
import com.domains.TRegister;
@Component
@Service("userService1")
public class UserServiceImpl {
	@Autowired(required = true)
	private PersonService person;
    @Autowired
    private UserDaoImpl  userDao;
    @Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRED)//可以卸载DA层
    public void addUser(TRegister user) throws Exception {
        userDao.addUser(user);
        //此处不回滚事务throw new RuntimeException("yyy");
    }
}