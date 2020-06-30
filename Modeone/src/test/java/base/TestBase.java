package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class TestBase {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties obj = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");

	
	@BeforeSuite
	public void setUp() {

		if (driver == null) {
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Conf.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("config file loaded!!");
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Obj.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				obj.load(fis);
				log.debug("object file loaded!!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (config.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "gecko.exe");
			driver = new FirefoxDriver();
		} else if (config.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
			log.debug("chrome launched!!");
		}

		driver.get(config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicity.wait")),
				TimeUnit.SECONDS);
		log.debug("Navigated to : " + config.getProperty("testsiteurl"));

	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	
	  @AfterSuite public void tearDown() { if (driver != null) { driver.quit(); }
	  log.debug("test execution ended"); }
	 

	public void Click(String i) {
		WebElement a = driver.findElement(By.cssSelector(obj.getProperty(i)));
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", a);	
	}
	
	public void Click2(String i) {
		WebElement a = driver.findElement(By.xpath(obj.getProperty(i)));
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", a);	
	}
	
	public void Focus(String i) {
		WebElement a = driver.findElement(By.cssSelector(obj.getProperty(i)));
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='2px solid red'", a);	
	}
	
	public void Write(String i, String o) {
		driver.findElement(By.cssSelector(obj.getProperty(i))).sendKeys(o);
	}
}
