package main.java.SitepediaPages;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserInstractionsPage extends BasePage{
	
	String fileToLoad=propLoad().getProperty("FileWithInstructionForSysAdmin");
	InputStream fileFromSitepedia;
	String hashCodeForFileFromSitepedia;
	String hashCodeForLoadedFile;
	
	public UserInstractionsPage(WebDriver driver) {
		super(driver);
	}

	String userInstractionsPageUrl="/#/administration/instructions?rnd=";
	String sitepediaInstructionUrl="http://92.242.32.232:8133/sp/help/5";
	
	//buttons
	By buttonChooseFile= By.xpath("//div[@class='vi-panel-title' and contains(.,'Sysadmin')]/following-sibling::div/div/input[@type='file']");
	By buttonSaveFile = By.xpath("//div[@class='vi-panel-title' and contains(.,'Sysadmin')]/following-sibling::div/div/button[contains(text(),'Сохранить')]");
	
	//others
	String pageLoadEvent="//div[@class='vi-panel-title' and contains(.,'Sysadmin')]/following-sibling::div/div/input[@type='file']";
	By eventSuccessLoadFile = By.xpath("//div[contains(text(),'Загрузка произошла успешно')]");
	
	
	
	public void loadPage() {
		loadingPage(userInstractionsPageUrl, pageLoadEvent, "xpath");
	}
	
	public void addInstructionFile() {
		inputTextToField(buttonChooseFile, fileToLoad);			
	}
	
	public void clickButtonSaveFile() {
		clickElement(buttonSaveFile);				
	}
	
	public boolean checkSuccessLoadingFile () {
		return findSomeElement(eventSuccessLoadFile);
	}
	
	public void getInstructionFileFromSitepedia(String cookie) {
		try{
		HttpURLConnection connection=makeHttpReq(sitepediaInstructionUrl, cookie);
		if (connection.getResponseCode()==200) {		
			fileFromSitepedia  = connection.getInputStream();			
		}
		else System.out.println("Response code is: "+connection.getResponseCode());
		
		
		} catch( Exception ex) {ex.printStackTrace();}
	}
	
	public void getHashCodeForFileFromSitepedia() {
		hashCodeForFileFromSitepedia = getHashCode(fileFromSitepedia);
		
	}
	
	public String getHashCode(InputStream text)  {
	try {
			return DigestUtils.sha256Hex(text);
	} catch( Exception ex) {
		                   ex.printStackTrace();
						   return null;
		                   }			
	}
	
	public void GetHashCodeForLoadedFile() {
		try {
		hashCodeForLoadedFile=getHashCode(new FileInputStream(fileToLoad));
		} catch( Exception ex) {ex.printStackTrace();}	
	}
	
	public boolean CompareTwoHashCodes() {
		return hashCodeForLoadedFile.equals(hashCodeForFileFromSitepedia);
	}
	

}
