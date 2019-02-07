package tests.java.SitepediaTests;

import junit.framework.Assert;

import org.testng.annotations.Test;

import main.java.SitepediaPages.UserInstractionsPage;

public class UserInstractionsPageTests extends BaseTest{
	
	UserInstractionsPage page = new UserInstractionsPage(driver);
	
	@Test (description="Checking saving instruction for Sysadmin")
	public void checkSaveInstructionForSysadmin() {
		page.loadPage();
		page.addInstructionFile();
		page.clickButtonSaveFile();
		Assert.assertTrue(page.checkSuccessLoadingFile());
	}
	
	@Test (dependsOnMethods="checkSaveInstructionForSysadmin", description="Checking that file we loaded and file we will receive from Sitepedia for Sysadmin are the same")
	public void checkThatLoadingFileAndFileInSitepediaAreTheSame() {
		page.getInstructionFileFromSitepedia(stp_cookie);
		page.getHashCodeForFileFromSitepedia();
		page.GetHashCodeForLoadedFile();		
		Assert.assertTrue(page.CompareTwoHashCodes());		
	}

}

	