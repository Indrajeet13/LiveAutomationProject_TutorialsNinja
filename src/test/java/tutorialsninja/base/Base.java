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
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.*;
import utils.*;

public class Base {

	public WebDriver driver;
	public Properties prop;
	public MyXLSReader myXLSReader;
	public RegisterPage registerPage;
	public AccountSuccessPage accountSuccessPage;
	public AccountPage accountPage;
	public NewsletterPage newsletterPage;
	public LoginPage loginPage;
	public EditAccountInformationPage editAccountInformationPage;
	public ContactUsPage contactUsPage;
	public ShoppingCartPage shoppingCart;
	public SearchPage searchPage;
	public WebDriverWait wait;
	public ForgotPasswordPage forgotPassword;
	public AboutUsPage aboutUsPage;
	public BrandsPage brandsPage;
	public DeliveryInformationPage deliveryInformationPage;
	public PrivacyPolicyPage privacyPolicyPage;
	public TermsAndConditionPage termsAndConditionPage;
	public ProductReturnsPage productReturnsPage;
	public SiteMapPage siteMapPage;
	public GiftCertificatesPage giftCertificatesPage;
	public AffiliateProgramPage affiliateProgramPage;
	public SpecialOffersPage specialOffersPage;
	public HeaderOptions headerOptions;
	public RightColumnOptions rightColumnOptions;
	public FooterOptions footerOptions;
	public LandingPage landingPage;
	public AccountLogoutPage logoutAccountPage;
	public ChangePasswordPage changePasswordPage ;

	
	
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
	
	public void closeBrowser(WebDriver driver) {
		if(driver!=null) {
			driver.quit();
		}
		
		
	}

	public WebDriver refreshPage(WebDriver driver) {
		driver.navigate().refresh();
		return driver;
	}
	
}
