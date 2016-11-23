package com.ghsoft.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.ghsoft.api.EntityApi;
import com.ghsoft.api.conf.Config;
import com.ghsoft.factory.entity.AuthEntity;

public class AuthApi extends EntityApi<AuthEntity> {
	
	
	
	private static String authApiUrl=Config.baseUrl+"/restapi/v1/token/get.action";
	
	
	private static AuthApi ins;
	
	private AuthApi(){}
	
	public synchronized static AuthApi getInstance(){
		if(ins==null){
			ins=new AuthApi();
		}
		return ins;
	}
	
	
	public AuthEntity getAuth(){
		AuthEntity entity=null;
		try {
			List<NameValuePair>param =new ArrayList<NameValuePair>();
			param.add(new BasicNameValuePair("apiKey", Config.apiKey));
			entity= super.sendRequest(authApiUrl, param,AuthEntity.class);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  entity;
	}

}
