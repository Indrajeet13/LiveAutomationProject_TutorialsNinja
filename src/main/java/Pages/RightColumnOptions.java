package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;

public class RightColumnOptions extends RootPage{

	public RightColumnOptions(WebDriver driver){
		super(driver);
		this.driver = driver;
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
		return isElementDisplayed(logoutOption);
	}
	
	public AccountLogoutPage clickLogoutOptionOnRightPanel() {
		logoutOption.click();	
		return new AccountLogoutPage(driver);
	}
	
	public LoginPage clickLoginTextOnRightPanel() {
		loginTextOnRightPanel.click();	
		return new LoginPage(driver);
	}
	
	public ForgotPasswordPage clickForgottenPasswordTextOnRightPanel() {
		forgottenPasswordOnRightPanel.click();	
		return new ForgotPasswordPage(driver);
	}
	
	public LoginPage clickOnMyAccountTextOnRightPanel() {
		myAccountTextOnRightPanel.click();	
		return new LoginPage(driver);
	}
	
	public LoginPage clickOnAddressBookTextOnRightPanel() {
		addressBookTextOnRightPanel.click();	
		return new LoginPage(driver);
	}
	
	public LoginPage clickOnWishListTextOnRightPanel() {
		wishListTextOnRightPanel.click();	
		return new LoginPage(driver);
	}
	
	public LoginPage clickOnDownlodsTextOnRightPanel() {
		downloadsTextOnRightPanel.click();	
		return new LoginPage(driver);
	}
	
	public LoginPage clickOnRecurringPaymentsTextOnRightPanel() {
		recurringPaymentsTextOnRightPanel.click();	
		return new LoginPage(driver);
	}
	
	public LoginPage clickOnRewardPointsTextOnRightPanel() {
		rewardPointsTextOnRightPanel.click();	
		return new LoginPage(driver);
	}
	
	public LoginPage clickOnReturnsTextOnRightPanel() {
		returnsTextOnRightPanel.click();	
		return new LoginPage(driver);
	}
	
	public LoginPage clickOnTransactionsTextOnRightPanel() {
		transactionsTextOnRightPanel.click();	
		return new LoginPage(driver);
	}
	
	public LoginPage clickOnNewsLetterTextOnRightPanel() {
		newsletterTextOnRightPanel.click();	
		return new LoginPage(driver);
	}
	
	
}
