package com.transcation.domains;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.commmon.domains.HibernateUtil;
import com.domain.services.PersonService;
import com.domains.TRegister;
@Component
public class AnnotationTranscation {
	@Autowired(required = true)
	public UserDaoImpl person;
	@Transactional(rollbackFor = Exception.class)
	public void TestTrans() {
		Integer id = 0;
		try {
			id++;
			System.out.print(id.toString());
			throw new RuntimeException("注释");
		} catch (Exception ex) {
			System.out.println("id=" + id.toString());
		}

	}
	
	@Transactional(value="transactionManager",rollbackFor=Exception.class,propagation=Propagation.REQUIRED)
	public  void  testAspect() throws Exception{
    	 TRegister rg = new TRegister();
         rg.setAge(3);
         rg.setSex("9");
         rg.setUserName("3");
         rg.setUserPwd("userPwd");
       //  Configuration config = new Configuration().configure();
  //  ServiceRegistry     serviceRegistry =  new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
  ///  SessionFactory   sessionFactory = config.buildSessionFactory(serviceRegistry); 
		//sessionFactory = config.buildSessionFactory();
   // Session see=HibernateUtil.currentSession();
    		//sessionFactory.getCurrentSession();
         //Session session = sessionFactory.openSession();//生成Session实例            
       
          //  session.beginTransaction();  
             //session.save(rg);    //保存持久类对象
    //         see.save(rg);
         person.addUser(rg);
          // session.getTransaction().commit();
           //throw new Exception("d");
	}
}
