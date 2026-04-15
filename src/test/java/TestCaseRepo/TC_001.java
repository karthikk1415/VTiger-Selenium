package TestCaseRepo;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POMClasses.CreatingNewLeadPage;
import POMClasses.HomePage;
import POMClasses.Leadspage;
import genericUtility.BaseClass;

@Listeners(genericUtility.ListenersImplementation.class)
public class TC_001 extends BaseClass
{
	int i = 1;
	@Test(groups = {"Regression"} , retryAnalyzer = genericUtility.RetryAnalyzerImplementation.class)
	public void LE_001() throws IOException 
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnLeadsMenu();
		Leadspage lead = new Leadspage(driver);
		lead.clickOnCreateNewLeadIcon();
//		if(i<=3)
//		{
//			i++;
//			Assert.fail();
//		}
		
		String fName = eUtil.getDataFromExcelFile("leads", 1, 1);
		String lName = eUtil.getDataFromExcelFile("leads", 1, 2);
		String company = eUtil.getDataFromExcelFile("leads", 1, 3);
		CreatingNewLeadPage cnl=new CreatingNewLeadPage(driver);
		cnl.createNewLead(fName, lName, company);
	}

}
