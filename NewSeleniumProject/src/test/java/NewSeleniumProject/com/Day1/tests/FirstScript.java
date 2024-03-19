package NewSeleniumProject.com.Day1.tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstScript {

	public static void main(String[] args) throws InterruptedException {
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
		By searchBox= By.name("q");
		WebElement searchBoxElement =driver.findElement(searchBox);
		searchBoxElement.clear();
		searchBoxElement.sendKeys("selenium");
		Thread.sleep(4000);
		By searchButton = By.className("gNO89b");
		WebElement searchButtonElement =driver.findElement(searchButton);
		searchButtonElement.click();
		String expectedSearchTitle="selenium - Google Search";
		String actualSearchTitle=driver.getTitle();
				if(expectedSearchTitle.equals(actualSearchTitle)){
					System.out.println("Landed in search page");
				}
				else {
					System.out.println("not Landed in search page");
				}
				driver.close();
;
		}

}
