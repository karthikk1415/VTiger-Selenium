package genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * This is a generic method to fetch single cell data from Excel file
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @return
	 * @throws IOException
	 */

	public String getDataFromExcelFile(String sheetName,int rowIndex ,int cellIndex) throws IOException
	{
		
		FileInputStream fis = new FileInputStream(IPathUtility.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Cell c = wb.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex);
		DataFormatter df = new DataFormatter();
		String Value = df.formatCellValue(c);
		return Value;
		
	}
	/**
	 * This is a generic method to fetch Multiple cell data from Excel file
	 * @param sheetName
	 * @param startRowIndex
	 * @param startCellIndex
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public ArrayList<String> getMultipleDataFromExcelFile(String sheetName,int startRowIndex,int startCellIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("C:\\\\Users\\\\KARTHI\\\\OneDrive\\\\Desktop\\\\SeleniumSheet.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		DataFormatter df = new DataFormatter();
		ArrayList<String> aL=new ArrayList<String>();
		for(int i = startRowIndex;i<=sh.getLastRowNum();i++)
		{
			Row r = sh.getRow(i);
			for(int j = startCellIndex;j<r.getLastCellNum();j++)
			{
				Cell c = r.getCell(j);
				String value = df.formatCellValue(c);
				aL.add(value);
			}
		}
		return aL;
	}
	/**
	 * This is a generic method to Write the data  from Excel file
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataToExcelFile(String sheetName , int rowIndex , int cellIndex , String value) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\KARTHI\\OneDrive\\Desktop\\SeleniumSheet.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row r = sh.getRow(rowIndex);
		Cell c = r.getCell(cellIndex);
		c.setCellValue(value);
		FileOutputStream fos = new FileOutputStream("C:\\\\Users\\\\KARTHI\\\\OneDrive\\\\Desktop\\\\SeleniumSheet.xlsx");
		wb.write(fos);
	}

}
