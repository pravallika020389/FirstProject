package NewSeleniumProject.com.SalesForce.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestCase3RememberMe {

	public static void main(String[] args) throws InterruptedException {
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
		String userId="pravallika@training.com";
		By loginid = By.id("username");
		WebElement loginidElement = driver.findElement(loginid);
		loginidElement.sendKeys(userId);
		By password =By.name("pw");
		WebElement passwordElement = driver.findElement(password);
		passwordElement.sendKeys("123ugofree");
		By rememberMeChkbox = By.name("rememberUn");
		WebElement rememberMeChkboxElement = driver.findElement(rememberMeChkbox);
		rememberMeChkboxElement.click();
		By loginButton = By.name("Login");
		WebElement loginButtonElement = driver.findElement(loginButton);
		loginButtonElement.click();
		String expectedHomeTitle="Home Page ~ Salesforce - Developer Edition";
		String actualHomeTitle=driver.getTitle();
		if(expectedHomeTitle.equals(actualHomeTitle)){
			System.out.println("Home page is displayed");
		}
		else {
			System.out.println("Home page is not displayed");
		}
		By userMenu = By.id("userNav-arrow");
		WebElement userMenuElement = driver.findElement(userMenu);
		userMenuElement.click();
		By logout =By.linkText("Logout");
		WebElement logoutElement = driver.findElement(logout);
		logoutElement.click();
		Thread.sleep(6000);
		WebElement reLoginidElement = driver.findElement(By.id("username"));
		String rememberedUserId=reLoginidElement.getAttribute("value");
		
		if(expectedHomeTitle.equals(actualHomeTitle)){
			System.out.println("Logged out sucessfully and Home page is displayed");
		}
		else {
			System.out.println("Logged out unsucessfully");
		}
		
		
	
		  if(rememberedUserId.equals(userId)){
		  System.out.println("User name is displayed in user name field, Test Psss");
		  }else {
		  System.out.println("User name is not displayed in user name field,Test Fail"); }
		 driver.close();
	}

}
