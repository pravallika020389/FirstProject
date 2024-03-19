package com.SalesForce.Test;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver = null;
	public static WebDriverWait wait;

	public static void launchBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
	}

	public static void getUrl(String url) {
		driver.get(url);
		System.out.println(url + " is entered");

	}
	public  static String getPagetitle() {
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle + " title is captured");
		return actualTitle;

	}
	public static void verifyTittle(String expectedTitle) {
		String actualTitle = driver.getTitle();
		if (expectedTitle.equals(actualTitle)) {
			System.out.println("Pass: Title matched with " + expectedTitle);
		} else {
			System.out.println("Fail : Title not matched with " + expectedTitle);
		}

	}

	public static void enterText(WebElement element, String data, String objectName) {
		if (element.isDisplayed()) {
			element.clear();
			element.sendKeys(data);
			System.out.println("Pass: " + objectName + " is entered ");
		} else {
			System.out.println("Fail: " + objectName + " element is not displayed");
		}
	}

	public static void clickOnElement(WebElement element,String label) {
		if (element.isDisplayed()) {
			element.click();

			System.out.println("Pass: Element " + label + " is clicked");
		} else {
			System.out.println("Fail: Element not displayed");

		}
	}

	public static void clearTheField(WebElement element) {
		if (element.isDisplayed()) {
			String label = element.getText();
			element.clear();

			System.out.println("Pass: Field " + label + " is cleared");
		} else {
			System.out.println("Fail: Element not displayed");

		}

	}

	public static String getText(WebElement element) {
		String fetchedData = element.getText();
		System.out.println("Text captured is " + fetchedData);
		return fetchedData;

	}

	public static void goToAlert(WebElement element) {
		driver.switchTo().alert();
		System.out.println("Focus is moved to alert");

	}

	public static void switchToWindow(String handle) {
		driver.switchTo().window(handle);
		System.out.println("Focus is moved to window");

	}

	public static void switchToDefault() {
		driver.switchTo().defaultContent();
		System.out.println("Focus is moved to the default content");

	}

	public static void copyToClipboard(String text) {

		Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection strse1 = new StringSelection(text);
		clip.setContents(strse1, strse1);
		System.out.println("Text copied to clipboard");
	}

	public static void closeBrowser() {
		driver.close();
		System.out.println("Browser is closed");

	}

	public static void closeAllBrowsers() {
		driver.quit();
		System.out.println("All Browser are closed");

	}

	public static void takescreenshot(String filepath) throws IOException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");  
		   LocalDateTime now = LocalDateTime.now();  
		    
		TakesScreenshot screenCapture = (TakesScreenshot) driver;
		File srcFile = screenCapture.getScreenshotAs(OutputType.FILE);
		String path = filepath + "_"+dtf.format(now)+".png";
		File destFile = new File(path);
		FileUtils.copyFile(srcFile, destFile);

	}
	
	
	
	public static void selectOptionbyIndex(WebElement element,int indexNumber) {
		
		Select select = new Select(element);
		select.selectByIndex(indexNumber);
		
	}
	
public static void selectOptionbyValue(WebElement element,String value) {
		
		Select select = new Select(element);
		select.selectByValue(value);
		
	}

public static void selectOptionbyVisibleText(WebElement element,String text) {
	
	Select select = new Select(element);
	select.selectByVisibleText(text);
	
}

public static void waitForPageLoad(int time) {
	driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
}

}
