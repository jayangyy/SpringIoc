package com.domains;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {
	// 所有控制器需要继承 基类控制器才能执行异常处理
	@ExceptionHandler
	public void exception(HttpServletRequest request, Exception e) {
	
		// 添加自己的异常处理逻辑，如日志记录
		/*request.setAttribute("exceptionMessage", e.getMessage());
		System.out.print(e.toString());
		// 根据不同的异常类型进行不同处理
		if (e instanceof SQLException)
			return "testerror";
		else
			return "error";*/
	}
}
