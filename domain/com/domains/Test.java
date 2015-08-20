package com.domains;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Entity;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.commmon.domains.HibernateUtil;
import com.domain.services.PersonService;
import com.ioc.domains.Boss;
import com.ioc.domains.Boss1;
import com.transcation.domains.AnnotationTranscation;
@Service
public class Test {
	@Autowired(required = true)
	private static  PersonService person;
	public PersonService getPerson() {
		return person;
	}
	public void setPerson(PersonService person) {
		this.person = person;
	}
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
	/*ApplicationContext appContext = new FileSystemXmlApplicationContext(
				"WebContent/WEB-INF/dispatcher-servlet.xml");
		PersonService personService = appContext.getBean(PersonService.class);
		String personName = "Jim";
		personService.AddPerson(personName);
		personService.deletePerson(personName);
		//personService.editPerson(personName);
		((FileSystemXmlApplicationContext) appContext).close();*/
		 
		//testAspect();
		/*AnnotationTranscation trans=new AnnotationTranscation();
		trans.TestTrans();*/
		Session session = HibernateUtil.currentSession();//生成Session实例
	
	}
	@Transactional(value="transactionManager",rollbackFor=Exception.class,propagation=Propagation.REQUIRED)
	public static void  testAspect() throws Exception{
    	 TRegister rg = new TRegister();
         rg.setAge(3);
         rg.setSex("3");
         rg.setUserName("3");
         rg.setUserPwd("userPwd");
       //  Configuration config = new Configuration().configure();
  //  ServiceRegistry     serviceRegistry =  new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
  ///  SessionFactory   sessionFactory = config.buildSessionFactory(serviceRegistry); 
		//sessionFactory = config.buildSessionFactory();
    Session see=HibernateUtil.currentSession();
    		//sessionFactory.getCurrentSession();
         //Session session = sessionFactory.openSession();//生成Session实例            
       
          //  session.beginTransaction();  
             //session.save(rg);    //保存持久类对象
             see.save(rg);
          // session.getTransaction().commit();
           //throw new Exception("d");
	}

}
