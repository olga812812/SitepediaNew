package main.java.SitepediaPages;
import java.io.File;
import java.net.HttpURLConnection;

import org.openqa.selenium.*;


public class PriceList extends BasePage {
	
	
	String sitepedia_url = propLoad().getProperty("SitepediaURL");
	String sitePage="/#/1?rnd=";
	
	//Extra charges
	String extra_charge_number = String.valueOf(Math.round(Math.random()*10000));
	String extra_charge_number_for_cancel = String.valueOf(Math.round(Math.random()*10000));
	String extra_charge_number_for_advertisers = String.valueOf(Math.round(Math.random()*100000));
	By priceListTab = By.xpath("//li[contains(text(),'Прайс-лист')]");
	//links
	By linkAdditionalInformationToPriceList = By.xpath("//a[contains(text(),'Дополнительная информация к прайс-листу')]");
	By linkDownloadPriceListFile = By.linkText("Скачать таблицу в XLSX");
	By linkExtraChargeForDeferredPayment = By.xpath("//li[contains(text(),'Наценка за отсрочку платежа:')]//i[@class='fa fa-pencil-square-o']");
	By linkExtraChargeForSeveralAdvertisers = By.xpath("//li[contains(text(),'Наценка за 2-х и более рекламодателей:')]//i[@class='fa fa-pencil-square-o']");
	By linkComment = By.xpath("//li[contains(text(),'Комментарий к прайс-листу')]//i[@class='fa fa-pencil-square-o']");
	//fields
	By fieldExtraChargeForDeferredPayment = By.xpath("//li[contains(text(),'Наценка за отсрочку платежа:')]//input[@class='ng-pristine ng-untouched ng-valid ng-isolate-scope']");
	By fieldExtraChargeForSeveralAdvertisers = By.xpath("//li[contains(text(),'Наценка за 2-х и более рекламодателей')]//input[@class='ng-pristine ng-untouched ng-valid ng-isolate-scope']");
	By fieldComment = By.xpath("//li[contains(text(),'Комментарий к прайс-листу')]//input[@class='ng-pristine ng-untouched ng-valid']");
	//buttons
	By buttonSaveExtraChargeForDeferredPayment = By.xpath("//li[contains(text(),'Наценка за отсрочку платежа')]//span[@class='button tiny save' and @title='Сохранить']");
	By buttonSaveExtraChargeForSeveralAdvertisers = By.xpath("//li[contains(text(),'Наценка за 2-х и более рекламодателей')]//span[@class='button tiny save' and @title='Сохранить']");
	By buttonSaveComment = By.xpath("//li[contains(text(),'Комментарий к прайс-листу')]//span[@class='button tiny save' and @title='Сохранить']");
	By buttonCancelOfAdditionOfExtraChargeForDeferredPayment= By.xpath("//li[contains(text(),'Наценка за отсрочку платежа')]//span[@class='button tiny undo' and @title='Отменить']");
	By buttonCancelOfAdditionOfExtraChargeForSeveralAdvertisers = By.xpath("//li[contains(text(),'Наценка за 2-х и более рекламодателей')]//span[@class='button tiny undo' and @title='Отменить']");
	By buttonCancelComment = By.xpath("//li[contains(text(),'Комментарий к прайс-листу')]//span[@class='button tiny undo' and @title='Отменить']");
	//Events
	String priceListPageLoadEvent = "//span[contains(text(),'Все страницы')]";
	String ExtraChargeForDeferredPaymentSaving = "//span//b[contains(text(), '"+extra_charge_number+"')]";
	String ExtraChargeForCancel = "//span//b[contains(text(), '"+extra_charge_number_for_cancel+"')]";
	String ExtraChargeForSeveralAdvertisersSaving = "//span//b[contains(text(), '"+extra_charge_number_for_advertisers+"')]";
	String CommentSaving = "//span//b[contains(text(), 'Comment_"+extra_charge_number_for_advertisers+"')]";
		
	
	public PriceList(WebDriver driver)
	{
		super(driver);
	}
	
	public void loadSitePage()
	{
		loadingSitePage(sitePage, priceListPageLoadEvent, "xpath");
	}
	
	
	public void clickElementOnPagePriceList(By elementOnPagePriceList)
	{
		getWebDriver().findElement(elementOnPagePriceList).click();
	}
	
	
	public void inputTextToField(By fieldOnPagePriceList, String text)
	{
		WebElement field= getWebDriver().findElement(fieldOnPagePriceList);
		field.clear();
		field.sendKeys(text);
	}

		
	public void waitingOf(String locator, String locator_type)
	{
		waitOfPresence(locator_type, locator);
	}
	
	public void waitingOfVisibilityOfLinkDownloadPriceListFile()
	{
		waitOfVisibilityOfElement("linktext", "Скачать таблицу в XLSX");
	}
	
		
	
	public boolean checkPriceListTitles()
	{
		getSitePage(sitePage);
		getWebDriver().navigate().refresh();
		clickElementOnPagePriceList(priceListTab);
		try
		{
			getWebDriver().findElement(By.xpath("//th/div[contains(text(),'Название')]"));
			getWebDriver().findElement(By.xpath("//th/div[contains(text(),'Сайт/Раздел/Формат')]"));
			getWebDriver().findElement(By.xpath("//th[contains(text(),'Вид размещения')]"));
			getWebDriver().findElement(By.xpath("//th[contains(text(),'Объем, показы')]"));
			getWebDriver().findElement(By.xpath("//th[contains(text(),'CPM, руб')]"));
			getWebDriver().findElement(By.xpath("//th[contains(text(),'Прайс, руб')]"));
			getWebDriver().findElement(By.xpath("//th[contains(text(),'Гео')]"));
			getWebDriver().findElement(By.xpath("//th[contains(text(),'Соцдем')]"));
			getWebDriver().findElement(By.xpath("//th[contains(text(),'Интересы')]"));
			getWebDriver().findElement(By.xpath("//th[contains(text(),'Жанр')]"));
			getWebDriver().findElement(By.xpath("//th[contains(text(),'Доход')]"));
			getWebDriver().findElement(By.xpath("//th[contains(text(),'За формат')]"));
		    getWebDriver().findElement(By.xpath("//th[contains(text(),'Платформа')]"));
		    getWebDriver().findElement(By.xpath("//th[contains(text(),'Поведение')]"));
		    getWebDriver().findElement(By.xpath("//th[contains(text(),'Подразделы')]"));
		    getWebDriver().findElement(By.xpath("//th[contains(text(),'Поиск')]"));
		    getWebDriver().findElement(By.xpath("//th[contains(text(),'Ползователи')]"));
		    getWebDriver().findElement(By.xpath("//th[contains(text(),'Комментарий')]"));
				
		}
		catch (NoSuchElementException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean addExtraChargeForDeferredPayment()
	{
		
		loadSitePage();
		clickElementOnPagePriceList(priceListTab);
		clickElementOnPagePriceList(linkAdditionalInformationToPriceList);
		clickElementOnPagePriceList(linkExtraChargeForDeferredPayment);
		inputTextToField(fieldExtraChargeForDeferredPayment, extra_charge_number);
		clickElementOnPagePriceList(buttonSaveExtraChargeForDeferredPayment);
		try {
			waitingOf(ExtraChargeForDeferredPaymentSaving, "xpath");
			}
		catch (Exception e)
		{
			return false;
		}
	  	return true;
	}
	
	public boolean cancelOfAdditionOfExtraChargeForDeferredPayment()
	{
		loadSitePage();
		clickElementOnPagePriceList(priceListTab);
		clickElementOnPagePriceList(linkAdditionalInformationToPriceList);
		clickElementOnPagePriceList(linkExtraChargeForDeferredPayment);
		inputTextToField(fieldExtraChargeForDeferredPayment, extra_charge_number_for_cancel);
		clickElementOnPagePriceList(buttonCancelOfAdditionOfExtraChargeForDeferredPayment);
		try {
			waitingOf(ExtraChargeForCancel, "xpath");
			}
		catch (Exception e)
		{
			e.printStackTrace();
			return true;
			
		}
	  	return false;
	}
	
	public boolean downloadPriceListInFile(String cookie)
	{
	
		try {
			//make http request to Sitepedia API  - download price list file - check response code and header Content-Disposition(should be name of file there) 
			HttpURLConnection conn=Common.makeHttpReq(sitepedia_url+"/sp/site/1/product/m/exim", cookie);
			System.out.println("Key 6 is: "+conn.getHeaderFieldKey(6)+" Field of 6 header is: "+conn.getHeaderField(6));
			if ((conn.getHeaderFieldKey(6).equals("content-disposition")) && (conn.getHeaderField(6).contains("afisha.ru_pricelist_")))
			{}
				else return false;
			
		int resp_code=conn.getResponseCode();
		if (resp_code==200){
			//Check that link "Download price list" is active and clickable
			loadSitePage();
			clickElementOnPagePriceList(priceListTab);
			waitingOfVisibilityOfLinkDownloadPriceListFile();
			clickElementOnPagePriceList(linkDownloadPriceListFile);		 
			            	}
		else return false;
		
	
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
		
		return true;
	}
	
	public boolean addExtraChargeForAdvertisers()
	{
		loadSitePage();
		clickElementOnPagePriceList(priceListTab);
		clickElementOnPagePriceList(linkAdditionalInformationToPriceList);
		clickElementOnPagePriceList(linkExtraChargeForSeveralAdvertisers);
		inputTextToField(fieldExtraChargeForSeveralAdvertisers, extra_charge_number_for_advertisers);
		clickElementOnPagePriceList(buttonSaveExtraChargeForSeveralAdvertisers);
		try {
			waitingOf(ExtraChargeForSeveralAdvertisersSaving, "xpath");
		
			}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	  	return true;
	}
	
	public boolean cancelOfAdditionOfExtraChargeForAdvertisers()
	{
		loadSitePage();
		clickElementOnPagePriceList(priceListTab);
		clickElementOnPagePriceList(linkAdditionalInformationToPriceList);
		clickElementOnPagePriceList(linkExtraChargeForSeveralAdvertisers);
		inputTextToField(fieldExtraChargeForSeveralAdvertisers, extra_charge_number_for_cancel);
		clickElementOnPagePriceList(buttonCancelOfAdditionOfExtraChargeForSeveralAdvertisers);
		try {
			waitingOf(ExtraChargeForCancel, "xpath");
		
			}
		catch (Exception e)
		{
			e.printStackTrace();
			return true;
		}
	  	return false;
	}

	public boolean addComment()
	{
		loadSitePage();
		clickElementOnPagePriceList(priceListTab);
		clickElementOnPagePriceList(linkAdditionalInformationToPriceList);
		clickElementOnPagePriceList(linkComment);
		inputTextToField(fieldComment, "Comment_"+extra_charge_number_for_advertisers);
		clickElementOnPagePriceList(buttonSaveComment);
		//
		
		try {
			waitingOf(CommentSaving, "xpath");
		
			}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	  	return true;
	}
	
	public boolean cancelOfAdditionOfComment()
	{
		loadSitePage();
		clickElementOnPagePriceList(priceListTab);
		clickElementOnPagePriceList(linkAdditionalInformationToPriceList);
		clickElementOnPagePriceList(linkComment);
		inputTextToField(fieldComment, "Comment_"+extra_charge_number_for_cancel);
		clickElementOnPagePriceList(buttonCancelComment);
		//
		
		try {
		    makeScreenshot(getWebDriver(), "screenCancelComment");
			waitingOf(ExtraChargeForCancel, "xpath");
		
			}
		catch (Exception e)
		{
			e.printStackTrace();
			return true;
		}
	  	return false;
	}
	
}
