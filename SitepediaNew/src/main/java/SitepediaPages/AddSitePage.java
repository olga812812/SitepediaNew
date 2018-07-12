package main.java.SitepediaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddSitePage extends BasePage {
	
	String sitePage="/#/sites?rnd=";
	String newSiteName = "newSite"+String.valueOf(Math.round(Math.random()*1000));
	String imagePath = propLoad().getProperty("logoImagePath");
	String statisticsText = "Site statistics text" + String.valueOf(Math.round(Math.random()*1000));
	
	//Events
	String addSitePageLoadEvent = "//th[contains(text(),'Тематики площадки')]";
	By newSite = By.xpath("//td[contains(text(),'"+statisticsText+"')]");
	
	//Buttons 
	By buttonAddSite = By.xpath("//span[@ng-click='showAddSite()']");
	By buttonSaveNewSite = By.xpath("//span[@ng-click='addSite()']");
	
	//Fields
	By fieldSiteName = By.xpath("//input[@placeholder='Название площадки']");
	By fieldSiteLogoImage = By.xpath("//input[@placeholder='Логотип площадки']");
	By fieldSiteOwnStatistics = By.xpath("//textarea[@placeholder='Собственная статистика площадки']");
	
	//Select
	By selectOpportunityToPlaceNonResidents = By.xpath("//select[@ng-model='models.site_to_add.isNonResidentAllowed']");
	By selectYesNonResident = By.xpath("//select[@ng-model='models.site_to_add.isNonResidentAllowed']/option[contains(text(),'Да')]");
	By selectAccreditationSiteLikeSMI = By.xpath("//select[@ng-model='models.site_to_add.isRegisteredAsMedia']");
	By selectYesAccreditationSiteLikeSMI = By.xpath("//select[@ng-model='models.site_to_add.isRegisteredAsMedia']/option[contains(text(),'Нет')]");
	
	
	public AddSitePage(WebDriver driver)
	{
		super(driver);
	}
	
	
	public void loadAddSitePage()
	{
		loadingSitePage(sitePage, addSitePageLoadEvent, "xpath");
	}
	
	public void clickButtonAddSite()
	{
		clickElement(buttonAddSite);
	}
	
	public void enterSiteName()
	{
		inputTextToField(fieldSiteName, newSiteName);
	}
	
	public void addSiteLogoImage()
	{
		inputTextToField(fieldSiteLogoImage, imagePath);
	}
	
	public void addSiteOwnStatistics()
	{
		inputTextToField(fieldSiteOwnStatistics, statisticsText);	
	}
	
	public void addOpportunityToPlaceNonResidents()
	{
		clickElement(selectOpportunityToPlaceNonResidents);
		clickElement(selectYesNonResident);
		
		
	}
	
	public void addAccreditationSiteLikeSMI()
	{
		clickElement(selectAccreditationSiteLikeSMI);
		clickElement(selectYesAccreditationSiteLikeSMI);
	}
	
	public void clickButtonSaveNewSite()
	{
		clickElement(buttonSaveNewSite);
	}
	
	public boolean findNewSite()
	{
		loadingSitePage(sitePage, addSitePageLoadEvent, "xpath");
		return	findSomeElement(newSite);
	
	}
	
}
