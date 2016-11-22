package com.ghsoft.factory.entity;




public class ApiResult<T> {
	private Integer state;
	private String message;
	private T result;
	private Integer code=0;

/////////////////////////////////////////////////////////////////////////////////////////////////////
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResult() {
		return  result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
