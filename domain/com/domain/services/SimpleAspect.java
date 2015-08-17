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
//����ע���AOp,����XML�ļ���AOP���ø���� ͬһ��ASPECT���������
@Component
@Aspect
public class SimpleAspect {
	@Pointcut("execution(* com.domain.services.*Service*.*(..))")
/*	@Pointcut("execution(* org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter.handle(..))")����Controller ���Բ�����*/
	
	public void pointCut() {

	}

	@After("pointCut()")
	public void After() {

	}

	// ǰ��֪ͨ
	@Before("pointCut()")
	public void before(JoinPoint joinPoint) {
		// �����Ҫ�������ȡ���������д���
		// Object[] args = joinPoint.getArgs();
		System.out.println("before aspect executing");
	}

	@AfterReturning(pointcut = "pointCut()", returning = "returnVal")
	public void afterReturning(JoinPoint joinPoint, Object returnVal) {
		System.out.println("afterReturning executed, return result is " + returnVal);
	}

	// ����֪ͨ
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
	//Ҫ��ʹ���쳣֪ͨ�������б����׳��쳣,���Բ��Գ�����Щ�����쳣��׽���� ��ȫ���쳣�����ǵ���BASEController �����쳣������
	@AfterThrowing(pointcut = "pointCut()", throwing = "error")
	public void afterThrowing(JoinPoint jp, Throwable error)  {
		System.out.println("����:" + error);
		System.out.println("error:" + error);
	}
}
