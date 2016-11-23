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
 * Send command and set the location model of upload at once
 * @author mjl
 *
 */
public class LocationTimeIntervalCommandApi extends EntityApi<CommandEntity>{

	private static String url = Config.baseUrl + "/restapi/v1/uploadInterval/set.action";

	private static LocationTimeIntervalCommandApi ins;

	private LocationTimeIntervalCommandApi() {
	}

	public static LocationTimeIntervalCommandApi getInstance() {
		if (ins == null) {
			ins = new LocationTimeIntervalCommandApi();
		}
		return ins;
	}
	
	/**
	 * Send Command 
	 * @param md5 device md5
	 * @param type 1:One minute 2:Fifteen minutes
	 * @return CommandEntity
	 */
	public CommandEntity send(String md5,Integer type) {
		CommandEntity entity = null;
		try {
			if (super.verifiParam(md5)) {
				throw new NullPointerException("md5 is null");
			}
			List<NameValuePair> param = new ArrayList<NameValuePair>();
			param.add(new BasicNameValuePair("token", Config.getAuth().getAccessToken()));
			param.add(new BasicNameValuePair("md5", md5));
			param.add(new BasicNameValuePair("type", Integer.toString(type)));
			entity = super.sendRequest(url, param, CommandEntity.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

	
}
