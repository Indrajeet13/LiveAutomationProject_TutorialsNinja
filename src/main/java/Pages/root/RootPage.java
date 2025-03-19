package Pages.root;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class RootPage {
	
	public WebDriver driver;
	
	public RootPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public String getDomAttributeOfElement(WebElement element, String attribute) {
		
		String text = null;
		try {
			text  = element.getDomAttribute(attribute);
		}catch(NoSuchElementException e) {
			text = null;
		}catch(Exception e) {
			text =null;
		}
		return text;
	}
	
	public int getElementCount(List<WebElement> elements) {
		int n=0;
		try {
			n = elements.size();
		}catch(NoSuchElementException e) {
			n = 0;
		}catch(Exception e) {
			n = 0;
		}
		return n;
	}
	
	public String getTextOfElements(WebElement element) {
		String text = null;
		try {
			text = element.getText();
		}catch(NoSuchElementException e) {
			text = null;
		}catch(Exception e) {
			text = null;
		}
		return text;
	}
	
	public boolean isElementDisplayed(WebElement element) {
		boolean b = false;
		try {
			b = element.isDisplayed();
		}catch(NoSuchElementException e) {
			b = false;
		}catch(Exception e) {
			b = false;
		}
		return b;
	}
	
	public boolean isElementDisplayedAfterWaiting(By by, int seconds) {
		boolean b = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			b = element.isDisplayed();
		}catch(NoSuchElementException e) {
			b = false;
		}catch(Exception e) {
			b = false;
		}
		return b;
	}
	
}
