package TestPractice;

import java.io.IOException;

import org.testng.annotations.Test;

import POMClasses.CreatingNewLeadPage;
import POMClasses.HomePage;
import POMClasses.Leadspage;
import genericUtility.BaseClass;

public class testNGAnnotationoperation extends BaseClass
{
	@Test
	public void annotationOperation() throws IOException 
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnLeadsMenu();
		Leadspage lead = new Leadspage(driver);
		lead.clickOnCreateNewLeadIcon();
		String fName = eUtil.getDataFromExcelFile("leads", 1, 1);
		String lName = eUtil.getDataFromExcelFile("leads", 1, 2);
		String company = eUtil.getDataFromExcelFile("leads", 1, 3);
		CreatingNewLeadPage cnl=new CreatingNewLeadPage(driver);
		cnl.createNewLead(fName, lName, company);
	}
}
