package com.ghsoft.factory.entity;

import java.io.Serializable;

public class AuthEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 2925827259232915751L;

	/** Default Parameter */

	private String tokenId;
	private Long expiresIn;

	

	public AuthEntity() {
		super();
	}

	public AuthEntity(String id, String tokenId, Long expiresIn) {
		super();	
		this.tokenId = tokenId;
		this.expiresIn = expiresIn;
	}



	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public Long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}


	

}