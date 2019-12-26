package main;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import page.objects.Account;
import page.objects.HomePage;
import page.objects.PetStoreMenu;
import page.objects.Registration;
import page.objects.SignIn;
import utility.ExcelUtils;

public class GrandFinale {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Open HomePage
		driver.get(HomePage.HOME_PAGE_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    	// Maximize the window
		driver.manage().window().maximize();

		HomePage.clickEnterButton(driver);

		PetStoreMenu.clickSignIn(driver);
		Thread.sleep(3000);

		
		//EXCEL
		String dataSRC = "UserRandomData.xlsx";

		ExcelUtils.setExcell(dataSRC);
		ExcelUtils.setWorkSheet("data");
		ExcelUtils.setDataAt(0, 12, "Status");

		// Open register form page
		SignIn.clickRegister(driver);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		

		
		for (int i = 1; i < 51; i++) {

			driver.get(HomePage.HOME_PAGE_URL);

			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			HomePage.clickEnterButton(driver);

			
			PetStoreMenu.clickSignIn(driver);
			Thread.sleep(3000);

			SignIn.clickRegister(driver);
			
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

			
		}
		Thread.sleep(3000);
		
		driver.get(HomePage.HOME_PAGE_URL);

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		HomePage.clickEnterButton(driver);
	
		for (int i = 1; i < 52; i++) {
			Thread.sleep(2000);

			PetStoreMenu.clickSignIn(driver);
			Thread.sleep(3000);
			
			Thread.sleep(2000);
			Registration.inputUserID(driver, ExcelUtils.getDataAtNum(i, 0));
			Registration.inputPassword(driver, ExcelUtils.getDataAt(i, 1));
			SignIn.clickLogInBtn(driver);
			Thread.sleep(2000);
			
			if (Account.getWelcome(driver).isDisplayed()) {
				ExcelUtils.setDataAt(i, 12, "Uspesno ste se logovali");
			}
			
			
			
			Account.clickSignOut(driver);
			Thread.sleep(3000);
		}
		
		
		for (int i = 1; i < 52; i++) {
			PetStoreMenu.clickSignIn(driver);
			Thread.sleep(3000);

			Registration.inputUserID(driver, ExcelUtils.getDataAtNum(i, 0));
			Registration.inputPassword(driver, ExcelUtils.getDataAt(i, 1));
			SignIn.clickLogInBtn(driver);
			Thread.sleep(2000);

			if (Account.getWelcome(driver).isDisplayed()) {
				ExcelUtils.setDataAt(i, 12, "Uspesno ste se logovali");
			}

			Account.clickSignOut(driver);
			Thread.sleep(3000);
		}
	}
}
