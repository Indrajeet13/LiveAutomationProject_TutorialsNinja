package utils;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementsUtilities {

	WebDriver driver;

	public ElementsUtilities(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isElementDisplayed(WebElement element) {

		boolean b = false;
		try {
			b = element.isDisplayed();
		} catch (NoSuchElementException e) {
			b = false;
		} catch (Exception e) {
			b = false;
		}
		return b;
	}

	public boolean isElementEnabled(WebElement element) {

		boolean b = false;
		try {
			b = element.isEnabled();
		} catch (NoSuchElementException e) {
			b = false;
		} catch (Exception e) {
			b = false;
		}
		return b;
	}
	
	public String getTextOfElements(WebElement element) {
		String text = "";
		try {
			text = element.getText();
		}catch(NoSuchElementException e) {
			text = "";
		}catch(Exception e) {
			text = "";
		}
		return text;
	}
	
	public void clickOnElement(WebElement element) {
		if(isElementDisplayed(element) && isElementEnabled(element)) {
			element.click();
		}
					
	}
	
	public void enterTextIntoElement(WebElement element, String text) {
		if(isElementDisplayed(element) && isElementEnabled(element)) {
			element.click();
			element.sendKeys(text);
		}
					
	}
	
	public void clearTextFromTextField(WebElement element) {
		if(isElementDisplayed(element) && isElementEnabled(element)) {
			element.clear();
		}
	}
	
	
}
