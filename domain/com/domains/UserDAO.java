package com.domains;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.annotation.User;
import com.ioc.domains.Car;

@Repository(value = "userRepository") 
public class UserDAO   implements IDAO<Car> {

    @Autowired
    public UserDAO(SessionFactory sessionFactory) {
       
    }

    @Override
    public void insert(Car user) {
       System.out.print("Insert");
    }

    @Override
    public void update(Car user) {
      
    }

    @Override
    public void delete(Car user) {
        
    }

	@Override
	public <T> T doSomething(T param) {
		// TODO Auto-generated method stub
		return null;
	} 
	public void Test(){
		
		
	}
}