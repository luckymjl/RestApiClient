package com.ghsoft.factory.entity;

import java.io.Serializable;

public class AuthEntity extends ResultEntity implements Serializable {

	private static final long serialVersionUID = 2925827259232915751L;

	/** Default Parameter */

	private String accessToken;
	private Long expiresIn;

	public AuthEntity() {
		super();
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}

}