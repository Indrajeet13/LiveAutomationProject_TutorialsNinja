package Pages;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	public int getNoOfProductsDisplayedInSearchResults() {
		int n = 0;
		try {
			n = noOfProducts.size();
		}catch(NoSuchElementException e) {
			n = 0;
		}
		return n;
	}
	
	
	public String getNoProductMessage(){
		String noProductMessageText=null;
		try {
			noProductMessageText = noProductMessage.getText();
		}catch(NoSuchElementException e) {
			noProductMessageText=null;
		}
		return noProductMessageText;
	}
	
	public boolean isExistingProductDisplayed(){
		boolean b = false;
		try {
			b =  existingProduct.isDisplayed();
		}catch(NoSuchElementException e)
		{
			b = false;
		}
		return b;
	}
	
	public boolean verifySearchText(){
		boolean b = false;
		try {
			b =  searchTextVerify.isDisplayed();
		}catch(NoSuchElementException e)
		{
			b = false;
		}
		return b;
	}
	
	public boolean didWeNavigateToSearcPage(){
		boolean b = false;
		try {
			b =  searchBreadcrumb.isDisplayed();
		}catch(NoSuchElementException e)
		{
			b = false;
		}
		return b;
	}
	
	
}
