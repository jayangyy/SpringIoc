package com.domains;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {
	// ���п�������Ҫ�̳� �������������ִ���쳣����
	@ExceptionHandler
	public void exception(HttpServletRequest request, Exception e) {
	
		// ����Լ����쳣�����߼�������־��¼
		/*request.setAttribute("exceptionMessage", e.getMessage());
		System.out.print(e.toString());
		// ���ݲ�ͬ���쳣���ͽ��в�ͬ����
		if (e instanceof SQLException)
			return "testerror";
		else
			return "error";*/
	}
}
