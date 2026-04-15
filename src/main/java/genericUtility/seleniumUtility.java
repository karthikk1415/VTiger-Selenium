package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This is a utilitu class whichj stored the functionality from selenium
 */

public class seleniumUtility {
	
	/**
	 * This is a generic to accept the application 
	 * @param driver
	 * @param URL
	 */
	public void acceptApplication(WebDriver driver , String URL)
	{
		driver.get(URL);
	}
	
	/**
	 * This is a generic method to maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This is a generic method to give implicit wait
	 * @param driver
	 * @param maxTIme
	 */
	public void impilicitWait(WebDriver driver , int maxTIme)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(maxTIme));
	}
	
	/**
	 * This is a generic method to Refresh the current page
	 * @param driver
	 */
	public void refreshWebpage(WebDriver driver)
	{
		driver.navigate().refresh();
	}
	/**
	 * This is a generic method to wait for Element Explicitly
	 * @param driver
	 * @param maxTime
	 * @param by
	 */
	public void waitForElementToVisible(WebDriver driver,int maxTime,By by)
	{
		WebDriverWait wait =new  WebDriverWait (driver,Duration.ofSeconds(maxTime));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	}
	
	/**
	 * This is a generic method to Scroll the Webpage
	 * @param driver
	 * @param element
	 */
	public void scrollingOperation(WebDriver driver , WebElement element)
	{
		Actions act = new Actions (driver);
		act.scrollToElement(element).perform();;
	}
	
	/**
	 * This is a generic method to perform mouse hovering action
	 * @param driver
	 * @param element
	 */
	public void mouseHoverring(WebDriver driver , WebElement element)
	{
		Actions act = new Actions (driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This is a generic method to perform double click operation
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver , WebElement element)
	{
		Actions act = new Actions (driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This is a generic method to select  an option in dropdown using value attributes
	 * @param dropdownEle
	 * @param value
	 * 
	 */
	public void selectOptionByValue(WebElement dropdownEle , String value)
	{
		Select sel = new Select (dropdownEle);
		sel.selectByValue(value);
	}
	
	/**
	 * This is a generic method to select  an option in dropdown using index
	 * @param dropdownEle
	 * @param value
	 */
	public void selectOptionByIndex(WebElement dropdownEle , int index)
	{
		Select sel = new Select (dropdownEle);
		sel.selectByIndex(index);
	}
	
	/**
	 * This is a generic method to switch the control inside a frame
	 * @param driver
	 * @param frameIndex
	 */
	public void switchToFrameUsingindex(WebDriver driver,int frameIndex)
	{
		driver.switchTo().frame(frameIndex);
	}
	
	/**
	 * This is a generic method to switch the control inside a frame
	 * @param driver
	 * @param frameIndex
	 */
	public void switchToFrameUsingnameOrId(WebDriver driver,String nameOriD)
	{
		driver.switchTo().frame(nameOriD);
	}
	
	/**
	 * This is a generic method to switch the control inside a frame
	 * @param driver
	 * @param frameIndex
	 */
	public void switchToFrameUsingFrameEle (WebDriver driver,WebElement frameEle)
	{
		driver.switchTo().frame(frameEle);
	}
	
	/**
	 * This is a generic method to dismiss the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This is a generic method to switch the control to 2nd tab
	 * @param driver
	 */
	public void switchToSecondTab(WebDriver driver)
	{
		String pid = driver.getWindowHandle();
		Set<String> allids = driver.getWindowHandles();
		for(String id:allids)
		{
			if(!id.equals(pid))
			{
				driver.switchTo().window(id);
			}
		}
	}
	
	/**
	 * This is a generic method to Upload a file
	 * @param FileUploadEle
	 * @param filePath
	 */
	public void uploadFile(WebElement FileUploadEle ,String filePath)
	{
		FileUploadEle.sendKeys(filePath);
	}
	
	/**
	 * This is a generic method to capture webpage screenshot
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String webpageScreenshot (WebDriver driver , String screenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\ScreenShot\\"+screenshotName+".jpg");
		Files.copy(src, dest);
		return dest.getAbsolutePath();
		
	}
	
}
