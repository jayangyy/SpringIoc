package com.domains;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Entity;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.commmon.domains.HibernateUtil;
import com.domain.services.PersonService;
import com.ioc.domains.Boss;
import com.ioc.domains.Boss1;
import com.transcation.domains.AnnotationTranscation;
@Service
@Transactional
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
		// ���������ļ���SPRING MVC����ע��
		/*
		 * ApplicationContext ctx = new
		 * FileSystemXmlApplicationContext("WebContent/WEB-INF/iocBeans.xml");
		 */
		/*
		 * SetIocTest a = (SetIocTest)ctx.getBean("boss"); a.ok(); //����ע�� Boss b
		 * = (Boss)ctx.getBean("boss1"); System.out.print(b.toString()); Boss1
		 * b1 = (Boss1)ctx.getBean("boss2"); System.out.print(b1.toString());
		 */
		// ����ע���SPRING MVC����ע��
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
		Session session = HibernateUtil.currentSession();//����Sessionʵ��
	
	}
	public static void  testAspect() throws Exception{
    	 TRegister rg = new TRegister();
         rg.setAge(3);
         rg.setSex("3");
         rg.setUserName("3");
         rg.setUserPwd("userPwd");
         Configuration config = new Configuration().configure();
		//sessionFactory = config.buildSessionFactory();
         Session session = config.buildSessionFactory().openSession();//����Sessionʵ��            
          //  session.beginTransaction();  
             session.save(rg);    //����־������
          // session.getTransaction().commit();
           throw new Exception("d");
	}

}
