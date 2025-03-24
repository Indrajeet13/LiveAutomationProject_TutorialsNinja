package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
import utils.ElementsUtilities;

public class LandingPage extends RootPage{
	
	ElementsUtilities elementsUtilities;
	
	public LandingPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
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
		elementsUtilities.clickOnElement(searchButton);
		return new SearchPage(driver);
	}
	
	public void enterProductNameIntoSearchBoxField(String productNameText) {
		elementsUtilities.enterTextIntoElement(searchBoxField, productNameText);
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
		elementsUtilities.clickOnElement(myAcctountDropMenu);
	}
	
	public RegisterPage selectRegisterOption() {
		elementsUtilities.clickOnElement(registerOption);
		return new RegisterPage(driver);
	}
	
	public boolean isFeaturedHeadingDisplayed(){
		return elementsUtilities.isElementDisplayed(featuredHeading);
	}
	
	public LoginPage selectLoginOption() {
		elementsUtilities.clickOnElement(loginOption);
		return new LoginPage(driver);
	}
	
	
}
