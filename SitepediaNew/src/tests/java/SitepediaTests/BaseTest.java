package tests.java.SitepediaTests;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import main.java.SitepediaPages.Common;

public class BaseTest extends Common{
	
	
	static WebDriver driver = initDriver(propLoad().getProperty("browser"));
	String stp_cookie;
	

	
@BeforeClass
		 
	   public void init()
		{
		    stp_cookie=login(driver);
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 }
	
@AfterClass
	    public void close()
	     {
	       driver.quit();
		 }

@Override
public WebDriver getWebDriver() {
	// TODO Auto-generated method stub
	return driver;
}


public static  WebDriver initDriver (String browser)
{
	System.out.println("here: "+browser);
	if(browser.equalsIgnoreCase("firefox")) {
		 
		WebDriverManager.firefoxdriver().setup();		
		 driver = new FirefoxDriver();
	  
	  }else if (browser.equalsIgnoreCase("ie")) { 
	 
		  
		  WebDriverManager.iedriver().setup();
		  //InternetExplorerDriverManager.getInstance().setup(); 
		 
		  DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
		  ieCapabilities.setCapability("requireWindowFocus", true);
          ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
true);
          Common.ieDriver();
		  driver = new InternetExplorerDriver(ieCapabilities);
	 
	  } else if (browser.equalsIgnoreCase("chrome"))
	  {
		
		 WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	  }
	

	return driver;

}

}
