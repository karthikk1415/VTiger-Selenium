package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is a POM class for Ci=ontect Webpage
 * @author KARTHI
 * @version 27/03\2026
 */
public class ContectPage 
{
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createNewContactIcon;
	
	public ContectPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement getCreateNewContactIcon() 
	{
		return createNewContactIcon;		
	}
	public void clickOnCreateNewLeadIcon() 
	{
		getCreateNewContactIcon().click();
	}
}

