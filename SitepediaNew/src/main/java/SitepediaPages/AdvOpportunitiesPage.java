package main.java.SitepediaPages;
import org.openqa.selenium.*;

public class AdvOpportunitiesPage  {
	
	WebDriver driver;
	Common common;
	String sitepedia_url = common.propLoad().getProperty("SitepediaURL");
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
		this.driver = driver;
		common = new Common(driver);
	}

	void getSitePage()
	{
		driver.get(sitepedia_url+"/#/1?rnd="+String.valueOf(Math.round(Math.random()*10000)));
	}
	
	
	void loadSitePage()
	{
		getSitePage();
		driver.navigate().refresh();
		common.waitingOf(SitePageLoad, "xpath");
	}
	
	
	
	public boolean addSection()
	{
		
		loadSitePage();
		common.clickElement(buttonAddSection);
		common.inputTextToField(fieldSectionName, newSectionName);
		common.clickElement(buttonSaveNewSection);
		loadSitePage();
		try {
		driver.findElement(titleNewSection);
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
		common.clickElement(buttonAddPosition);
		common.inputTextToField(fieldPositionName, newPositionName);
		common.clickElement(buttonSaveNewPosition);
		loadSitePage();
		try {
			driver.findElement(titleNewPosition);
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
		common.clickElement(buttonDeleteSection);
		common.clickElement(buttonConfirmDeleteSection);
		loadSitePage();
		try {
			driver.findElement(titleNewSection);
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
		common.clickElement(buttonDeletePosition);
		common.clickElement(buttonConfirmDeletePosition);
		loadSitePage();
		try {
			driver.findElement(titleNewPosition);
			}
			catch (NoSuchElementException e)
			{
				e.printStackTrace();
				return true;
			}
			
			return false;
	}
		
		
}
