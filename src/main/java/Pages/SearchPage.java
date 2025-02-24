package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	
	public SearchPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='Search']")
	private WebElement searchTextVerify;
	
	
	
	
	public boolean verifySearchText(){
		return searchTextVerify.isDisplayed();
	}
	
	
	
	
}
