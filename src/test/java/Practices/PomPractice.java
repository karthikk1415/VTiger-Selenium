package Practices;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.poi.openxml4j.opc.internal.PackagePropertiesPart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import POMClasses.ContectPage;
import POMClasses.CreatingNewContectPage;
import POMClasses.CreatingNewLeadPage;
import POMClasses.HomePage;
import POMClasses.Leadspage;
import POMClasses.LoginPage;
import genericUtility.ExcelUtility;
import genericUtility.IPathUtility;
import genericUtility.PropertiesUtility;
import genericUtility.seleniumUtility;

public class PomPractice 
{
	
	@FindBy(name="user_name")
	WebElement usernameTF;

	public PomPractice(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		seleniumUtility sUtil = new seleniumUtility();
		PropertiesUtility prop=new PropertiesUtility();
		ExcelUtility eUtil = new ExcelUtility();

		String URL=prop.getDataFromProperties("url");
		String UN=prop.getDataFromProperties("username");
		String PWD=prop.getDataFromProperties("password");
		WebDriver driver = new ChromeDriver();
		sUtil.acceptApplication(driver,URL);
		sUtil.maximizeWindow(driver);
		sUtil.impilicitWait(driver, 15);	
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(UN,PWD);
		HomePage hp = new HomePage(driver);
		hp.clickOnLeadsMenu();
		Leadspage lead = new Leadspage(driver);
		lead.clickOnCreateNewLeadIcon();
		String fName = eUtil.getDataFromExcelFile("leads", 1, 1);
		String lName = eUtil.getDataFromExcelFile("leads", 1, 2);
		String company = eUtil.getDataFromExcelFile("leads", 1, 3);
		CreatingNewLeadPage cnl=new CreatingNewLeadPage(driver);
		cnl.createNewLead(fName, lName, company);
		hp.clickOnContactMenu();
		ContectPage contect = new ContectPage(driver);
		contect.clickOnCreateNewLeadIcon();
		String fname=eUtil.getDataFromExcelFile("contact", 1, 1);
		String lname=eUtil.getDataFromExcelFile("contact", 1, 2);
		String title=eUtil.getDataFromExcelFile("contact", 1, 3);
		CreatingNewContectPage cnc=new CreatingNewContectPage(driver);
		cnc.createNewContect(fname, lname, title);
		hp.signoutOperation(driver);
		driver.quit();

	}

}
