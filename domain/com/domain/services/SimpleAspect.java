package com.domain.services;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
//基于注解的AOp,基于XML文件的AOP配置更灵活 同一个ASPECT类可以重用
@Component
@Aspect
public class SimpleAspect {
	@Pointcut("execution(* com.domain.services.*Service*.*(..))")
/*	@Pointcut("execution(* org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter.handle(..))")拦截Controller 测试不可用*/
	
	public void pointCut() {

	}

	@After("pointCut()")
	public void After() {

	}

	// 前置通知
	@Before("pointCut()")
	public void before(JoinPoint joinPoint) {
		// 如果需要这里可以取出参数进行处理
		// Object[] args = joinPoint.getArgs();
		System.out.println("before aspect executing");
	}

	@AfterReturning(pointcut = "pointCut()", returning = "returnVal")
	public void afterReturning(JoinPoint joinPoint, Object returnVal) {
		System.out.println("afterReturning executed, return result is " + returnVal);
	}

	// 环绕通知
	@Around("pointCut()")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around start..");
		try {
			pjp.proceed();
		} catch (Throwable ex) {
			System.out.println("error in around");
			throw new RuntimeException(ex);
		}
		System.out.println("around end");
	}
	//要想使用异常通知，代码中必须抛出异常,所以测试出来有些方法异常捕捉不到 ，全局异常处理还是得用BASEController 或者异常拦截器
	@AfterThrowing(pointcut = "pointCut()", throwing = "error")
	public void afterThrowing(JoinPoint jp, Throwable error)  {
		System.out.println("错误:" + error);
		System.out.println("error:" + error);
	}
}
