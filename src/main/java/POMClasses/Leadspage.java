package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Leadspage 
{
	@FindBy(xpath = "//img[@title='Create Lead...']")
	private WebElement createNewLocation;
	
	public Leadspage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getCreateNewLeadIcon() {
		return createNewLocation;
	}
	
	/**
	 * This is a business library to click on Create new lead icon
	 */
	public void clickOnCreateNewLeadIcon() {
		getCreateNewLeadIcon().click();
	}
}

