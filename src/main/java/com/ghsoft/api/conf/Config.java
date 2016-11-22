package com.ghsoft.api.conf;

import com.ghsoft.factory.entity.AuthEntity;

public class Config {
	
	public static String baseUrl;
	
	public static String apiKey;
	
	public static Integer socketTimeout=30000;
	
	public static Integer connectTimeout=3000;
	

	
	private static AuthEntity auth;
	

	public static AuthEntity getAuth() {
		return auth;
	}

	public static void setAuth(AuthEntity auth) {
		Config.auth = auth;
	}
	
	

}
