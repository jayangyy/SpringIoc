package com.domains;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {
@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
        Authpassport authPassport = ((HandlerMethod) handler).getMethodAnnotation(Authpassport.class);
        //û��������ҪȨ��,������������֤Ȩ��
            if(authPassport == null || authPassport.validate() == false)
            return true;
        else{     
        	
            //������ʵ���Լ���Ȩ����֤�߼�
            if(false)//�����֤�ɹ�����true������ֱ��дfalse��ģ����֤ʧ�ܵĴ���
                return true;
            else//�����֤ʧ��
            {
            	 return true;
                //���ص���¼����
                /*response.sendRedirect("account/login");
                return false;*/
            }       
        }
    }
    else
        return true;   
 }
}
