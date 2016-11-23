package com.ghsoft.factory.entity;

public class DeviceInfoEntity extends ResultEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8624802172377229951L;


	private Integer firmsCode;

	private Integer unitCode;	

	private String md5;
	
	private String num;
	
	private String state;
	
	private String validity;
	
	private Integer battery;

	public DeviceInfoEntity() {
		super();		
	}

	public Integer getFirmsCode() {
		return firmsCode;
	}

	public void setFirmsCode(Integer firmsCode) {
		this.firmsCode = firmsCode;
	}

	public Integer getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(Integer unitCode) {
		this.unitCode = unitCode;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public Integer getBattery() {
		return battery;
	}

	public void setBattery(Integer battery) {
		this.battery = battery;
	}
	
	
	
}
