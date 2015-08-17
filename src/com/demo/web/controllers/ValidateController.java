package com.demo.web.controllers;

import java.security.NoSuchAlgorithmException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.annotation.SystemControllerLog;
import com.domain.services.PersonService;
import com.domains.Authpassport;
import com.domains.BaseController;
import com.domains.SetIocTest;
import com.domains.ValidateModel;
import com.ioc.domains.Boss;
import com.ioc.domains.Boss1;
import com.transcation.domains.AnnotationTranscation;

@Controller
@RequestMapping(value = "/validate")
public class ValidateController extends BaseController {
	@Autowired(required=true)
    private PersonService person;
	@RequestMapping(value = "/test", method = { RequestMethod.GET })
	@SystemControllerLog(description = "删除用户")  //基于注解的AOP风格日志记录，也可设置为基于注解的拦截器风格日志记录
	public String test(Model model) throws Exception {

	if (!model.containsAttribute("contentModel")) {
			model.addAttribute("contentModel", new ValidateModel());
		}
		 /*String[] locations = {"iocBeans.xml"};
	        ApplicationContext ctx = 
			    new ClassPathXmlApplicationContext(locations);*/
		// 基于配置文件的SPRING MVC依赖注入
	/*	ApplicationContext ctx = new FileSystemXmlApplicationContext("iocBeans.xml");
	SetIocTest a = (SetIocTest) ctx.getBean("boss");
		a.ok();
		// 属性注入
		Boss b = (Boss) ctx.getBean("boss1");
		System.out.print(b.toString());
		Boss1 b1 = (Boss1) ctx.getBean("boss2");
		System.out.print(b1.toString());
		 ((AbstractApplicationContext) ctx).destroy();
*/	/*	PersonService personService = person;
	    	String personName = "Jim";
	    	personService.AddPerson(personName);
	    	personService.deletePerson(personName);
	    	personService.editPerson(personName);
	    throw new Exception("444");*/
	AnnotationTranscation trans=new AnnotationTranscation();
	trans.TestTrans();
return "";
	//	return "validatetest";
	}

	/// 验证后台注解模型格式
	@RequestMapping(value = "/test", method = { RequestMethod.POST })
	public String test(Model model, @Valid ValidateModel validateModel, BindingResult result)
			throws Exception {

		// 如果有验证错误 返回到form页面
		if (result.hasErrors())
			return test(model);
		return "validatesuccess";
	}

}