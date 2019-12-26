package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	public static final String HOME_PAGE_URL = "https://petstore.octoperf.com/";
	private static final String ENTER_XPATH = "//a[contains(text(),'Enter the Store')]";
	
	
	//Enter the store button
	public static WebElement getEnterButton (WebDriver driver) {
		return driver.findElement(By.xpath(ENTER_XPATH));
	}
	public static void clickEnterButton(WebDriver driver){
		getEnterButton(driver).click();
	}

}
