package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PetStoreMenu {
	public static final String HOME_URL = "https://petstore.octoperf.com/actions/Catalog.action";
	private static final String SIGN_IN_XPATH = "//a[contains(text(),'Sign In')]";
	private static final String CART_XPATH = "//img[@name='img_cart']";
	private static final String HELP_XPATH = "//a[contains(text(),'?')]";
	private static final String LOGO_BACK_TO_MAIN_XPATH = "//div[@id='LogoContent']//a//img";
	private static final String SEARCH_BOX_XPATH = "//input[@name='keyword']";
	private static final String SEARCH_BUTTON_XPATH = "//input[@name='searchProducts']";
	private static final String POWERED_BY_LINK_XPATH = "//a[contains(text(),'www.mybatis.org')]";

	// LEFT SIDE MENU
	private static final String FISH_LEFT_XPATH = "//div[@id='Content']//a[1]//img[1]";
	private static final String DOGS_LEFT_XPATH = "//div[@id='Content']//a[2]//img[1]";
	private static final String CATS_LEFT_XPATH = "//div[@id='Content']//a[3]//img[1]";
	private static final String REPTILES_LEFT_XPATH = "//div[@id='Content']//a[4]//img[1]";
	private static final String BIRDS_LEFT_XPATH = "//div[@id='Content']//a[5]//img[1]";
	
	// LEFT SIDE FISH MENU
	private static final String ANGEL_FISH_XPATH = "//a[contains(text(),'FI-SW-01')]";
	private static final String TIGER_SHARK_XPATH = "//a[contains(text(),'FI-SW-02')]";
	private static final String KOI_FISH_XPATH = "//a[contains(text(),'FI-FW-01')]";
	private static final String GOLD_FISH_XPATH = "//a[contains(text(),'FI-FW-02')]";

	// LEFT SIDE FISH MENU Large
	private static final String LARGE_ANGEL_FISH_XPATH = "//tr[2]//td[5]//a[1]";
	// LEFT SIDE FISH MENU Small
	private static final String SMALL_ANGEL_FISH_XPATH = "//tr[3]//td[5]//a[1]";

	// TOP MENU
	private static final String FISH_TOP_XPATH = "//div[@id='QuickLinks']//a[1]//img[1]";
	private static final String DOGS_TOP_XPATH = "//div[@id='Header']//a[2]//img[1]";
	private static final String REPTILES_TOP_XPATH = "//div[@id='Header']//a[3]//img[1]";
	private static final String CATS_TOP_XPATH = "//div[@id='Header']//a[4]//img[1]";
	private static final String BIRDS_TOP_XPATH = "//div[@id='Header']//a[5]//img[1]";

	// MAIN MENU
	private static final String BIRDS_CENTER_BIG_XPATH = "//body//area[1]";
	private static final String FISH_CENTER_XPATH = "//body//area[2]";
	private static final String DOGS_CENTER_XPATH = "//body//area[3]";
	private static final String REPTILES_CENTER_XPATH = "//body//area[4]";
	private static final String CATS_CENTER_XPATH = "//body//area[5]";
	private static final String BIRDS_CENTER_XPATH = "//body//area[6]";

	// SIGN IN
	public static WebElement getSignIn(WebDriver driver) {
		return driver.findElement(By.xpath(SIGN_IN_XPATH));
	}

	public static void clickSignIn(WebDriver driver) {
		getSignIn(driver).click();
	}

	// CART
	public static WebElement getCart(WebDriver driver) {
		return driver.findElement(By.xpath(CART_XPATH));
	}

	public static void clickCart(WebDriver driver) {
		getCart(driver).click();
	}

	// HELP
	public static WebElement getHelp(WebDriver driver) {
		return driver.findElement(By.xpath(HELP_XPATH));
	}

	public static void clickHelp(WebDriver driver) {
		getHelp(driver).click();
	}

	// LOGO
	public static WebElement getLogo(WebDriver driver) {
		return driver.findElement(By.xpath(LOGO_BACK_TO_MAIN_XPATH));
	}

	public static void clickLogo(WebDriver driver) {
		getLogo(driver).click();
	}

	// SEARCH BOX
	public static WebElement getSearchBox(WebDriver driver) {
		return driver.findElement(By.xpath(SEARCH_BOX_XPATH));
	}

	public static void clickSearchBox(WebDriver driver) {
		getSearchBox(driver).click();
	}

	public static void inputSearchBox(WebDriver driver, String data) {
		getSearchBox(driver).sendKeys(data);
		;
	}

	// SEARCH BUTTON
	public static WebElement getSearchButton(WebDriver driver) {
		return driver.findElement(By.xpath(SEARCH_BUTTON_XPATH));
	}

	public static void clickSearchButton(WebDriver driver) {
		getSearchButton(driver).click();
	}

	// POWERED BY LINK
	public static WebElement getPoweredBy(WebDriver driver) {
		return driver.findElement(By.xpath(POWERED_BY_LINK_XPATH));
	}

	public static void clickPoweredBy(WebDriver driver) {
		getPoweredBy(driver).click();
	}

	// FISH LEFT MENU
	public static WebElement getFishLeft(WebDriver driver) {
		return driver.findElement(By.xpath(FISH_LEFT_XPATH));
	}

	public static void clickFishLeft(WebDriver driver) {
		getFishLeft(driver).click();
	}

	// DOGS LEFT MENU
	public static WebElement getDogsLeft(WebDriver driver) {
		return driver.findElement(By.xpath(DOGS_LEFT_XPATH));
	}

	public static void clickDogsLeft(WebDriver driver) {
		getDogsLeft(driver).click();
	}

	// CATS LEFT MENU
	public static WebElement getCatsLeft(WebDriver driver) {
		return driver.findElement(By.xpath(CATS_LEFT_XPATH));
	}

	public static void clickCatsLeft(WebDriver driver) {
		getCatsLeft(driver).click();
	}

	// REPTILES LEFT MENU
	public static WebElement getReptilesLeft(WebDriver driver) {
		return driver.findElement(By.xpath(REPTILES_LEFT_XPATH));
	}

	public static void clickReptilesLeft(WebDriver driver) {
		getReptilesLeft(driver).click();
	}

	// BIRDS LEFT MENU
	public static WebElement getBirdsLeft(WebDriver driver) {
		return driver.findElement(By.xpath(BIRDS_LEFT_XPATH));
	}

	public static void clickBirdsLeft(WebDriver driver) {
		getBirdsLeft(driver).click();
	}

	// FISH TOP MENU
	public static WebElement getFishTop(WebDriver driver) {
		return driver.findElement(By.xpath(FISH_TOP_XPATH));
	}

	public static void clickFishTop(WebDriver driver) {
		getFishTop(driver).click();
	}

	// DOGS TOP MENU
	public static WebElement getDogsTop(WebDriver driver) {
		return driver.findElement(By.xpath(DOGS_TOP_XPATH));
	}

	public static void clickDogsTop(WebDriver driver) {
		getDogsTop(driver).click();
	}

	// CATS TOP MENU
	public static WebElement getCatsTop(WebDriver driver) {
		return driver.findElement(By.xpath(CATS_TOP_XPATH));
	}

	public static void clickCatsTop(WebDriver driver) {
		getCatsTop(driver).click();
	}

	// REPTILES TOP MENU
	public static WebElement getReptilesTop(WebDriver driver) {
		return driver.findElement(By.xpath(REPTILES_TOP_XPATH));
	}

	public static void clickReptilesTop(WebDriver driver) {
		getReptilesTop(driver).click();
	}

	// BIRDS TOP MENU
	public static WebElement getBirdsTop(WebDriver driver) {
		return driver.findElement(By.xpath(BIRDS_TOP_XPATH));
	}

	public static void clickBirdsTop(WebDriver driver) {
		getBirdsTop(driver).click();
	}

	// BIRDS CENTER BIG MENU
	public static WebElement getBirdsCenterBig(WebDriver driver) {
		return driver.findElement(By.xpath(BIRDS_CENTER_BIG_XPATH));
	}

	public static void clickBirdsCenterBig(WebDriver driver) {
		getBirdsCenterBig(driver).click();
	}

	// FISH CENTER MENU
	public static WebElement getFishCenter(WebDriver driver) {
		return driver.findElement(By.xpath(FISH_CENTER_XPATH));
	}

	public static void clickFishCenter(WebDriver driver) {
		getFishCenter(driver).click();
	}

	// DOGS CENTER MENU
	public static WebElement getDogsCenter(WebDriver driver) {
		return driver.findElement(By.xpath(DOGS_CENTER_XPATH));
	}

	public static void clickDogsCenter(WebDriver driver) {
		getDogsCenter(driver).click();
	}

	// CATS CENTER MENU
	public static WebElement getCatsCenter(WebDriver driver) {
		return driver.findElement(By.xpath(CATS_CENTER_XPATH));
	}

	public static void clickCatsCenter(WebDriver driver) {
		getCatsCenter(driver).click();
	}

	// REPTILES CENTER MENU
	public static WebElement getReptilesCenter(WebDriver driver) {
		return driver.findElement(By.xpath(REPTILES_CENTER_XPATH));
	}

	public static void clickReptilesCenter(WebDriver driver) {
		getReptilesCenter(driver).click();
	}

	// BIRDS CENTER MENU
	public static WebElement getBirdsCenter(WebDriver driver) {
		return driver.findElement(By.xpath(BIRDS_CENTER_XPATH));
	}

	public static void clickBirdsCenter(WebDriver driver) {
		getBirdsCenter(driver).click();
	}

	// ANGEL FISH
	public static WebElement getAngelFishLeft(WebDriver driver) {
		return driver.findElement(By.xpath(ANGEL_FISH_XPATH));
	}

	public static void clickAngelFishLeft(WebDriver driver) {
		getAngelFishLeft(driver).click();
	}

	// TIGER FISH
	public static WebElement getTigerFishLeft(WebDriver driver) {
		return driver.findElement(By.xpath(TIGER_SHARK_XPATH));
	}

	public static void clickTigerFishLeft(WebDriver driver) {
		getTigerFishLeft(driver).click();
	}

	// KOI FISH
	public static WebElement getKoiFishLeft(WebDriver driver) {
		return driver.findElement(By.xpath(KOI_FISH_XPATH));
	}

	public static void clickKoiFishLeft(WebDriver driver) {
		getKoiFishLeft(driver).click();
	}

	// GOLD FISH
	public static WebElement getGoldFishLeft(WebDriver driver) {
		return driver.findElement(By.xpath(GOLD_FISH_XPATH));
	}

	public static void clickGoldFishLeft(WebDriver driver) {
		getGoldFishLeft(driver).click();
	}

	// LARGE ANGEL FISH ADD TO CART
	public static WebElement getLargeAngelFishAdd(WebDriver driver) {
		return driver.findElement(By.xpath(LARGE_ANGEL_FISH_XPATH));
	}

	public static void clickLargeAngelFishAdd(WebDriver driver) {
		getLargeAngelFishAdd(driver).click();
	}

	// SMALL ANGEL FISH ADD TO CART
	public static WebElement getSmallAngelFishAdd(WebDriver driver) {
		return driver.findElement(By.xpath(SMALL_ANGEL_FISH_XPATH));
	}

	public static void clickSmallAngelFishAdd(WebDriver driver) {
		getSmallAngelFishAdd(driver).click();
	}
}
