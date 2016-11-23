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
 * Send command and set familiarity number
 * @author mjl
 *
 */
public class FamiliarityNumberCommandApi extends EntityApi<CommandEntity>{

	private static String url = Config.baseUrl + "/restapi/v1/familiarityNumber/set.action";

	private static FamiliarityNumberCommandApi ins;

	private FamiliarityNumberCommandApi() {
	}

	public static FamiliarityNumberCommandApi getInstance() {
		if (ins == null) {
			ins = new FamiliarityNumberCommandApi();
		}
		return ins;
	}

	/**
	 * Send Command 
	 * @param md5 device md5
	 * @param content Batch:telephone number1,show name1|telephone number2,show name2|telephone number...,show name...
	 *				  Notice 1:Batch max: 5count/once.
	 *						 2:If you want to clear this info,you can keep ‘content’ null;
	 * @return CommandEntity
	 */
	public CommandEntity send(String md5,String content) {
		CommandEntity entity = null;
		try {
			if (super.verifiParam(md5)) {
				throw new NullPointerException("md5 or content is null");
			}
			List<NameValuePair> param = new ArrayList<NameValuePair>();
			param.add(new BasicNameValuePair("token", Config.getAuth().getAccessToken()));
			param.add(new BasicNameValuePair("md5", md5));
			param.add(new BasicNameValuePair("content", content));
			entity = super.sendRequest(url, param, CommandEntity.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

	
}
