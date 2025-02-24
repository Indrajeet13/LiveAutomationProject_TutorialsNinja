package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditAccountInformationPage {
	
	WebDriver driver;
	
	public EditAccountInformationPage(WebDriver driver){
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
