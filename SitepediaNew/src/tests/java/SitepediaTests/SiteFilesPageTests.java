package tests.java.SitepediaTests;

import java.util.concurrent.TimeUnit;

import main.java.SitepediaPages.Common;
import main.java.SitepediaPages.SiteFilesPage;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class SiteFilesPageTests extends Assert {

	WebDriver driver;
	String stp_cookie;
	SiteFilesPage objSFP;
	Common com = new Common();
	

@Parameters("browser")
	
@BeforeClass
	 
   public void init(String browser)
	{
	 	driver=com.initDriver(browser);
	    stp_cookie = com.login(driver);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    objSFP = new SiteFilesPage(driver);
	  	
	}
	
@AfterClass
	
	public void close()
    {
      driver.quit();
	 }
	
	
	
	
	@Test (description="Add link on site's page  - Files")
	public void addLink()
	{
		boolean result= objSFP.addLink();
		assertTrue(result);
	}
	

}
