package Pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import Pages.root.RootPage;
<<<<<<< HEAD
import utils.ElementsUtilities;

public class AccountSuccessPage extends RootPage{

	ElementsUtilities elementsUtilities;
	
=======

public class AccountSuccessPage extends RootPage{

>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	public AccountSuccessPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Logout")
	private WebElement logoutOption; 
	
	@FindBy(xpath="//div[@id='content']//h1")
	private WebElement pageHeading;
	
	@FindBy(xpath="//a[normalize-space()='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	private WebElement myAccountHeading;
	
	
	
	
	
	public boolean isUserLoggedIn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(logoutOption));
<<<<<<< HEAD
	    return elementsUtilities.isElementDisplayed(logoutOption);
	}
	
	public String getPageHeading() {
		return elementsUtilities.getTextOfElements(pageHeading);
=======
	    return isElementDisplayed(logoutOption);
	}
	
	public String getPageHeading() {
		return getTextOfElements(pageHeading);
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	}
	
	public AccountPage clickOnContinueButton() {
		elementsUtilities.clickOnElement(continueButton);
		return new AccountPage(driver);
	}
	
	public boolean didWeNavigateToAccountSucessPage() {
<<<<<<< HEAD
		return elementsUtilities.isElementDisplayed(myAccountHeading); 
=======
		return isElementDisplayed(myAccountHeading); 
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	}
	
}
