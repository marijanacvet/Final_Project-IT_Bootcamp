package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Registration {
	public static final String REGISTRATION_URL = "https://petstore.octoperf.com/actions/Account.action?newAccountForm=";

	private static final String USER_ID_NAME = "username";
	private static final String NEW_PASSWORD_XPATH = "//input[@name='password']";
	private static final String REPEAT_PASSWORD_XPATH = "//input[@name='repeatedPassword']";
	private static final String FIRST_NAME_XPATH = "//input[@name='account.firstName']";
	private static final String LAST_NAME_XPATH = "//input[@name='account.lastName']";
	private static final String EMAIL_XPATH = "//input[@name='account.email']";
	private static final String PHONE_XPATH = "//input[@name='account.phone']";
	private static final String ADDRESS1_XPATH = "//input[@name='account.address1']";
	private static final String ADDRESS2_XPATH = "//input[@name='account.address2']";
	private static final String CITY_XPATH = "//input[@name='account.city']";
	private static final String STATE_XPATH = "//input[@name='account.state']";
	private static final String ZIP_XPATH = "//input[@name='account.zip']";
	private static final String COUNTRY_XPATH = "//input[@name='account.country']";
	private static final String LANGUAGE_PREFERENCE_XPATH = "//select[@name='account.languagePreference']";
	private static final String CATEGORY_XPATH = "//select[@name='account.favouriteCategoryId']";// TYPE LETTER
	private static final String ENABLE_MY_LIST_XPATH = "//input[@name='account.listOption']";
	private static final String ENABLE_MY_BANNER_XPATH = "//input[@name='account.bannerOption']";
	private static final String SAVE_ACC_INFORMATION_XPATH = "//input[@name='newAccount']";
	

	// USER ID
	public static WebElement getUserID(WebDriver driver) {
		return driver.findElement(By.name(USER_ID_NAME));
	}

	public static void clickUserID(WebDriver driver) {
		getUserID(driver).click();
	}

	public static void inputUserID(WebDriver driver, String data) {
		WebElement elem = getUserID(driver);
		elem.clear();
		elem.sendKeys(data);
	}

	// NEW PASSWORD
	public static WebElement getPassword(WebDriver driver) {
		return driver.findElement(By.xpath(NEW_PASSWORD_XPATH));
	}

	public static void clickPassword(WebDriver driver) {
		getPassword(driver).click();
	}

	public static void inputPassword(WebDriver driver, String data) {
		WebElement elem = getPassword(driver);
		elem.clear();
		elem.sendKeys(data);
	}

	// REPEAT PASSWORD
	public static WebElement getRepeatPassword(WebDriver driver) {
		return driver.findElement(By.xpath(REPEAT_PASSWORD_XPATH));
	}

	public static void clickRepeatPassword(WebDriver driver) {
		getRepeatPassword(driver).click();
	}

	public static void inputRepeatPassword(WebDriver driver, String data) {
		WebElement elem = getRepeatPassword(driver);
		elem.clear();
		elem.sendKeys(data);
	}

	// FIRST NAME
	public static WebElement getFirstName(WebDriver driver) {
		return driver.findElement(By.xpath(FIRST_NAME_XPATH));
	}

	public static void clickFirstName(WebDriver driver) {
		getFirstName(driver).click();
	}

	public static void inputFirstName(WebDriver driver, String data) {
		WebElement elem = getFirstName(driver);
		elem.clear();
		elem.sendKeys(data);
	}

	// LAST NAME
	public static WebElement getLastName(WebDriver driver) {
		return driver.findElement(By.xpath(LAST_NAME_XPATH));
	}

	public static void clickLastName(WebDriver driver) {
		getLastName(driver).click();
	}

	public static void inputLastName(WebDriver driver, String data) {
		WebElement elem = getLastName(driver);
		elem.clear();
		elem.sendKeys(data);
	}

	// EMAIL
	public static WebElement getEmail(WebDriver driver) {
		return driver.findElement(By.xpath(EMAIL_XPATH));
	}

	public static void clickEmail(WebDriver driver) {
		getEmail(driver).click();
	}

	public static void inputEmail(WebDriver driver, String data) {
		WebElement elem = getEmail(driver);
		elem.clear();
		elem.sendKeys(data);
	}
	
	
	// PHONE
		public static WebElement getPhone(WebDriver driver) {
			return driver.findElement(By.xpath(PHONE_XPATH));
		}

		public static void clickPhone(WebDriver driver) {
			getPhone(driver).click();
		}

		public static void inputPhone(WebDriver driver, String data) {
			WebElement elem = getPhone(driver);
			elem.clear();
			elem.sendKeys(data);
		}
		
		// ADDRESS 1
		public static WebElement getAddress1(WebDriver driver) {
			return driver.findElement(By.xpath(ADDRESS1_XPATH));
		}

		public static void clickAddress1(WebDriver driver) {
			getAddress1(driver).click();
		}

		public static void inputAddress1(WebDriver driver, String data) {
			WebElement elem = getAddress1(driver);
			elem.clear();
			elem.sendKeys(data);
		}
		
		// ADDRESS 2
		public static WebElement getAddress2(WebDriver driver) {
			return driver.findElement(By.xpath(ADDRESS2_XPATH));
		}

		public static void clickAddress2(WebDriver driver) {
			getAddress2(driver).click();
		}

		public static void inputAddress2(WebDriver driver, String data) {
			WebElement elem = getAddress2(driver);
			elem.clear();
			elem.sendKeys(data);
		}
		
		// CITY
		public static WebElement getCity(WebDriver driver) {
			return driver.findElement(By.xpath(CITY_XPATH));
		}

		public static void clickCity(WebDriver driver) {
			getCity(driver).click();
		}

		public static void inputCity(WebDriver driver, String data) {
			WebElement elem = getCity(driver);
			elem.clear();
			elem.sendKeys(data);
		}
		
		// STATE
		public static WebElement getState(WebDriver driver) {
			return driver.findElement(By.xpath(STATE_XPATH));
		}

		public static void clickState(WebDriver driver) {
			getState(driver).click();
		}

		public static void inputState(WebDriver driver, String data) {
			WebElement elem = getState(driver);
			elem.clear();
			elem.sendKeys(data);
		}
	
		// ZIP
		public static WebElement getZip(WebDriver driver) {
			return driver.findElement(By.xpath(ZIP_XPATH));
		}

		public static void clickZip(WebDriver driver) {
			getZip(driver).click();
		}

		public static void inputZip(WebDriver driver, String data) {
			WebElement elem = getZip(driver);
			elem.clear();
			elem.sendKeys(data);
		}
		
		// COUNTRY
		public static WebElement getCountry(WebDriver driver) {
			return driver.findElement(By.xpath(COUNTRY_XPATH));
		}

		public static void clickCountry(WebDriver driver) {
			getCountry(driver).click();
		}

		public static void inputCountry(WebDriver driver, String data) {
			WebElement elem = getCountry(driver);
			elem.clear();
			elem.sendKeys(data);
		}
		
		//LANGUAGE PREFERENCE
		public static Select getLanguage(WebDriver driver) {
			return new Select(driver.findElement(By.xpath(LANGUAGE_PREFERENCE_XPATH)));
		}
		public static void inputLanguage (WebDriver driver, int index) {
			getLanguage(driver).selectByIndex(index);
		}
		
		//FAVOURITE CATEGORY
		public static Select getCategory (WebDriver driver) {
			return new Select (driver.findElement(By.xpath(CATEGORY_XPATH)));
		}
		public static void inputCategory (WebDriver driver, int index) {
			getCategory(driver).selectByIndex(index);
		}
		
		//ENABLE MY LIST
		public static WebElement getMyList(WebDriver driver) {
			return driver.findElement(By.xpath(ENABLE_MY_LIST_XPATH));
		}
		public static void clickMyList (WebDriver driver) {
			getMyList(driver).click();
		}
				
		//ENABLE MY BANNER
		public static WebElement getMyBanner (WebDriver driver) {
			return driver.findElement(By.xpath(ENABLE_MY_BANNER_XPATH));
		}
		public static void clickMyBanner (WebDriver driver) {
			getMyBanner(driver).click();
		}
		
		//SAVE INFO
		public static WebElement getSave (WebDriver driver) {
			return driver.findElement(By.xpath(SAVE_ACC_INFORMATION_XPATH));
		}
		public static void clickSave (WebDriver driver) {
			getSave(driver).click();
		}

}
