package tutorialsninja.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import Pages.HeaderOptions;
import Pages.LandingPage;
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
	
	
}
