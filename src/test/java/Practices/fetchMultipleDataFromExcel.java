package Practices;


import java.io.IOException;

import java.util.List;

import org.apache.poi.EncryptedDocumentException;


import genericUtility.ExcelUtility;

public class fetchMultipleDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		ExcelUtility eUtil = new ExcelUtility();
		List<String> value = eUtil.getMultipleDataFromExcelFile("Birds", 1 , 1 );
		System.out.println(value);	
	}
}
