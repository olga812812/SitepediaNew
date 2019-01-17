package main.java.SitepediaPages;

import org.openqa.selenium.*;

public class DirectoryPage {
	String itemName;
	
	//Buttons
	By buttonAddDirectoryItem = By.xpath("//span[text()='Добавить']");
	By buttonEditDirectoryItem = By.xpath("//div[contains(text(), '"+itemName+"')]/preceding-sibling::div[@class='buttons left']/span[@title='редактировать']");
	By buttonDeleteDirectoryItem = By.xpath("//div[contains(text(), '"+itemName+"')]/preceding-sibling::div[@class='buttons right']/span[@title='удалить']");
	By buttonSaveDirectoryItemNameAfterChanging = By.xpath("//div[contains(text(),'"+itemName+"')]/descendant::span[contains(text(),'сохранить')]");
	By buttonCancelChangingDirectoryItemName = By.xpath("//div[contains(text(),'"+itemName+"')]/descendant::span[contains(text(),'отменить')]");
	
	//fields
	By fieldEditDirectoryItemName = By.xpath("//div[contains(text(),'"+itemName+"')]/descendant::input[@ng-model='control.temp_edit']");
	By fieldEditDirectoryItem= By.cssSelector("[placeholder='по названию']");
	

	
	

}
