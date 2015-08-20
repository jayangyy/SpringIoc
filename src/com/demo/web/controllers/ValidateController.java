package com.demo.web.controllers;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.annotation.SystemControllerLog;
import com.commmon.domains.HibernateUtil;
import com.domain.services.PersonService;
import com.domains.Authpassport;
import com.domains.BaseController;
import com.domains.SetIocTest;
import com.domains.TRegister;
import com.domains.Test;
import com.domains.ValidateModel;
import com.ioc.domains.Boss;
import com.ioc.domains.Boss1;
import com.transcation.domains.AnnotationTranscation;
import com.transcation.domains.UserDaoImpl;

@Controller
@RequestMapping(value = "/validate")
public class ValidateController extends BaseController{
	@Autowired(required = true)
	private PersonService person;
	@Autowired(required = true)
	private UserDaoImpl  userDao;
	@Autowired(required = true)
	private AnnotationTranscation  AnnotationTranscation;
	
	@RequestMapping(value = "/test", method = { RequestMethod.GET })
	@SystemControllerLog(description = "删除用户") // 基于注解的AOP风格日志记录，也可设置为基于注解的拦截器风格日志记录
	public String test(Model model) throws Exception {
		if (!model.containsAttribute("contentModel")) {
			model.addAttribute("contentModel", new ValidateModel());
		}
		/*
		 * String[] locations = {"iocBeans.xml"}; ApplicationContext ctx = new
		 * ClassPathXmlApplicationContext(locations);
		 */
		// 基于配置文件的SPRING MVC依赖注入
		/*
		 * ApplicationContext ctx = new
		 * FileSystemXmlApplicationContext("iocBeans.xml"); SetIocTest a =
		 * (SetIocTest) ctx.getBean("boss"); a.ok(); // 属性注入 Boss b = (Boss)
		 * ctx.getBean("boss1"); System.out.print(b.toString()); Boss1 b1 =
		 * (Boss1) ctx.getBean("boss2"); System.out.print(b1.toString());
		 * ((AbstractApplicationContext) ctx).destroy();
		 */ /*
			 * PersonService personService = person; String personName = "Jim";
			 * personService.AddPerson(personName);
			 * personService.deletePerson(personName);
			 * personService.editPerson(personName); throw new Exception("444");
			 */
		/*AnnotationTranscation trans = new AnnotationTranscation();
		trans.TestTrans();
		throw new RuntimeException("edit person throw exception");*/
	// return "validatetest";
		return null;
	}

	/// 验证后台注解模型格式
	
	@RequestMapping(value = "/test", method = { RequestMethod.POST })
	@Transactional(rollbackFor = Exception.class)
	public String test(Model model, @Valid ValidateModel validateModel, BindingResult result) throws Exception {

		// 如果有验证错误 返回到form页面
		if (result.hasErrors())
			return test(model);
		return "validatesuccess";
	}

	/// 验证后台注解模型格式
	@RequestMapping(value = "/hiblate", method = { RequestMethod.GET })
	public String hitest() throws Exception {

		return "hiblate";
	}

	/// hiblatetest
	@RequestMapping(value = "/saveuser", method = { RequestMethod.POST })
	
	public String saveuser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        String sex = request.getParameter("sex");
        int age = Integer.parseInt(request.getParameter("age"));
        
        TRegister rg = new TRegister();
        rg.setAge(age);
        rg.setSex(sex);
        rg.setUserName(userName);
        rg.setUserPwd(userPwd);
        
        Session session = HibernateUtil.currentSession();//生成Session实例
*/     
        
       /// try
        //{
      // session.beginTransaction();  
            //session.save(rg);    //保存持久类对象
           //session.getTransaction().commit();    
                 //提交到数据库
          
          // throw new Exception("d");
         //   response.sendRedirect("registerOK.jsp");
        //}
        /*catch(HibernateException e)
        {
            e.printStackTrace();
            tx.rollback();
        }*/
		AnnotationTranscation.testAspect();
		return "hiblate";
            //测试事务
          //  throw new Exception("edit person throw exception");
	}

}