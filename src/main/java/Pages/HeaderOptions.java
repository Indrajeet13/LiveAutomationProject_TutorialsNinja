package Pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import Pages.root.RootPage;
<<<<<<< HEAD
import utils.ElementsUtilities;

public class HeaderOptions extends RootPage{

	ElementsUtilities elementsUtilities;
	
=======

public class HeaderOptions extends RootPage{

>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	public HeaderOptions(WebDriver driver) {
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
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
	

<<<<<<< HEAD
	
	
	public  String getPlaceholderTextOfSearchBoxField() {
		return getDomAttributeOfElement(searchBoxField,"Placeholder");
	}
=======
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	
	public  void enterProductIntoSearchBoxField(String productName) {
		elementsUtilities.enterTextIntoElement(searchBoxField, productName);
	}
	
	public boolean isLogoutOptionAvailable() {
		return elementsUtilities.isElementDisplayed(logoutOption);
	}
	
<<<<<<< HEAD
	public boolean isLoginOptionAvailable() {
		return elementsUtilities.isElementDisplayed(loginOption);
	}
	
	public AccountLogoutPage clickLogoutOption() {
		elementsUtilities.clickOnElement(logoutOption);
=======
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
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
		return new AccountLogoutPage(driver);
	}

	public LoginPage clickLoginMenu() {
		elementsUtilities.clickOnElement(loginOption);
		return new LoginPage(driver);
	}

	public void clickOnMyAccountDropMenu() {
		elementsUtilities.clickOnElement(myAccountDropMenu);
	}

	public ContactUsPage selectPhoneIcon() {
		elementsUtilities.clickOnElement(phoneIcon);
		return new ContactUsPage(driver);
	}

	public LoginPage selectHeartIcon() {
		elementsUtilities.clickOnElement(heartIconOption);
		return new LoginPage(driver);
	}

	public ShoppingCartPage selectShoppingCartOption() {
		elementsUtilities.clickOnElement(shoppingCartOption);
		return new ShoppingCartPage(driver);
	}

	public ShoppingCartPage selectCheckoutOption() {
		elementsUtilities.clickOnElement(checkoutOption);
		return new ShoppingCartPage(driver);
	}

	public LandingPage selectQAFoxHeading() {
		elementsUtilities.clickOnElement(QAFoxHeading);
		return new LandingPage(driver);
	}

	public SearchPage clickOnSearchButton() {
		elementsUtilities.clickOnElement(searchButton);
		return new SearchPage(driver);
	}

	public LoginPage clickAccountBreadcrumb() {
		elementsUtilities.clickOnElement(accountBreadcrumb);
		return new LoginPage(driver);
	}

	public LandingPage clickOnHomeBreadcrumb() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(homeBreadcrumb));
<<<<<<< HEAD
		elementsUtilities.clickOnElement(element);
=======
		element.click();
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
		return new LandingPage(driver);
	}

	public boolean getAccountBreadcrumb() {
<<<<<<< HEAD
		return elementsUtilities.isElementDisplayed(accountBreadcrumb);
=======
		return isElementDisplayed(accountBreadcrumb);
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	}
}
