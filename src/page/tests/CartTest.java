package page.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import page.objects.Cart;
import page.objects.PetStoreMenu;
import page.objects.SignIn;
import utility.ExcelUtils;

public class CartTest {
	@Test
	public void testAddToChart() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// EXCEL
		String dataSRC = "UserRandomData.xlsx";
		ExcelUtils.setExcell(dataSRC);
		ExcelUtils.setWorkSheet("data");

		// OPEN SIGN IN PAGE
		driver.get(SignIn.SIGN_IN_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		// CLICK ON THE SIGN IN BTN
		PetStoreMenu.clickSignIn(driver);

		
		Thread.sleep(2000);
		String registeredUser = ExcelUtils.getDataAtNum(51, 0);
		String registeredPassword = ExcelUtils.getDataAt(51, 1);

		// LOG IN input and click button for log in
		SignIn.inputUserName(driver, registeredUser);
		SignIn.inputPassword(driver, registeredPassword);
		SignIn.clickLogInBtn(driver);
		Thread.sleep(2000);

		// OPEN CART
		Cart.clickCart(driver);

		// GO TO THE MENU
		Cart.clickReturnToMenu(driver);
		Thread.sleep(2000);

		// CHOOSE THE PRODUCT
		PetStoreMenu.clickFishLeft(driver);
		PetStoreMenu.clickAngelFishLeft(driver);
		PetStoreMenu.clickLargeAngelFishAdd(driver);
		
		// TEST IF THE SAME PRODUCT IS IN THE CART
		WebElement smallFishProdID = driver.findElement(By.xpath("//td[contains(text(),'FI-SW-01')]"));
		Assert.assertTrue(smallFishProdID.isDisplayed());

	}
}
