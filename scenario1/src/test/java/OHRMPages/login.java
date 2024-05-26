package OHRMPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import config.Utilities;

public class login {

	private WebDriver driver;
	
	public login(WebDriver driver) {
		this.driver = driver;
	}
	
	private By uname = By.xpath("//input[@placeholder='username']");
	private By pswd = By.xpath("//input[@placeholder='password']");
	private By btn = By.xpath("//button[@type='submit']");
	
	
	public void loginWithData(String un,String ps) throws InterruptedException {
		driver.findElement(uname).sendKeys(un);
		driver.findElement(pswd).sendKeys(ps);
		Utilities.capture(driver);
		Thread.sleep(5000);
		
		driver.findElement(btn).click();
//		DashboardTest d1 = new DashboardTest();
//		System.out.println("Calling dashboard");
//		d1.verifyUrl();
		Thread.sleep(5000);

		Utilities.capture(driver);
		//OHRMPages.DashboardPage.getUrl()" because "this.db" is null
	}
	
}
