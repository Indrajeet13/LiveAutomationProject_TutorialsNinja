package temp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tutorialsninja.base.Base;

public class TC_RF_015 extends Base {
	
	WebDriver driver;
	
	// Database credentials
    private static final String url = "jdbc:mysql://localhost:3306/opencart_db"; 
    private static final String username = "root"; 
    private static final String password = null; 

    public static String generateBrandNewEmail() {
        return "user" + System.currentTimeMillis() + "@email.com";
    }
    
	@BeforeMethod
	public void setup() {

		driver = openBrowserAndApplication();

		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
	}

	@AfterMethod
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	@Test
	public void verifyDatabaseTestingOfRegisteringAccount() {

		String firstNameInputData = "Indrajeet";
		driver.findElement(By.id("input-firstname")).sendKeys(firstNameInputData);
		
		String lastNameInputData = "Yadav";
		driver.findElement(By.id("input-lastname")).sendKeys(lastNameInputData);
		
		String emailInputData = generateBrandNewEmail();
		driver.findElement(By.id("input-email")).sendKeys(emailInputData);
		
		String passwordInputData = "123456";
		driver.findElement(By.id("input-password")).sendKeys(passwordInputData);
		
		driver.findElement(By.id("input-newsletter")).click();
		
		driver.findElement(By.name("agree")).click();
		
		driver.findElement(By.xpath("//button[normalize-space()='Continue']")).click();

       Assert.assertEquals(driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText(),"Your Account Has Been Created!");
		
		// Database validation
	    try (Connection conn = DriverManager.getConnection(url, username, password);
	         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM `oc_customer` WHERE email = ?")) 
	    {
	        stmt.setString(1, emailInputData);
	        
	        try (ResultSet resultSet = stmt.executeQuery()) {
	           
	        	if (resultSet.next()) {
	                Assert.assertEquals(resultSet.getString("firstname"), firstNameInputData);
	                Assert.assertEquals(resultSet.getString("lastname"), lastNameInputData);
	                Assert.assertEquals(resultSet.getString("email"), emailInputData);
	            } else {
	                Assert.fail("No data found in the database for the email: " + emailInputData);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        Assert.fail("Database connection or query failed: " + e.getMessage());
	    }
	    
	}
	
}
