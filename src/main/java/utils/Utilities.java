package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class Utilities {
	
	WebDriver driver;
	
	public static String generateBrandNewEmail()
	{
		return new Date().toString().replaceAll("\\s","").replaceAll("\\:", "")+"@email.com";
		
	}
	
	public static boolean compareTwoScreenShots(String actualImagePath, String expectedImagePath) throws IOException
	{
		BufferedImage actualBImg = ImageIO.read(new File(actualImagePath));
		BufferedImage expectedBImg = ImageIO.read(new File(expectedImagePath));
		
		ImageDiffer imgDiffer = new ImageDiffer();
		ImageDiff imgDifference = imgDiffer.makeDiff(actualBImg, expectedBImg);
		
		return imgDifference.hasDiff(); //False means two images are same - No difference in two images
	
	}
	
	public static Properties loadProperties() 
	{
	
		Properties prop = new Properties();
		try {
			FileReader fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\projectdata.properties");
			prop.load(fr);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return prop;
	}
	
	public static WebDriver takeScreenshot(WebDriver driver, String pathToBeCopied) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcScreenshot = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(srcScreenshot,new File(System.getProperty("user.dir") + pathToBeCopied));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	public static String validEmailRandomizeGenerator() {

		String[] validEmails = { "abc@gmail.com", "abc1@gmail.com", "ericabc@gmail.com", "ericc1@gmail.com",
				"eric2@gmail.com", "eric3@gmail.com", "eric4@gmail.com", "eric5@gmail.com"};
		
		 int index = (int) (Math.random() * validEmails.length);
		 return validEmails[index];
	}
	
	public static void setProperties(String propertyKey, String propertyValue) {
		
		Properties prop = Utilities.loadProperties();
		FileWriter fr = null ;
		
		prop.setProperty(propertyKey, propertyValue);
		try {
			fr = new FileWriter(System.getProperty("user.dir")+"\\src\\test\\resources\\projectdata.properties");
			prop.store(fr, "");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
