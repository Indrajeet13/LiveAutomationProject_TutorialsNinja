package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;

public class EditAccountInformationPage extends RootPage{
	
	public EditAccountInformationPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	
	
	
	
	
	public String getEmailDomAttributeValue() {
		return emailField.getDomAttribute("value");
	}

	public String getFirstNameDomAttributeValue() {
		return firstNameField.getDomAttribute("value");
	}

	public String getLastNameDomAttributeValue() {
		return lastNameField.getDomAttribute("value");
	}

	public String getTelephoneDomAttributeValue() {
		return telephoneField.getDomAttribute("value");
	}
	
	
	
	
	
	
	
}
