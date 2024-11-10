package Assignment4;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Assignment4_scenario3 {
@Test(groups = { "Regression"})
    public void Test3() throws InterruptedException {
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
		Thread.sleep(5000);
		//Select "Name(ZtoA)"from sorting Dropdown box
		Select Sortname = new Select(driver.findElement(By.cssSelector(".product_sort_container")));
		Sortname.selectByVisibleText("Name (Z to A)");
        // click "Add to cart" for 6 product
		driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']")).click();
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
		// Click on the cart button
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		//verify all added product is displayed
		WebElement Tshirt=driver.findElement((By.xpath("//div[normalize-space()='Test.allTheThings() T-Shirt (Red)']")));
		boolean flag=Tshirt.isDisplayed();
        System.out.println("Test.allTheThings() T-Shirt (Red) is displayed: " +flag);
        WebElement Jacket=driver.findElement((By.xpath("//div[normalize-space()='Sauce Labs Fleece Jacket']")));
		boolean flag1=Jacket.isDisplayed();
        System.out.println("Sauce Labs Fleece Jacket is displayed: " +flag1);
        WebElement BikeLight=driver.findElement((By.xpath("//div[normalize-space()='Sauce Labs Bike Light']")));
		boolean flag2=BikeLight.isDisplayed();
        System.out.println("Sauce Labs Fleece Jacket is displayed" +flag2);
        WebElement Onesie=driver.findElement((By.xpath("//div[normalize-space()='Sauce Labs Onesie']")));
		boolean flag3=Onesie.isDisplayed();
        System.out.println("Sauce Labs Onesie is displayed" +flag3);
        WebElement BoltTshirt=driver.findElement((By.xpath("//div[normalize-space()='Sauce Labs Bolt T-Shirt']")));//div[normalize-space()='Sauce Labs Bolt T-Shirt']
		boolean flag4=BoltTshirt.isDisplayed();
        System.out.println("Sauce Labs Onesie is displayed" +flag4);
        WebElement Backpack=driver.findElement((By.xpath("//div[normalize-space()='Sauce Labs Backpack']")));
		boolean flag5=Backpack.isDisplayed();
        System.out.println("Sauce labs Backpack is displayed" +flag5);
		
		}
    	
    }

