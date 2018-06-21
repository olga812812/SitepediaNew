import main.java.SitepediaPages.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.chrome.ChromeDriver;

public class FilePage {
	WebDriver driver;
	Boolean result;
	String filename;
	Common cObj;
	
	FilePage (WebDriver driver)
	{
		this.driver=driver;
		
	}

	String addFile(int number, String[] types)
	{
		return filename;
	}
	
//	String addFile(int number)
	//{
		//return filename;
	//}
	
	void addFile(String filename)
	
	{
		
		cObj= new Common(driver);
		cObj.waitOfPresence("linkText", "�����");
		driver.get("http://92.242.32.232:8133/#/1");
		cObj.waitOfPresence("xpath", "//span[@ng-click='showCreatePosition(section)']");
		WebElement fileTab = driver.findElement(By.xpath("//div[@class='vi-tabs-place']/ul/li[contains(text(),'�����')]"));
		Common.waitAndClick(fileTab);
		cObj.waitOfPresence("xpath", "//th[contains(text(),'��������')]");
		cObj.waitOfPresence("xpath", "//button");
		WebElement addNewFile = driver.findElement(By.xpath("//button"));
	   Common.waitAndClick(addNewFile);
	   cObj.waitOfPresence("xpath", "//span[@class='select2-arrow']");
			WebElement choose = driver.findElement(By.xpath("//span[@class='select2-arrow']"));
	    Common.waitAndClick(choose);
		WebElement choosefile = driver.findElement(By.xpath("//div[contains(text(),'����')]"));
		Common.waitAndClick(choosefile);
		cObj.waitOfPresence("xpath", "//input[@placeholder='�������� ����']");
		driver.findElement(By.xpath("//input[@placeholder='�������� ����']")).sendKeys(filename);
		 cObj.waitOfPresence("xpath", "//span[@ng-click='saveFile()']");
		 WebElement save = driver.findElement(By.xpath("//span[@ng-click='saveFile()']"));
		 Common.waitAndClick(save);
		 cObj.waitOfPresence("xpath", "//th[contains(text(),'��������')]");
				
		
	}
	
	boolean checkFile(String filenameShort)
	
	{
		driver.get("http://92.242.32.232:8133/#/1");
		cObj.waitOfPresence("xpath", "//span[@ng-click='showCreatePosition(section)']");
		WebElement fileTab = driver.findElement(By.xpath("//div[@class='vi-tabs-place']/ul/li[contains(text(),'�����')]"));
		Common.waitAndClick(fileTab);
		cObj.waitOfPresence("xpath", "//th[contains(text(),'��������')]");
		
		try{
		WebElement file = driver.findElement(By.xpath("//td[contains(text(),'"+filenameShort+"')]"));
		return true;
		}
		catch (NoSuchElementException e) 
		
		{return false;}
		
	
	}
	
	void deleteFile (String filenameShort)
	{
		driver.get("http://92.242.32.232:8133/#/1");
		cObj.waitOfPresence("xpath", "//span[@ng-click='showCreatePosition(section)']");
		WebElement fileTab = driver.findElement(By.xpath("//div[@class='vi-tabs-place']/ul/li[contains(text(),'�����')]"));
		Common.waitAndClick(fileTab);
		cObj.waitOfPresence("xpath", "//th[contains(text(),'��������')]");
		WebElement delFile = driver.findElement(By.xpath("//td[contains(text(),'"+filenameShort+"')]/following-sibling::td/span[@ng-click='deleteAttachement(item)']/i"));
		cObj.waitAndClick(delFile);
		//How to avoid this????
		Common.sleep(1000);
		cObj.waitOfPresence("xpath", "//div[@class='b-popup-frame open']/div[@class='b-popup-frame-container']/div[@class='b-popup-body flipInY']/div[@class='b-popup-buttons']/span[@ng-click='ynDialogOk()']");
		WebElement del = driver.findElement(By.xpath("//div[@class='b-popup-frame open']/div[@class='b-popup-frame-container']/div[@class='b-popup-body flipInY']/div[@class='b-popup-buttons']/span[@ng-click='ynDialogOk()']"));
		cObj.waitAndClick(del);
		cObj.waitOfPresence("xpath", "//th[contains(text(),'��������')]");
	}
	
	
}
