package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;

public class GiftCertificatesPage extends RootPage{
	
	public GiftCertificatesPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[normalize-space()='Gift Certificate']")
	private WebElement giftCertificatesBreadcrumb;
	
	
	
	
	
	public boolean didWeNavigateToGiftCertificatesPage() {
		return isElementDisplayed(giftCertificatesBreadcrumb);
	}
	
}
