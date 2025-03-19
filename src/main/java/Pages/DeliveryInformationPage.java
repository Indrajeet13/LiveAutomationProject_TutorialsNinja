package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;

public class DeliveryInformationPage extends RootPage{
	
	public DeliveryInformationPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[contains(text(),'Delivery Information')]")
	private WebElement deliveryInformationBreadcrum;
	
	
	
	
	
	public boolean didWeNavigateToDeliveryInformationPage() {
		return isElementDisplayed(deliveryInformationBreadcrum);
	}
	
}
