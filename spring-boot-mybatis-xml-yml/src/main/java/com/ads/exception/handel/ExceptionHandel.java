package com.ads.exception.handel;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ads.exception.model.MyException;
import com.ads.utils.ResultData;

//统一异常处理
@ControllerAdvice
public class ExceptionHandel {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

	/**
	 * 全局异常捕捉处理
	 * 
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public ResultData<Object> errorHandler(HttpServletRequest req, Exception ex) {
		if (ex instanceof MyException) {
			MyException myException = (MyException) ex;
			return ResultData.error(myException.getCode(), myException.getMessage());
		} else {
			// 异常未被捕获则进入
			logger.error("[系统异常]", ex);	
			return ResultData.sysError();
		}
	}

}
