import main.java.SitepediaPages.Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;


public class IviTest {

	public static void main(String[] args) {
		WebDriver driver ;
		
		 for (int i=1; i<1000; i++)
		 {
			 System.setProperty("webdriver.chrome.driver", 
		                "C:\\Users\\ovalekseeva\\Sitepedia\\chromedriver.exe"); 
				 driver = new ChromeDriver();
		driver.get("http://advertiser:2oc8ES6UR@stable.ivi.ru/watch/7029?adr_order_id=246161");
		System.out.println(i);
		Common.sleep(31000);
		driver.quit();
		 }

	}

}
