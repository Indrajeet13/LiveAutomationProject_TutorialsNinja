package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountLogoutPage {
	
	WebDriver driver;
	
	public AccountLogoutPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[normalize-space()='Account Logout']")
	private WebElement accountLogoutText;
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	private WebElement loginOptionDropMenu;
	
	
	public LoginPage clickOnLoginOptionDropMenu() {
		loginOptionDropMenu.click();
		return new LoginPage(driver);
	}
	
	public void clickOnMyAccountDropMenu() {
		myAccountDropMenu.click();
	}
	
	public boolean didWeNavigateToAccountLogoutPage() {
		return accountLogoutText.isDisplayed();
	}
	
}
