package com.ghsoft.api.impl;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.ghsoft.server.util.EncodeUtils;

public class ParseCallBack {

	private static ParseCallBack ins;

	private ParseCallBack() {
	}

	public static ParseCallBack getInstance() {
		if (ins == null) {
			ins = new ParseCallBack();
		}
		return ins;
	}
	
	public void parse(HttpServletRequest request){
		BufferedReader bufferedReader;
		try {
			bufferedReader = request.getReader();		
			String str = "";  
			String line = null;  
			while((line = bufferedReader.readLine()) != null) {  
				str += EncodeUtils.urlDecode(line);  
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
