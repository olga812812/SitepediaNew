
import main.java.SitepediaPages.Common;
import main.java.SitepediaPages.LoginPage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;


public class FreqDirTest {
	
	
	String new_freq_text="NewFreq"+Math.random();
	WebDriver driver;
	FreqDir objFreqDir;
	LoginPage objLoginPage;
	String stp_cookie;
	String freq1="hello"+Math.random(), freq2="privet"+Math.random();
	String newFreq="editFreq"+Math.random();

	
@BeforeClass
	 
   public void init()
	{
		Common.chromeDriver();
	    driver = new ChromeDriver();
	    stp_cookie = LoginPage.login(driver);
	    LoginPage.setCookies(driver, stp_cookie);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
			 }
@AfterClass
    public void close()
     {
       driver.quit();
	 }



	
	@Test (description="Add new frequency")
	public void Add_freq()
	
	{
		//create object of frequency directory Page
		objFreqDir = new FreqDir(driver);
		//add new frequency
		objFreqDir.createFreq(new_freq_text);
		//find created frequency
		boolean result = objFreqDir.findFreq(new_freq_text);
	   	Assert.assertTrue(result);
		
		
			
	}
	
	@Test (dependsOnMethods = {"Add_freq"}, description="Delete frequency")
	public void Del_freq()
	{
	    // delete frequency that was created in test Add_freq
		objFreqDir.delFreq(new_freq_text); 
		boolean result = objFreqDir.findFreq(new_freq_text);
		Assert.assertFalse(result);
	               
	    			
	}
	
	@Test (dependsOnMethods = {"Add_freq"}, description="Testing searching of frequency")
	public void Find_freq()
	{
		//create 2 frequencies
		objFreqDir.createFreq(freq1);
		objFreqDir.createFreq(freq2);
		//enter full name of frequency1 in searching box and check that there is no frequency2
		boolean result = objFreqDir.enterFindFreq(freq1,freq2);
	    Assert.assertFalse(result);
	              
	   			
	}
	
	@Test (dependsOnMethods = {"Add_freq"}, description="Edit frequency")
	public void Edit_freq()
	{
		//create frequency
		objFreqDir.createFreq(newFreq);
		//edit frequency
		String editedFreq = objFreqDir.editFreq(newFreq);
		//find edited frequency
		boolean isHere = objFreqDir.findFreq(editedFreq);
		Assert.assertTrue(isHere);
		//find that there is no initial frequency
		boolean result = objFreqDir.findFreq(newFreq);
		Assert.assertFalse(result);
	              
	   			
	}
	

	

	}
