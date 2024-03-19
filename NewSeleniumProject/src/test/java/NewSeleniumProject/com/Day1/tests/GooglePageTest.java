package NewSeleniumProject.com.Day1.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GooglePageTest {

	public static void main(String[] args) {
		String expectedTitle="Google";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle)){
			System.out.println("title matched");
		}
		else {
			System.out.println("title not matched");
		}
		By about=By.linkText("About");
		WebElement aboutElement = driver.findElement(about);
		aboutElement.click();
		driver.close();
		

	}

}
