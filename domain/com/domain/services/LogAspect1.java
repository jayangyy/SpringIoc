/*package com.domain.services;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


*//**
 * \
 * 
 * @Aspect ʵ��spring aop ���棨Aspect����
 *         һ����ע���ģ�黯�������ע����ܻ���ж���������������J2EEӦ����һ�����ں��й�ע��ĺܺõ����ӡ� ��Spring
 *         AOP�У��������ʹ��ͨ���ࣨ����ģʽ�ķ�� ��������ͨ������ @Aspect ע�⣨@AspectJ�����ʵ�֡�
 * 
 *         AOP����AOP Proxy���� AOP��ܴ����Ķ�������ʵ��������Լ��aspect contract��������֪ͨ����ִ�еȹ��ܣ���
 *         ��Spring�У�AOP���������JDK��̬�������CGLIB���� ע�⣺Spring
 *         2.0��������Ļ���ģʽ��schema-based
 *         ������@AspectJע�������������������ʹ����Щ�����û���˵������Ĵ�����͸���ġ�
 * @author q
 * 
 *//*
@Component
@Aspect
public class LogAspect1 {

	@Autowired
	private SyslogDao syslogDao;

	public LogService() {
		System.out.println("Aop");
	}

	*//**
	 * ��Spring
	 * 2.0�У�Pointcut�Ķ�������������֣�Pointcut��ʾʽ(expression)��Pointcutǩ��(signature
	 * )���������ȿ���execution��ʾʽ�ĸ�ʽ��
	 * �����и���pattern�ֱ��ʾ���η�ƥ�䣨modifier-pattern?��������ֵƥ�䣨ret
	 * -type-pattern������·��ƥ�䣨declaring
	 * -type-pattern?����������ƥ�䣨name-pattern��������ƥ�䣨(param
	 * -pattern)�����쳣����ƥ�䣨throws-pattern?�������к�����š�?�����ǿ�ѡ�
	 * 
	 * @param point
	 * @throws Throwable
	 *//*

	@Pointcut("@annotation(com.wssys.framework.MethodLog)")
	public void methodCachePointcut() {

	}

	// // @Before("execution(* com.wssys.controller.*(..))")
	// public void logAll(JoinPoint point) throws Throwable {
	// System.out.println("��ӡ========================");
	// }
	//
	// // @After("execution(* com.wssys.controller.*(..))")
	// public void after() {
	// System.out.println("after");
	// }

	// ����ִ�е�ǰ�����
	// @Around("execution(* com.wssys.controller.*(..))||execution(* com.bpm.*.web.account.*.*(..))")
	// @Around("execution(* com.wssys.controller.*(..))")
	// @Around("execution(* org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter.handle(..))")
	@Around("methodCachePointcut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
		Calendar ca = Calendar.getInstance();
		String operDate = df.format(ca.getTime());
		String ip = TCPIPUtil.getIpAddr(request);
		PusSysUser user = (PusSysUser) SecurityUtils.getSubject()
				.getPrincipal();
		String loginName;
		String name;
		if (user != null) {
			loginName = user.getAccount();
			// name = user.name;
		} else {
			loginName = "�����û�";
			// name = "�����û�";
		}

		String monthRemark = getMthodRemark(point);
		String monthName = point.getSignature().getName();
		String packages = point.getThis().getClass().getName();
		if (packages.indexOf("$$EnhancerByCGLIB$$") > -1) { // �����CGLIB��̬���ɵ���
			try {
				packages = packages.substring(0, packages.indexOf("$$"));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		String operatingcontent = "";
		Object[] method_param = null;

		Object object;
		try {
			method_param = point.getArgs();	//��ȡ�������� 
			// String param=(String) point.proceed(point.getArgs());
			object = point.proceed();
		} catch (Exception e) {
			// �쳣�����¼��־..log.error(e);
			throw e;
		}
		Syslog sysLog = new Syslog();
		sysLog.setIpAddress(ip);
		sysLog.setLoginName(loginName);
		sysLog.setMethodName(packages + "." + monthName);
		sysLog.setMethodRemark(monthRemark);
		//�����е���� ���ǲ����жϵ�һ��objectԪ�ص����� ֻ��ͨ��  ���������� ��һһ  ת�͸о� ���� �е��鷳 �������Ҷ� aop��̫�˽�  ϣ�����ĸ����ڻظ������������ָ��
		//��û�и��õİ취����¼��������  ��Ϊ�������� ʵ���� ����javabean���ֲ�����ô������������ݶ���������?
		if (StringUtil.stringIsNull(monthRemark).equals("��Ա����")) {
			PusFrontUser pfu = (PusFrontUser) method_param[0];
			sysLog.setOperatingcontent("������Ա:" + pfu.getAccount());
		} else if (StringUtil.stringIsNull(monthRemark).equals("������ɫ")) {
			PusRole pr = (PusRole) method_param[0];
			sysLog.setOperatingcontent("������ɫ:" + pr.getName());
		} else if (StringUtil.stringIsNull(monthRemark).equals("�û���¼")) {
			PusSysUser currUser = (PusSysUser) method_param[0];
			sysLog.setOperatingcontent("��¼�ʺ�:" + currUser.getAccount());
		} else if (StringUtil.stringIsNull(monthRemark).equals("�û��˳�")) {
			sysLog.setOperatingcontent("������鿴�û���¼��־");
		} else if (StringUtil.stringIsNull(monthRemark).equals("��ɫ�����޸�")) {
			PusRole pr = (PusRole) method_param[0];
			sysLog.setOperatingcontent("�޸Ľ�ɫ:" + pr.getName());
		} else if (StringUtil.stringIsNull(monthRemark).equals("������̨�û�")) {
			PusSysUser psu = (PusSysUser) method_param[0];
			sysLog.setOperatingcontent("������̨�û�:" + psu.getAccount());
		} else if (StringUtil.stringIsNull(monthRemark).equals("���²˵�")) {
			PusMenu pm = (PusMenu) method_param[0];
			sysLog.setOperatingcontent("���²˵�:" + pm.getName());
		} else if (StringUtil.stringIsNull(monthRemark).equals("����˵�")) {
			PusMenu pm = (PusMenu) method_param[0];
			sysLog.setOperatingcontent("����˵�:" + pm.getName());
		} else if (StringUtil.stringIsNull(monthRemark).equals("�޸Ĺ�˾")) {
			ComPanyForm ciform = (ComPanyForm) method_param[0];
			sysLog.setOperatingcontent("�޸Ĺ�˾:" + ciform.getName());
		} else if (StringUtil.stringIsNull(monthRemark).equals("��ϵ�˸���")) {
			Companycontacts ct = (Companycontacts) method_param[0];
			sysLog.setOperatingcontent("��ϵ�˸���:" + ct.getName());
		} else if (StringUtil.stringIsNull(monthRemark).equals("�޸Ļ���")) {
			GoodsForm goodsForm = (GoodsForm) method_param[0];
			sysLog.setOperatingcontent("�޸Ļ������id/��ţ�:" + goodsForm.getId());
		} else if (StringUtil.stringIsNull(monthRemark).equals("��ӡ���ⵥ")) {
			DeliverBean owh= (DeliverBean) method_param[0];
			sysLog.setOperatingcontent("���ⵥ����:" + owh.getCknum());
		} else if (StringUtil.stringIsNull(monthRemark).equals("��ӡ�ᵥ")) {
			BolBean bol= (BolBean) method_param[0];
			sysLog.setOperatingcontent("�������:" + bol.getBolnum());
		} else if (StringUtil.stringIsNull(monthRemark).equals("ϵͳ���˵���ѯ")) {
			sysLog.setOperatingcontent("��");
		} else {
			sysLog.setOperatingcontent("��������:" + method_param[0]);
		}

		syslogDao.save(sysLog);
		return object;
	}

	// �������г����쳣ʱ����	
	// @AfterThrowing(pointcut = "execution(* com.wssys.controller.*(..))",
	// throwing = "ex")
	public void afterThrowing(Exception ex) {
		System.out.println("afterThrowing");
		System.out.println(ex);
	}

	// ��ȡ���������ı�ע____���ڼ�¼�û��Ĳ�����־����
	public static String getMthodRemark(ProceedingJoinPoint joinPoint)
			throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();

		Class targetClass = Class.forName(targetName);
		Method[] method = targetClass.getMethods();
		String methode = "";
		for (Method m : method) {
			if (m.getName().equals(methodName)) {
				Class[] tmpCs = m.getParameterTypes();
				if (tmpCs.length == arguments.length) {
					Method methodCache = m.getAnnotation(Method.class);
					if (methodCache != null) {
						methode = methodCache.remark();
					}
					break;
				}
			}
		}
		return methode;
	}


}

*/