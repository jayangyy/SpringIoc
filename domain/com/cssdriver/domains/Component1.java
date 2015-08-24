package com.cssdriver.domains;

import org.springframework.stereotype.Component;

@Component("Compoent1")
public class Component1 implements IComponent{

	@Override
	public void fun() {
		// TODO Auto-generated method stub
		System.out.println("com");
	}

}
