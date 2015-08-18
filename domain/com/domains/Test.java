package com.domains;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Entity;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.commmon.domains.HibernateUtil;
import com.domain.services.PersonService;
import com.ioc.domains.Boss;
import com.ioc.domains.Boss1;
import com.transcation.domains.AnnotationTranscation;

public class Test {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		// 基于配置文件的SPRING MVC依赖注入
		/*
		 * ApplicationContext ctx = new
		 * FileSystemXmlApplicationContext("WebContent/WEB-INF/iocBeans.xml");
		 */
		/*
		 * SetIocTest a = (SetIocTest)ctx.getBean("boss"); a.ok(); //属性注入 Boss b
		 * = (Boss)ctx.getBean("boss1"); System.out.print(b.toString()); Boss1
		 * b1 = (Boss1)ctx.getBean("boss2"); System.out.print(b1.toString());
		 */
		// 基于注解的SPRING MVC依赖注入
	/*	ApplicationContext appContext = new FileSystemXmlApplicationContext(
				"WebContent/WEB-INF/dispatcher-servlet.xml");
		PersonService personService = appContext.getBean(PersonService.class);
		String personName = "Jim";
		personService.AddPerson(personName);
		personService.deletePerson(personName);
		personService.editPerson(personName);
		((FileSystemXmlApplicationContext) appContext).close();*/
		
		/*AnnotationTranscation trans=new AnnotationTranscation();
		trans.TestTrans();*/
		Session session = HibernateUtil.currentSession();//生成Session实例
	
	}

}
