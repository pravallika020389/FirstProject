package com.SalesForce.Test;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationScripts {
	
	
	public static void login_Error_Message_1()  throws InterruptedException {
		String expectedTitle="Login | Salesforce";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle)){
			System.out.println("Title matched");
		}
		else {
			System.out.println("Title not matched");
		}
		Thread.sleep(4000);
		By loginid = By.id("username");
		WebElement loginidElement = driver.findElement(loginid);
		Actions ac = new Actions(driver);
		ac.moveToElement(loginidElement).build().perform();
		loginidElement.sendKeys("pravallika@training.com");
		WebElement passwordElement = driver.findElement(By.name("pw"));
		passwordElement.clear();
		WebElement loginButtonElement = driver.findElement(By.name("Login"));
		loginButtonElement.click();
		By error = By.id("error");
		WebElement errorElement = driver.findElement(error);
		String ActualerrorMsg =errorElement.getText();
	//	String ActualerrorColor=errorElement.getCssValue("color");
		String ExpectedErrorMsg="Please enter your password.";
		//System.out.println(ActualerrorColor);
		if(ExpectedErrorMsg.equals(ActualerrorMsg)){
			System.out.println("Test Case Pass");
		}
		else {
			System.out.println("Test Case Fail");
		}
	driver.close();
		

	}
	public static void login_Success_2() throws InterruptedException, AWTException {
	
	String expectedTitle="Login | Salesforce";
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver(); 
	driver.manage().window().maximize();
	driver.get("https://login.salesforce.com");
	String actualTitle=driver.getTitle();
	if(expectedTitle.equals(actualTitle)){
		System.out.println("Title matched");
	}
	else {
		System.out.println("Title not matched");
	}
	Thread.sleep(4000);
	Actions ac = new Actions(driver);
	By loginid = By.id("username");
	WebElement loginidElement = driver.findElement(loginid);
	loginidElement.sendKeys("pravallika@training.com");
	By password =By.name("pw");
	WebElement passwordElement = driver.findElement(password);
	String passwordAttr=passwordElement.getAttribute("type");
	System.out.println("type value="+passwordAttr);
	passwordElement.sendKeys("123ugofree");
	By loginButton = By.name("Login");
	//WebElement loginButtonElement = driver.findElement(loginButton);
	//loginButtonElement.click();
	WebElement forgotPswd = driver.findElement(By.id("forgot_password_link"));
	ac.contextClick(forgotPswd).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	 Robot r = new Robot();
	 r.keyPress(KeyEvent.VK_ENTER);
	 
	 
	 
	/*
	 * String expectedHomeTitle="Home Page ~ Salesforce - Developer Edition"; String
	 * actualHomeTitle=driver.getTitle();
	 * if(expectedHomeTitle.equals(actualHomeTitle)){
	 * System.out.println("Home page is displayed and Test Case Pass "); } else {
	 * System.out.println("Home page is not displayed and Test Case Fail"); }
	 * 
	 * ac.moveToElement(driver.findElement(By.xpath(
	 * "//*[@id=\"bodyCell\"]/div[1]/div/div/div/a/span"))).build().perform();
	 * //driver.close();  https://dhtmlx.com/docs/products/dhtmlxTree/
	 */}
	
	public static void drag_drop() throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:\\Users\\jandh\\OneDrive\\Desktop\\Selenium\\Crx file\\Selenium-IDE.crx"));
		WebDriver driver = new ChromeDriver(options); 
		
		driver.manage().window().maximize();
		
		//driver.get("https://dhtmlx.com/docs/products/dhtmlxTree/");
		driver.get("https://www.google.com");
		
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		/*
		 * Actions ac = new Actions(driver); WebElement from =
		 * driver.findElement(By.xpath(
		 * "//*[@id=\"treeSource\"]/ul/li[1]/ul/li[1]/div/div[2]"));
		 *  WebElement to = //*[@id="sampleHeading"]
		 * driver.findElement(By.xpath("//*[@id=\"treeTarget\"]/ul"));
		 *  from.click();
		 * Thread.sleep(4000); to.click(); Thread.sleep(4000); ac.dragAndDrop(from, to);
		 */
	//	
	}
public static void frames() throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		
		
		//driver.get("https://dhtmlx.com/docs/products/dhtmlxTree/");
		driver.get("https://demoqa.com/frames");
		driver.switchTo().frame("frame1");
		String text =driver.findElement(By.xpath("//*[@id=\"sampleHeading\"]")).getText();
		System.out.println(text);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		driver.close();
		/*
		 * Actions ac = new Actions(driver); WebElement from =
		 * driver.findElement(By.xpath(
		 * "//*[@id=\"treeSource\"]/ul/li[1]/ul/li[1]/div/div[2]")); WebElement to =
		 * driver.findElement(By.xpath("//*[@id=\"treeTarget\"]/ul")); from.click();
		 * Thread.sleep(4000); to.click(); Thread.sleep(4000); ac.dragAndDrop(from, to);
		 */
	//	
	}
public static void multiFrames() throws InterruptedException {
	
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver(); 
	driver.manage().window().maximize();
	driver.switchTo().window("");

	
	//driver.get("https://dhtmlx.com/docs/products/dhtmlxTree/");
	driver.get("https://demoqa.com/frames");
	driver.switchTo().frame("frame1");
	String text =driver.findElement(By.xpath("//*[@id=\"sampleHeading\"]")).getText();
	System.out.println(text);
	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	driver.close();
}
	
	public static void cricket_table() throws InterruptedException {
		
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://www.espncricinfo.com/series/indian-premier-league-2023-1345038/chennai-super-kings-vs-gujarat-titans-qualifier-1-1370350/full-scorecard");
		Thread.sleep(4000);
	//	Actions ac = new Actions(driver);
		WebElement table = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[5]/div[1]/div/div[3]/div[1]/div[2]/div[1]/div[2]/div/div[2]/table[1]"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for(int rnum =0;rnum<rows.size();rnum++) {
			List<WebElement> header = rows.get(rnum).findElements(By.tagName("th"));
		
			  for(int head =0;head<header.size();head++) {
			  System.out.print(header.get(head).getText() +" ");
			  }
			 
			 header = rows.get(rnum).findElements(By.tagName("td"));
			for(int head =0;head<header.size();head++) {
				System.out.print(header.get(head).getText() + " ");
			}
			System.out.println();
		}
	}
	

	public static void main(String[] args) throws InterruptedException {
		
		//login_Success_2();
		//cricket_table();
		//drag_drop();
		//frames();
		login_Error_Message_1();

	}

}
