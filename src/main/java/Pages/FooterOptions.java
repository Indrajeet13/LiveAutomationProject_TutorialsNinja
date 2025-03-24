package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
import utils.ElementsUtilities;

public class FooterOptions extends RootPage{

	ElementsUtilities elementsUtilities;
	
	public FooterOptions(WebDriver driver){
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
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
	
	@FindBy(linkText = "About Us")
	private WebElement aboutUsTextOnBottom;
	
	@FindBy(linkText = "Contact Us")
	private WebElement contactUsTextOnBottom;
	
	@FindBy(linkText = "Brands")
	private WebElement brandsTextOnBottom;
	
	
	public LoginPage clickOnMyAccountTextOnBottom() {
		elementsUtilities.clickOnElement(myAccountTextOnBottom);
		return new LoginPage(driver);
	}
	
	public DeliveryInformationPage clickOnDeliveryInformationTextOnBottom() {
		elementsUtilities.clickOnElement(deliveryInformationTextOnBottom);	
		return new DeliveryInformationPage(driver);
	}
	
	public PrivacyPolicyPage clickOnPrivacyPolicyTextOnBottom() {
		elementsUtilities.clickOnElement(privacyPolicyTextOnBottom);
		return new PrivacyPolicyPage(driver);
	}
	
	public TermsAndConditionPage clickOnTermsAndConditionTextOnBottom() {
		elementsUtilities.clickOnElement(termsConditionTextOnBottom);
		return new TermsAndConditionPage(driver);
	}
	
	public ProductReturnsPage clickOnReturnsTextOnBottom() {
		elementsUtilities.clickOnElement(returnsTextOnBottom);	
		return new ProductReturnsPage(driver);
	}
	
	public SiteMapPage clickOnSiteMapTextOnBottom() {
		elementsUtilities.clickOnElement(siteMapTextOnBottom);
		return new SiteMapPage(driver);
	}
	
	public GiftCertificatesPage clickOnGiftCertificatesTextOnBottom() {
		elementsUtilities.clickOnElement(giftCertificatesTextOnBottom);
		return new GiftCertificatesPage(driver);
	}
	
	public AffiliateProgramPage clickOnAffiliateTextOnBottom() {
		elementsUtilities.clickOnElement(affiliateTextOnBottom);
		return new AffiliateProgramPage(driver);
	}
	
	public SpecialOffersPage clickOnSepcialsTextOnBottom() {
		elementsUtilities.clickOnElement(specialsTextOnBottom);
		return new SpecialOffersPage(driver);
	}
	
	public LoginPage clickOnOrderHistoryTextOnBottom() {
		elementsUtilities.clickOnElement(orderHistoryTextOnBottom);
		return new LoginPage(driver);
	}
	
	public LoginPage clickOnNewsLetterTextOnBottom() {
		elementsUtilities.clickOnElement(newsletterTextOnBottom);
		return new LoginPage(driver);
	}
	
	public AboutUsPage clickOnAboutUsOnBottom() {
		elementsUtilities.clickOnElement(aboutUsTextOnBottom);
		return new AboutUsPage(driver);
	}
	
	public ContactUsPage clickOnContactUsOnBottom() {
		elementsUtilities.clickOnElement(contactUsTextOnBottom);
		return new ContactUsPage(driver);
	}
	
	public BrandsPage clickOnBrandsTextOnBottom() {
		elementsUtilities.clickOnElement(brandsTextOnBottom);
		return new BrandsPage(driver);
	}
	
	
	
	
	
}
