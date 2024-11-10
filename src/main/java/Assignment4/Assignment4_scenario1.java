package Assignment4;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class Assignment4_scenario1 {

	@Test(groups = { "Smoke" })
	public void Login() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\manju\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Users\\manju\\chrome-win64\\chrome.exe");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.navigate().to("https://www.saucedemo.com");
		//Locate the username text field and enter standard_user
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#user-name")));
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		//Locate the password Text Field and enter secret_sauce
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#password")));
		driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
		//Click on Login Button
		driver.findElement(By.cssSelector("#login-button")).click();
        //verify Swag Labs display on top
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Swag Labs";
		SoftAssert softAssert = new SoftAssert();
		AssertJUnit.assertEquals(ExpectedTitle, ActualTitle);
		softAssert.assertAll();
		//verify that sorting dropdown is visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product_sort_container")));
		driver.quit();
	}




	}

