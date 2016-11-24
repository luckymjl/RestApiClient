package com.ghsoft.api;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ghsoft.api.conf.Config;
import com.ghsoft.factory.entity.ApiCode;
import com.ghsoft.factory.entity.ApiResult;
import com.ghsoft.factory.entity.ResultEntity;
import com.ghsoft.server.util.HttpUtils;

public abstract class Api<T extends ResultEntity>{
	
	private static HttpUtils http =HttpUtils.getInstance();
	
	private static AtomicInteger count=new AtomicInteger();
	
	public T sendRequest(String authApiUrl,List<NameValuePair> param,Class<T> cl)throws Exception{
		T entity= null;		
		ApiResult apiResult=null;		
		String responce=http.httpPostNameValue(authApiUrl, param);		
		if(StringUtils.isNotBlank(responce)){			
			apiResult=JSON.parseObject(responce,ApiResult.class);			
			if(apiResult.getState()!=ApiCode.SUCCESS){
				entity=cl.newInstance();
				entity.setCode(apiResult.getCode());
				entity.setMessage(apiResult.getMessage());
			}else{
				Object result=apiResult.getResult();
				if(result!=null && (result instanceof JSONObject)){					
					entity=	JSON.parseObject(apiResult.getResult().toString(), cl);
				}else if(result == null){
					entity=cl.newInstance();
					entity.setCode(apiResult.getCode());
					entity.setMessage(apiResult.getMessage());
				}
			}
			
			if(entity!=null && entity.getCode() == ApiCode.CODE_INVALID_TOKEN){
				Integer times=count.addAndGet(1);
				if(times>3){
					count=new AtomicInteger();
					return entity;
				}
				Config.getAuth();
				return this.sendRequest(authApiUrl, param, cl);
			}
			
		}else{
			throw new Exception("api can not access url:"+authApiUrl);
		}
		return entity;
	}
	
	/** 非空验证 */
	public boolean verifiParam(Object... object) throws Exception{
		for (int i = 0; i < object.length; i++) {
			if(object[i] == null){
				return true;
			}else if((object[i] instanceof String) && StringUtils.isBlank((String)object[i])){
				return true;
			}
		}
		return false;
	}

}
