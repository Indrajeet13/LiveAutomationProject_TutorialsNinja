package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import Pages.root.RootPage;

public class AboutUsPage extends RootPage {
	
	public AboutUsPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//ul[@class='breadcrumb']//a[contains(text(),'About Us')]")
	private WebElement aboutUsBreadcrumb;
	
	
	
	
	
	public boolean verifyAboutUsBreadCrumb(){
		return isElementDisplayed(aboutUsBreadcrumb);
	}
	
	
}
