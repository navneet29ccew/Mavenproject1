package StepsDefinition;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class OpenSteps {
	public static ExtentHtmlReporter reporter=new ExtentHtmlReporter("./ExtentReports/report1.html");
	public static ExtentReports extent=new ExtentReports();
	public static String er;
	public static String ar;
	public static String screenshot;
	
	public static WebDriver driver;
	@BeforeTest
	public static void OpenBrowser()
	{
		System.out.println("open");
		extent.attachReporter(reporter);
		ExtentTest logger1=extent.createTest("open Browser");
		logger1.log(Status.INFO,"Opening the browser");
		try
		{
			String driverPath = System.getProperty("user.dir") +"\\Drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
			logger1.log(Status.PASS,"opening pass");
		}
		catch(Exception e)
		{
			logger1.log(Status.FAIL,"opening fail");
		}
	}
	@Test
	
	public static void navigation () throws Exception
	{
		System.out.println("navigating");
		extent.attachReporter(reporter);
		ExtentTest logger2=extent.createTest("Navigating");
		logger2.log(Status.INFO,"Navigating the browser");
		try
		{
			er="Google";
			driver.navigate().to("https://www.google.com");
			ar=driver.getTitle();
			Assert.assertTrue((er.equals(ar))? true:false);
			System.out.println("Title verified");
			logger2.log(Status.PASS,"Pass title verified");
		}
		catch(AssertionError ae)
		{
			logger2.log(Status.FAIL,"title verified fail");
			System.out.println("Title verified fail");
			//logger2.log(Status.FAIL, logger2.addScreenCaptureFromPath("C:\\Users\\DELL\\Desktop\\dolphins.jpeg"));
		
			//screenshot=capture.screen();
			//logger2.addScreenCaptureFromPath("screenshot");
		}
		extent.flush();
	}
	
	@AfterTest
	public static void closeBrowser()
	{
		System.out.println("closing");
		extent.attachReporter(reporter);
		ExtentTest logger3=extent.createTest("closing");
		logger3.log(Status.INFO,"closing the browser");
		try
		{
			driver.close();
			logger3.log(Status.PASS,"Closing pass");
		}
		catch(Exception e)
		{
			logger3.log(Status.FAIL,"fail");
		}
		extent.flush();
	}
	
	
}
