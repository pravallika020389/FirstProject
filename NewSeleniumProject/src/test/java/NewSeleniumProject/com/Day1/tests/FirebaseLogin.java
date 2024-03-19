package NewSeleniumProject.com.Day1.tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirebaseLogin {

	public static void main(String[] args) throws InterruptedException {
		String expectedTitle="Selenium";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://qa-tekarch.firebaseapp.com/");
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle)){
			System.out.println("title matched");
		}
		else {
			System.out.println("title not matched");
		}
		Thread.sleep(4000);
		By userId= By.id("email_field");
		WebElement useridElement =driver.findElement(userId);
		useridElement.sendKeys("admin123@gmail.com");
		By password= By.id("password_field");
		WebElement passwordElement =driver.findElement(password);
		passwordElement.sendKeys("admin123");
		By loginButton= By.tagName("button");
		WebElement loginButtonElement = driver.findElement(loginButton);
		loginButtonElement.click();
		
		/*By searchButton = By.className("gNO89b");
		WebElement searchButtonElement =driver.findElement(searchButton);
		searchButtonElement.click();
		String expectedSearchTitle="selenium - Google Search";
		String actualSearchTitle=driver.getTitle();
				if(expectedSearchTitle.equals(actualSearchTitle)){
					System.out.println("Landed in search page");
				}
				else {
					System.out.println("not Landed in search page");
				}*/
			//	driver.close();
;
		}

}
