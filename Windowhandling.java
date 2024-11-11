package solution;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Windowhandling {
	  WebDriver driver;
	    String url="https://www.magicbricks.com";
	    public Windowhandling() {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\manju\\chromedriver-win64\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Users\\manju\\chrome-win64\\chrome.exe");
			driver=new ChromeDriver(options);
			driver.manage().window().maximize();
			}
	@Test
	    public void action() {
	        driver.get(url);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	        driver.findElement(By.xpath("//a[@id='rentheading']")).click();
			driver.findElement(By.xpath("//a[normalize-space()='Furnished Homes']")).click();
			String parentWindowHandle = driver.getWindowHandle();
	        // Get all window handles
	        Set<String> windowHandles = driver.getWindowHandles();
            // Switch to the new window
	        for (String windowHandle : windowHandles) {
	            if (!windowHandle.equals(parentWindowHandle)) {
	                driver.switchTo().window(windowHandle);
	                break;
	            }
	        }

	        // Get and print the header text
	        WebElement headerElement = driver.findElement(By.tagName("h1")); 
	        String headerText = headerElement.getText();
	        System.out.println("Header Text: " + headerText);

	        // Close the new window
	        driver.close();

	        // Switch back to the original window
	        driver.switchTo().window(parentWindowHandle);
			 }
	    
}