package com.crm.Vtiger.DataDrivenExcelTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author RJ
 *
 */
public class Vtiger_FetchMultipleDataFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fileInputStream=new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook workbook=WorkbookFactory.create(fileInputStream);
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet("Sheet3");
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			Row row=sheet.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++)
			{
				Cell cell = row.getCell(j);
				String data = cell.getStringCellValue();
				System.out.println(data);
			}
		}

	}

}

