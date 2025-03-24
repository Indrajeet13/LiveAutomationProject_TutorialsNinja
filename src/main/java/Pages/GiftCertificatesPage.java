package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
<<<<<<< HEAD
import utils.ElementsUtilities;

public class GiftCertificatesPage extends RootPage{
	
	ElementsUtilities elementsUtilities;
=======

public class GiftCertificatesPage extends RootPage{
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	
	public GiftCertificatesPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[normalize-space()='Gift Certificate']")
	private WebElement giftCertificatesBreadcrumb;
	
	
	
	
	
	public boolean didWeNavigateToGiftCertificatesPage() {
<<<<<<< HEAD
		return elementsUtilities.isElementDisplayed(giftCertificatesBreadcrumb);
=======
		return isElementDisplayed(giftCertificatesBreadcrumb);
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	}
	
}
