package tests.java.SitepediaTests;

import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;
import org.json.simple.JSONObject;


public class TestRailApi {
	
	public void sendReq ()
	{
		APIClient client = new APIClient("http://<server>/testrail/");
		client.setUser("..");
		client.setPassword("..");
		try{
		JSONObject c = (JSONObject) client.sendGet("get_case/1");
		System.out.println(c.get("title"));
		}
		catch (Exception ex) {ex.printStackTrace();}
		
	}

}
