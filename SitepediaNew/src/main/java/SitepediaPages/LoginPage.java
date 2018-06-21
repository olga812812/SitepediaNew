package main.java.SitepediaPages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {
	 WebDriver driver;
	 Common com;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		com = new Common(driver);
	}
	
	
	public String login ()
	{
		String sitepedia_url = com.propLoad().getProperty("SitepediaURL");
		driver.get(sitepedia_url);
		WebElement login = driver.findElement(By.name("username"));
		WebElement pwd = driver.findElement(By.name("password"));
		login.sendKeys("sysadmin");
		pwd.sendKeys("SYSadmin1");
		WebElement but = driver.findElement(By.id("loginFormButton"));
		but.click();
		com.waitOfPresence("linktext", "Выход");
		Set<Cookie> allCookies = driver.manage().getCookies();
		for (Cookie loadedCookie : allCookies) {
		    String key = loadedCookie.getName();
		    String value = loadedCookie.getValue();
		      if (key.equals("sitepedia.sid"))
		    {
		    	String site_key = key;
		    	String site_value = value;
		    			    	return site_key+";"+site_value;
		    }
		}
		return "null";
	
	}
	
	public void setCookies(String stp_cookie)
	{
		String[] ar = stp_cookie.split(";");
	    Cookie cookie = new Cookie(ar[0],ar[1]);
		Cookie cookie2 = new Cookie("urlparams","2");
		driver.manage().addCookie(cookie);
		driver.manage().addCookie(cookie2);
	}
}
