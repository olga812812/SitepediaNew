package main.java.SitepediaPages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage {
	
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	
	public String login ()
	{
		String sitepedia_url = propLoad().getProperty("SitepediaURL");
		getWebDriver().get(sitepedia_url);
		WebElement login = getWebDriver().findElement(By.name("username"));
		WebElement pwd = getWebDriver().findElement(By.name("password"));
		login.sendKeys("sysadmin");
		pwd.sendKeys("SYSadmin1");
		WebElement but = getWebDriver().findElement(By.id("loginFormButton"));
		but.click();
		waitOfPresence("linktext", "Выход");
		Set<Cookie> allCookies = getWebDriver().manage().getCookies();
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
		getWebDriver().manage().addCookie(cookie);
		getWebDriver().manage().addCookie(cookie2);
	}
}
