package OHRMTestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class LogoutTest extends BaseClass {

	@Test(priority=1)
	public void doLogin() throws InterruptedException {
		lg.loginWithData("Admin","admin123");
	}
	
	@Test(priority=2)
	public void verifyUrl() {
		lp.getUrl();
	}

	@Test(priority=3)
	public void doLogout() {
	  lp.logoutUser();
	}
	
}
