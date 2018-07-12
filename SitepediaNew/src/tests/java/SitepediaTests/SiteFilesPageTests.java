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



public class SiteFilesPageTests extends BaseTest {

	
	SiteFilesPage page = new SiteFilesPage(driver);


	
	
	
	@Test (description="Add link on site's page  - Files")
	public void addLink()
	{
		page.loadSitePage();
		page.clickTabFiles();
		page.clickButtonAddFileOrLink();	
		page.clickListOfAttachmentType();
		page.clickLink();
		page.enterLinkName();
		page.enterLinkUrl();
		page.clickButtonSaveLink();
		Assert.assertTrue(page.findNewLink());
	}
	

	@Test (description="Add file on site's page  - Files")
	public void addFile()
	{
		page.loadSitePage();
		page.clickTabFiles();
		page.clickButtonAddFileOrLink();	
		page.clickListOfAttachmentType();
		page.clickFile();
		page.enterFileDescription();
		page.enterFilePath();
		page.clickButtonSaveFile();
		Assert.assertTrue(page.findNewFile());
	}
}
