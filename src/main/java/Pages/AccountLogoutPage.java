package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
<<<<<<< HEAD
import utils.ElementsUtilities;

public class AccountLogoutPage extends RootPage {

	ElementsUtilities elementsUtilities;
	
=======

public class AccountLogoutPage extends RootPage {

>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
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
<<<<<<< HEAD
		return elementsUtilities.getTextOfElements(pageHeading);
	}

	public LandingPage clickOnContinue() {
		elementsUtilities.clickOnElement(continueButton);
=======
		return getTextOfElements(pageHeading);
	}

	public LandingPage clickOnContinue() {
		continueButton.click();
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
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
<<<<<<< HEAD
		return elementsUtilities.isElementDisplayed(accountLogoutText);
=======
		return isElementDisplayed(accountLogoutText);
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	}

}
