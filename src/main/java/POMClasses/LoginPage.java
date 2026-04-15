package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is a pPOM class for Login Webpage
 * @author KARTHI
 * @version 27/03/26
 /*/
public class LoginPage 
{
	//Declarring the WebElement :
	@FindBy (name="user_name")
	private WebElement usernameTextfield;
	@FindBy (name="user_password")
	private WebElement passwordTextfield;
	@FindBy (id="submitbutton")
	private WebElement loginButton;
	
	//Initializing the WebElement
	public LoginPage (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getUsernameTextfield() 
	{
		return usernameTextfield;
	}

	public WebElement getPasswordTextfield() 
	{
		return passwordTextfield;
	}

	public WebElement getLoginButton() 
	{
		return loginButton;
	}
	
	//Utiliting the WebElement 
	
	public void loginToApplication(String UN , String PWD)
	{
		getUsernameTextfield().sendKeys(UN);
		getPasswordTextfield().sendKeys(PWD);
		getLoginButton().click();
	}
}
