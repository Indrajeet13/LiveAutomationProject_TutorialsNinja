package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
import utils.ElementsUtilities;

public class DeliveryInformationPage extends RootPage{
	
	ElementsUtilities elementsUtilities;
	
	public DeliveryInformationPage(WebDriver driver){
		
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[contains(text(),'Delivery Information')]")
	private WebElement deliveryInformationBreadcrum;
	
	
	
	
	
	public boolean didWeNavigateToDeliveryInformationPage() {
		return elementsUtilities.isElementDisplayed(deliveryInformationBreadcrum);
	}
	
}
