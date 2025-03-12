package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;

public class ForgotPasswordPage extends RootPage{
	
	public ForgotPasswordPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//ul[@class='breadcrumb']//a[normalize-space()='Forgotten Password']")
	private WebElement forgotPasswordBreadcrumb;
	
	
	
	
	
	public boolean verifyForgotPasswordBreadCrumb(){
		boolean b = false;
		try {
			b =  forgotPasswordBreadcrumb.isDisplayed();
		}catch(NoSuchElementException e)
		{
			b = false;
		}
		return b;
	}
	
	
	
	
	
}
