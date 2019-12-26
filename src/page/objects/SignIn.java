package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignIn {
	public static final String SIGN_IN_URL = "https://petstore.octoperf.com/actions/Account.action?signonForm=";
	public static final String SIGN_IN_FAILED_XPATH = "//li[contains(text(),'Signon failed.')]";//For testNG
	private static final String USER_NAME_BYNAME = "username";
	private static final String PASSWORD_XPATH = "//input[@name='password']";
	private static final String LOG_IN_BUTTON_XPATH = "//input[@name='signon']";
	private static final String REGISTER_LINK_XPATH = "//a[contains(text(),'Register Now!')]";
	
	

	
	
	// USER NAME
	public static WebElement getUserName(WebDriver driver) {
		WebElement emptyUserBox = driver.findElement(By.name(USER_NAME_BYNAME));
		emptyUserBox.clear();
		return emptyUserBox;
	}

	public static void clickUserName(WebDriver driver) {
		getUserName(driver).click();
	}

	public static void inputUserName(WebDriver driver, String data) {
		getUserName(driver).sendKeys(data);
	}

	// PASSWORD
	//Box for input pass is not empty so I want to clear it before input data
	//My method getPassword will return Web element such as empty box
	public static WebElement getPassword(WebDriver driver) {
		WebElement emptyPassBox = driver.findElement(By.xpath(PASSWORD_XPATH));
		emptyPassBox.clear();
		return emptyPassBox;
	}

	public static void clickPassword(WebDriver driver) {
		getPassword(driver).click();
	}

	public static void inputPassword(WebDriver driver, String data) {
		getPassword(driver).sendKeys(data);

	}
	
	//LOG IN
	public static WebElement getLogInBtn (WebDriver driver) {
		return driver.findElement(By.xpath(LOG_IN_BUTTON_XPATH));
	}
	public static void clickLogInBtn (WebDriver driver) {
		getLogInBtn(driver).click();
	}
	
	//REGISTER
	public static WebElement getRegister (WebDriver driver) {
		return driver.findElement(By.xpath(REGISTER_LINK_XPATH));
	}
	public static void clickRegister (WebDriver driver) {
		getRegister(driver).click();
	}
	
	
	

}
