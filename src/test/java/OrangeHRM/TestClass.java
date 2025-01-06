package OrangeHRM;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class TestClass {
	WebDriver driver;
	ExtentReports extent;
	
	@BeforeSuite
	public void ExtentSetUp() {
		extent= new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("MyTestReport.html");
		
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Web Testing Automation Assessment");
		spark.config().setReportName("Nasif Sadiq");
		extent.attachReporter(spark);
		
		
	   
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		  System.setProperty("C:\\eclipse\\chrome-win64\\chrome.exe\"", "C:\\eclipse");
		     driver= new ChromeDriver();
		//System.setProperty("driver.firfox.mariontee", "C:\\eclipse");
		//  driver= new FirefoxDriver();
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		  
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  //Thread.sleep(2000);
		  String Exp_Title="OrangeHRM";
		  String Act_Title=driver.getTitle();
		  Assert.assertEquals(Exp_Title, Act_Title);
		  
	}
	
	
	@Test (priority=1)
	public void LogInTest() {
		ExtentTest test=extent.createTest("Login Functionality","Sheba Platform").assignAuthor("Nasif").assignDevice("Windows 11: Chrome Browser");
        
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));   

		PageObjectClass pm= new PageObjectClass(driver);
		
		//giving email
		pm.setUserName("Admin");
		test.info("User name:Admin");
		
		
		
		pm.setPassword("admin123");
		test.info("Password:admin123");
		
		
		pm.clickLoginBtn();
		test.info("Cliked in LogIn BTN");
		
		
		String expectedTitle="OrangeHRM";
		String actualTitle=driver.getTitle();
		if(expectedTitle.contains(actualTitle)) {
			test.pass("Log in Successful");
		}
		else {
			test.fail("Log In Failed" ,MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		}
		
		
		
	}
	@Test (priority=2)
	public void LeaveModule() throws InterruptedException {
ExtentTest test=extent.createTest("Login Functionality","Sheba Platform").assignAuthor("Nasif").assignDevice("Windows 11: Chrome Browser");
        
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));   

		PageObjectClass pm= new PageObjectClass(driver);
		
		//giving email
		pm.setUserName("Admin");
		test.info("User name:Admin");
		
		
		
		pm.setPassword("admin123");
		test.info("Password:admin123");
		
		
		pm.clickLoginBtn();
		test.info("Cliked in LogIn BTN");
		
		
		String expectedTitle="OrangeHRM";
		String actualTitle=driver.getTitle();
		if(expectedTitle.contains(actualTitle)) {
			test.pass("Log in Successful");
		}
		else {
			test.fail("Log In Failed" ,MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		}
		
		pm.ClickLeave();
		test.info("Clicked Leave Module");
		
		pm.ClickLApply();
		test.info("Clicked Leave Apply Page");
		test.fail("No Leave Types with Leave Balance" ,MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());

		
	/*	Thread.sleep(2000);
		
		pm.SelectingLeaveType();
		test.info("Clicking leave type from dropdown" ,MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());

		pm.clickingleavetype();
		test.info("Choice a leave type from dropdown" ,MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
	*/	
		
	}
	
	
	@AfterMethod
	public void tearDown1() {
		
		driver.close();
		driver.quit();
		
	}
	@AfterSuite
	public void tearDwon() {
		extent.flush();
		
	}
	public String getBase64() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}

}
