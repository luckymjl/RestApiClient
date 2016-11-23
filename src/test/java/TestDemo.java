import com.alibaba.fastjson.JSON;
import com.ghsoft.api.conf.Configuration;
import com.ghsoft.api.impl.AdjustBloodPressureCommandApi;
import com.ghsoft.api.impl.BloodPressureCommandApi;
import com.ghsoft.api.impl.DeviceInfoApi;
import com.ghsoft.api.impl.FamiliarityNumberCommandApi;
import com.ghsoft.api.impl.HeartHateCommandApi;
import com.ghsoft.api.impl.LocationTimeIntervalCommandApi;
import com.ghsoft.api.impl.SOSNumberCommandApi;
import com.ghsoft.factory.entity.CommandEntity;
import com.ghsoft.factory.entity.DeviceInfoEntity;


public class TestDemo {
	
	private static String apiKey="KGTJTSQNMIGOXDLMZBPNFKFTWCSHNODX";
	private static String baseUrl="http://test.backeytech.com:8090";
	private static String deviceMd5="1BFF3AF819C6A39D";
	
	public static void main(String[] args) throws Exception{
		
		Configuration.init(apiKey, baseUrl);
		
		DeviceInfoEntity deviceInfo=DeviceInfoApi.getInstance().getInfo(deviceMd5);		
		System.out.println(JSON.toJSONString(deviceInfo));
		
		CommandEntity heartHateCommand=HeartHateCommandApi.getInstance().send(deviceMd5);
		System.out.println(JSON.toJSONString(heartHateCommand));
		
		Thread.sleep(10000); //if send command too offen,then server can refuse the request
		
		CommandEntity bloodPressureCommand=BloodPressureCommandApi.getInstance().send(deviceMd5);
		System.out.println(JSON.toJSONString(bloodPressureCommand));
		
		Thread.sleep(10000);
		
		CommandEntity adjustBloodPressureCommand=AdjustBloodPressureCommandApi.getInstance().send(deviceMd5,60,110);
		System.out.println(JSON.toJSONString(adjustBloodPressureCommand));
		
		Thread.sleep(10000);
		
		CommandEntity familiarityNumberCommand=FamiliarityNumberCommandApi.getInstance().send(deviceMd5,"");
		System.out.println(JSON.toJSONString(familiarityNumberCommand));
		
		Thread.sleep(10000);
		
		CommandEntity sosNumberCommand=SOSNumberCommandApi.getInstance().send(deviceMd5,"13735878079,test");
		System.out.println(JSON.toJSONString(sosNumberCommand));
		
		Thread.sleep(10000);
		
		CommandEntity locationTimeIntervalCommandApi=LocationTimeIntervalCommandApi.getInstance().send(deviceMd5,1);
		System.out.println(JSON.toJSONString(locationTimeIntervalCommandApi));
		
	}

}
