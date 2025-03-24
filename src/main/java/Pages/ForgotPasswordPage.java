package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
<<<<<<< HEAD
import utils.ElementsUtilities;

public class ForgotPasswordPage extends RootPage{
	
	ElementsUtilities elementsUtilities;
=======

public class ForgotPasswordPage extends RootPage{
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	
	public ForgotPasswordPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//ul[@class='breadcrumb']//a[normalize-space()='Forgotten Password']")
	private WebElement forgotPasswordBreadcrumb;
	
	
	
	
	
	public boolean verifyForgotPasswordBreadCrumb(){
<<<<<<< HEAD
		return elementsUtilities.isElementDisplayed(forgotPasswordBreadcrumb);
=======
		return isElementDisplayed(forgotPasswordBreadcrumb);
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	}
	
	
	
	
	
}
