package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.seleniumUtility;

public class HomePage 
{

	@FindBy(xpath="//td[@class=\"tabUnSelected\"]/a[text()='Leads']")
	private WebElement leadsMenu;
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactMenu;
	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement accountIcon;
	@FindBy(xpath ="//a[text()='Sign Out']")
	private WebElement signoutButton;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getLeadsMenu() 
	{
		return leadsMenu;
	}
	public WebElement getContactMenu() 
	{
		return contactMenu;
	}
	public WebElement getAccountIcon() 
	{
		return accountIcon;
	}
	public WebElement getSignoutButton() 
	{
		return signoutButton;
	}
	public void clickOnLeadsMenu()
	{
		getLeadsMenu().click();
	}
	public void clickOnContactMenu()
	{
		getContactMenu().click();
	}
	public void signoutOperation(WebDriver driver)
	{
		seleniumUtility sUtil = new seleniumUtility();
		sUtil.mouseHoverring(driver,getAccountIcon());
		getSignoutButton().click();
	}
	
}
