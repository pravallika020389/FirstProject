package com.Testng.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestTrial {
	public static void main(String[] args) {
		int rowCountToRead = 11;
		int columnCountToRead  = 3;
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
				System.out.println(rowCount + "," + columnCount + "=" + data[rowCount][columnCount]);
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

	}

}
