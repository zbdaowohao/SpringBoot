package com.ads.exception.model;

import com.ads.enums.ResultEnum;

public class MyException extends RuntimeException {

	private static final long serialVersionUID = -4400146829590202418L;

	private Integer code;

	private String message;

	public MyException(ResultEnum resultEnum) {
		this.code = resultEnum.getCode();
		this.message = resultEnum.getMessage();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
