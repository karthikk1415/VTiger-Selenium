import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import genericUtility.ExcelUtility;

public class FetchingDatafromExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream ("C:\\Users\\KARTHI\\OneDrive\\Desktop\\SeleniumSheet.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Animal");
		Row r = sh.getRow(3);
		Cell c = r.getCell(3);
		String value = c.getStringCellValue();
		double value1=c.getNumericCellValue();
		System.out.println(value);
		Cell c2 = wb.getSheet("Actors").getRow(8).getCell(2);
		String value2=c2.getStringCellValue();
		System.out.println(value2);
		System.out.println("============================================");
		//Using methods
		ExcelUtility eUtil = new ExcelUtility();
		String value3=eUtil.getDataFromExcelFile("Animal", 3, 3);
		System.out.println(value3);
 	}

}
