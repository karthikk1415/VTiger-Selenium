package TestCaseRepo;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POMClasses.ContectPage;
import POMClasses.CreatingNewContectPage;
import POMClasses.HomePage;
import genericUtility.BaseClass;

@Listeners(genericUtility.ListenersImplementation.class)
public class TC_004 extends BaseClass
{
	@Test(groups = "Smoke")
	public void CT_004() throws IOException
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnContactMenu();
		ContectPage contect = new ContectPage(driver);
		contect.clickOnCreateNewLeadIcon();
		String fname=eUtil.getDataFromExcelFile("contact", 1, 1);
		String lname=eUtil.getDataFromExcelFile("contact", 1, 2);
		String title=eUtil.getDataFromExcelFile("contact", 1, 3);
		CreatingNewContectPage cnc=new CreatingNewContectPage(driver);
		cnc.createNewContect(fname, lname, title);
		System.out.println("Done");
		}
}
