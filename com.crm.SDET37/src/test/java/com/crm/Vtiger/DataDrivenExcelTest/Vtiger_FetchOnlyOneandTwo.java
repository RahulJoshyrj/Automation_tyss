package com.crm.Vtiger.DataDrivenExcelTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Vtiger_FetchOnlyOneandTwo {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fileInputStream=new FileInputStream("./src/test/resources/testdata.xlsx");
	    Workbook workbook=WorkbookFactory.create(fileInputStream);
	    org.apache.poi.ss.usermodel.Sheet sheet= workbook.getSheet("sheet1");
	    
	    int count=sheet.getLastRowNum();
	    for(int i=0;i<=count;i++) {
	    	Row row = sheet.getRow(i);
	    	String firstcelldata=row.getCell(0).toString();
	    	String Secondcelldata=row.getCell(1).toString();
	    	System.out.println(firstcelldata+"\t"+Secondcelldata);
	    }
	}

}
