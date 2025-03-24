package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
import utils.ElementsUtilities;

public class AccountLogoutPage extends RootPage {

	ElementsUtilities elementsUtilities;
	
	public AccountLogoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
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
		return elementsUtilities.getTextOfElements(pageHeading);
	}

	public LandingPage clickOnContinue() {
		elementsUtilities.clickOnElement(continueButton);
		return new LandingPage(driver);
	}

	public LoginPage clickOnLoginOptionDropMenu() {
		elementsUtilities.clickOnElement(loginOptionDropMenu);
		return new LoginPage(driver);
	}

	public void clickOnMyAccountDropMenu() {
		elementsUtilities.clickOnElement(myAccountDropMenu);
	}

	public boolean didWeNavigateToAccountLogoutPage() {
		return elementsUtilities.isElementDisplayed(accountLogoutText);
	}

}
