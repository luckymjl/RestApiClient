import com.ghsoft.api.conf.Configuration;


public class TestDemo {
	
	private static String apiKey="KGTJTSQNMIGOXDLMZBPNFKFTWCSHNODX";
	private static String baseUrl="http://test.backeytech.com:8090";
	//private static String baseUrl="http://127.0.0.1:8080";
	private static String deviceMd5="";
	
	public static void main(String[] args) {
		Configuration.init(apiKey, baseUrl);

	}

}
