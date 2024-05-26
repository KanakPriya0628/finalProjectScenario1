package OHRMTestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import OHRMPages.login;
import OHRMPages.logoutPage;
import OHRMTestCases.ReadData;

public class BaseClass {
	
	public WebDriver driver;
	public login lg;

	public logoutPage lp;
	public ReadData rd;
	
	ExtentSparkReporter htmlReporter;
	ExtentReports report;
	ExtentTest test;
	
  @BeforeTest
  public void pageOpen() {
		htmlReporter = new ExtentSparkReporter("Reports\\OrangeHRMTestResult.html");
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		
		report.setSystemInfo("Machine Name", "Dell");
		report.setSystemInfo("OS", "Windows 11");
		report.setSystemInfo("User", "Kanak");
		report.setSystemInfo("Browser", "Google Chrome");
		report.setSystemInfo("Processor", "Intel(R) Core(TM) i5-7300U CPU @ 2.60GHz   2.70 GHz");

		// Configuration for look of report
		htmlReporter.config().setDocumentTitle("My First Report");
		htmlReporter.config().setReportName("Google Title Report");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setTimeStampFormat("EEEE MMMM dd yyyy, hh:mm a '('zzz')'");
		
	  	driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		lg = new login(driver);
		lp = new logoutPage(driver);
		rd = new ReadData();
	
  }
  
//  @BeforeClass
//  public void pageSetUp() {  
//	 lg.loginWithData("Admin","admin123");
//  }
  
//  @Test(dataProvider="getLoginDetails",dataProviderClass = OHRMTestCases.ReadData.class)
//  public void demo(String un,String ps) {
//	  System.out.println("username =" +un);
//	  System.out.println("password =" +ps);
//  }
  
  @AfterTest
  public void close() {
//	  driver.quit();
	  report.flush();
  }
  
}
