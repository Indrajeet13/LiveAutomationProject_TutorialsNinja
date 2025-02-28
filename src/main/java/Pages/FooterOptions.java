package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterOptions {

	WebDriver driver;
	
	public FooterOptions(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//ul[@class='list-unstyled']//a[normalize-space()='My Account']")
	private WebElement myAccountTextOnBottom;
	
	@FindBy(linkText = "Delivery Information")
	private WebElement deliveryInformationTextOnBottom;
	
	@FindBy(xpath = "//a[contains(text(),'Privacy Policy')]")
	private WebElement privacyPolicyTextOnBottom;
	
	@FindBy(linkText = "Terms & Conditions")
	private WebElement termsConditionTextOnBottom;
	
	@FindBy(xpath = "//a[@href='https://tutorialsninja.com/demo/index.php?route=account/return/add'][normalize-space()='Returns']")
	private WebElement returnsTextOnBottom;
	
	@FindBy(linkText = "Site Map")
	private WebElement siteMapTextOnBottom;
	
	@FindBy(linkText = "Gift Certificates")
	private WebElement giftCertificatesTextOnBottom;
	
	@FindBy(linkText = "Affiliate")
	private WebElement affiliateTextOnBottom;
	
	@FindBy(linkText = "Specials")
	private WebElement specialsTextOnBottom;
	
	@FindBy(xpath = "//ul[@class='list-unstyled']//a[normalize-space()='Order History']")
	private WebElement orderHistoryTextOnBottom;
	
	@FindBy(xpath = "//ul[@class='list-unstyled']//a[normalize-space()='Newsletter']")
	private WebElement newsletterTextOnBottom;
	
	public LoginPage clickOnMyAccountTextOnBottom() {
		myAccountTextOnBottom.click();	
		return new LoginPage(driver);
	}
	
	public DeliveryInformationPage clickOnDeliveryInformationTextOnBottom() {
		deliveryInformationTextOnBottom.click();	
		return new DeliveryInformationPage(driver);
	}
	
	public PrivacyPolicyPage clickOnPrivacyPolicyTextOnBottom() {
		privacyPolicyTextOnBottom.click();	
		return new PrivacyPolicyPage(driver);
	}
	
	public TermsAndConditionPage clickOnTermsAndConditionTextOnBottom() {
		termsConditionTextOnBottom.click();	
		return new TermsAndConditionPage(driver);
	}
	
	public ProductReturnsPage clickOnReturnsTextOnBottom() {
		returnsTextOnBottom.click();	
		return new ProductReturnsPage(driver);
	}
	
	public SiteMapPage clickOnSiteMapTextOnBottom() {
		siteMapTextOnBottom.click();	
		return new SiteMapPage(driver);
	}
	
	public GiftCertificatesPage clickOnGiftCertificatesTextOnBottom() {
		giftCertificatesTextOnBottom.click();	
		return new GiftCertificatesPage(driver);
	}
	
	public AffiliateProgramPage clickOnAffiliateTextOnBottom() {
		affiliateTextOnBottom.click();	
		return new AffiliateProgramPage(driver);
	}
	
	public SpecialOffersPage clickOnSepcialsTextOnBottom() {
		specialsTextOnBottom.click();	
		return new SpecialOffersPage(driver);
	}
	
	public LoginPage clickOnOrderHistoryTextOnBottom() {
		orderHistoryTextOnBottom.click();	
		return new LoginPage(driver);
	}
	
	public LoginPage clickOnNewsLetterTextOnBottom() {
		newsletterTextOnBottom.click();	
		return new LoginPage(driver);
	}
	
	
	
	
	
	
	
}
