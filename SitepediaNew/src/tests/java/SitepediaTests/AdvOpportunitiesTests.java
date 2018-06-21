package tests.java.SitepediaTests;
import java.util.concurrent.TimeUnit;

import main.java.SitepediaPages.AdvOpportunitiesPage;
import main.java.SitepediaPages.Common;
import main.java.SitepediaPages.PriceList;

import org.openqa.selenium.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;

public class AdvOpportunitiesTests {
	

	WebDriver driver;
	String stp_cookie;
	AdvOpportunitiesPage objAO;
	Common com = new Common();
	boolean result;
	

@Parameters("browser")
	
@BeforeClass
	 
   public void init(String browser)
	{
	
        driver=com.initDriver(browser);
   	   stp_cookie = com.login(driver);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    objAO = new AdvOpportunitiesPage(driver);
	  
	  	
			 }
@AfterClass
    public void close()
     {
       driver.quit();
	 }

	
	@Test (description="Check for addition of section")
	public void advOpportunities_checkAddSection()
	{
		result = objAO.addSection();
		Assert.assertTrue(result);
	}
	
	@Test (description="Check for addition of position")
	public void advOpportunities_checkAddPosition()
	{
		result=objAO.addPosition();
		Assert.assertTrue(result);
	}
	
	@Test(dependsOnMethods={"advOpportunities_checkAddSection"}, description="Check for deletion of section")
	public void advOpportunities_checkDeleteSection()
	{
		result=objAO.deleteSection();
		Assert.assertTrue(result);
	}
	
	@Test(dependsOnMethods={"advOpportunities_checkAddPosition"}, description="Check for deletion of position")
	public void advOpportunities_checkDeletePosition()
	{
		result=objAO.deletePosition();
		Assert.assertTrue(result);
	}

}
