package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrandsPage {
	
	WebDriver driver;
	
	public BrandsPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[normalize-space()='Brand']")
	private WebElement brandsBreadcrum;
	
	
	
	
	
	public boolean didWeNavigateToBrandsPage() {
		return brandsBreadcrum.isDisplayed();
	}
	
	
}
