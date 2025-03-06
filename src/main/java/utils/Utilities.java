package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class Utilities {

	WebDriver driver;

	public static String generateBrandNewEmail() {
		return new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "") + "@email.com";

	}

	public static boolean compareTwoScreenShots(String actualImagePath, String expectedImagePath) {
		BufferedImage actualBImg = null;
		BufferedImage expectedBImg = null;
		try {
			actualBImg = ImageIO.read(new File(actualImagePath));
			expectedBImg = ImageIO.read(new File(expectedImagePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ImageDiffer imgDiffer = new ImageDiffer();
		ImageDiff imgDifference = imgDiffer.makeDiff(actualBImg, expectedBImg);

		return imgDifference.hasDiff(); // False means two images are same - No difference in two images

	}

	public static Properties loadProperties() {

		Properties prop = new Properties();
		try {
			FileReader fr = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\projectdata.properties");
			prop.load(fr);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return prop;
	}

	public static WebDriver takeScreenshot(WebDriver driver, String pathToBeCopied) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcScreenshot = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(srcScreenshot, new File(System.getProperty("user.dir") + pathToBeCopied));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	public static String takeScreenshotAndReturnPath(WebDriver driver, String pathToBeCopied) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcScreenshot = ts.getScreenshotAs(OutputType.FILE);
		String destScreenshotPath = System.getProperty("user.dir") + pathToBeCopied;
		try {
			FileHandler.copy(srcScreenshot, new File(destScreenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destScreenshotPath;
	}
	

	public static String validEmailRandomizeGenerator() {

		String[] validEmails = { "abc@gmail.com", "abc1@gmail.com", "ericabc@gmail.com", "ericc1@gmail.com",
				"eric2@gmail.com", "eric3@gmail.com", "eric4@gmail.com", "eric5@gmail.com" };

		int index = (int) (Math.random() * validEmails.length);
		return validEmails[index];
	}

	public static void setProperties(String propertyKey, String propertyValue) {

		Properties prop = Utilities.loadProperties();
		FileWriter fr = null;

		prop.setProperty(propertyKey, propertyValue);
		try {
			fr = new FileWriter(System.getProperty("user.dir") + "\\src\\test\\resources\\projectdata.properties");
			prop.store(fr, "");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Object[][] getTestData(MyXLSReader xls_received, String testName, String sheetName) {

		MyXLSReader xls = xls_received;
		String testCaseName = testName;
		String testDataSheet = sheetName;
		int testStartRowNumber = 1;

		while (!(xls.getCellData(testDataSheet, 1, testStartRowNumber).equals(testCaseName))) {
			testStartRowNumber++;
		}

		int columnStartRowNumber = testStartRowNumber + 1;
		int dataStartRowNumber = testStartRowNumber + 2;

		int rows = 0;
		while (!(xls.getCellData(testDataSheet, 1, dataStartRowNumber + rows).equals(""))) {

			rows++;

		}

		// Total number of columns in the required test
		int columns = 1;

		while (!(xls.getCellData(testDataSheet, columns, columnStartRowNumber).equals(""))) {

			columns++;

		}

		Object[][] obj = new Object[rows][1];

		HashMap<String, String> map = null;

		// Reading the data in the test
		for (int i = 0, row = dataStartRowNumber; row < dataStartRowNumber + rows; row++, i++) {
			map = new HashMap<String, String>();

			for (@SuppressWarnings("unused")
			int j = 0, column = 1; column < columns; column++, j++) {
				String key = xls.getCellData(testDataSheet, column, columnStartRowNumber);
				String value = xls.getCellData(testDataSheet, column, row);
				map.put(key, value);

			}
			obj[i][0] = map;
		}
		return obj;
	}
	
	public static ExtentReports getExtentReport() {
		
		ExtentReports extentReport = new ExtentReports();
		
		File extentReportFile = new File(System.getProperty("user.dir")+"\\reports\\TNExtentReport.html");
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		ExtentSparkReporterConfig sparkConfig = sparkReporter.config();
		sparkConfig.setReportName("Tutorials Ninja Test Automation Results");
		sparkConfig.setDocumentTitle("TNER Results");
		
		extentReport.attachReporter(sparkReporter);
		extentReport.setSystemInfo("OS",System.getProperty("os.name"));
		extentReport.setSystemInfo("Java Version",System.getProperty("java.version"));
		extentReport.setSystemInfo("Username",System.getProperty("user.name"));
		extentReport.setSystemInfo("Selenium WebDriver Version","4.24.0");
		
		return extentReport;
		
	}
	

}
