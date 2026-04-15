package Practices;

import org.openqa.selenium.chrome.*;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import genericUtility.PropertiesUtility;

public class fetchingDataFromPropertiesFile {

	public static void main(String[] args) throws IOException 
	{
		PropertiesUtility pUtil = new  PropertiesUtility();
		String URL = pUtil.getDataFromProperties("url");
		String UN = pUtil.getDataFromProperties("username");
		String PWD = pUtil.getDataFromProperties("password");
		System.out.println(UN);
		System.out.println(PWD);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get(URL);
		driver.findElement(By.name("username")).sendKeys(UN,Keys.TAB,PWD,Keys.ENTER);
	}

}
