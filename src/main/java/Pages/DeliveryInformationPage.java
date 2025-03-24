package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
<<<<<<< HEAD
import utils.ElementsUtilities;

public class DeliveryInformationPage extends RootPage{
	
	ElementsUtilities elementsUtilities;
	
	public DeliveryInformationPage(WebDriver driver){
		
=======

public class DeliveryInformationPage extends RootPage{
	
	public DeliveryInformationPage(WebDriver driver){
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[contains(text(),'Delivery Information')]")
	private WebElement deliveryInformationBreadcrum;
	
	
	
	
	
	public boolean didWeNavigateToDeliveryInformationPage() {
<<<<<<< HEAD
		return elementsUtilities.isElementDisplayed(deliveryInformationBreadcrum);
=======
		return isElementDisplayed(deliveryInformationBreadcrum);
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	}
	
}
