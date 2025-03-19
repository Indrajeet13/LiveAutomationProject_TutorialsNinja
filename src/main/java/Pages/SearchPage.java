package Pages;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import Pages.root.RootPage;

public class SearchPage extends RootPage{
	
	public SearchPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='Search']")
	private WebElement searchTextVerify;
	
	@FindBy(linkText="Search")
	private WebElement searchBreadcrumb;
	
	@FindBy(linkText="HP LP3065")
	private WebElement existingProduct;
	
	@FindBy(xpath="//p[contains(text(),'There is no product that matches the search criter')]")
	private WebElement noProductMessage;
	
	@FindBy(xpath="//div[@class='caption']")
	private List<WebElement> noOfProducts;
	
	@FindBy(id="input-search")
	private WebElement searchCriteriaField;
	
	
	
	
	public String getPlaceHolderTextOfSearchCriteriaField() {
		return getDomAttributeOfElement(searchCriteriaField,"placeholder");
	}

	
	public int getNoOfProductsDisplayedInSearchResults() {
		return getElementCount(noOfProducts);
	}
	
	public String getNoProductMessage(){
		return getTextOfElements(noProductMessage);
	}
	
	public boolean isExistingProductDisplayed(){
		return isElementDisplayed(existingProduct);
	}
	
	public boolean verifySearchText(){
		return isElementDisplayed(searchTextVerify);
	}
	
	public boolean didWeNavigateToSearcPage(){
		return isElementDisplayed(searchBreadcrumb);
	}
	
}
