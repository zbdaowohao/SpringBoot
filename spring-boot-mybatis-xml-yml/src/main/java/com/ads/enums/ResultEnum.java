package com.ads.enums;

public enum ResultEnum {
	
	CUCCESS(1, "成功"),
	ERROR(0, "失败"),
	UNKNOW_ERROR(-1, "未知错误");
	
	private Integer code;
	
	private String message;

	private ResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
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
