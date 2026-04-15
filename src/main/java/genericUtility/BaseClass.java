package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


import POMClasses.HomePage;
import POMClasses.LoginPage;

public class BaseClass 
{
	public WebDriver driver;
	public static WebDriver sDriver;
	public PropertiesUtility pUtil = new PropertiesUtility();
	public seleniumUtility sUtil = new seleniumUtility();
	public ExcelUtility eUtil = new ExcelUtility();
	
	@BeforeSuite(alwaysRun = true)
	public  void bsConfig()
	{
		System.out.println("Creating DB Connection");
	}
	
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void bcConfig(@Optional ("Chrome") String BROWSER) throws IOException
	{
		if(BROWSER.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else 
		{
			driver = new ChromeDriver();
		}
		sDriver = driver;
		String URL = pUtil.getDataFromProperties("url");
		sUtil.acceptApplication(driver, URL);
		sUtil.impilicitWait(driver, 15);
		sUtil.maximizeWindow(driver);
		System.out.println("Browser Launch Successfully");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
		String UN = pUtil.getDataFromProperties("username");
		String PWD = pUtil.getDataFromProperties("password");
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(UN, PWD);
		System.out.println("Login Done Successfuly");
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() 
	{
		HomePage home = new HomePage(driver);
		home.signoutOperation(driver);
		System.out.println("Logout Done Successfuly");
	}
	
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
	   driver.quit();
	   System.out.println("Close the Browser");
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.err.println("Cancle DB Connection");
	}
}
