package main.java.SitepediaPages;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

import java.util.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;



public class Common {
	
	WebDriver driver;
	LoginPage loginPageObj;
	String stp_cookie;
	

	
	public Common ()
	{
		
	}
	public Common (WebDriver driver)
	
	{
		this.driver=driver;
	}
	
	public String login(WebDriver driver)
	{
		loginPageObj = new LoginPage(driver);
	    stp_cookie = loginPageObj.login();
	    loginPageObj.setCookies(stp_cookie);
	    
	    return stp_cookie;
	}
	
	public WebDriver initDriver (String browser)
	{
		System.out.println("here: "+browser);
		if(browser.equalsIgnoreCase("firefox")) {
			 
			// Common.fireFoxDriver(); 
			// FirefoxDriverManager.setup(); 
			 FirefoxDriverManager.getInstance().setup(); 
			 driver = new FirefoxDriver();
		  
		  }else if (browser.equalsIgnoreCase("ie")) { 
		 
			  
			  InternetExplorerDriverManager.getInstance().setup(); 
			 
			  DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			  ieCapabilities.setCapability("requireWindowFocus", true);
	          ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
	true);
	          Common.ieDriver();
			  driver = new InternetExplorerDriver(ieCapabilities);
		 
		  } else if (browser.equalsIgnoreCase("chrome"))
		  {
			//Common.chromeDriver();
			ChromeDriverManager.getInstance().setup();
		    driver = new ChromeDriver();
		  }
		
	
		return driver;
	
	}
	
	public static void chromeDriver ()
	{
		System.setProperty("webdriver.chrome.driver", 
                "C:\\Users\\ovalekseeva\\Sitepedia\\chromedriver.exe"); 
	}
	
	public static void ieDriver ()
	{
		 System.setProperty("webdriver.ie.driver", "C:\\Users\\ovalekseeva\\Sitepedia\\IEDriverServer.exe");
	}
	
	public static void fireFoxDriver()
	{
		System.setProperty("webdriver.ie.driver", "C:\\Users\\ovalekseeva\\Sitepedia\\firefox.exe");
	}
	
	public static void sleep(int time)
	{
		try
		{Thread.sleep(time);}
		catch(Exception e)
		{e.printStackTrace();};
		
	}
  
	public void waitOfPresence(String type, String path)
	{
		System.out.println("I am in waitOfPersense");
		WebDriverWait waitG = new WebDriverWait(driver, 10);
		System.out.println("Type is: "+type+"Path is: "+path);
		switch (type.toLowerCase()) {
		case "xpath":
		System.out.println(path);
		waitG.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
		break;
		case "linktext":
	    waitG.until(ExpectedConditions.presenceOfElementLocated(By.linkText(path)));
	    break;
		}
		
	}
	
	public void waitOfVisibilityOfElement(String type, String path)
	{
		WebDriverWait waitG = new WebDriverWait(driver, 10);
		switch (type.toLowerCase()) {
		case "xpath":
		waitG.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
		break;
		case "linktext":
	    waitG.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(path)));
	    break;
		}
		
	}
	
	public static HttpURLConnection makeHttpReq(String url_string, String cookie)
	{
		try{
			String[] ar = cookie.split(";");    
			URL url = new URL(url_string);
			    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			    conn.setRequestMethod("GET");
			    System.out.println (ar[0]+"="+ar[1]+"; urlparams=2" + "\n");
			    conn.setRequestProperty("Cookie",ar[0]+"="+ar[1]+"; urlparams=2");
			       		
			    conn.connect();
			     return conn;
			    }catch(IOException ex)
			    {
			    ex.printStackTrace();
			     return null;
			    }
	}
	
	public static void waitAndClick(WebElement element)
	{
		
		for (int i=0; i<=40; i++)
		{
			try {
				System.out.println("i am here " + i + " times" + element );
				element.click();
			     return; 
			    }
			
			catch (org.openqa.selenium.WebDriverException e)
			{
				
				System.out.println("Catch no clikable exception" + i + element + "times" );
				e.printStackTrace();
			}
			
			try {
				Thread.sleep(100);}
				catch (Exception ex1)
				{ex1.printStackTrace();};
				
		}
		
	}
	
	public static Properties propLoad ()
	{
	Properties prop = new Properties();
	InputStream stream = null;
	InputStreamReader reader = null;

	try {
		 stream = new FileInputStream(new File("Sitepedia.properties"));
	    reader = new InputStreamReader(stream,"Windows-1251");
	//prop.load(new FileInputStream(new File ("C:\\Users\\ovalekseeva\\workspace\\Sitepedia\\bin\\Sitepedia.properties")));
	    prop.load(reader);
	} catch (Exception ex) {System.out.println(ex);}


	return prop;

	}
	
	public void makeScreenshot(WebDriver driver, String filename)
	{
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
        FileUtils.copyFile(screenshotFile, new File(filename+".png"));
		}
		catch (Exception ex) {ex.printStackTrace();}
	}

	 public void clickElement(By elementOnPage)
	  {
		driver.findElement(elementOnPage).click();
	  }
	 
	 public void waitingOf(String locator, String locator_type)
		{
			waitOfPresence(locator_type, locator);
		}
		
	 public void inputTextToField(By fieldNameOnPage, String text)
		{
			WebElement field= driver.findElement(fieldNameOnPage);
			field.clear();
			field.sendKeys(text);
		}

	 
}
