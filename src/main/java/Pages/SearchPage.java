package Pages;

import java.util.List;
<<<<<<< HEAD

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Pages.root.RootPage;
import utils.ElementsUtilities;

public class SearchPage extends RootPage{
	
	ElementsUtilities elementsUtilities;
=======

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import Pages.root.RootPage;

public class SearchPage extends RootPage{
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	
	public SearchPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
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
	
<<<<<<< HEAD
	@FindBy(id="button-search")
	private WebElement searchButton;
	
	@FindBy(id="description")
	private WebElement searchInProductDescriptionSearchBoxField;
	
	@FindBy(linkText="iMac")
	private WebElement iMacProduct;
	
	@FindBy(name="category_id")
	private WebElement categoryDropDownField;
	
	
	
	public void selectOptionFromCategoryDropDownField(String optionText) {
		Select select = new Select(categoryDropDownField);
		select.selectByContainsVisibleText(optionText);
	}
	
	public void selectSearchInProductDescriptionCheckBoxField() {
		elementsUtilities.clickOnElement(searchInProductDescriptionSearchBoxField);	
=======
	
	
	
	public String getPlaceHolderTextOfSearchCriteriaField() {
		return getDomAttributeOfElement(searchCriteriaField,"placeholder");
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	}

	
<<<<<<< HEAD
	public void clickOnSearchButton() {
		elementsUtilities.clickOnElement(searchButton);	
	}
	
	public void enterIntoSearchCriteriaField(String text) {
		elementsUtilities.enterTextIntoElement(searchCriteriaField, text);
=======
	public int getNoOfProductsDisplayedInSearchResults() {
		return getElementCount(noOfProducts);
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	}
	
	public String getNoProductMessage(){
		return getTextOfElements(noProductMessage);
	}
	
	public boolean isExistingProductDisplayed(){
		return isElementDisplayed(existingProduct);
	}
	
<<<<<<< HEAD
	public String getPlaceHolderTextOfSearchCriteriaField() {
		return getDomAttributeOfElement(searchCriteriaField,"placeholder");
	}

	
	public int getNoOfProductsDisplayedInSearchResults() {
		return getElementCount(noOfProducts);
	}
	
	public String getNoProductMessage(){
		return elementsUtilities.getTextOfElements(noProductMessage);
	}
	
	public boolean isExistingProductDisplayed(){
		return elementsUtilities.isElementDisplayed(existingProduct);
	}
	
	public boolean isProductHavingDescriptionTextDisplayedInSearchResults(){
		return elementsUtilities.isElementDisplayed(iMacProduct);
	}
	
	public boolean isProductInCategoryDisplayedInSearchResults(){
		return elementsUtilities.isElementDisplayed(iMacProduct);
	}
	
	public boolean verifySearchText(){
		return elementsUtilities.isElementDisplayed(searchTextVerify);
	}
	
	public boolean didWeNavigateToSearcPage(){
		return elementsUtilities.isElementDisplayed(searchBreadcrumb);
=======
	public boolean verifySearchText(){
		return isElementDisplayed(searchTextVerify);
	}
	
	public boolean didWeNavigateToSearcPage(){
		return isElementDisplayed(searchBreadcrumb);
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	}
	
}
