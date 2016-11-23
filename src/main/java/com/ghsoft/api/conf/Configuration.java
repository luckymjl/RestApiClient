package com.ghsoft.api.conf;

import com.ghsoft.api.impl.AuthApi;
import com.ghsoft.factory.entity.AuthEntity;


public class Configuration {
	
	

	/**
	 * config api param
	 * @param apiKey  api key
	 * @param baseUrl service domain name and port
	 */
	public synchronized static void init(String apiKey,String baseUrl){		
		Config.apiKey=apiKey;
		Config.baseUrl=baseUrl;
		AuthEntity entity=AuthApi.getInstance().getAuth();
		Config.setAuth(entity);
	}
	
	/**
	 * config api param
	 * @param apiKey api key
	 * @param baseUrl service domain name and port
	 * @param socketTimeout http read timeout,defult 30000
	 * @param ConnectTimeout http connect timeout,defult 3000
	 * @param readTimeout http read timeout
	 */
	public synchronized static void init(String apiKey,String baseUrl,Integer socketTimeout,Integer ConnectTimeout,Integer readTimeout){		
		Config.apiKey=apiKey;
		Config.baseUrl=baseUrl;
		Config.socketTimeout=socketTimeout;
		Config.connectTimeout=ConnectTimeout;		
		AuthEntity entity=AuthApi.getInstance().getAuth();
		Config.setAuth(entity);
	}
 
	
	public static void updateAuth(){
		AuthEntity entity=AuthApi.getInstance().getAuth();
		Config.setAuth(entity);
	}

}
