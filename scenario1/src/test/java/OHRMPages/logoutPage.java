package OHRMPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class logoutPage {
	
	private WebDriver driver;
	
	public logoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	private By icon = By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
	private By logout = By.linkText("Logout");
	
	
	public void getUrl() {
		String url =  driver.getCurrentUrl();
		 Assert.assertTrue(url.contains("dashboard"),"Test Case Fail : username and password not correct");
		 System.out.println("Test case Pass");
		 
	}
	
	public void logoutUser() {
		driver.findElement(icon).click();
		driver.findElement(logout).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("login"),"Test case fail : Logout didnt work");
		System.out.println("Test Case Pass");
	}
	
	

}
