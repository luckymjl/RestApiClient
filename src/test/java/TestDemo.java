import com.alibaba.fastjson.JSON;
import com.ghsoft.api.conf.Configuration;
import com.ghsoft.api.impl.DeviceInfoApi;
import com.ghsoft.factory.entity.DeviceInfoEntity;


public class TestDemo {
	
	private static String apiKey="KGTJTSQNMIGOXDLMZBPNFKFTWCSHNODX";
	private static String baseUrl="http://test.backeytech.com:8090";
	private static String deviceMd5="1BFF3AF819C6A39D";
	
	public static void main(String[] args) {
		Configuration.init(apiKey, baseUrl);
		DeviceInfoEntity deviceInfo=DeviceInfoApi.getInstance().getInfo(deviceMd5);		
		System.out.println(JSON.toJSONString(deviceInfo));
		
	}

}
