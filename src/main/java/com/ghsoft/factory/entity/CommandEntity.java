package com.ghsoft.factory.entity;

public class CommandEntity extends ResultEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1900354469366416041L;

	private String md5;

	public CommandEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public CommandEntity(String md5,Integer code, String message) {
		super(code,message);
		this.md5 = md5;
	}


	/**
	 * device md5
	 * @return
	 */
	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

}
