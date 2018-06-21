package tests.java.SitepediaTests;

import main.java.SitepediaPages.Common;
import main.java.SitepediaPages.PriceList;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;


public class PriceListTest {
	

	WebDriver driver;
	String stp_cookie;
	PriceList objPL;
	Common com = new Common();
	

@Parameters("browser")
	
@BeforeClass
	 
   public void init(String browser)
	{
	
        driver=com.initDriver(browser);
   	   stp_cookie = com.login(driver);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    objPL = new PriceList(driver);
	  	
			 }
@AfterClass
    public void close()
     {
       driver.quit();
	 }

	
	@Test (description="Check price list table's titles")
	public void priceList_checkTableTitles()
	{
		//check all Table Price-List titles
		boolean result = objPL.checkPriceListTitles();
		Assert.assertTrue(result);
	}
	
	@Test (description="Check of addition of extra charge of deferred payment to price list")
	public void priceList_checkAddExtraChargeForDeferredPayments()
	{
		//Add extra charge to price list and check that is was saved
		boolean result = objPL.addExtraChargeForDeferredPayment();
		Assert.assertTrue(result);
	}
	
	@Test (description="Check of cancel of addition of extra charge of deferred payment to price list")
	public void priceList_checkCancelOfAdditionOfExtraChargeForDeferredPayments()
	{
		//Add extra charge to price list, cancel this action and check that is wasn't saved
		boolean result = objPL.cancelOfAdditionOfExtraChargeForDeferredPayment();
		Assert.assertTrue(result);
	}

	
	@Test (description="Check of addition of extra charge for more than one advertiser. TestRail test case is C24.")
	public void pricelist_checkAddExtraChargeForAdvertisers()
	{
		//Add extra charge for more than one advertiser and check that it was saved
		Assert.assertTrue(objPL.addExtraChargeForAdvertisers());
	}
	
	@Test (description="Check of cancel of addition of extra charge for more than one advertiser")
	public void priceList_checkCancelOfAdditionOfExtraChargeForAdvertisers()
	{
		//Add extra charge to price list, cancel this action and check that is wasn't saved
		boolean result = objPL.cancelOfAdditionOfExtraChargeForAdvertisers();
		Assert.assertTrue(result);
	}
	
	@Test (description="Check of download of price list file")
	public void priceList_checkDownloadFile()
	{
		//Add download of price-list file
		boolean result = objPL.downloadPriceListInFile(stp_cookie);
		Assert.assertTrue(result);
	}
	
	@Test (description="Check of addition comment to price list")
	public void priceList_checkAddComment()
	{
		//Add comment to price list and check that is was saved
		boolean result = objPL.addComment();
		Assert.assertTrue(result);
	}
	
	@Test (description="Check of cancel Of addition comment to price list")
	public void priceList_checkCancelOfAdditionComment()
	{
		//Add comment to price list, cancel this action and check that is wasn't saved
		boolean result = objPL.cancelOfAdditionOfComment();
		Assert.assertTrue(result);
	}
}
