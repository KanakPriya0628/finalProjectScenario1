package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import pages.DashboardPage;
import pages.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public DashboardPage dp;
	
	@BeforeTest
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		lp=new LoginPage(driver);
		dp=new DashboardPage(driver);
	 
	}
	
}
