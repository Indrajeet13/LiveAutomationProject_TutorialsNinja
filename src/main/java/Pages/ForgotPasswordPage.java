package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
import utils.ElementsUtilities;

public class ForgotPasswordPage extends RootPage{
	
	ElementsUtilities elementsUtilities;
	
	public ForgotPasswordPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//ul[@class='breadcrumb']//a[normalize-space()='Forgotten Password']")
	private WebElement forgotPasswordBreadcrumb;
	
	
	
	
	
	public boolean verifyForgotPasswordBreadCrumb(){
		return elementsUtilities.isElementDisplayed(forgotPasswordBreadcrumb);
	}
	
	
	
	
	
}
