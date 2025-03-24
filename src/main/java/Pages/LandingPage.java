package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
<<<<<<< HEAD
import utils.ElementsUtilities;

public class LandingPage extends RootPage{
	
	ElementsUtilities elementsUtilities;
=======

public class LandingPage extends RootPage{
	
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	
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
<<<<<<< HEAD
		elementsUtilities.clickOnElement(searchButton);
=======
		searchButton.click();
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
		return new SearchPage(driver);
	}
	
	public void enterProductNameIntoSearchBoxField(String productNameText) {
<<<<<<< HEAD
		elementsUtilities.enterTextIntoElement(searchBoxField, productNameText);
=======
		searchBoxField.sendKeys(productNameText);
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
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
<<<<<<< HEAD
		elementsUtilities.clickOnElement(myAcctountDropMenu);
=======
		myAcctountDropMenu.click();
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	}
	
	public RegisterPage selectRegisterOption() {
		elementsUtilities.clickOnElement(registerOption);
		return new RegisterPage(driver);
	}
	
	public boolean isFeaturedHeadingDisplayed(){
<<<<<<< HEAD
		return elementsUtilities.isElementDisplayed(featuredHeading);
=======
		return isElementDisplayed(featuredHeading);
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	}
	
	public LoginPage selectLoginOption() {
		elementsUtilities.clickOnElement(loginOption);
		return new LoginPage(driver);
	}
	
	
}
