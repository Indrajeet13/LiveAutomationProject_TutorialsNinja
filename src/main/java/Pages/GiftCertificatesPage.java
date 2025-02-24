package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GiftCertificatesPage {
	
	WebDriver driver;
	
	public GiftCertificatesPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[normalize-space()='Gift Certificate']")
	private WebElement giftCertificatesBreadcrumb;
	
	
	
	
	
	public boolean didWeNavigateToGiftCertificatesPage() {
		return giftCertificatesBreadcrumb.isDisplayed();
	}
	
}
