package NewSeleniumProject.com.SalesForce.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestCase1LoginError {

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
		loginidElement.sendKeys("");
		By password =By.name("pw");
		WebElement passwordElement = driver.findElement(password);
		passwordElement.clear();
		By loginButton = By.name("Login");
		WebElement loginButtonElement = driver.findElement(loginButton);
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
	
		

	}

}
