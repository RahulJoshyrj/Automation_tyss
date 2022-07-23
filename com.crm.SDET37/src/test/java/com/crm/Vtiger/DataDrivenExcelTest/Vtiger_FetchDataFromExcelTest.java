package com.crm.Vtiger.DataDrivenExcelTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger_FetchDataFromExcelTest {

	public static void main(String[] args) throws IOException {
		//load the excel sheet
		 FileInputStream fileinputstream=new FileInputStream("./src/test/resources/testdata.xlsx");
		 Workbook workbook=WorkbookFactory.create(fileinputstream);
		 Sheet sheet = workbook.getSheet("Sheet1");
		 //select row 
		 Row row = sheet.getRow(4);
		 //select cell
		 Cell cell = row.createCell(2);
		 //set cell value
		 cell.setCellValue("TYSS");
		 FileOutputStream fileoutputstream=new FileOutputStream("./src/test/resources/testdata.xlsx");
		 workbook.write(fileoutputstream);
	 
	}

}
