package tests.java.SitepediaTests;

import org.junit.Assert;
import org.testng.annotations.*;

import main.java.SitepediaPages.DirectoryPage;

public class DirectoryPageTests extends BaseTest {
	String directoryPage;
	DirectoryPage page;
	
	@Factory(dataProvider = "dataMethod")
    public DirectoryPageTests(String url) {
        this.directoryPage = url;
        page = new DirectoryPage(driver, directoryPage);
    }
 
    @DataProvider
    public static Object [][] dataMethod() {
    	return new Object[][] {
				//test Frequency Directory
				{"/#/administration/catalogs/freqperiod?rnd="},
				//test Platforms Directory
                {"/#/administration/catalogs/platform?rnd="},
                //test SocDem Directory
                {"/#/administration/catalogs/socdem?rnd="}
            };
    }
	
	
	
	@Test (dependsOnMethods={"checkCancelOfCreationNewDirectoryItem"}, description="Checking addition of directory item")
	public void checkAddDirectoryItem() {		
		page.loadPage();
		page.clickButtonAddDirectoryItem();
		page.enterDirectoryItemName();
		page.clickButtonSaveDirectoryItem();
		page.loadPage();
		Assert.assertTrue(page.findNewDirectoryItem());	
	}
	
	@Test (description="Checking cancellation of creation new directory item")
	public void checkCancelOfCreationNewDirectoryItem() {
		page.loadPage();
		page.clickButtonAddDirectoryItem();
		page.enterDirectoryItemName();
		page.clickButtonCancelCreatingNewDirectoryItem();
		page.loadPage();
		Assert.assertFalse(page.findNewDirectoryItem());
	}
	
	@Test (dependsOnMethods={"checkCancelOfEditDirectoryItem"},description="Checking editing of directory item")
	public void checkEditDirectoryItemName() {
		page.loadPage();
		page.clickButtonEditDirectoryItem();
		page.enterNewDirectoryItemName();
		page.clickButtonSaveEditedDirectoryItem();
		page.loadPage();
		Assert.assertTrue(page.findEditedDirectoryItem());	
		
	}
	
	@Test (description="Checking deletion of Directory Item")
	public void checkDeleteDirectoryItem() {
		page.loadPage();
		page.clickButtonAddDirectoryItem();
		page.enterDirectoryItemForDeletionName();
		page.clickButtonSaveDirectoryItem();
		page.loadPage();
		page.clickButtonDeleteDirectoryItem();
		page.clickButtorConfirmDeletionOfDirectoryItem();
		page.loadPage();
		Assert.assertFalse(page.findDEletedDirectoryItem());
		
	}
	
	@Test (dependsOnMethods={"checkAddDirectoryItem"}, description="Checking cancel editing of directory item")
	public void checkCancelOfEditDirectoryItem() {
		page.loadPage();
		page.clickButtonEditDirectoryItem();
		page.enterNewDirectoryItemName();
		page.clickButtonCancelChangingDirectoryItemName();
		page.loadPage();
		Assert.assertFalse(page.findEditedDirectoryItem());	
		
	}
	
	@Test (dependsOnMethods={"checkAddDirectoryItem"}, description="Checking finding directory item")
	public void checkFindDirectoryItem() {
		page.loadPage();
		page.enterDirectoryItemNameInSearchField();
		Assert.assertEquals(1, page.numberOfDirectoryItemsOnPage());
		
	}
}
