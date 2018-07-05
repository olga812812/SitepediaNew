package main.java.SitepediaPages;


import java.util.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.WebDriver;




public abstract class Common {
	
	
	public abstract WebDriver getWebDriver();
	
	
	LoginPage pageLogin;
	String stp_cookie;
	

	public String login(WebDriver driver)
	{
		pageLogin = new LoginPage(driver);
	    stp_cookie = pageLogin.login();
	    pageLogin.setCookies(stp_cookie);
	    
	    return stp_cookie;
	    
	}
	
	public static void ieDriver ()
	{
		 System.setProperty("webdriver.ie.driver", "C:\\Users\\ovalekseeva\\Sitepedia\\IEDriverServer.exe");
	}
	

	public static void sleep(int time)
	{
		try
		{Thread.sleep(time);}
		catch(Exception e)
		{e.printStackTrace();};
		
	}
  
	
	
	public static HttpURLConnection makeHttpReq(String url_string, String cookie)
	{
		try{
			String[] ar = cookie.split(";");    
			URL url = new URL(url_string);
			    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			    conn.setRequestMethod("GET");
			    System.out.println (ar[0]+"="+ar[1]+"; urlparams=2" + "\n");
			    conn.setRequestProperty("Cookie",ar[0]+"="+ar[1]+"; urlparams=2");
			       		
			    conn.connect();
			     return conn;
			    }catch(IOException ex)
			    {
			    ex.printStackTrace();
			     return null;
			    }
	}
	
	
	
	public static Properties propLoad ()
	{
	Properties prop = new Properties();
	InputStream stream = null;
	InputStreamReader reader = null;

	try {
		 stream = new FileInputStream(new File("Sitepedia.properties"));
	    reader = new InputStreamReader(stream,"Windows-1251");
	    prop.load(reader);
	} catch (Exception ex) {System.out.println(ex);}


	return prop;

	}
	
	

	 
}
