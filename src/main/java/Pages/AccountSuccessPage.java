package Pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import Pages.root.RootPage;

public class AccountSuccessPage extends RootPage{

	public AccountSuccessPage(WebDriver driver){
		super(driver);
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
	    boolean b = false;
		try {
			b =  logoutOption.isDisplayed();
		}catch(NoSuchElementException e)
		{
			b = false;
		}
		return b;
	}
	
	public String getPageHeading() {
		String pageHeadingText = null;
		try {
			pageHeadingText = pageHeading.getText();
		} catch (NoSuchElementException e) {
			pageHeadingText = null;
		}
		return pageHeadingText;
	}
	
	public AccountPage clickOnContinueButton() {
		continueButton.click();
		return new AccountPage(driver);
	}
	
	public boolean didWeNavigateToAccountSucessPage() {
		 boolean b = false;
			try {
				b =  myAccountHeading.isDisplayed();
			}catch(NoSuchElementException e)
			{
				b = false;
			}
			return b;
	}
	
}
