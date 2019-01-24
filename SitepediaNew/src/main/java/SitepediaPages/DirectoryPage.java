package main.java.SitepediaPages;

import org.openqa.selenium.*;

public class DirectoryPage extends BasePage{
	public DirectoryPage(WebDriver driver) {
		super(driver);
	}

	long randomNumber=Math.round(Math.random()*1000);
	String directoryItemName="newDirectoryItem"+String.valueOf(randomNumber);
	String editedDirectoryItemName="EditedDirectoryItem"+String.valueOf(randomNumber);
	
	//Buttons
	By buttonAddDirectoryItem = By.xpath("//span[text()='Добавить']");
	By buttonSaveNewDirectoryItem = By.cssSelector("[ng-click='control.save()']");
	By buttonEditDirectoryItem = By.xpath("//div[contains(text(), '"+directoryItemName+"')]/preceding-sibling::div[@class='buttons left']/span[@title='редактировать']");
	By buttonDeleteDirectoryItem = By.xpath("//div[contains(text(), '"+directoryItemName+"')]/preceding-sibling::div[@class='buttons right']/span[@title='удалить']");
	By buttonSaveDirectoryItemNameAfterChanging = By.xpath("//div[contains(text(),'"+directoryItemName+"')]/descendant::span[contains(text(),'сохранить')]");
	By buttonCancelChangingDirectoryItemName = By.xpath("//div[contains(text(),'"+directoryItemName+"')]/descendant::span[contains(text(),'отменить')]");
	
	//fields
	By fieldAddNewDirectoryItem = By.xpath("//span[text()='сохранить']/preceding-sibling::input");
	By fieldEditDirectoryItemName = By.xpath("//div[contains(text(),'"+directoryItemName+"')]/descendant::input[@ng-model='control.temp_edit']");
	By fieldFindDirectoryItem= By.cssSelector("[placeholder='по названию']");
	
	//other elements
	By elementDeleteDirectoryItem = By.xpath("//div[contains(text(),'"+directoryItemName+"')]/preceding-sibling::div/span[@title='удалить']");
	By titleNewDirectoryItem = By.xpath("//div[contains(text(),'"+directoryItemName+"')]");
	By titleEditedDirectoryItem = By.xpath("//div[contains(text(),'"+editedDirectoryItemName+"')]");
	String pageLoadEvent="//div[@class='buttons right']/span[@title='удалить']";
	
	
	
	public void loadPage(String pageURL){
		loadingPage(pageURL, pageLoadEvent, "xpath");
	}
	
	public void clickButtonAddDirectoryItem() {
		clickElement(buttonAddDirectoryItem);
	}
	
	public void enterDirectoryItemName() {
		inputTextToField(fieldAddNewDirectoryItem,directoryItemName);
	}
	
	public void clickButtonSaveDirectoryItem() {
		clickElement(buttonSaveNewDirectoryItem);
		
	}
	
	public boolean findNewDirectoryItem() {
		return findSomeElement(titleNewDirectoryItem);
	}
	
	public void clickButtonEditDirectoryItem() {
		clickElement(buttonEditDirectoryItem);
	}
	
	public void enterNewDirectoryItemName() {
		inputTextToField(fieldEditDirectoryItemName,editedDirectoryItemName);
	}
	
	public void clickButtonSaveNewDirectoryItem() {
		clickElement(buttonSaveDirectoryItemNameAfterChanging);
	}
	
	public boolean findEditedDirectoryItem() {
		return findSomeElement(titleEditedDirectoryItem);
	}
}
