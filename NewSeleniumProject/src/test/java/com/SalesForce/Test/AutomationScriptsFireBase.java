package com.SalesForce.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AutomationScriptsFireBase extends BaseTest {

	public static void login() {
		launchBrowser("Chrome");
		getUrl("https://qa-tekarch.firebaseapp.com/");
		verifyTittle("Selenium");
		WebElement userName = driver.findElement(By.id("email_field"));
		enterText(userName, "admin123@gmail.com", "Login id");
		WebElement password = driver.findElement(By.id("password_field"));
		enterText(password, "admin123", "Password");
		WebElement login = driver.findElement(By.tagName("button"));
		clickOnElement(login,"login");
		verifyTittle("Selenium");
	}

	public static void testMultiWindow() throws InterruptedException, AWTException {
		WebElement switchToLabel = driver.findElement(By.className("dropbtn"));
		Actions action = new Actions(driver);
		Thread.sleep(4000);
		action.moveToElement(switchToLabel).perform();
		Thread.sleep(4000);
		WebElement windows = driver.findElement(By.linkText("Windows"));
		clickOnElement(windows,"windows");
		Thread.sleep(4000);
		WebElement newWindow = driver.findElement(By.xpath("//*[@id=\"user_div\"]/div[2]/a[2]/button"));
		String baseWindowHandle = driver.getWindowHandle();
		clickOnElement(newWindow,"newWindow");
		Thread.sleep(4000);
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!baseWindowHandle.equals(handle)) {
				switchToWindow(handle);
				break;
			}
		}
		driver.findElement(By.name("q")).sendKeys("selenium");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		switchToDefault();
		getUrl("https://demoqa.com/frames");
		verifyTittle("DEMOQA");
		closeAllBrowsers();

	}
	
	

	public static void testAutoFill() throws InterruptedException, AWTException {

		WebElement widgetLabel = driver.findElement(By.xpath("//button[contains(text(),\"Widget\")]"));
		Actions action = new Actions(driver);
		Thread.sleep(4000);
		action.moveToElement(widgetLabel).perform();
		Thread.sleep(4000);
		WebElement autoComplete = driver.findElement(By.linkText("AutoComplete"));
		clickOnElement(autoComplete,"autoComplete");
		Thread.sleep(4000);
		WebElement enterCountry = driver.findElement(By.id("myInput"));
		enterText(enterCountry, "un", "Country input");
		WebElement usaDrpdwnSelect = driver.findElement(By.xpath("//*[@id=\"myInputautocomplete-list\"]/div[3]"));
		clickOnElement(usaDrpdwnSelect,"usaDrpdwnSelect");
		closeBrowser();

	}

	public static void testFileUpload() throws InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement fileUploadLabel = driver.findElement(By.xpath("//*[text()='File Upload']"));
		wait.until(ExpectedConditions.visibilityOf(fileUploadLabel));
		Actions action = new Actions(driver);
		action.moveToElement(fileUploadLabel).perform();
		wait.until(ExpectedConditions.elementToBeClickable(fileUploadLabel));
		clickOnElement(fileUploadLabel,"fileUploadLabel");
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		Robot robot = new Robot();
		
		 WebElement chooseFileButton = driver.findElement(By.id("logo"));
				 //driver.findElement(By.xpath("//button[contains(text(),'Clear')]//preceding::input"));
		 wait.until(ExpectedConditions.visibilityOf(chooseFileButton));
		 wait.until(ExpectedConditions.elementToBeClickable(chooseFileButton));
			js.executeScript("arguments[0].click();", chooseFileButton);
			System.out.println("clicked");
		// clickOnElement(chooseFileButton);
		 Thread.sleep(5000);
		String filePath ="C:\\Users\\jandh\\OneDrive\\Desktop\\Screenshot.jpg";
		copyToClipboard(filePath);
		
		 WebElement home =driver.findElement(By.linkText("Home"));
		 clickOnElement(home,"home"); WebElement nameField =
		 driver.findElement(By.id("name"));
		 wait.until(ExpectedConditions.visibilityOf(nameField));
		 clickOnElement(nameField,"nameField");
		 
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("completed");
		//closeBrowser();

	
	}
	public static void testAlert() throws InterruptedException, AWTException {
		WebElement switchToLabel = driver.findElement(By.className("dropbtn"));
		Actions action = new Actions(driver);
		Thread.sleep(4000);
		action.moveToElement(switchToLabel).perform();
		Thread.sleep(4000);
		WebElement alerts = driver.findElement(By.linkText("Alert"));
		clickOnElement(alerts,"alerts");
		Thread.sleep(4000);
		WebElement windowAlert =driver.findElement(By.className("bootbutton"));
		clickOnElement(windowAlert,"windowAlert");
	}

	public static void main(String[] args) throws InterruptedException, AWTException {

		login();
		// testMultiWindow();
		// testAutoFill();
		testFileUpload();
		//testAlert();
	}

}
