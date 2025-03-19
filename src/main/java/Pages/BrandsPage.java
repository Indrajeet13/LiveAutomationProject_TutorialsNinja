package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;

public class BrandsPage extends RootPage{
	

	public BrandsPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[normalize-space()='Brand']")
	private WebElement brandsBreadcrum;
	
	
	
	
	
	public boolean didWeNavigateToBrandsPage() {
		return isElementDisplayed(brandsBreadcrum);
	}
	
	
}
