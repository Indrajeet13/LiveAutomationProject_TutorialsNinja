package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountSuccessPage {
	
	WebDriver driver;
	
	public AccountSuccessPage(WebDriver driver){
		this.driver = driver;
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
	    return logoutOption.isDisplayed();
	}
	
	public String getPageHeading() {
		return pageHeading.getText();
	}
	
	public AccountPage clickOnContinueButton() {
		continueButton.click();
		return new AccountPage(driver);
	}
	
	public boolean didWeNavigateToAccountSucessPage() {
		return myAccountHeading.isDisplayed();
	}
	
}
