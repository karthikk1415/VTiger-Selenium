package TestCaseRepo;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POMClasses.CreatingNewLeadPage;
import POMClasses.HomePage;
import POMClasses.Leadspage;
import genericUtility.BaseClass;

@Listeners(genericUtility.ListenersImplementation.class)
public class Test_TC_002 extends BaseClass
{
	@Test(groups = {"system","Smoke"})
	
	public void LE_002() throws IOException 
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnLeadsMenu();
		Leadspage lead = new Leadspage(driver);
		lead.clickOnCreateNewLeadIcon();
		String lName = eUtil.getDataFromExcelFile("leads", 4, 1);
		String company = eUtil.getDataFromExcelFile("leads", 4, 2);
		String title = eUtil.getDataFromExcelFile("leads", 4, 3);
		String leadSource =eUtil.getDataFromExcelFile("leads", 4, 4);
		String noOfEmp = eUtil.getDataFromExcelFile("leads", 4, 5);
		
		CreatingNewLeadPage cnl=new CreatingNewLeadPage(driver);
		cnl.createNewLead(lName, company, title, leadSource, noOfEmp);
	}
	@Test
	public void m1()
	{
		System.out.println("Mass Karthi");
	}
}
