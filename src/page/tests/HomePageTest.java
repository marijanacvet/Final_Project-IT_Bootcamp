package page.tests;

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

public class HomePageTest {

	@Test
	public void homePageUrlAndTitle() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get(HomePage.HOME_PAGE_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		String expectedTitle = "JPetStore Demo";
		SoftAssert sa = new SoftAssert();

		sa.assertEquals(driver.getTitle(), expectedTitle, "Title does not match.");
		sa.assertEquals(driver.getCurrentUrl(), HomePage.HOME_PAGE_URL, "Home Page is not successfully opened");

		sa.assertAll();

	}

	@Test
	public void enterButton() {
		//Checking wheather enter btn exists at the Home Page
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get(HomePage.HOME_PAGE_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement enterBtn = driver.findElement(By.linkText("Enter the Store"));

		SoftAssert sa = new SoftAssert();
		// Assert.assertTrue(enterBtn.isEnabled());
		sa.assertTrue(enterBtn.isEnabled(), "Text is not visible");

		// Checking wheather the enter button is clickable and if navigates us to the expected page
		HomePage.clickEnterButton(driver);
		sa.assertEquals(driver.getCurrentUrl(), PetStoreMenu.HOME_URL, "Not the right page");

		sa.assertAll();

	}

}
