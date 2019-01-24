package tests.java.SitepediaTests;

import org.junit.Assert;
import org.testng.annotations.*;

import main.java.SitepediaPages.DirectoryPage;

public class DirectoryPageTests extends BaseTest {
	DirectoryPage page = new DirectoryPage(driver);
	String pageURL = "/#/administration/catalogs/socdem?rnd=";
	
	
	@Test (description="Checking addition of directory item")
	public void checkAddDirectoryItem() {		
		page.loadPage(pageURL);
		page.clickButtonAddDirectoryItem();
		page.enterDirectoryItemName();
		page.clickButtonSaveDirectoryItem();
		page.loadPage(pageURL);
		Assert.assertTrue(page.findNewDirectoryItem());	
	}
	
	@Test (dependsOnMethods={"checkAddDirectoryItem"},description="Checking editing of directory item")
	public void checkEditDirectoryItemName() {
		page.loadPage(pageURL);
		page.clickButtonEditDirectoryItem();
		page.enterNewDirectoryItemName();
		page.clickButtonSaveNewDirectoryItem();
		page.loadPage(pageURL);
		Assert.assertTrue(page.findEditedDirectoryItem());	
		
	}
}
