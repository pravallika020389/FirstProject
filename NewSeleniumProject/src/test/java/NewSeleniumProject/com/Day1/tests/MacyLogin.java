package NewSeleniumProject.com.Day1.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MacyLogin {

	public static void main(String[] args) throws InterruptedException {
		String expectedTitle="Sign In - Macy's";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://www.macys.com/account/signin");
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle)){
			System.out.println("Title matched");
		}
		else {
			System.out.println("Title not matched");
		}
		Thread.sleep(4000);
		By loginid = By.id("email");
		WebElement loginidElement = driver.findElement(loginid);
		loginidElement.sendKeys("jandhyalabharadwaj@gmail.com");
		By password =By.id("pw-input");
		WebElement passwordElement = driver.findElement(password);
	
		passwordElement.sendKeys("Chilkur@1301");
		By loginButton = By.id("sign-in");
		WebElement loginButtonElement = driver.findElement(loginButton);
		loginButtonElement.click();
		String expectedHomeTitle="My Account Dashboard";
		Thread.sleep(4000);
		String actualHomeTitle=driver.getTitle();
		if(expectedHomeTitle.equals(actualHomeTitle)){
			System.out.println("Home page is displayed and Test Case Pass ");
		}
		else {
			System.out.println("Home page is not displayed and Test Case Fail");
		}

	}

}
