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

	

	
	@Test (description="Check for addition of section")
	public void advOpportunities_checkAddSection()
	{
		
		pageAO.loadSitePage();
		pageAO.clickButtonAddSection();
		pageAO.inputTextToFieldNewSectionName();
		pageAO.clickButtonSaveNewSection();
		pageAO.loadSitePage();
		Assert.assertTrue(pageAO.findNewSection());
	}
	
	/*
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
*/
}
