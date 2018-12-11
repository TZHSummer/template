package com.mlj.tshop.backend.controller.exception;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理类
 * @author mlj
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private static Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception ex) {
		ex.printStackTrace();
		logger.debug(ex);
		return "error.jsp";
	}
}
