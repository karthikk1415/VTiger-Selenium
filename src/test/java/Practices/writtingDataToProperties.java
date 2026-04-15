package Practices;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import genericUtility.PropertiesUtility;

public class writtingDataToProperties {

	public static void main(String[] args) throws IOException 
	{
//		FileInputStream fis = new FileInputStream("C:\\Users\\KARTHI\\OneDrive\\Desktop\\Section3\\orangehrm.properties");
//		Properties prop = new Properties();
//		prop.load(fis);
//		prop.setProperty("mobile", "9080907071");
//		FileOutputStream fos = new FileOutputStream("C:\\Users\\KARTHI\\OneDrive\\Desktop\\Section3\\orangehrm.properties");
//		prop.store(fos,"Mobile Number Updated");
		PropertiesUtility pUtil=new PropertiesUtility();
		pUtil.writeDataToProperties("mobile", "9080907071","Mobile Number Updated");
		System.out.println("Done");
	}

}
