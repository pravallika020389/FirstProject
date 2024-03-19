package com.Testng.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SalesForce.Test.BaseTest;

public class DataProviderExcel extends BaseTest {
	@Test(dataProvider = "loginData")

	public static void loginValidation(String userId, String password) throws IOException {
		launchBrowser("Chrome");
		getUrl("https://login.salesforce.com");
		verifyTittle("Login | Salesforce");
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement loginidElement = driver.findElement(By.id("username"));
		wait.until(ExpectedConditions.visibilityOf(loginidElement));
		enterText(loginidElement, userId, "Wrong User Name");
		WebElement passwordElement = driver.findElement(By.name("pw"));
		enterText(passwordElement, password, "Wrong Password");
		WebElement loginButtonElement = driver.findElement(By.name("Login"));
		clickOnElement(loginButtonElement,"login");
		WebElement errorElement = driver.findElement(By.id("error"));
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		String actualErrorMsg = getText(errorElement);
		String expectedErrorMsg = "Please your username and password. If you still can't log in, contact your Salesforce administrator.";
		if (expectedErrorMsg.equals(actualErrorMsg)) {
			System.out.println("Pass : Expected error message is dispalyed");
		} else {
			System.out.println("Fail : Expected error message is not dispalyed");
			String path = System.getProperty("user.dir") + "/screenshots/" + methodName;
			takescreenshot(path);
		}
		driver.close();

	}

	@DataProvider(name = "loginData")
	public static Object[][] getData() {
		int rowCountToRead = 10;
		int columnCountToRead = 2;
		String[][] data = new String[rowCountToRead][columnCountToRead];
		File file = new File("C:\\Pravallika-java\\BasicJavaProject\\Resources\\info.xlsx");
		String sheetName = "LOGIN";
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet(sheetName);
		Iterator<Row> rows = sheet.iterator();
		int rowCount = 0;
		while (rows.hasNext() && rowCount < rowCountToRead) {
			Row row = rows.next();
			Iterator<Cell> cells = row.iterator();
			int columnCount = 0;
			while (cells.hasNext() && columnCount < columnCountToRead) {
				Cell cell = cells.next();
				data[rowCount][columnCount] = cell.getStringCellValue();
				columnCount++;
			}
			rowCount++;
		}

		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}

}
