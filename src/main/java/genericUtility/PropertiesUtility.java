package genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This is an utility class which deals with Properties File
 * @author KARTHI
 * @version 26-03-20
 */
public class PropertiesUtility 
{
	/**
	 * This is a generic method to fetch data from Properties File
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getDataFromProperties(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData\\VTiger_TestData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;		
	}
	public String writeDataToProperties(String key,String value,String comment) throws IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData\\VTiger_TestData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		prop.setProperty(key,value);
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData\\VTiger_TestData.properties");
	    prop.store(fos,comment);
		return null;
	}
}
