package tests.java.SitepediaTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import main.java.SitepediaPages.AddSitePage;

public class AddSitePageTests extends BaseTest {
	
	AddSitePage page = new AddSitePage(driver);
	
	@Test (description="Check addition of Site")
	public void checkAddSite()
	{
		//No LOGO check!!!
		page.loadAddSitePage();
		page.clickButtonAddSite();
		page.enterSiteName();
		page.addSiteLogoImage();
		page.addSiteOwnStatistics();
		page.addOpportunityToPlaceNonResidents();
		page.addAccreditationSiteLikeSMI();
		page.clickButtonSaveNewSite();
		Assert.assertTrue(page.findNewSite());
	}
	

}
