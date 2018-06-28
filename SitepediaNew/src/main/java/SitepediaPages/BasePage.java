package main.java.SitepediaPages;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends Common{
	
	
	
	private WebDriver driver;

	@Override
	public WebDriver getWebDriver() {
		return driver;
	}
	
	BasePage(WebDriver driver)
	{
		this.driver = driver;
		
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
		 getWebDriver().findElement(elementOnPage).click();
	  }
	 
	 public void waitingOf(String locator, String locator_type)
		{
			waitOfPresence(locator_type, locator);
		}
		
	 public void inputTextToField(By fieldNameOnPage, String text)
		{
			WebElement field= getWebDriver().findElement(fieldNameOnPage);
			field.clear();
			field.sendKeys(text);
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
		
		public void waitOfVisibilityOfElement(String type, String path)
		{
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
	

}
