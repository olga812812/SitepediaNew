package main.java.SitepediaPages;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends Common{
	
	
	
	private WebDriver driver;
	String sitepedia_url = propLoad().getProperty("SitepediaURL");

	@Override
	public WebDriver getWebDriver() {
		return driver;
	}
	
	BasePage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
		
	public void loadingPage(String Page, String PageLoadEvent, String locator_type)
	{
		getSitePage(Page);
		waitingOf(PageLoadEvent, locator_type);
	}
	
	
	public void getSitePage(String sitePage)
	{
		 
		 getWebDriver().get(sitepedia_url+sitePage+String.valueOf(Math.round(Math.random()*10000)));
		 getWebDriver().navigate().refresh();
	}

	public void waitingOf(String locator, String locator_type)
	{
		waitOfPresence(locator_type, locator);
	}
	
	public void waitOfPresence(String type, String path)
		{
			System.out.println("I am in waitOfPersense");
			 System.out.println("driver in waifOfPresence: "+getWebDriver());
			WebDriverWait waitG = new WebDriverWait(getWebDriver(), 10);
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
	
	public void makeScreenshot(WebDriver driver, String filename){
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
        FileUtils.copyFile(screenshotFile, new File(filename+".png"));
		}
		catch (Exception ex) {ex.printStackTrace();}
	}

	 public void clickElement(By elementOnPage){
		 getWebDriver().findElement(elementOnPage).click();
	  }
	 
	 
		
	 public void inputTextToField(By fieldNameOnPage, String text){
			WebElement field= getWebDriver().findElement(fieldNameOnPage);
			field.clear();
			field.sendKeys(text);
		}
	 
	 public  void waitAndClick(By elementLocator){
			
			for (int i=0; i<=40; i++)
			{
				try {
					System.out.println("i am here " + i + " times" + elementLocator );
					getWebDriver().findElement(elementLocator).click();
				     return; 
				    }
				
				catch (org.openqa.selenium.WebDriverException e)
				{
					
					System.out.println("Catch no clikable exception" + i + elementLocator + "times" );
					e.printStackTrace();
				}
				
				try {
					Thread.sleep(100);}
					catch (Exception ex1)
					{ex1.printStackTrace();};
					
			}
			
		}
	
		
		public void waitOfVisibilityOfElement(String type, String path) {
			WebDriverWait waitG = new WebDriverWait(getWebDriver(), 10);
			switch (type.toLowerCase()) {
			case "xpath":
			waitG.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
			break;
			case "linktext":
		    waitG.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(path)));
		    break;
			}
			
		}
		
		public boolean findSomeElement(By locator) {
			try {
				getWebDriver().findElement(locator);
				}
				catch (NoSuchElementException e)
				{
					e.printStackTrace();
					return false;
				}
				
				return true;
		}
		
		public List<WebElement> findAllElements(By locator) {
			
			return getWebDriver().findElements(locator);
			
		}
	

}
