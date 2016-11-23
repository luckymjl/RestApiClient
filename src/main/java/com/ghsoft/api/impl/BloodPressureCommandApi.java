package com.ghsoft.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.ghsoft.api.EntityApi;
import com.ghsoft.api.conf.Config;
import com.ghsoft.factory.entity.CommandEntity;
import com.ghsoft.factory.entity.ResultEntity;
/**
 * Send command and test blood pressure
 * @author mjl
 *
 */
public class BloodPressureCommandApi extends EntityApi<CommandEntity>{

	private static String url = Config.baseUrl + "/restapi/v1/bloodPressure/cmd.action";

	private static BloodPressureCommandApi ins;

	private BloodPressureCommandApi() {
	}

	public static BloodPressureCommandApi getInstance() {
		if (ins == null) {
			ins = new BloodPressureCommandApi();
		}
		return ins;
	}
	
	/**
	 * Send Command 
	 * @param md5 device md5
	 * @return CommandEntity
	 */
	public CommandEntity send(String md5) {
		CommandEntity entity = null;
		try {
			if (super.verifiParam(md5)) {
				throw new NullPointerException("md5 is null");
			}
			List<NameValuePair> param = new ArrayList<NameValuePair>();
			param.add(new BasicNameValuePair("token", Config.getAuth().getAccessToken()));
			param.add(new BasicNameValuePair("md5", md5));
			entity = super.sendRequest(url, param, CommandEntity.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

	
}
