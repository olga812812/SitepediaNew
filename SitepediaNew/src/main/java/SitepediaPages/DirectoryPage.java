package main.java.SitepediaPages;

import org.openqa.selenium.*;

public class DirectoryPage extends BasePage{
	public DirectoryPage(WebDriver driver, String directoryPageUrl) {
		super(driver);
		pageURL=directoryPageUrl;
	}

	long randomNumber=Math.round(Math.random()*1000);
	String directoryItemName="newDirectoryItem"+String.valueOf(randomNumber);
	String editedDirectoryItemName="EditedDirectoryItem"+String.valueOf(randomNumber);
	String directoryItemNameForDeletion = "directoryItemForDeletion"+String.valueOf(randomNumber);;
	String pageURL;
	
	//Buttons
	By buttonAddDirectoryItem = By.xpath("//span[text()='Добавить']");
	By buttonSaveNewDirectoryItem = By.cssSelector("[ng-click='control.save()']");
	By buttonEditDirectoryItem = By.xpath("//div[contains(text(), '"+directoryItemName+"')]/preceding-sibling::div[@class='buttons left']/span[@title='редактировать']");
	By buttonDeleteDirectoryItem = By.xpath("//div[contains(text(), '"+directoryItemNameForDeletion+"')]/preceding-sibling::div[@class='buttons right']/span[@title='удалить']");
	By buttonConfirmDeletionOfDirectoryItem = By.cssSelector("[ng-click='control.deleteRun()']");
	By buttonSaveDirectoryItemNameAfterChanging = By.xpath("//div[contains(text(),'"+directoryItemName+"')]/descendant::span[contains(text(),'сохранить')]");
	By buttonCancelChangingDirectoryItemName = By.xpath("//div[contains(text(),'"+directoryItemName+"')]/descendant::span[contains(text(),'отменить')]");
	By buttonCancelCreationNewDirectoryItem = By.cssSelector("[ng-click='control.cancel()']");
	
	//fields
	By fieldAddNewDirectoryItem = By.xpath("//span[text()='сохранить']/preceding-sibling::input");
	By fieldEditDirectoryItemName = By.xpath("//div[contains(text(),'"+directoryItemName+"')]/descendant::input[@ng-model='control.temp_edit']");
	By fieldFindDirectoryItem= By.cssSelector("[placeholder='по названию']");
	
	//other elements
	By elementDeleteDirectoryItem = By.xpath("//div[contains(text(),'"+directoryItemName+"')]/preceding-sibling::div/span[@title='удалить']");
	By titleNewDirectoryItem = By.xpath("//div[contains(text(),'"+directoryItemName+"')]");
	By titleEditedDirectoryItem = By.xpath("//div[contains(text(),'"+editedDirectoryItemName+"')]");
	By titleDeletedDirectoryItem = By.xpath("//div[contains(text(),'"+directoryItemNameForDeletion+"')]");
	By generalDirectoryItemLocator = By.cssSelector("[class='b-products-list-admin-name ng-binding']");
	String pageLoadEvent="//div[@class='buttons right']/span[@title='удалить']";
	
	
	
	public void loadPage(){		
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
	
	public void clickButtonSaveEditedDirectoryItem() {
		clickElement(buttonSaveDirectoryItemNameAfterChanging);
	}
	
	public boolean findEditedDirectoryItem() {
		return findSomeElement(titleEditedDirectoryItem);
	}
	
	public void enterDirectoryItemForDeletionName() {
		inputTextToField(fieldAddNewDirectoryItem,directoryItemNameForDeletion);
		
	}
	
	public void clickButtonDeleteDirectoryItem() {
		clickElement(buttonDeleteDirectoryItem);
	}
	
	public void clickButtorConfirmDeletionOfDirectoryItem() {
		clickElement(buttonConfirmDeletionOfDirectoryItem);
	}
	
	public boolean findDEletedDirectoryItem() {
		return findSomeElement(titleDeletedDirectoryItem);
		
	}
	
	public void clickButtonCancelChangingDirectoryItemName() {
		clickElement(buttonCancelChangingDirectoryItemName);
	}
	
	public void enterDirectoryItemNameInSearchField() {
		inputTextToField(fieldFindDirectoryItem,directoryItemName);
		
	}
	
	public int numberOfDirectoryItemsOnPage() {
		return findAllElements(generalDirectoryItemLocator).size();
	}
	
	public void clickButtonCancelCreatingNewDirectoryItem() {
		clickElement(buttonCancelCreationNewDirectoryItem);
	}
}
