package tests.java.SitepediaTests;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import main.java.SitepediaPages.Common;

public class BaseTest extends Common{
	
	static WebDriver driver = initDriver("Chrome");
	String stp_cookie;
	
@Parameters("browser")
	
@BeforeClass
		 
	   public void init(String browser)
		{
		  
		    System.out.println("driver before init: "+driver);
		  //  driver=initDriver(browser);
		    System.out.println("driver after iniDriver: "+driver);
	   	    stp_cookie = login(driver);
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
		 
		// Common.fireFoxDriver(); 
		// FirefoxDriverManager.setup(); 
		 FirefoxDriverManager.getInstance().setup(); 
		 driver = new FirefoxDriver();
	  
	  }else if (browser.equalsIgnoreCase("ie")) { 
	 
		  
		  InternetExplorerDriverManager.getInstance().setup(); 
		 
		  DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
		  ieCapabilities.setCapability("requireWindowFocus", true);
          ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
true);
          Common.ieDriver();
		  driver = new InternetExplorerDriver(ieCapabilities);
	 
	  } else if (browser.equalsIgnoreCase("chrome"))
	  {
		//Common.chromeDriver();
		ChromeDriverManager.getInstance().setup();
	    driver = new ChromeDriver();
	  }
	

	return driver;

}

}
