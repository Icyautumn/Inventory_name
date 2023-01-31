import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.Alert;
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

public class SeleniumTest {
	// declare Selenium WebDriver
	private WebDriver webDriver;

	@Test
	public void checkInvalidCredentials() {
		// Load Login as a new page
		webDriver.navigate().to("http://localhost:8080/Inventory_manager/login.jsp");

		// Find the email input element and enter the email address
		WebElement emailInput = webDriver.findElement(By.name("username"));
		emailInput.sendKeys("inventory");

		WebElement passwordInput = webDriver.findElement(By.name("password"));
		passwordInput.sendKeys("wrong");

		WebElement loginButton = webDriver.findElement(By.xpath("//button[@name='loginButton']"));
		loginButton.click();

		System.out.println(webDriver.switchTo().alert().getText());
		if (webDriver.switchTo().alert().getText() != null) {
			AssertJUnit.assertEquals(webDriver.switchTo().alert().getText(), "Username or Password is Incorrect");
		} else if (webDriver.switchTo().alert().getText() == "no such alert") {
			AssertJUnit.assertEquals(webDriver.switchTo().alert().getText(), "no such alert");
		}
		webDriver.quit();
	}

	@Test
	public void checkLogin() {
		String chromeDriverDir = "C:\\Program Files\\Google\\Chrome\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", chromeDriverDir);

		// initialize FirefoxDriver at the start of test
		webDriver = new ChromeDriver();

		// Load Login as a new page
		webDriver.navigate().to("http://localhost:8080/Inventory_manager/");

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
		AssertJUnit.assertTrue(webDriver.getTitle().contains("Reports"));
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
		AssertJUnit.assertTrue(isDisplayed);
	}

	@Test
	public void verifyAddReportFunctionality() {
		WebElement addReportPageButton = webDriver.findElement(By.xpath("//button[@name='addReport']"));
		addReportPageButton.click();

		WebElement categoryInput = webDriver.findElement(By.name("category"));
		categoryInput.sendKeys("FOOD");

		WebElement nameInput = webDriver.findElement(By.name("name"));
		nameInput.sendKeys("Mala");

		WebElement openStockInput = webDriver.findElement(By.name("openStock"));
		openStockInput.sendKeys("10");

		WebElement closeStockInput = webDriver.findElement(By.name("closeStock"));
		closeStockInput.sendKeys("5");

		WebElement costPriceInput = webDriver.findElement(By.name("costPrice"));
		costPriceInput.sendKeys("3");

		WebElement retailPriceInput = webDriver.findElement(By.name("retailPrice"));
		retailPriceInput.sendKeys("11");

		WebElement profitInput = webDriver.findElement(By.name("profit"));
		profitInput.sendKeys("8");

		WebElement addReport = webDriver.findElement(By.xpath("//button[@name='submit']"));
		addReport.click();

		WebElement tableRow = webDriver.findElement(By.xpath("//th[text()='26/01/23']")); // NOTE: this isn't dynamic,
																							// the ReportModel adds in a
																							// new list of its own cause
																							// idk how to make it
																							// dynamic without
																							// rebuilding the whole
																							// model.

		if (tableRow.isDisplayed()) {
			System.out.println("Add Report Status: Reports is Added");
		} else {
			System.out.println("Add Report Status: Reports is not Added");
		}
//		Assert.assertTrue(isDisplayed);
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