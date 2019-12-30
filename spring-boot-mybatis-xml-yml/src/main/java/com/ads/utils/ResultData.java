package com.ads.utils;

import java.io.Serializable;

import com.ads.enums.ResultEnum;
import com.google.gson.Gson;

public class ResultData<T> implements Serializable {

	private static final long serialVersionUID = -597934362350162476L;

	private Integer code;

	private String message;

	/** 返回数据 */
	private T data;

	public ResultData(ResultEnum exceptionEnum, T data) {
		this.code = exceptionEnum.getCode();
		this.message = exceptionEnum.getMessage();
		this.data = data;
	}

	public ResultData(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public ResultData(ResultEnum exceptionEnum) {
		this.code = exceptionEnum.getCode();
		this.message = exceptionEnum.getMessage();
	}

	public static <T> ResultData<T> success(T data) {
		return new ResultData<T>(ResultEnum.CUCCESS, data);
	}

	public static <T> ResultData<T> error(Integer code, String message) {
		return new ResultData<T>(code, message);
	}

	public static <T> ResultData<T> sysError() {
		return new ResultData<T>(ResultEnum.UNKNOW_ERROR);
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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
