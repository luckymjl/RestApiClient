package com.ghsoft.factory.entity;

import java.io.Serializable;

public class ResultEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9184385876606868994L;
	private Integer code;
	private String message;

	public ResultEntity() {
		
	}

	public ResultEntity(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * error code
	 * @return Integer
	 */
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * message
	 * @return String
	 */
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
