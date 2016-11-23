package com.ghsoft.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.ghsoft.api.Api;
import com.ghsoft.api.conf.Config;
import com.ghsoft.factory.entity.DeviceInfoEntity;

public class DeviceInfoApi extends Api<DeviceInfoEntity>{
	
	private static String url=Config.baseUrl+"/restapi/v1/device/getInfo.action";
	
	private static DeviceInfoApi ins;
	

	
	private DeviceInfoApi(){}
	
	public static DeviceInfoApi getInstance(){
		if(ins==null){
			ins=new DeviceInfoApi();
		}		
		return ins;
	}
	
	public DeviceInfoEntity getInfo(String md5){
		DeviceInfoEntity entity=null;
		try {
			List<NameValuePair>param =new ArrayList<NameValuePair>();
			param.add(new BasicNameValuePair("token", Config.getAuth().getAccessToken()));
			param.add(new BasicNameValuePair("md5", md5));
			entity= super.sendRequest(url, param,DeviceInfoEntity.class);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

}
