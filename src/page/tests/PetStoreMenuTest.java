package page.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import page.objects.AnimalsURL;
import page.objects.HomePage;
import page.objects.PetStoreMenu;
import page.objects.SignIn;

public class PetStoreMenuTest {

	@Test
	public void testUrl() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get(PetStoreMenu.HOME_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		Assert.assertEquals(driver.getCurrentUrl(), PetStoreMenu.HOME_URL, "Page is not successfully opened");

		driver.quit();
	}

	@Test
	public void clickAndNavigation() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		

		SoftAssert sa = new SoftAssert();

		driver.get(PetStoreMenu.HOME_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		PetStoreMenu.clickLogo(driver);
		Thread.sleep(3000);

		
		// LEFT MENU
		PetStoreMenu.clickFishLeft(driver);
		Thread.sleep(3000);
		sa.assertTrue(driver.getCurrentUrl().contains(AnimalsURL.FISH_URL),
				"Fish from the left menu doesn't navigate to the right page.");
		
		driver.get(PetStoreMenu.HOME_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		
		PetStoreMenu.clickDogsLeft(driver);
		sa.assertEquals(driver.getCurrentUrl(), AnimalsURL.DOGS_URL,
				"Dogs from the left menu doesn't navigate to the right page.");
		driver.get(PetStoreMenu.HOME_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		PetStoreMenu.clickCatsLeft(driver);
		sa.assertEquals(driver.getCurrentUrl(), AnimalsURL.CATS_URL,
				"Cats from the left menu doesn't navigate to the right page.");
		driver.get(PetStoreMenu.HOME_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		PetStoreMenu.clickReptilesLeft(driver);
		sa.assertEquals(driver.getCurrentUrl(), AnimalsURL.REPTILES_URL,
				"Reptiles from the left menu doesn't navigate to the right page.");
		driver.get(PetStoreMenu.HOME_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		PetStoreMenu.clickBirdsLeft(driver);
		sa.assertEquals(driver.getCurrentUrl(), AnimalsURL.BIRDS_URL,
				"Birds from the left menu doesn't navigate to the right page.");
		driver.get(PetStoreMenu.HOME_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


		
		// TOP MENU
		PetStoreMenu.clickFishTop(driver);
		sa.assertEquals(driver.getCurrentUrl(), AnimalsURL.FISH_URL,
				"Fish from the top menu doesn't navigate to the right page.");
		driver.get(PetStoreMenu.HOME_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		PetStoreMenu.clickDogsTop(driver);
		sa.assertEquals(driver.getCurrentUrl(), AnimalsURL.DOGS_URL,
				"Dogs from the top menu doesn't navigate to the right page.");
		driver.get(PetStoreMenu.HOME_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		PetStoreMenu.clickCatsTop(driver);
		sa.assertEquals(driver.getCurrentUrl(), AnimalsURL.CATS_URL,
				"Cats from the top menu doesn't navigate to the right page.");
		driver.get(PetStoreMenu.HOME_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		PetStoreMenu.clickReptilesTop(driver);
		sa.assertEquals(driver.getCurrentUrl(), AnimalsURL.REPTILES_URL,
				"Reptiles from the top menu doesn't navigate to the right page.");
		driver.get(PetStoreMenu.HOME_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		PetStoreMenu.clickBirdsTop(driver);
		sa.assertEquals(driver.getCurrentUrl(), AnimalsURL.BIRDS_URL,
				"Birds from the top menu doesn't navigate to the right page.");
		driver.get(PetStoreMenu.HOME_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		
		
		// CENTER MENU
		PetStoreMenu.clickBirdsCenterBig(driver);
		sa.assertEquals(driver.getCurrentUrl(), AnimalsURL.BIRDS_URL,
				"Big icon of bird from the center menu doesn't navigate to the right page.");
		driver.get(PetStoreMenu.HOME_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		PetStoreMenu.clickFishCenter(driver);
		sa.assertEquals(driver.getCurrentUrl(), AnimalsURL.FISH_URL,
				"Fish from the center menu doesn't navigate to the right page.");
		driver.get(PetStoreMenu.HOME_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		PetStoreMenu.clickDogsCenter(driver);
		sa.assertEquals(driver.getCurrentUrl(), AnimalsURL.DOGS_URL,
				"Dogs from the center menu doesn't navigate to the right page.");
		driver.get(PetStoreMenu.HOME_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		PetStoreMenu.clickCatsCenter(driver);
		sa.assertEquals(driver.getCurrentUrl(), AnimalsURL.CATS_URL,
				"Cats from the center menu doesn't navigate to the right page.");
		driver.get(PetStoreMenu.HOME_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		PetStoreMenu.clickReptilesCenter(driver);
		sa.assertEquals(driver.getCurrentUrl(), AnimalsURL.REPTILES_URL,
				"Reptiles from the center menu doesn't navigate to the right page.");
		driver.get(PetStoreMenu.HOME_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		PetStoreMenu.clickBirdsCenter(driver);
		sa.assertEquals(driver.getCurrentUrl(), AnimalsURL.BIRDS_URL,
				"Birds from the center menu doesn't navigate to the right page.");

		
		
		//SING IN BTN
		driver.get(PetStoreMenu.HOME_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		PetStoreMenu.clickSignIn(driver);
		sa.assertEquals(driver.getCurrentUrl(), SignIn.SIGN_IN_URL, "Sign in link doesn't navigate to the right page.");

		
		sa.assertAll();
		
		driver.quit();
	}

	@Test
	public void testNavigateBack() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get(HomePage.HOME_PAGE_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		HomePage.clickEnterButton(driver);
		driver.navigate().back();

		Assert.assertEquals(driver.getCurrentUrl(), HomePage.HOME_PAGE_URL, "Page is not successfully opened");

		driver.quit();
	}
}
