package tutorialsninja.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import Pages.*;
import tutorialsninja.base.Base;
import utils.Utilities;

public class Search extends Base{

	public WebDriver driver;
	Properties prop;
	
	@BeforeMethod
	public void setup() {
		
		driver = openBrowserAndApplication();
		prop = Utilities.loadProperties();
		landingPage = new LandingPage(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		closeBrowser(driver);
	}
	
	@Test(priority=1)
	public void verifySearchWithValidProduct() {
		
		landingPage.enterProductNameIntoSearchBoxField(prop.getProperty("existingProduct"));
		searchPage = landingPage.clickOnSearchButton();
		Assert.assertTrue(searchPage.didWeNavigateToSearcPage());
		Assert.assertTrue(searchPage.isExistingProductDisplayed());
	}
	
	@Test(priority=2)
	public void verifySearchWithInvaliadProduct() {
		
		landingPage.enterProductNameIntoSearchBoxField(prop.getProperty("nonExistingProduct"));
		searchPage = landingPage.clickOnSearchButton();
		String expectedMessage = "There is no product that matches the search criteria.";
		Assert.assertEquals(searchPage.getNoProductMessage(), expectedMessage);
	}
	
	@Test(priority=3)
	public void verifySearchWithoutEnteringAnyProduct() {
		
		searchPage = landingPage.clickOnSearchButton();
		String expectedMessage = "There is no product that matches the search criteria.";
		Assert.assertEquals(searchPage.getNoProductMessage(), expectedMessage);
	}
	
	@Test(priority=4)
	public void verifySearchAfterrLogin() {
		
		loginPage = landingPage.navigateToLoginPage();
		accountPage = loginPage.loginToApplication(prop.getProperty("existingEmail"), prop.getProperty("validPassword"));
		headerOptions = new HeaderOptions(accountPage.getDriver());
		headerOptions.enterProductIntoSearchBoxField(prop.getProperty("existingProduct"));
		searchPage = headerOptions.clickOnSearchButton();
		Assert.assertTrue(searchPage.isExistingProductDisplayed());
	}
	
	@Test(priority=5)
	public void verifySearchResultingMultipleProducts() {
		
		landingPage.enterProductNameIntoSearchBoxField(prop.getProperty("searchTermResultingMultipleProduct"));
		searchPage = landingPage.clickOnSearchButton();
		Assert.assertTrue(searchPage.getNoOfProductsDisplayedInSearchResults() > 1);
	}
	
	@Test(priority=6)
	public void verifySearchFieldsPlaceholders() {
		
		headerOptions = new HeaderOptions(driver);
		String expectedSearchBoxField = "Search";
		Assert.assertEquals(headerOptions.getPlaceholderTextOfSearchBoxField(), expectedSearchBoxField);
		searchPage = headerOptions.clickOnSearchButton();
		String expectedSearchCriteriaFieldPlaceholder = "Keywords";
		Assert.assertEquals(searchPage.getPlaceHolderTextOfSearchCriteriaField(), expectedSearchCriteriaFieldPlaceholder);
	
	}
	
	@Test(priority=7)
	public void verifySearchingForProductUsingSearchCriteriaField() {
		
		headerOptions = new HeaderOptions(driver);
		searchPage = headerOptions.clickOnSearchButton();
		searchPage.enterIntoSearchCriteriaField(prop.getProperty("existingProduct"));
		searchPage.clickOnSearchButton();
		Assert.assertTrue(searchPage.isExistingProductDisplayed());
	}
	
	@Test(priority=8)
	public void verifySearchingForProductUsingSomeTextInProductDescription() {
		
		headerOptions = new HeaderOptions(driver);
		searchPage = headerOptions.clickOnSearchButton();
		searchPage.enterIntoSearchCriteriaField(prop.getProperty("termInProductDescription"));
		searchPage.selectSearchInProductDescriptionCheckBoxField();
		searchPage.clickOnSearchButton();
		Assert.assertTrue(searchPage.isProductHavingDescriptionTextDisplayedInSearchResults());
		
	}
	
	@Test(priority=9)
	public void verifySearchBySelectingSubCategory() {
		
		headerOptions = new HeaderOptions(driver);
		searchPage = headerOptions.clickOnSearchButton();
		searchPage.enterIntoSearchCriteriaField(prop.getProperty("existingProductinSubCategory"));
		searchPage.selectOptionFromCategoryDropDownField(prop.getProperty("sampleCategory"));
		searchPage.clickOnSearchButton();
		Assert.assertTrue(searchPage.isProductInCategoryDisplayedInSearchResults());
	}
	
	
	
	
}
