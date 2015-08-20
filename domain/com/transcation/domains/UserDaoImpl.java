package com.transcation.domains;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.domain.services.PersonService;
import com.domains.TRegister;
@Component
public class UserDaoImpl  {
    @Autowired
    private SessionFactory sessionFactory;
	@Autowired(required = true)
	private PersonService person;
	
    public  void addUser(TRegister user)  {
        sessionFactory.getCurrentSession().save(user);
        //此处回滚事务
        throw new RuntimeException("yyy");
    }
}