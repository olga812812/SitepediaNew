package main.java.SitepediaPages;

import org.openqa.selenium.*;

public class SiteFilesPage {
	WebDriver driver;
	Common common;
	String linkName="newLink#"+String.valueOf(Math.round(Math.random()*10000));
	
	By buttonAddFileOrLink = By.xpath("//button");
	By tabFiles = By.xpath("//li[contains(text(),'Файлы')]");
	By selectAttachementType = By.xpath("//b[@role='presentation']");
	By selectLink = By.xpath("//div[contains(text(),'Ссылка')]");
	By inputLinkName = By.xpath("//input[@placeholder='Название']");
	By inputLinkURL = By.xpath("//input[@placeholder='Введите URL ссылки']");
	By buttonSaveLink = By.xpath("//span[contains(text(),'Сохранить') and @ng-click='saveFile()']");
	By newLink = By.xpath("//td[contains(text(),'"+linkName+"')]");
	
	
	
	public SiteFilesPage (WebDriver driver)
	{
		this.driver=driver;
		common=new Common(driver);
		
	}
	
	void getSitePage()
	{
		driver.get("http://92.242.32.232:8133/#/1?rnd="+String.valueOf(Math.round(Math.random()*10000)));
	}
	
	void waitingOfSitePageLoad()
	{
		common.waitOfPresence("xpath", "//span[contains(text(),'Все страницы')]");
	}
	
	void waitingOfTabFilesLoad()
	{
		common.waitOfPresence("xpath", "//tr/th[contains(text(),'Название')]");
	}

	void waitingOfNewTabLoad()
	{
		common.waitOfPresence("xpath", "//label[contains(text(),'Тип')]");
	}
	void clickTabFiles()
	{
		driver.findElement(tabFiles).click();
	}
	
	void clickButtonAddFileOrLink()
	{
	driver.findElement(buttonAddFileOrLink).click();	
	}
	
	void clickListOfAttachmentType()
	{
		common.waitAndClick(driver.findElement(selectAttachementType));
	}
	
	void clickLink()
	{
		common.waitAndClick(driver.findElement(selectLink));
	}
	
	void enterLinkName()
	{
		driver.findElement(inputLinkName).sendKeys(linkName);
	}
	
	void enterLinkUrl()
	{
		driver.findElement(inputLinkURL).sendKeys("http://linl/number/"+String.valueOf(Math.round(Math.random()*10000)));
	}
	
	void clickButtonSaveLink()
	{
		driver.findElement(buttonSaveLink).click();	
	}
	
	void findNewLink()
	{
		driver.findElement(newLink);
	}
	
	public boolean addLink()
	{
		boolean result;
		try{
		getSitePage();
		driver.navigate().refresh();
		waitingOfSitePageLoad();
		clickTabFiles();
		waitingOfTabFilesLoad();
		clickButtonAddFileOrLink();	
		waitingOfNewTabLoad();
		clickListOfAttachmentType();
		clickLink();
		enterLinkName();
		enterLinkUrl();
		clickButtonSaveLink();
		waitingOfTabFilesLoad();
		findNewLink();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
		return true;
	}
}
