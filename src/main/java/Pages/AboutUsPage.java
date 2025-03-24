package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pages.root.RootPage;
import utils.ElementsUtilities;

public class AboutUsPage extends RootPage {
	
	ElementsUtilities elementsUtilities;
	
	public AboutUsPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//ul[@class='breadcrumb']//a[contains(text(),'About Us')]")
	private WebElement aboutUsBreadcrumb;
	
	

	
	public boolean verifyAboutUsBreadCrumb(){
		return elementsUtilities.isElementDisplayed(aboutUsBreadcrumb);
	}
	
	
}
