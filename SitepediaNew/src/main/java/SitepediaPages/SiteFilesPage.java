package main.java.SitepediaPages;

import org.openqa.selenium.*;

public class SiteFilesPage extends BasePage{
	
	String linkName="newLink#"+String.valueOf(Math.round(Math.random()*10000));
	String fileDescription = "fileDescription"+String.valueOf(Math.round(Math.random()*10000));
	String filePath = propLoad().getProperty("siteFilePath");
	String sitePage="/#/1?rnd=";
	
	//Buttons
	By buttonAddFileOrLink = By.xpath("//button");
	By buttonSaveLink = By.xpath("//span[contains(text(),'Сохранить') and @ng-click='saveFile()']");
	
	By tabFiles = By.xpath("//li[contains(text(),'Файлы')]");
	By selectAttachementType = By.xpath("//b[@role='presentation']");
	
	By selectLink = By.xpath("//div[contains(text(),'Ссылка')]");
	By selectFile = By.xpath("//div[contains(text(),'Файл')]");
	
	By newLink = By.xpath("//td[contains(text(),'"+linkName+"')]");
	By newFile = By.xpath("//td[contains(text(),'"+fileDescription+"')]");
	
	//Fields
	By fieldLinkName = By.xpath("//input[@placeholder='Название']");
	By fieldLinkURL = By.xpath("//input[@placeholder='Введите URL ссылки']");
	By fieldFileDescription = By.xpath("//textarea[@placeholder='Описание']");
	By fieldFilePath = By.xpath("//input[@placeholder='Выберите файл']");
	
	//Events
		String sitePageLoadEvent = "//span[contains(text(),'Все страницы')]";
		String sitePageFilesTabLoad = "//tr/th[contains(text(),'Название')]";
		String addNewFileOrLinkWindowLoad = "//label[contains(text(),'Тип')]";
	
	
	
	public SiteFilesPage (WebDriver driver)
	{
		super(driver);
	}
	
	
	
	public void loadSitePage()
	{
		loadingPage(sitePage, sitePageLoadEvent, "xpath");
	}
	
	

	public void clickTabFiles()
	{
		clickElement(tabFiles);
		waitOfPresence("xpath", sitePageFilesTabLoad);
	}
	
	public void clickButtonAddFileOrLink()
	{
		clickElement(buttonAddFileOrLink);	
		waitOfPresence("xpath", addNewFileOrLinkWindowLoad);
	}
	
	public void clickListOfAttachmentType()
	{
		waitAndClick(selectAttachementType);
	}
	
	public void clickLink()
	{
		waitAndClick(selectLink);
	}
	
	public void clickFile()
	{
		waitAndClick(selectFile);
	}
	
	public void enterLinkName()
	{
		inputTextToField(fieldLinkName, linkName);
	}
	
	public void enterFilePath()
	{
		inputTextToField(fieldFilePath, filePath);
	}
	
	public void enterFileDescription()
	{
		inputTextToField(fieldFileDescription, fileDescription);
	}
	
	public void enterLinkUrl()
	{
		inputTextToField(fieldLinkURL,"http://link/number/"+String.valueOf(Math.round(Math.random()*10000)));
	}
	
	public void clickButtonSaveLink()
	{
		clickElement(buttonSaveLink);	
		waitOfPresence("xpath", sitePageFilesTabLoad);
	}
	
	public void clickButtonSaveFile()
	{
		clickButtonSaveLink();
	}
	
	public boolean findNewLink()
	{
		return	findSomeElement(newLink);
	
	}
	
	public boolean findNewFile()
	{
		return	findSomeElement(newFile);
	
	}
	

}
