package com.ghsoft.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.ghsoft.api.EntityApi;
import com.ghsoft.api.conf.Config;
import com.ghsoft.factory.entity.DeviceInfoEntity;
/**
 * Get device base info
 * @author mjl
 *
 */
public class DeviceInfoApi extends EntityApi<DeviceInfoEntity> {

	private static String url = Config.baseUrl + "/restapi/v1/device/getInfo.action";

	private static DeviceInfoApi ins;

	private DeviceInfoApi() {
	}

	public static DeviceInfoApi getInstance() {
		if (ins == null) {
			ins = new DeviceInfoApi();
		}
		return ins;
	}

	/**
	 * Get device base info
	 * @param md5 device md5
	 * @return CommandEntity
	 */
	public DeviceInfoEntity getInfo(String md5) {
		DeviceInfoEntity entity = null;
		try {
			if (super.verifiParam(md5)) {
				throw new NullPointerException("md5 is null");
			}
			List<NameValuePair> param = new ArrayList<NameValuePair>();
			param.add(new BasicNameValuePair("token", Config.getAuth().getAccessToken()));
			param.add(new BasicNameValuePair("md5", md5));
			entity = super.sendRequest(url, param, DeviceInfoEntity.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

}
