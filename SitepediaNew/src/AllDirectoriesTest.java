
import main.java.SitepediaPages.Common;
import main.java.SitepediaPages.LoginPage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import org.testng.Assert;


public class AllDirectoriesTest {
	
	
	String new_freq_text="NewFreq"+Math.random();
	WebDriver driver;
	AllDirectories objDir;
	LoginPage objLoginPage;
	String stp_cookie;
	String freq1="hello"+Math.random(), freq2="privet"+Math.random();
	String newFreq="editFreq"+Math.random();
	String url;
	
	AllDirectoriesTest(String url1)
	{
		this.url=url1;
		
	}

	

	
@BeforeClass
	 
   public void init()
	{
		Common.chromeDriver();
	    driver = new ChromeDriver();
	    System.out.println(url);
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
		System.out.println(this.url);
		//create object of frequency directory Page
		objDir = new AllDirectories(driver);
		//add new frequency
		objDir.createObj(url,new_freq_text);
		//find created frequency
		boolean result = objDir.findObj(url,new_freq_text);
	   	Assert.assertTrue(result);
		
		
			
	}
	
	@Test (dependsOnMethods = {"Add_freq"}, description="Delete frequency")
	public void Del_freq()
	{
	    // delete frequency that was created in test Add_freq
		objDir.delObj(url,new_freq_text); 
		boolean result = objDir.findObj(url,new_freq_text);
		Assert.assertFalse(result);
	               
	    			
	}
	
	@Test (dependsOnMethods = {"Add_freq"}, description="Testing searching of frequency")
	public void Find_freq()
	{
		//create 2 frequencies
		objDir.createObj(url, freq1);
		objDir.createObj(url, freq2);
		//enter full name of frequency1 in searching box and check that there is no frequency2
		boolean result = objDir.enterFindObj(url,freq1,freq2);
	    Assert.assertFalse(result);
	              
	   			
	}
	
	@Test ( dependsOnMethods = {"Add_freq"}, description="Edit frequency")
	public void Edit_freq()
	{
		//create frequency
		objDir.createObj(url, newFreq);
		//edit frequency
		String editedFreq = objDir.editObj(url,newFreq);
		//find edited frequency
		boolean isHere = objDir.findObj(url,editedFreq);
		Assert.assertTrue(isHere);
		//find that there is no initial frequency
		boolean result = objDir.findObj(url,newFreq);
		Assert.assertFalse(result);
	              
	   			
	}
	

	

}





