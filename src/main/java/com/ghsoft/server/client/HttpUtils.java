package com.ghsoft.server.client;

import java.io.IOException;
import java.net.URLEncoder;
import java.security.cert.CertificateException;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.ghsoft.api.conf.Config;

@SuppressWarnings("deprecation")
public class HttpUtils {
	
	private static HttpUtils ins=null;
	
	private HttpUtils(){}
	
	public synchronized static HttpUtils getInstance(){
		if(ins==null){
			ins=new HttpUtils();
		}
		return ins;
	}
	
	
	
	public String httpPostNameValue(String url,List<NameValuePair> list){
		CloseableHttpResponse response = null;
		try {			
			CloseableHttpClient httpClient = HttpClients.createDefault();
//			if (url.toUpperCase().indexOf("HTTPS://") != -1) {
//				enableSSL(httpClient);
//			}
			
			URIBuilder uriBuilder = new URIBuilder(url);
			
			uriBuilder.addParameters(list);			
			HttpPost httpPost = new HttpPost(uriBuilder.build());
			//请求配置
			RequestConfig requestConfig =this.getRequestConfig();
			//设置头
			this.setHeader(httpPost, requestConfig);	
			response =httpClient.execute(httpPost);
			return this.factory(response);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(response!=null){
				try {
					EntityUtils.consume(response.getEntity());	
					response.close();
				} catch (IOException e) {					
					e.printStackTrace();
				}
			}
		}		
		return null;
	}
	
	
	
	
	public String httpPostWithJSON(String url, String json){	
		CloseableHttpResponse response = null;
		try {
			// 将参数进行UTF-8编码,以便传输中文
			String encoderJson = URLEncoder.encode(json, HTTP.UTF_8);			
			DefaultHttpClient httpClient = new DefaultHttpClient();
			if (url.toUpperCase().indexOf("HTTPS://") != -1) {
				enableSSL(httpClient);
			}
			HttpPost httpPost = new HttpPost(url);
			//请求配置
			RequestConfig requestConfig =this.getRequestConfig();
			//设置头
			this.setHeader(httpPost, requestConfig);		
			StringEntity se = new StringEntity(encoderJson);
			httpPost.setEntity(se);
			response =httpClient.execute(httpPost);
			return this.factory(response);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(response!=null){
				try {
					EntityUtils.consume(response.getEntity());	
					response.close();
				} catch (IOException e) {					
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	private RequestConfig getRequestConfig()throws Exception{
		RequestConfig requestConfig = RequestConfig.custom()
				.setConnectTimeout(Config.connectTimeout)
				.setSocketTimeout(Config.socketTimeout)				
				.setConnectionRequestTimeout(1000)
				.build();
		return requestConfig;
	}
	
	private void setHeader(HttpPost httpPost,RequestConfig requestConfig)throws Exception{
		httpPost.setConfig(requestConfig);
		httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8");		
	}
	
	
	private String factory(CloseableHttpResponse response)throws Exception{
		String result=null;		
		if(response.getStatusLine().getStatusCode()==200){
			if(response.getEntity()==null){
				return result;
			}
			result=EntityUtils.toString(response.getEntity());					
			if(StringUtils.isBlank(result)){
				return result;
			}
			return result;
		}
		response.close();
		return result;
	}

	/** 访问https的网站 */
	private static void enableSSL(DefaultHttpClient httpclient) {
		// 调用ssl
		try {
			SSLContext sslcontext = SSLContext.getInstance("TLS");
			sslcontext.init(null, new TrustManager[] { truseAllManager }, null);
			SSLSocketFactory sf = new SSLSocketFactory(sslcontext);
			sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			Scheme https = new Scheme("https", sf, 443);
			httpclient.getConnectionManager().getSchemeRegistry().register(https);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 重写验证方法，取消检测ssl */
	private static TrustManager truseAllManager = new X509TrustManager() {

		public void checkClientTrusted(
				java.security.cert.X509Certificate[] arg0, String arg1)
				throws CertificateException {
			// TODO Auto-generated method stub

		}

		public void checkServerTrusted(
				java.security.cert.X509Certificate[] arg0, String arg1)
				throws CertificateException {
			// TODO Auto-generated method stub

		}

		public java.security.cert.X509Certificate[] getAcceptedIssuers() {
			// TODO Auto-generated method stub
			return null;
		}

	};

}
