package com.ioc.domains;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("baseDao")
public class TestGenic<T> {
	private Class<T> ttttt;


	private T ttt;

	public T getTtt() {
		return ttt;
	}

	public void setTtt(T ttt) {
		this.ttt = ttt;
	}

	public void save(T m) {
		System.out.println("=====repository save:" + m);
	}

	public <T> T doSomething(T param) {
		return param;

	}
}
