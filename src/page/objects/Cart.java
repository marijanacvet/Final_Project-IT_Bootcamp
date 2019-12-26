package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart {
	public static final String CART_URL = "https://petstore.octoperf.com/actions/Cart.action?viewCart=";
	private static final String CART_XPATH = "//img[@name='img_cart']";
	private static final String UPDATE_CART_XPATH = "//input[@name='updateCartQuantities']";
	private static final String RETURN_TO_MAIN_MENU_XPATH = "//a[contains(text(),'Return to Main Menu')]";
	

	//CART ICON
	public static WebElement getCart (WebDriver driver) {
		return driver.findElement(By.xpath(CART_XPATH));
	}
	public static void clickCart (WebDriver driver) {
		getCart(driver).click();
	}
	
	//UPDATE CART
	public static WebElement getUpdateCart (WebDriver driver) {
		return driver.findElement(By.xpath(UPDATE_CART_XPATH));
	}
	public static void clickUpdateCart (WebDriver driver) {
		getUpdateCart(driver).click();
	}
	
	//RETURN TO MAIN MENU
	public static WebElement getReturnToMenu (WebDriver driver) {
		return driver.findElement(By.xpath(RETURN_TO_MAIN_MENU_XPATH));
	}
	public static void clickReturnToMenu (WebDriver driver) {
		getReturnToMenu(driver).click();
	}
	
	
}
