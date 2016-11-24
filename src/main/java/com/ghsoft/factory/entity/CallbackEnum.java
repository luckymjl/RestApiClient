package com.ghsoft.factory.entity;

public enum CallbackEnum {
	
	BODY_TEMPERATURE		("BODY_TEMPERATURE"),
	HUMIDITY				("HUMIDITY"),
	CARBON_MONOXIDE			("CARBON_MONOXIDE"),
	BLOOD_OXYGEN			("BLOOD_OXYGEN"),
	BLOOD_GLUCOSE			("BLOOD_GLUCOSE"),
	AT_HOME					("AT_HOME"),
	LEAVE_HOME				("LEAVE_HOME"),
	LOW_BATTERY				("LOW_BATTERY"),
	NOT_WEAR				("NOT_WEAR"),
	HEART_RATE				("HEART_RATE"),
	DEVICE_SLEEP			("DEVICE_SLEEP"),
	LOW_TEMPERATURE			("LOW_TEMPERATURE"),
	HIGH_TEMPERATURE		("HIGH_TEMPERATURE"),
	FALL_DOWN				("FALL_DOWN"),
	BLOOD_PRESSURE			("BLOOD_PRESSURE"),
	SOS_ALARM				("SOS_ALARM"),
	I_AM_SAFE				("I_AM_SAFE"),
	BLUETOOTH_LOCATION		("BLUETOOTH_LOCATION"),
	BLUETOOTH_SIGN			("BLUETOOTH_SIGN"),
	DEVICE_OFFLINE			("DEVICE_OFFLINE"),
	IN_FENCE				("IN_FENCE"),
	OUT_FENCE				("OUT_FENCE"),
	LATEST_LOCATION			("LATEST_LOCATION"),
	LATEST_STEP				("LATEST_STEP"),
	LATEST_BLOOD_PRESSURE	("LATEST_BLOOD_PRESSURE"),
	LATEST_HEART_RATE		("LATEST_HEART_RATE");
	
	private String name;
	

	private CallbackEnum(String name) {
		this.name = name;		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		CallbackEnum.valueOf("LATEST_HEART_RATE");
	}
}