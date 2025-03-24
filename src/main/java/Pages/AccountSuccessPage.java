package Pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import Pages.root.RootPage;
import utils.ElementsUtilities;

public class AccountSuccessPage extends RootPage{

	ElementsUtilities elementsUtilities;
	
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
	    return elementsUtilities.isElementDisplayed(logoutOption);
	}
	
	public String getPageHeading() {
		return elementsUtilities.getTextOfElements(pageHeading);
	}
	
	public AccountPage clickOnContinueButton() {
		elementsUtilities.clickOnElement(continueButton);
		return new AccountPage(driver);
	}
	
	public boolean didWeNavigateToAccountSucessPage() {
		return elementsUtilities.isElementDisplayed(myAccountHeading); 
	}
	
}
