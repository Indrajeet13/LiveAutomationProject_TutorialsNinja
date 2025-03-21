package Pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import Pages.root.RootPage;

public class HeaderOptions extends RootPage{

	public HeaderOptions(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='fa fa-phone']")
	private WebElement phoneIcon;

	@FindBy(xpath = "//i[@class='fa fa-heart']")
	private WebElement heartIconOption;

	@FindBy(xpath = "//a[@title='Shopping Cart']//i[@class='fa fa-shopping-cart']")
	private WebElement shoppingCartOption;

	@FindBy(xpath = "//i[@class='fa fa-share']")
	private WebElement checkoutOption;

	@FindBy(linkText = "Qafox.com")
	private WebElement QAFoxHeading;

	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;

	@FindBy(xpath = "//a[normalize-space()='Account']")
	private WebElement accountBreadcrumb;

	@FindBy(xpath = "//ul[@class='breadcrumb']//i[@class='fa fa-home']")
	private WebElement homeBreadcrumb;

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement myAccountDropMenu;

	@FindBy(linkText = "Login")
	private WebElement loginOption;

	@FindBy(linkText = "Logout")
	private WebElement logoutOption;

	@FindBy(name = "search")
	private WebElement searchBoxField;
	

	
	
	public  String getPlaceholderTextOfSearchBoxField() {
		return getDomAttributeOfElement(searchBoxField,"Placeholder");
	}
	
	public  void enterProductIntoSearchBoxField(String productName) {
		searchBoxField.sendKeys(productName);
	}
	
	public boolean isLogoutOptionAvailable() {
		return isElementDisplayed(logoutOption);
	}
	
	public boolean isLoginOptionAvailable() {
		return isElementDisplayed(loginOption);
	}
	
	public AccountLogoutPage clickLogoutOption() {
		logoutOption.click();
		return new AccountLogoutPage(driver);
	}

	public LoginPage clickLoginMenu() {
		loginOption.click();
		return new LoginPage(driver);
	}

	public void clickOnMyAccountDropMenu() {
		myAccountDropMenu.click();
	}

	public ContactUsPage selectPhoneIcon() {
		phoneIcon.click();
		return new ContactUsPage(driver);
	}

	public LoginPage selectHeartIcon() {
		heartIconOption.click();
		return new LoginPage(driver);
	}

	public ShoppingCartPage selectShoppingCartOption() {
		shoppingCartOption.click();
		return new ShoppingCartPage(driver);
	}

	public ShoppingCartPage selectCheckoutOption() {
		checkoutOption.click();
		return new ShoppingCartPage(driver);
	}

	public LandingPage selectQAFoxHeading() {
		QAFoxHeading.click();
		return new LandingPage(driver);
	}

	public SearchPage clickOnSearchButton() {
		searchButton.click();
		return new SearchPage(driver);
	}

	public LoginPage clickAccountBreadcrumb() {
		accountBreadcrumb.click();
		return new LoginPage(driver);
	}

	public LandingPage clickOnHomeBreadcrumb() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(homeBreadcrumb));
		element.click();
		return new LandingPage(driver);
	}

	public boolean getAccountBreadcrumb() {
		return isElementDisplayed(accountBreadcrumb);
	}
}
