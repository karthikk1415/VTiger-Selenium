package TestCaseRepo;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POMClasses.CreatingNewLeadPage;
import POMClasses.HomePage;
import POMClasses.Leadspage;
import genericUtility.BaseClass;

@Listeners(genericUtility.ListenersImplementation.class)
public class TC_003 extends BaseClass
{
	@Test(groups = {"Regression","System"})
	public void LE_003() throws IOException 
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnLeadsMenu();
		Leadspage lead = new Leadspage(driver);
		lead.clickOnCreateNewLeadIcon();
		String lName = eUtil.getDataFromExcelFile("leads", 7, 1);
		String company = eUtil.getDataFromExcelFile("leads", 7, 2);
		String email = eUtil.getDataFromExcelFile("leads", 7, 3);
		String city =eUtil.getDataFromExcelFile("leads", 7, 4);
		String 	state = eUtil.getDataFromExcelFile("leads", 7, 5);
		String country = eUtil.getDataFromExcelFile("leads", 7, 6);
		
		CreatingNewLeadPage cnl=new CreatingNewLeadPage(driver);
		cnl.createNewLead(lName, company, company, email, city, state, country);
	}
}
