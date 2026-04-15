package TestCaseRepo;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POMClasses.ContectPage;
import POMClasses.CreatingNewContectPage;
import POMClasses.HomePage;
import genericUtility.BaseClass;

@Listeners(genericUtility.ListenersImplementation.class)
public class Test_TC_005 extends BaseClass
{
	@Test(groups = {"System"})
	public void CT_005() throws IOException
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnContactMenu();
		ContectPage contect = new ContectPage(driver);
		contect.clickOnCreateNewLeadIcon();
		String lname=eUtil.getDataFromExcelFile("contact", 4, 1);
		String department=eUtil.getDataFromExcelFile("contact", 4, 2);
		String email=eUtil.getDataFromExcelFile("contact", 4, 3);
		String mobile=eUtil.getDataFromExcelFile("contact", 4, 4);
		CreatingNewContectPage cnc=new CreatingNewContectPage(driver);
		cnc.createNewContect(lname, department, email, mobile);
	}
	
}
