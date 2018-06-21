import main.java.SitepediaPages.Common;
import main.java.SitepediaPages.LoginPage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class FilePageTest {

	WebDriver driver;
	FilePage objFile;
	LoginPage objLoginPage;
	String stp_cookie;
	Properties prop;
	
	
@BeforeClass
	 
   public void init()
	{
		Common.chromeDriver();
	    driver = new ChromeDriver();
	    stp_cookie = LoginPage.login(driver);
	    LoginPage.setCookies(driver, stp_cookie);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    prop = Common.propload();
	    objFile = new FilePage(driver);
		
			 }
@AfterClass
    public void close()
     {
       driver.quit();
	 }

@Test (description="Add new file to site")
public void AddFile()

{
	//Get filename from properties file
	String filename = prop.getProperty("addFile");
	//Create short file name for checking on the page after adding
	String filenameShort = filename.substring(filename.lastIndexOf('\\')+1, filename.length());
	//Add new file to site
	objFile.addFile(filename);
	//check that file is on the page
	boolean result=objFile.checkFile(filenameShort);
	Assert.assertTrue(result);
}

@Test (description="Delete file")
public void DeleteFile()

{
	//Get filename from properties file
	String fileToDelete = prop.getProperty("fileToDelete");
	//Create short file name for checking on the page after adding
	String filenameShort = fileToDelete.substring(fileToDelete.lastIndexOf('\\')+1, fileToDelete.length());
	//check that file is not on the page
	Boolean result = objFile.checkFile(filenameShort);
	Assert.assertFalse(result);
	//Assert.assertFalse(objFile.checkFile(filenameShort));	
	//Add new file to site
	objFile.addFile(fileToDelete);
	//check that file is on the page
	Assert.assertTrue(objFile.checkFile(filenameShort));
	objFile.deleteFile(filenameShort);
	//check that file is not on the page
	Assert.assertFalse(objFile.checkFile(filenameShort));
}



}


