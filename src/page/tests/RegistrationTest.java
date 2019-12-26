package page.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import page.objects.HomePage;
import page.objects.PetStoreMenu;
import page.objects.Registration;
import page.objects.SignIn;
import utility.ExcelUtils;

public class RegistrationTest {

	@Test(priority = 1)
	public void testUrl() {
		WebDriver driver = new ChromeDriver();

		// Open registration page
		driver.get(Registration.REGISTRATION_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		Assert.assertEquals(driver.getCurrentUrl(), Registration.REGISTRATION_URL, "Not the right page.");
		driver.quit();
	}

	@Test(priority = 2)
	public void testRegisterBlankFields() throws InterruptedException {// zasto pada test? Manuelno je ok
		WebDriver driver = new ChromeDriver();
		// Open registration page
		driver.get(Registration.REGISTRATION_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// All input fields
		List<WebElement> elements = driver.findElements(By.tagName("type = text"));

		// I want blank everything to try to register
		// Leaving everything blank
		for (WebElement e : elements) {
			if (e.isDisplayed()) {
				e.clear();
				e.sendKeys("");
			}
		}

		// Now i can click save
		Registration.clickSave(driver);

		Thread.sleep(2000);
		
		// Testing if I can register with blank fields. 
		// That should take me back to the same page url
		SoftAssert sa = new SoftAssert();
		sa.assertTrue((Registration.getUserID(driver)).isDisplayed(),
				"Not the same page. Something wrong.");
		driver.quit();

	}

	@Test(priority = 3)
	public void testWrongRepeatPass() throws InterruptedException {
		// this test is suposed to fail
		WebDriver driver = new ChromeDriver();

		// Open registration page
		driver.get(Registration.REGISTRATION_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// EXCEL
		String dataSRC = "UserRandomData.xlsx";

		ExcelUtils.setExcell(dataSRC);
		ExcelUtils.setWorkSheet("data");

		// Input data for one user
		String wrongPassword = "dsddds";
		Registration.inputUserID(driver, ExcelUtils.getDataAt(1, 0));
		Registration.inputPassword(driver, ExcelUtils.getDataAt(1, 1));
		Registration.inputRepeatPassword(driver, wrongPassword);
		Registration.inputFirstName(driver, ExcelUtils.getDataAt(1, 2));
		Registration.inputLastName(driver, ExcelUtils.getDataAt(1, 3));
		Registration.inputEmail(driver, ExcelUtils.getDataAt(1, 4));
		Registration.inputPhone(driver, ExcelUtils.getDataAt(1, 5));
		Registration.inputAddress1(driver, ExcelUtils.getDataAt(1, 6));
		Registration.inputAddress2(driver, ExcelUtils.getDataAt(1, 7));
		Registration.inputCity(driver, ExcelUtils.getDataAt(1, 8));
		Registration.inputState(driver, ExcelUtils.getDataAt(1, 9));
		Registration.inputZip(driver, ExcelUtils.getDataAt(1, 10));
		Registration.inputCountry(driver, ExcelUtils.getDataAt(1, 11));
		// PROFILE INFORMATION
		Registration.inputLanguage(driver, 0);
		Registration.inputCategory(driver, 4);
		Registration.clickMyList(driver);
		Registration.clickMyBanner(driver);
		Registration.clickSave(driver);

		Thread.sleep(2000);
		// Should take us to the pet store home if pass, but I inputed wrong data so I
		// expect that is not the case
		// We shouldn't register, that's why notEquals
		Assert.assertNotEquals(driver.getCurrentUrl(), PetStoreMenu.HOME_URL, "Error. We registered.");

		ExcelUtils.closeExcell();
		driver.quit();
	}

	@Test(priority = 4)
	public void testDuplicateRegister() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		// EXCEL
		String dataSRC = "UserRandomData.xlsx";

		ExcelUtils.setExcell(dataSRC);
		ExcelUtils.setWorkSheet("data");
		// Open registration page
		driver.get(Registration.REGISTRATION_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// same id already registered
		Registration.inputUserID(driver, ExcelUtils.getDataAt(1, 0));
		Registration.inputPassword(driver, ExcelUtils.getDataAt(1, 1));
		Registration.inputRepeatPassword(driver, ExcelUtils.getDataAt(1, 1));
		Registration.inputFirstName(driver, ExcelUtils.getDataAt(1, 2));
		Registration.inputLastName(driver, ExcelUtils.getDataAt(1, 3));
		Registration.inputEmail(driver, ExcelUtils.getDataAt(1, 4));
		Registration.inputPhone(driver, ExcelUtils.getDataAt(1, 5));
		Registration.inputAddress1(driver, ExcelUtils.getDataAt(1, 6));
		Registration.inputAddress2(driver, ExcelUtils.getDataAt(1, 7));
		Registration.inputCity(driver, ExcelUtils.getDataAt(1, 8));
		Registration.inputState(driver, ExcelUtils.getDataAt(1, 9));
		Registration.inputZip(driver, ExcelUtils.getDataAt(1, 10));
		Registration.inputCountry(driver, ExcelUtils.getDataAt(1, 11));
		// PROFILE INFORMATION
		Registration.inputLanguage(driver, 0);
		Registration.inputCategory(driver, 4);
		Registration.clickMyList(driver);
		Registration.clickMyBanner(driver);
		Registration.clickSave(driver);

		Thread.sleep(2000);

		String expectedMessage_xpath = "//h1[contains(text(),'Internal Server Error')]";
		// Error page if I want to use already registered id
		Assert.assertTrue(driver.findElement(By.xpath(expectedMessage_xpath)).isDisplayed(), "ID already taken.");
	}

	@Test(priority = 5)
	public void testMultipleRegistration() throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		// EXCEL
		String dataSRC = "UserRandomData.xlsx";

		ExcelUtils.setExcell(dataSRC);
		ExcelUtils.setWorkSheet("data");

		SoftAssert sa = new SoftAssert();

		// Input data from excel file for multiple users(all)
		// i=2 because we've already registered the first user
		for (int i = 2; i < 51; i++) {

			driver.get(HomePage.HOME_PAGE_URL);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.manage().window().maximize();

			HomePage.clickEnterButton(driver);
			PetStoreMenu.clickSignIn(driver);
			Thread.sleep(3000);
			SignIn.clickRegister(driver);

			// driver.get(Registration.REGISTRATION_URL);

			Thread.sleep(2000);
			Registration.inputUserID(driver, ExcelUtils.getDataAtNum(i, 0));
			Registration.inputPassword(driver, ExcelUtils.getDataAt(i, 1));
			Registration.inputRepeatPassword(driver, ExcelUtils.getDataAt(i, 1));
			Registration.inputFirstName(driver, ExcelUtils.getDataAt(i, 2));
			Registration.inputLastName(driver, ExcelUtils.getDataAt(i, 3));
			Registration.inputEmail(driver, ExcelUtils.getDataAt(i, 4));
			Registration.inputPhone(driver, ExcelUtils.getDataAt(i, 5));
			Registration.inputAddress1(driver, ExcelUtils.getDataAt(i, 6));
			Registration.inputAddress2(driver, ExcelUtils.getDataAt(i, 7));
			Registration.inputCity(driver, ExcelUtils.getDataAt(i, 8));
			Registration.inputState(driver, ExcelUtils.getDataAt(i, 9));
			Registration.inputZip(driver, ExcelUtils.getDataAtNum(i, 10));
			Registration.inputCountry(driver, ExcelUtils.getDataAt(i, 11));
			// PROFILE INFORMATION
			Registration.inputLanguage(driver, 1);
			Registration.inputCategory(driver, 4);
			Registration.clickMyList(driver);
			Registration.clickMyBanner(driver);
			Registration.clickSave(driver);
			Thread.sleep(3000);
			sa.assertEquals(driver.getCurrentUrl(), PetStoreMenu.HOME_URL, "Error. User " + i + " is not registered.");

		}

		sa.assertAll();
		Thread.sleep(2000);

		driver.quit();
	}

}
