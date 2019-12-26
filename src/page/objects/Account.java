package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Account {
	private static final String SIGN_OUT_XPATH = "//a[contains(text(),'Sign Out')]";
	private static final String SIGN_OUT_ABS_XPATH = "/html[1]/body[1]/div[1]/div[2]/div[1]/a[2]";
	//private static final String SIGN_OUT_LINK = "href=\"/actions/Account.action?signoff=\"";
	//private static final String SIGN_OUT_STYLE = "Sign off";
	private static final String MY_ACCOUNT_XPATH = "//a[contains(text(),'My Account')]";
	private static final String WELCOME_CONTENT_XPATH = "//div[@id='WelcomeContent']";
	private static final String WELCOME_CONTENT_ID = "WelcomeContent";
	
	//MY ACCOUNT
	private static final String USER_FIELD_XPATH1 = "//td[contains(text(),'";
	private static final String USER_ID_NUMBER = "number";
	private static final String USER_FIELD_XPATH2 = "')]";
	private static final String MY_ORDERS_XPATH = "//a[contains(text(),'My Orders')]";
	private static final String SAVE_INFO_ABS_XPATH = "/html[1]/body[1]/div[2]/div[1]/form[1]/input[1]";
		

	// SIGN OUT
	public static WebElement getSignOut(WebDriver driver) {
		return driver.findElement(By.xpath(SIGN_OUT_ABS_XPATH));
	}

	public static void clickSignOut(WebDriver driver) {
		getSignOut(driver).click();
	}

	// MY ACCOUNT
	public static WebElement getMyAccount(WebDriver driver) {
		return driver.findElement(By.xpath(MY_ACCOUNT_XPATH));
	}

	public static void clickMyAccount(WebDriver driver) {
		getMyAccount(driver).click();
	}

	// WELCOME CONTENT
	public static WebElement getWelcome(WebDriver driver) {
		return driver.findElement(By.xpath(WELCOME_CONTENT_XPATH));
	}
	
	public static WebElement getWelcomeId(WebDriver driver) {
		return driver.findElement(By.id(WELCOME_CONTENT_ID));
	}

	//MY ORDERS
	public static WebElement getMyOrders(WebDriver driver) {
		return driver.findElement(By.xpath(MY_ORDERS_XPATH));
	}
	public static void clickMyOrders(WebDriver driver) {
		getMyOrders(driver).click();
	}
	
	//SAVE
	public static WebElement getSaveInfo(WebDriver driver) {
		return driver.findElement(By.xpath(SAVE_INFO_ABS_XPATH));
	}
	public static void clickSaveInfo(WebDriver driver) {
		getSaveInfo(driver).click();
	}
}
