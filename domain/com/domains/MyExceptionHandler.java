package com.domains;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionHandler implements HandlerExceptionResolver  {

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception arg3) {
		//����쳣��¼����־����
		/*// TODO Auto-generated
		 * method stub
		logger.error("Catch Exception: ", arg3);// ��©�����쳣��Ϣ������־
		Map<String, Object> map = new HashMap<String, Object>();
		StringPrintWriter strintPrintWriter = new StringPrintWriter();
		ex.printStackTrace(strintPrintWriter);
		map.put("errorMsg", strintPrintWriter.getString());// ��������Ϣ���ݸ�view 
*/	        return new ModelAndView("error","", arg2);  
	}

}
