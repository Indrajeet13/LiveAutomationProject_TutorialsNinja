package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
import utils.ElementsUtilities;

public class GiftCertificatesPage extends RootPage{
	
	ElementsUtilities elementsUtilities;
	
	public GiftCertificatesPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[normalize-space()='Gift Certificate']")
	private WebElement giftCertificatesBreadcrumb;
	
	
	
	
	
	public boolean didWeNavigateToGiftCertificatesPage() {
		return elementsUtilities.isElementDisplayed(giftCertificatesBreadcrumb);
	}
	
}
