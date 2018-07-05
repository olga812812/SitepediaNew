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

public class AdvOpportunitiesTests extends BaseTest {
	
	


	AdvOpportunitiesPage pageAO = new AdvOpportunitiesPage(driver);

	

	
	@Test (description="Check addition of section")
	public void advOpportunities_checkAddSection()
	{
		
		pageAO.loadSitePage();
		pageAO.clickButtonAddSection();
		pageAO.inputTextToFieldNewSectionName();
		pageAO.clickButtonSaveNewSection();
		pageAO.loadSitePage();
		Assert.assertTrue(pageAO.findNewSection());
	}
	
	
	@Test (description="Check addition of position")
	public void advOpportunities_checkAddPosition()
	{
		pageAO.loadSitePage();
		pageAO.clickButtonAddPosition();
		pageAO.inputTextToFieldNewPositionName();
		pageAO.clickButtonSaveNewPosition();
		pageAO.loadSitePage();
		Assert.assertTrue(pageAO.findNewPosition());
	}
	
	@Test (dependsOnMethods={"advOpportunities_checkAddSection"}, description="Check section name editing")
	public void advOpportunities_checkEditSectionName()
	{
		
		pageAO.loadSitePage();
		pageAO.clickButtonEditSectionName();
		sleep(1000);
		pageAO.inputNewSectionName();
		pageAO.clickButtonSaveEditedSectionName();
		pageAO.loadSitePage();
		Assert.assertTrue(pageAO.findEditedSection());
	}
	
	
	@Test(dependsOnMethods={"advOpportunities_checkEditSectionName"}, description="Check deletion of section")
	public void advOpportunities_checkDeleteSection()
	{
		pageAO.loadSitePage();
		pageAO.clickButtonDeleteSection();
		pageAO.clickButtonConfirmDeleteSection();
		pageAO.loadSitePage();
		Assert.assertFalse(pageAO.findNewSection());
	}
	
	
	@Test(dependsOnMethods={"advOpportunities_checkAddPosition"}, description="Check for deletion of position")
	public void advOpportunities_checkDeletePosition()
	{
		pageAO.loadSitePage();
		pageAO.clickButtonDeletePosition();
		pageAO.clickButtonConfirmDeletePosition();
		pageAO.loadSitePage();
		Assert.assertFalse(pageAO.findNewPosition());
	}

}
