package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
import utils.ElementsUtilities;

public class RightColumnOptions extends RootPage{

	ElementsUtilities elementsUtilities;
	
	public RightColumnOptions(WebDriver driver){
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='list-group-item'][text()='Login']")
	private WebElement loginTextOnRightPanel;
	
	@FindBy(linkText = "Forgotten Password")
	private WebElement forgottenPasswordOnRightPanel;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='My Account']")
	private WebElement myAccountTextOnRightPanel;
	
	@FindBy(xpath = "//a[normalize-space()='Address Book']")
	private WebElement addressBookTextOnRightPanel;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Wish List']")
	private WebElement wishListTextOnRightPanel;
	
	@FindBy(xpath = "//a[normalize-space()='Downloads']")
	private WebElement downloadsTextOnRightPanel;
	
	@FindBy(xpath = "//a[normalize-space()='Recurring payments']")
	private WebElement recurringPaymentsTextOnRightPanel;
	
	@FindBy(xpath = "//a[normalize-space()='Reward Points']")
	private WebElement rewardPointsTextOnRightPanel;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Returns']")
	private WebElement returnsTextOnRightPanel;
	
	@FindBy(xpath = "//a[normalize-space()='Transactions']")
	private WebElement transactionsTextOnRightPanel;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Newsletter']")
	private WebElement newsletterTextOnRightPanel;
	
	@FindBy(xpath = "//a[@class='list-group-item'][text()='Logout']")
	private WebElement logoutOption;
	
	
	
	public boolean isLogoutRightColumnOptionAvailable() {
		return elementsUtilities.isElementDisplayed(logoutOption);
	}
	
	public AccountLogoutPage clickLogoutOptionOnRightPanel() {
		elementsUtilities.clickOnElement(logoutOption);	
		return new AccountLogoutPage(driver);
	}
	
	public LoginPage clickLoginTextOnRightPanel() {
		elementsUtilities.clickOnElement(loginTextOnRightPanel);	
		return new LoginPage(driver);
	}
	
	public ForgotPasswordPage clickForgottenPasswordTextOnRightPanel() {
		elementsUtilities.clickOnElement(loginTextOnRightPanel);	
		return new ForgotPasswordPage(driver);
	}
	
	public LoginPage clickOnMyAccountTextOnRightPanel() {
		elementsUtilities.clickOnElement(myAccountTextOnRightPanel);	
		return new LoginPage(driver);
	}
	
	public LoginPage clickOnAddressBookTextOnRightPanel() {
		elementsUtilities.clickOnElement(addressBookTextOnRightPanel);		
		return new LoginPage(driver);
	}
	
	public LoginPage clickOnWishListTextOnRightPanel() {
		elementsUtilities.clickOnElement(wishListTextOnRightPanel);	
		return new LoginPage(driver);
	}
	
	public LoginPage clickOnDownlodsTextOnRightPanel() {
		elementsUtilities.clickOnElement(downloadsTextOnRightPanel);	
		return new LoginPage(driver);
	}
	
	public LoginPage clickOnRecurringPaymentsTextOnRightPanel() {
		elementsUtilities.clickOnElement(recurringPaymentsTextOnRightPanel);	
		return new LoginPage(driver);
	}
	
	public LoginPage clickOnRewardPointsTextOnRightPanel() {
		elementsUtilities.clickOnElement(rewardPointsTextOnRightPanel);		
		return new LoginPage(driver);
	}
	
	public LoginPage clickOnReturnsTextOnRightPanel() {
		elementsUtilities.clickOnElement(returnsTextOnRightPanel);		
		return new LoginPage(driver);
	}
	
	public LoginPage clickOnTransactionsTextOnRightPanel() {
		elementsUtilities.clickOnElement(transactionsTextOnRightPanel);	
		return new LoginPage(driver);
	}
	
	public LoginPage clickOnNewsLetterTextOnRightPanel() {
		elementsUtilities.clickOnElement(newsletterTextOnRightPanel);	
		return new LoginPage(driver);
	}
	
	
}
