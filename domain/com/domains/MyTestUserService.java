package com.domains;

import org.springframework.stereotype.Component;

import com.ioc.domains.Car;
@Component("TestUserService")
public class MyTestUserService implements MyUserIDao<Car> {

	@Override
	public void insert(Car model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Car model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Car model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> T doSomething(T param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void MyTestDaoMethod() {
		// TODO Auto-generated method stub
		System.out.print("TEST");
	}

}
