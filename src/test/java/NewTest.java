import org.openqa.selenium.By;
//import necessary Selenium WebDriver classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {
	// declare Selenium WebDriver
	private WebDriver webDriver;

//  @Test
//  public void checkId() {
//	  //Load website as a new page
//	  webDriver.navigate().to("http://localhost:8080/Inventory_manager/login.jsp");
//	  WebElement we =  webDriver.findElement(By.id("content"));
//	  
//	  System.out.println("id we: "+we.getAttribute("role"));
//	  Assert.assertEquals(we.getAttribute("role"), "contentinfo");
//  }
//  

	@Test
	public void checkLogin() {
		// Load Login as a new page
		webDriver.navigate().to("http://localhost:8080/Inventory_manager/login.jsp");

		// Find the email input element and enter the email address
		WebElement emailInput = webDriver.findElement(By.name("username"));
		emailInput.sendKeys("inventory");

		WebElement passwordInput = webDriver.findElement(By.name("password"));
		passwordInput.sendKeys("password");

		// Create a new WebDriverWait object and set the timeout to 10 seconds
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		WebElement loginButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='loginButton']")));
		loginButton.click();

		if (webDriver.findElement(By.xpath("//h1[1]")).isDisplayed()) {
			System.out.println("Login Status: Logged in successfully");
		} else {
			System.out.println("Login Status: Login failed");
		}
		Assert.assertTrue(webDriver.getTitle().contains("Reports"));
	}
	
	@Test
	public void checkReportsLoaded() {
		WebElement tableRow = webDriver.findElement(By.xpath("//th[1]"));
		
		boolean isDisplayed = tableRow.isDisplayed();
		
		if (tableRow.isDisplayed()) {
			System.out.println("Reports Status: Reports is loaded");
		} else {
			System.out.println("Reports Status: Reports is not loaded");
		}
		Assert.assertTrue(isDisplayed);
	}

	@BeforeTest
	public void beforeTest() {
		// Setting system properties of ChromeDriver
		// to amend directory path base on your local file path
		String chromeDriverDir = "C:\\Program Files\\Google\\Chrome\\chromedriver.exe";
		

		System.setProperty("webdriver.chrome.driver", chromeDriverDir);

		// initialize FirefoxDriver at the start of test
		webDriver = new ChromeDriver();
	}

	@AfterTest
	public void afterTest() {
		// Quit the ChromeDriver and close all associated window at the end of test
		webDriver.quit();
	}

}
