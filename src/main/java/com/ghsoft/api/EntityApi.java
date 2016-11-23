package com.ghsoft.api;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ghsoft.factory.entity.ApiCode;
import com.ghsoft.factory.entity.ApiResult;
import com.ghsoft.factory.entity.BaseEntity;
import com.ghsoft.server.client.HttpUtils;

public abstract class EntityApi<T extends BaseEntity>{
	
	private static HttpUtils http =HttpUtils.getInstance();
	
	
	
	public T sendRequest(String authApiUrl,List<NameValuePair> param,Class<T> cl)throws Exception{
		T entity= null;		
		ApiResult apiResult=null;		
		String result=http.httpPostNameValue(authApiUrl, param);		
		if(StringUtils.isNotBlank(result)){			
			apiResult=JSON.parseObject(result,ApiResult.class);			
			if(apiResult.getState()!=ApiCode.SUCCESS){
				entity=cl.newInstance();
				entity.setCode(apiResult.getCode());
				entity.setMessage(apiResult.getMessage());
			}else{
				if(apiResult.getResult() instanceof JSONObject){					
					entity=	JSON.parseObject(apiResult.getResult().toString(), cl);
				}
			}
		}else{
			throw new Exception("api can not access url:"+authApiUrl);
		}
		return entity;
	}

}
