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

	WebDriver driver;
	String stp_cookie;
	SiteFilesPage pageFiles;


	
	
	
	@Test (description="Add link on site's page  - Files")
	public void addLink()
	{
		boolean result= pageFiles.addLink();
		Assert.assertTrue(result);
	}
	

}
