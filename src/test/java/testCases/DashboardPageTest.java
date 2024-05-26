package testCases;

import org.testng.annotations.Test;

public class DashboardPageTest extends BaseClass{
	
	
	@Test(priority=1)
	  public void login() 
	  {
		  lp.doLogin("Admin","admin123");
	  }
	
	 @Test(priority=2)
	  public void verifyAdmin() 
	  {
		  dp.menu();
	  }
	  
	  @Test(priority=3)
	  public void VerifyByUsername() throws InterruptedException 
	  {
		  dp.empSearchByUsername("Admin");
	  }
	  
	  @Test(priority=4)
	  public void VerifyByUserRole() throws InterruptedException
	  {
		  dp.empSearchByUserRole("Admin");
	  }
	  
	  @Test(priority=4)
	  public void VerifyByUserStatus() throws InterruptedException
	  {
		  dp.empSearchByStatus("Enabled");
	  }
}
