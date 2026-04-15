package genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener
{
	ExtentReports reports;
	ExtentTest test;
	javaUtility jUtil = new javaUtility();
	String dateTimeStamp = jUtil.getCalendarDetails("dd-MM-yyyy hh-mm-ss");

	@Override
	public void onTestStart(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"on test start executed");
		
		//Creating fields for every @TEst metyhod in the rpoert
		test=reports.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"on test success executed");
		
		//Logging the Status as PASS for test method
		test.log(Status.PASS, methodName+"Successfukky Executed");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	
	{
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"on test failure executed");
		
		//Logging the Status as FAIL
		test.log(Status.FAIL,methodName+"-->Failed");
		test.log(Status.INFO,result.getThrowable());
		
		String screenShotNmae = methodName+"-"+dateTimeStamp;
		seleniumUtility sUtil = new seleniumUtility();
		try 
		{
			String path=sUtil.webpageScreenshot(BaseClass.sDriver, screenShotNmae);
			//Attaching the ScreenShot in the failed test in report
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"on test skipped executed");
		
		//Logging thr Sy=tatus as SKIP
		test.log(Status.SKIP,methodName+"-->Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) 
	{
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) 
	{
		System.out.println("on  tart executed");
		
		//Configuring the Extent Report
		ExtentSparkReporter reporter = new ExtentSparkReporter(".\\ExtendsReport\\report"+ dateTimeStamp+".html");
		reporter.config().setDocumentTitle("Extent Report");
		reporter.config().setReportName("VTiger Report");
		reporter.config().setTheme(Theme.DARK);
		
		//Generate an Empty Report
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Base URL","http://localhost:8888");
		reports.setSystemInfo("Base browser", "chrome");
		reports.setSystemInfo("Base Platform", "Windows");
		reports.setSystemInfo("Test Engineer", "Karthi");
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		System.out.println("on start executed");
		//Finishing the report
		reports.flush();
	}
	
}
