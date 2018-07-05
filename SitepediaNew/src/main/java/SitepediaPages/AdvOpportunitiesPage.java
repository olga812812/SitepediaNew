package main.java.SitepediaPages;

import org.openqa.selenium.*;

public class AdvOpportunitiesPage  extends BasePage {
	

	
	String sitepedia_url = propLoad().getProperty("SitepediaURL");
	String newSectionName= "NewSection"+String.valueOf(Math.round(Math.random()*1000));
	String newPositionName="NewPosition"+String.valueOf(Math.round(Math.random()*1000));
	String editedSectionName = newSectionName + "Edited";
	
	
	//Buttons
	By buttonAddSection = By.xpath("//span[@ng-click='showCreateSection()']/i");
	By buttonSaveNewSection = By.xpath("//span[@ng-click='saveSection()']");
	By buttonAddPosition = By.xpath("//span[@ng-click='showCreatePosition(section)']/i[1]");
	By buttonSaveNewPosition = By.xpath("//span[@ng-click='savePosition()']");
	By buttonDeleteSection = By.xpath("//span[(contains(text(), '"+newSectionName+"'))]/following-sibling::span[@title='Удалить секцию']/i");
	By buttonConfirmDeleteSection= By.xpath("//h3[contains(text(),'Удаление секции')]/following::span[@class='button tiny save' and contains(text(),'Хорошо')]");
	By buttonDeletePosition = By.xpath("//span[(contains(text(), '"+newPositionName+"'))]/following-sibling::span[@title='Удалить позицию']/i");
	By buttonConfirmDeletePosition = By.xpath("//h3[contains(text(),'Удаление позиции')]/following::span[@class='button tiny save' and contains(text(),'Хорошо')]");
	By buttonEditPosition = By.xpath("//span[contains(text(),'"+newPositionName+"')]/preceding-sibling::span[@ng-click='showEditPosition(position,section)']");
	By buttonEditSectionName = By.xpath("//span[contains(text(),'"+newSectionName+"')]/preceding-sibling::span[@ng-click='showEdit()']");
	By buttonSaveEditedSectionName = By.xpath("//span[@ng-click='saveEdit()']");
	
	
	//fields
	By fieldSectionName = By.xpath("//input[@placeholder='Название раздела']");
	By fieldPositionName = By.xpath("//input[@placeholder='Название позиции']");
	By fieldEditSectionName=By.xpath("//input[@ng-model='fieldValue']");
	
	
	
	//labels/titles
	By titleNewSection = By.xpath("//span[contains(text(),'"+newSectionName+"')]");
	By titleNewPosition = By.xpath("//span[contains(text(),'"+newPositionName+"')]");
	By titleEditedSectionName = By.xpath("//span[contains(text(),'"+editedSectionName+"')]");
	
	
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
	
	public void clickButtonEditSectionName()
	{
		clickElement(buttonEditSectionName);
	}
	
	public void clickButtonAddPosition()
	{
		clickElement(buttonAddPosition);
	}
	
	
	public void inputTextToFieldNewSectionName()
	{
		inputTextToField(fieldSectionName, newSectionName);
	}
	
	public void inputNewSectionName()
	{
		System.out.println(editedSectionName);
		inputTextToField(fieldEditSectionName, editedSectionName);
	}
	
	public void inputTextToFieldNewPositionName()
	{
		inputTextToField(fieldPositionName, newPositionName);
	}
	
	
	public void clickButtonSaveNewSection()
	{
		clickElement(buttonSaveNewSection);
	}
	
	public void clickButtonSaveEditedSectionName()
	{
		clickElement(buttonSaveEditedSectionName);
	}
	
	
	public void clickButtonDeleteSection()
	{
		clickElement(buttonDeleteSection);
	}
	
	
	public void clickButtonConfirmDeleteSection()
	{
		clickElement(buttonConfirmDeleteSection);
	}
	
	
	public void clickButtonDeletePosition()
	{
		clickElement(buttonDeletePosition);
	}
	
	
	public void clickButtonConfirmDeletePosition()
	{
		clickElement(buttonConfirmDeletePosition);
	}
	
	public void clickButtonSaveNewPosition()
	{
		clickElement(buttonSaveNewPosition);
	}
	
	
	public boolean findSomeElement(By locator)
	{
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
	
	
	public boolean findNewSection()
	{
		return	findSomeElement(titleNewSection);
	}
	
	
	public boolean findEditedSection()
	{
		return	findSomeElement(titleEditedSectionName);
	}

	
	public boolean findNewPosition()
	{
		return	findSomeElement(titleNewPosition);
	}
	

	
	
		
		
}
