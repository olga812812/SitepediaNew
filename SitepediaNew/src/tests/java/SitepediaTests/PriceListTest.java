package tests.java.SitepediaTests;


import main.java.SitepediaPages.PriceList;
import org.openqa.selenium.*;

import org.testng.annotations.Test;
import org.testng.Assert;


public class PriceListTest extends BaseTest {

	PriceList page = new PriceList(driver);

	
	@Test (description="Check price list table's titles")
	public void priceList_checkTableTitles()
	{
		//check all Table Price-List titles
		boolean result = page.checkPriceListTitles();
		Assert.assertTrue(result);
	}
	
	@Test (description="Check of addition of extra charge of deferred payment to price list")
	public void priceList_checkAddExtraChargeForDeferredPayments()
	{
		//Add extra charge to price list and check that is was saved
		boolean result = page.addExtraChargeForDeferredPayment();
		Assert.assertTrue(result);
	}
	
	@Test (description="Check of cancel of addition of extra charge of deferred payment to price list")
	public void priceList_checkCancelOfAdditionOfExtraChargeForDeferredPayments()
	{
		//Add extra charge to price list, cancel this action and check that is wasn't saved
		boolean result = page.cancelOfAdditionOfExtraChargeForDeferredPayment();
		Assert.assertTrue(result);
	}

	
	@Test (description="Check of addition of extra charge for more than one advertiser. TestRail test case is C24.")
	public void pricelist_checkAddExtraChargeForAdvertisers()
	{
		//Add extra charge for more than one advertiser and check that it was saved
		Assert.assertTrue(page.addExtraChargeForAdvertisers());
	}
	
	@Test (description="Check of cancel of addition of extra charge for more than one advertiser")
	public void priceList_checkCancelOfAdditionOfExtraChargeForAdvertisers()
	{
		//Add extra charge to price list, cancel this action and check that is wasn't saved
		boolean result = page.cancelOfAdditionOfExtraChargeForAdvertisers();
		Assert.assertTrue(result);
	}
	
	@Test (description="Check of download of price list file")
	public void priceList_checkDownloadFile()
	{
		//Add download of price-list file
		boolean result = page.downloadPriceListInFile(stp_cookie);
		Assert.assertTrue(result);
	}
	
	@Test (description="Check of addition comment to price list")
	public void priceList_checkAddComment()
	{
		//Add comment to price list and check that is was saved
		boolean result = page.addComment();
		Assert.assertTrue(result);
	}
	
	@Test (description="Check of cancel Of addition comment to price list")
	public void priceList_checkCancelOfAdditionComment()
	{
		//Add comment to price list, cancel this action and check that is wasn't saved
		boolean result = page.cancelOfAdditionOfComment();
		Assert.assertTrue(result);
	}
}
