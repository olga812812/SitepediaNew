import main.java.SitepediaPages.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.chrome.ChromeDriver;


public class AllDirectories {
	WebDriver driver;
	
	public AllDirectories(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void createObj(String url, String new_freq_text)
	{
		WebElement wait = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.linkText("�����")));
		driver.get(url);
		//WebElement wait1 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'��������')]")));
		WebElement add_button = driver.findElement(By.xpath("//span[text()='��������']"));
		Common.sleep(1000);
		//IT'S DOESN'T WORK: WebElement wait1 = (new WebDriverWait(driver, 100)).until(ExpectedConditions.elementToBeClickable(add_button));
		add_button.click();
		WebElement new_freq = driver.findElement(By.xpath("//input[@class='input-field ng-pristine ng-untouched ng-valid']"));
		new_freq.sendKeys(new_freq_text);
		WebElement save = driver.findElement(By.xpath("//span[text()='���������']"));
		save.click();
		
	}
	
	public boolean findObj(String url, String new_freq_text)
	{
		
		try {
			driver.get(url);
			WebElement nf = driver.findElement(By.xpath("//div[contains(text(),'"+new_freq_text+"')]"));
		    return true;
		     		 	     }
		catch (NoSuchElementException e)
		     {
		      return false;	 }
	}
	
	public void delObj(String url, String new_freq_text)
	{
		 driver.get(url);
	     //WebElement wait1 = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),new_freq_text)]")));
		 //Common.sleep(1000);
		 WebElement del_freq = driver.findElement(By.xpath("//div[contains(text(),'"+new_freq_text+"')]/preceding-sibling::div[@class='buttons right']/span[@title='�������']/i[@class='fa fa-times']"));
	     del_freq.click();
	     //WebElement wait2 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'����� �����')]")));
	     WebElement confirm= driver.findElement(By.xpath("//span[contains(text(),'�����������')]"));
	     confirm.click();
	    
	    
		
	}
	
	public boolean enterFindObj(String url, String freqName1, String freqName2)
	{
		driver.get(url);
		WebElement textBox = driver.findElement(By.xpath("//input[@placeholder='�� ��������']"));
		textBox.sendKeys(freqName1);
		try {
			WebElement fr2 = driver.findElement(By.xpath("//div[contains(text(),'"+freqName2+"')]"));
		    return true;
		     		 	     }
		     catch (NoSuchElementException e)
		     {
		      return false;	 }
		
	
	}
	
	public String editObj(String url, String freq)
	{
		driver.get(url);
		WebElement edit_freq = driver.findElement(By.xpath("//div[contains(text(),'"+freq+"')]/preceding-sibling::div[@class='buttons left']/span[@title='�������������']/i[@class='fa fa-pencil-square-o']"));
		edit_freq.click();
		WebElement enter_new_freq_name = driver.findElement(By.xpath("//div[contains(text(),'"+freq+"')]/child::div[@class='ng-scope']/input[@class='input-field ng-pristine ng-untouched ng-valid']"));
		String newFreq = "edited"+ Math.random();
		enter_new_freq_name.clear();
		enter_new_freq_name.sendKeys(newFreq);
		WebElement save= driver.findElement(By.xpath("//span[contains(text(),'���������')]"));
		save.click();
		return newFreq;
		
	}
	

}
