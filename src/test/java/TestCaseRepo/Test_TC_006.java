package TestCaseRepo;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POMClasses.ContectPage;
import POMClasses.CreatingNewContectPage;
import POMClasses.HomePage;
import genericUtility.BaseClass;

@Listeners(genericUtility.ListenersImplementation.class)
public class Test_TC_006 extends BaseClass
{
	@Test(groups = {"System","Smoke"})
	public void CT_006() throws IOException
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnContactMenu();
		ContectPage contect = new ContectPage(driver);
		contect.clickOnCreateNewLeadIcon();
		String lname=eUtil.getDataFromExcelFile("contact", 7, 1);
		String title=eUtil.getDataFromExcelFile("contact", 7, 2);
		String mobile=eUtil.getDataFromExcelFile("contact", 7, 3);
		String email=eUtil.getDataFromExcelFile("contact", 7, 4);
		String mailingCity=eUtil.getDataFromExcelFile("contact", 7, 5);
		String mailingState=eUtil.getDataFromExcelFile("contact", 7, 6);
		String mailingCountry=eUtil.getDataFromExcelFile("contact", 7, 7);
		CreatingNewContectPage cnc=new CreatingNewContectPage(driver);
		cnc.createNewContect(lname, title, mobile, email, mailingCity, mailingState, mailingCountry);
	}
	
}
