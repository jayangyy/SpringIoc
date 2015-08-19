package com.ioc.domains;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.domain.services.PersonService;
@Scope("prototype")//���������� Spring �����л�ȡ boss Bean ʱ��ÿ�η��صĶ����µ�ʵ���ˡ�
//ע���Զ�ע��
@Component("boss2")
public class Boss1 {
	@Resource
	private PersonService person;
	@Resource
	private Car1 car2;
	@Resource(name = "car1")
	private Car1 car3;

	public Car1 getCar3() {
		return car3;
	}

	// ʵ�л������
	@PostConstruct
	public void postConstruct1() {
		System.out.println("postConstruct1");
	}

	// ��������ʱ����ã����Ƕ����������ڽ���ʱ��ʹ��
	@PreDestroy
	public void preDestroy1() {
		System.out.println("preDestroy1");
	}

	public void setCar3(Car1 car3) {
		this.car3 = car3;
	}

	public Car1 getCar2() {
		return car2;
	}

	public void setCar2(Car1 car2) {
		this.car2 = car2;
	}

	private Car1 car1;
	@Autowired
	private Offic1 offic1;

	@Override
	public String toString() {
		return "car:" + car1 + "\n" + "office:" + offic1 + "car2:-------" + car2;
	}

	public Car1 getCar() {
		return car1;
	}

	@Autowired
	public void setCar(Car1 car) {
		this.car1 = car;
	}

	public Offic1 getOffice() {
		return offic1;
	}

	public void setOffice(@Qualifier("offic1") Offic1 office) {
		this.offic1 = office;
	}
}
