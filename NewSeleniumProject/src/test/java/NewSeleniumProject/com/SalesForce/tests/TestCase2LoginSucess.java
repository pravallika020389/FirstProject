package NewSeleniumProject.com.SalesForce.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestCase2LoginSucess {

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
		By loginid = By.id("username");
		WebElement loginidElement = driver.findElement(loginid);
		loginidElement.sendKeys("pravallika@training.com");
		By password =By.name("pw");
		WebElement passwordElement = driver.findElement(password);
		String passwordAttr=passwordElement.getAttribute("type");
		System.out.println("type value="+passwordAttr);
		passwordElement.sendKeys("123ugofree");
		By loginButton = By.name("Login");
		WebElement loginButtonElement = driver.findElement(loginButton);
		loginButtonElement.click();
		String expectedHomeTitle="Home Page ~ Salesforce - Developer Edition";
		String actualHomeTitle=driver.getTitle();
		if(expectedHomeTitle.equals(actualHomeTitle)){
			System.out.println("Home page is displayed and Test Case Pass ");
		}
		else {
			System.out.println("Home page is not displayed and Test Case Fail");
		}

	}

}
