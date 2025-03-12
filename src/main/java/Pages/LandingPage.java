package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;

public class LandingPage extends RootPage{
	
	
	public LandingPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAcctountDropMenu;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(xpath="//h3[normalize-space()='Featured']")
	private WebElement featuredHeading;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	private WebElement loginOption;
	
	@FindBy(name="search")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//i[@class='fa fa-search']")
	private WebElement searchButton;
	
	
	
	public SearchPage clickOnSearchButton() {
		searchButton.click();
		return new SearchPage(driver);
	}
	
	public void enterProductNameIntoSearchBoxField(String productNameText) {
		searchBoxField.sendKeys(productNameText);
	}
	
	public RegisterPage navigateToRegisterPage() {
		clickOnMyAccount();
		return selectRegisterOption();
	}
	
	public LoginPage navigateToLoginPage() {
		clickOnMyAccount();
		return selectLoginOption();
	}

	public void clickOnMyAccount(){
		myAcctountDropMenu.click();
	}
	
	public RegisterPage selectRegisterOption()
	{
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	public boolean isFeaturedHeadingDisplayed(){
		boolean b = false;
		try {
			b =  featuredHeading.isDisplayed();
		}catch(NoSuchElementException e)
		{
			b = false;
		}
		return b;
	}
	
	public LoginPage selectLoginOption()
	{
		loginOption.click();
		return new LoginPage(driver);
	}
	
	
}
