package page.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import page.objects.Account;
import page.objects.PetStoreMenu;
import page.objects.Registration;
import page.objects.SignIn;
import utility.ExcelUtils;

public class SignInTest {

	@Test
	public void urlAndFieldsTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Open SignIn page
		driver.get(SignIn.SIGN_IN_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		SoftAssert sa = new SoftAssert();

		// URL
		sa.assertTrue(driver.getCurrentUrl().contains(SignIn.SIGN_IN_URL), "The URL of Sign in page is not right.");

		// USER NAME
		sa.assertTrue(SignIn.getUserName(driver).isDisplayed(), "Web element User name is not displayed.");
		SignIn.inputUserName(driver, "mari111");

		// PASSWORD
		sa.assertTrue(SignIn.getPassword(driver).isDisplayed(), "Web element Password is not displayed.");

		// To the sign in page
		Thread.sleep(2000);
		PetStoreMenu.clickLogo(driver);
		PetStoreMenu.clickSignIn(driver);
		SignIn.clickRegister(driver);
		Thread.sleep(2000);

		// CLICK REGISTER NAVIGATES TO the right page
		sa.assertTrue(driver.getCurrentUrl().contains(Registration.REGISTRATION_URL),
				"Register now link does not navigate to the right page.");

		sa.assertAll();

		driver.quit();
	}

	@Test
	public void trySignIn() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Open SignIn page
		driver.get(SignIn.SIGN_IN_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		SoftAssert sa = new SoftAssert();

		// Blank. I want to leave the fields empty
		String blankUser = "";
		String blankPassword = "";
		SignIn.inputUserName(driver, blankUser);
		SignIn.inputPassword(driver, blankPassword);
		SignIn.clickLogInBtn(driver);

		// Testing if we can sign in with blank fields.
		// If after clicking on login button driver get the same url like before
		// clicking, we did not singed in.
		sa.assertEquals(driver.getCurrentUrl(), SignIn.SIGN_IN_URL, "Error. We just singed in with blank fields.");

		// Input unregistered user and password
		String invalidUser = "kjhdskfah";
		String invalidPassword = "jdslsjs";
		SignIn.inputUserName(driver, invalidUser);
		SignIn.inputPassword(driver, invalidPassword);
		SignIn.clickLogInBtn(driver);

		// Now testing if unregistered data will pass
		sa.assertTrue(driver.findElement(By.xpath(SignIn.SIGN_IN_FAILED_XPATH)).getText()
				.equals("Invalid username or password. Signon failed.\n" + ""), "Text does not exist.");

		driver.quit();

	}

	@Test
	public void signInValidDataTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// EXCEL
		String dataSRC = "UserRandomData.xlsx";
		ExcelUtils.setExcell(dataSRC);
		ExcelUtils.setWorkSheet("data");

		// Open SignIn page
		driver.get(SignIn.SIGN_IN_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		// Click on sign in button
		PetStoreMenu.clickSignIn(driver);

		// Vars for log in fields
		Thread.sleep(2000);
		String registeredUser = ExcelUtils.getDataAtNum(51, 0);
		String registeredPassword = ExcelUtils.getDataAt(51, 1);

		// LOG IN input and click button for log in
		SignIn.inputUserName(driver, registeredUser);
		SignIn.inputPassword(driver, registeredPassword);
		SignIn.clickLogInBtn(driver);
		Thread.sleep(2000);

		SoftAssert sa = new SoftAssert();

		// Testing if we are logged in. If we are, we'll see sign out btn
		sa.assertTrue((Account.getSignOut(driver)).isDisplayed(), "You are not signed in.");
		Thread.sleep(3000);
		Thread.sleep(2000);
		sa.assertAll();

		ExcelUtils.closeExcell();
		driver.quit();
	}

	@Test
	public void testMultipleSignIn() throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		// EXCEL
		String dataSRC = "UserRandomData.xlsx";

		ExcelUtils.setExcell(dataSRC);
		ExcelUtils.setWorkSheet("data");

		SoftAssert sa = new SoftAssert();
		
		driver.get(SignIn.SIGN_IN_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		// Log in all from excel file
		for (int i = 1; i < 52; i++) {
			PetStoreMenu.clickSignIn(driver);
			Thread.sleep(3000);

			Registration.inputUserID(driver, ExcelUtils.getDataAtNum(i, 0));
			Registration.inputPassword(driver, ExcelUtils.getDataAt(i, 1));
			SignIn.clickLogInBtn(driver);
			Thread.sleep(2000);

			Account.clickSignOut(driver);
			Thread.sleep(3000);
		}

		driver.quit();

		ExcelUtils.closeExcell();
	}

	@Test
	public void testSignOut() throws InterruptedException {
		// ONE USER
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// EXCEL
		String dataSRC = "UserRandomData.xlsx";
		ExcelUtils.setExcell(dataSRC);
		ExcelUtils.setWorkSheet("data");

		// Open SignIn page
		driver.get(SignIn.SIGN_IN_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		PetStoreMenu.clickSignIn(driver);
		SoftAssert sa = new SoftAssert();
		String userName = ExcelUtils.getDataAtNum(51, 0);
		String password = ExcelUtils.getDataAt(51, 1);
		// Sign in
		SignIn.inputUserName(driver, userName);
		SignIn.inputPassword(driver, password);
		SignIn.clickLogInBtn(driver);
		Thread.sleep(2000);
		// Firstable test if we are succesfully signed in
		sa.assertTrue(Account.getWelcomeId(driver).isDisplayed(), "You are not signed in.");
		// Click Sign out
		Thread.sleep(3000);
		Account.clickSignOut(driver);
		sa.assertTrue(PetStoreMenu.getSignIn(driver).isDisplayed(), "Sign out error.");
		sa.assertAll();
		Thread.sleep(2000);

		ExcelUtils.closeExcell();
		driver.quit();
	}
}
