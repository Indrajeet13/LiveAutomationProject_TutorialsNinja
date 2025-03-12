package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;

public class AccountLogoutPage extends RootPage {

	public AccountLogoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[normalize-space()='Account Logout']")
	private WebElement accountLogoutText;

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement myAccountDropMenu;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	private WebElement loginOptionDropMenu;

	@FindBy(linkText = "Continue")
	private WebElement continueButton;

	@FindBy(xpath = "//h1[normalize-space()='Account Logout']")
	private WebElement pageHeading;

	public String getPageHeading() {
		String pageHeadingText = null;
		try {
			pageHeadingText = pageHeading.getText();
		} catch (NoSuchElementException e) {
			pageHeadingText = null;
		}
		return pageHeadingText;
	}

	public LandingPage clickOnContinue() {
		continueButton.click();
		return new LandingPage(driver);
	}

	public LoginPage clickOnLoginOptionDropMenu() {
		loginOptionDropMenu.click();
		return new LoginPage(driver);
	}

	public void clickOnMyAccountDropMenu() {
		myAccountDropMenu.click();
	}

	public boolean didWeNavigateToAccountLogoutPage() {
		boolean b = false;
		try {
			b = accountLogoutText.isDisplayed();
		} catch (NoSuchElementException e) {
			b = false;
		}
		return b;
	}

}
