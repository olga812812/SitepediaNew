package main.java.SitepediaPages;

import org.openqa.selenium.*;

public class AdvOpportunitiesPage  extends BasePage {
	

	
	String sitepedia_url = propLoad().getProperty("SitepediaURL");
	String newSectionName= "NewSection"+String.valueOf(Math.round(Math.random()*1000));
	String newPositionName="NewPosition"+String.valueOf(Math.round(Math.random()*1000));
	
	
	//Buttons
	By buttonAddSection = By.xpath("//span[@ng-click='showCreateSection()']/i");
	By buttonSaveNewSection = By.xpath("//span[@ng-click='saveSection()']");
	By buttonAddPosition = By.xpath("//span[@ng-click='showCreatePosition(section)']/i[1]");
	By buttonSaveNewPosition = By.xpath("//span[@ng-click='savePosition()']");
	By buttonDeleteSection = By.xpath("//span[(contains(text(), '"+newSectionName+"'))]/following-sibling::span[@title='Удалить секцию']/i");
	By buttonConfirmDeleteSection= By.xpath("//h3[contains(text(),'Удаление секции')]/following::span[@class='button tiny save' and contains(text(),'Хорошо')]");
	By buttonDeletePosition = By.xpath("//span[(contains(text(), '"+newPositionName+"'))]/following-sibling::span[@title='Удалить позицию']/i");
	By buttonConfirmDeletePosition = By.xpath("//h3[contains(text(),'Удаление позиции')]/following::span[@class='button tiny save' and contains(text(),'Хорошо')]");
	
	//fields
	By fieldSectionName = By.xpath("//input[@placeholder='Название раздела']");
	By fieldPositionName = By.xpath("//input[@placeholder='Название позиции']");
	
	//labels/titles
	By titleNewSection = By.xpath("//span[contains(text(),'"+newSectionName+"')]");
	By titleNewPosition = By.xpath("//span[contains(text(),'"+newPositionName+"')]");
	
	//Events
	String SitePageLoad = "//span[contains(text(),'Все страницы')]";
	
	public AdvOpportunitiesPage(WebDriver driver)
	{
		super(driver);
		System.out.println("driver in AdvOpportunitiesPage constructor: "+driver);
		
	}
	

	void getSitePage()
	{
		 System.out.println("driver in getSitePage: "+getWebDriver());
		 getWebDriver().get(sitepedia_url+"/#/1?rnd="+String.valueOf(Math.round(Math.random()*10000)));
	}
	
	
	public void loadSitePage()
	{
		getSitePage();
		getWebDriver().navigate().refresh();
		waitingOf(SitePageLoad, "xpath");
	}
	
	
	
	public void clickButtonAddSection()
	{
		clickElement(buttonAddSection);
	}
	
	public void inputTextToFieldNewSectionName()
	{
		inputTextToField(fieldSectionName, newSectionName);
	}
	
	public void clickButtonSaveNewSection()
	{
		clickElement(buttonSaveNewSection);
	}
	
	public boolean findNewSection()
	{
		try {
			getWebDriver().findElement(titleNewSection);
			}
			catch (NoSuchElementException e)
			{
				e.printStackTrace();
				return false;
			}
			
			return true;
	}

	
	public boolean addPosition()
	{
		loadSitePage();
		clickElement(buttonAddPosition);
		inputTextToField(fieldPositionName, newPositionName);
		clickElement(buttonSaveNewPosition);
		loadSitePage();
		try {
			getWebDriver().findElement(titleNewPosition);
		}
		catch (NoSuchElementException e)
		{
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean deleteSection()
	{
		loadSitePage();
		clickElement(buttonDeleteSection);
		clickElement(buttonConfirmDeleteSection);
		loadSitePage();
		try {
			getWebDriver().findElement(titleNewSection);
			}
			catch (NoSuchElementException e)
			{
				e.printStackTrace();
				return true;
			}
			
			return false;
	}
	
	public boolean deletePosition()
	{
		loadSitePage();
		clickElement(buttonDeletePosition);
		clickElement(buttonConfirmDeletePosition);
		loadSitePage();
		try {
			getWebDriver().findElement(titleNewPosition);
			}
			catch (NoSuchElementException e)
			{
				e.printStackTrace();
				return true;
			}
			
			return false;
	}
		
		
}
