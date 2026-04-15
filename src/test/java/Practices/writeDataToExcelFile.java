package Practices;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import genericUtility.ExcelUtility;

public class writeDataToExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
//		FileInputStream fis = new FileInputStream("C:\\Users\\KARTHI\\OneDrive\\Desktop\\SeleniumSheet.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh = wb.createSheet("Cars");
////		Row r = sh.getRow(1);
////		Cell c = r.getCell(3);
////		c.setCellValue("wooyoo");
//		FileOutputStream fos = new FileOutputStream("C:\\\\Users\\\\KARTHI\\\\OneDrive\\\\Desktop\\\\SeleniumSheet.xlsx");
//		wb.write(fos);
//		System.out.println("pass");
//		
		ExcelUtility eUtil = new ExcelUtility();
		eUtil.writeDataToExcelFile("Cars", 1, 3,"hahaha");
	}

}
