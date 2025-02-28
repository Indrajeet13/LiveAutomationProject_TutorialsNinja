package tutorialsninja.base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

import utils.Utilities;

public class Base {

	WebDriver driver;
	Properties prop;
	
	public WebDriver openBrowserAndApplication() 
	{
		prop = Utilities.loadProperties();
		
		String browserName = prop.getProperty("browserName");

		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equals("ie")) {
			driver = new InternetExplorerDriver();
		} else if (browserName.equals("safari")) {
			driver = new SafariDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("appURL"));

		return driver;
	}
	
	public WebDriver navigateToPage_GivenURL(WebDriver driver, String URL) {
		driver.navigate().to(URL);
		return driver;
	}
	
	public WebDriver navigateBack(WebDriver driver) {
		driver.navigate().back();
		return driver;
	}
	
	public WebDriver pressKeyMultipleTimes(WebDriver driver, Keys keyName, int count) {
		
		Actions actions = new Actions(driver);
		for(int i=1 ; i <= count ; i++) {
			actions.sendKeys(keyName).perform();;
		}
		return driver;
	}
	
	public WebDriver enterDetailsIntoLoginFieldUsingKeyboard() {
		 
		Actions actions = new Actions(driver);
		prop = Utilities.loadProperties();
		actions.sendKeys(Utilities.validEmailRandomizeGenerator()).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys(prop.getProperty("validPassword")).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys(Keys.ENTER).perform();
		return driver;
	}
		
	public String getHTMLCodeOfPage() {
		return driver.getPageSource();
	}
	
	public String getPageURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
}
