package page.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import page.objects.Account;
import page.objects.HomePage;
import page.objects.PetStoreMenu;
import page.objects.Registration;
import page.objects.SignIn;
import utility.ExcelUtils;

public class AccountTest {
	@Test
	public void testEditData() throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		// EXCEL
		String dataSRC = "UserRandomData.xlsx";

		ExcelUtils.setExcell(dataSRC);
		ExcelUtils.setWorkSheet("data");

		SoftAssert sa = new SoftAssert();

		driver.get(HomePage.HOME_PAGE_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		HomePage.clickEnterButton(driver);
		PetStoreMenu.clickSignIn(driver);
		Thread.sleep(3000);
		String registeredUser = ExcelUtils.getDataAtNum(51, 0);
		String registeredPassword = ExcelUtils.getDataAt(51, 1);

		// LOG IN input and click button for log in
		SignIn.inputUserName(driver, registeredUser);
		SignIn.inputPassword(driver, registeredPassword);
		SignIn.clickLogInBtn(driver);
		Thread.sleep(2000);
		Account.clickMyAccount(driver);
		Thread.sleep(2000);

		// Change Password. Input new data
		String newPassword = "KK12bb";
		Registration.inputPassword(driver, newPassword);
		Registration.inputRepeatPassword(driver, newPassword);

		
		// Save new changed info
		Account.clickSaveInfo(driver);
		// Log out
		Account.clickSignOut(driver);
		// Log in again to test weather the new info are saved
		PetStoreMenu.clickSignIn(driver);

		// Input new password and old ID
		SignIn.inputUserName(driver, registeredUser);
		SignIn.inputPassword(driver, newPassword);
		SignIn.clickLogInBtn(driver);
		Thread.sleep(2000);

		//We are not logged in with new password because we are at the same page
		String expectedURL = "https://petstore.octoperf.com/actions/Account.action";
		String actualURL = driver.getCurrentUrl();
		
		sa.assertEquals(actualURL, expectedURL);

		sa.assertAll();
		Thread.sleep(2000);
		driver.quit();
	}
}
