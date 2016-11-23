package com.ghsoft.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.ghsoft.api.EntityApi;
import com.ghsoft.api.conf.Config;
import com.ghsoft.factory.entity.CommandEntity;

/**
 * Send command and adjust blood pressure
 * @author mjl
 *
 */
public class AdjustBloodPressureCommandApi extends EntityApi<CommandEntity>{

	private static String url = Config.baseUrl + "/restapi/v1/bloodPressure/adjust.action";

	private static AdjustBloodPressureCommandApi ins;

	private AdjustBloodPressureCommandApi() {
	}

	public static AdjustBloodPressureCommandApi getInstance() {
		if (ins == null) {
			ins = new AdjustBloodPressureCommandApi();
		}
		return ins;
	}

	/**
	 * Send Command 
	 * @param md5 device md5
	 * @param high high pressure
	 * @param low low pressure
	 * @return CommandEntity
	 */
	public CommandEntity send(String md5,Integer high,Integer low) {
		
		CommandEntity entity = null;
		try {
			if(super.verifiParam(md5,high,low)){
				throw new NullPointerException("md5 or high or low param is null");
			}
			
			List<NameValuePair> param = new ArrayList<NameValuePair>();
			param.add(new BasicNameValuePair("token", Config.getAuth().getAccessToken()));
			param.add(new BasicNameValuePair("md5", md5));
			param.add(new BasicNameValuePair("high", Integer.toString(high)));
			param.add(new BasicNameValuePair("low", Integer.toString(low)));
			entity = super.sendRequest(url, param, CommandEntity.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

	
}
