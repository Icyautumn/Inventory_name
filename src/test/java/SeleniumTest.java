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
	private static final String URL = "http://localhost:8080/Inventory_manager/";
	private static final String CHROME_DRIVER_DIR = "C:\\Program Files\\Google\\Chrome\\chromedriver.exe";
	private static final int WAIT_TIME = 10;

	private static final By CATEGORY_INPUT = By.name("category");
	private static final By NAME_INPUT = By.name("name");
	private static final By OPEN_STOCK_INPUT = By.name("openStock");
	private static final By CLOSE_STOCK_INPUT = By.name("closeStock");
	private static final By COST_PRICE_INPUT = By.name("costPrice");
	private static final By RETAIL_PRICE_INPUT = By.name("retailPrice");
	private static final By PROFIT_INPUT = By.name("profit");
	private static final By ADD_REPORT_BUTTON = By.cssSelector("button[name='submit']");
	private static final By ADD_REPORT_PAGE_BUTTON = By.cssSelector("button[name='addReport']");
	private static final By TABLE_ROW = By.xpath("//th[text()='26/01/23']");
	
	@BeforeTest
	public void beforeTest() {
		// Setting system properties of ChromeDriver
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_DIR);
		webDriver = new ChromeDriver();
	}

	@AfterTest
	public void afterTest() {
		// Quit the ChromeDriver and close all associated window at the end of test
		webDriver.quit();
	}

	@Test
	public void checkInvalidCredentials() {
		// Load Login as a new page
		webDriver.navigate().to(URL + "login.jsp");
		WebElement emailInput = webDriver.findElement(By.name("username"));
		emailInput.sendKeys("inventory");
		WebElement passwordInput = webDriver.findElement(By.name("password"));
		passwordInput.sendKeys("wrong");
		WebElement loginButton = webDriver.findElement(By.xpath("//button[@name='loginButton']"));
		loginButton.click();

		try {
			String alertText = webDriver.switchTo().alert().getText();
			Assert.assertEquals("Username or Password is Incorrect", alertText);
		} catch (Exception e) {
			Assert.fail("Alert not present");
		} finally {
			webDriver.quit();
		}
	}

	@Test
	public void checkLogin() {
		beforeTest();
		webDriver.navigate().to(URL);
		WebElement emailInput = webDriver.findElement(By.name("username"));
		emailInput.sendKeys("inventory");
		WebElement passwordInput = webDriver.findElement(By.name("password"));
		passwordInput.sendKeys("password");
		WebDriverWait wait = new WebDriverWait(webDriver, WAIT_TIME);
		WebElement loginButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='loginButton']")));
		loginButton.click();
		Assert.assertTrue(webDriver.getTitle().contains("Reports"));
	}

	@Test
	public void checkReportsLoaded() {
		WebElement tableRow = webDriver.findElement(By.xpath("//th[1]"));
		Assert.assertTrue(tableRow.isDisplayed());
	}

	@Test
	public void verifyAddReportFunctionality() {
		webDriver.findElement(ADD_REPORT_PAGE_BUTTON).click();

		WebElement categoryInput = webDriver.findElement(CATEGORY_INPUT);
		categoryInput.sendKeys("FOOD");

		WebElement nameInput = webDriver.findElement(NAME_INPUT);
		nameInput.sendKeys("Mala");

		WebElement openStockInput = webDriver.findElement(OPEN_STOCK_INPUT);
		openStockInput.sendKeys("10");

		WebElement closeStockInput = webDriver.findElement(CLOSE_STOCK_INPUT);
		closeStockInput.sendKeys("5");

		WebElement costPriceInput = webDriver.findElement(COST_PRICE_INPUT);
		costPriceInput.sendKeys("3");

		WebElement retailPriceInput = webDriver.findElement(RETAIL_PRICE_INPUT);
		retailPriceInput.sendKeys("11");

		WebElement profitInput = webDriver.findElement(PROFIT_INPUT);
		profitInput.sendKeys("8");

		WebElement addReport = webDriver.findElement(ADD_REPORT_BUTTON);
		addReport.click();

		Assert.assertTrue(webDriver.findElement(TABLE_ROW).isDisplayed());
	}

}
