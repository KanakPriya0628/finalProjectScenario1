package OHRMTestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ReadData extends BaseClass{

	
	String fPath = "D:\\SeleniumJarFiles\\ExcelFiles\\MyFirstExcel1.xlsx";
	File file;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	int i,j;
	String expUrl="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index",actUrl;


//	@Test
//	public void readFromExcel() {
//		int rows = sheet.getPhysicalNumberOfRows();
//		// int cells = sheet.getRow(0).getPhysicalNumberOfCells();
//
//		System.out.println(rows);
//		// System.out.println(cells);
//
//		for (int i = 0; i < rows; i++) {
//			row = sheet.getRow(i); // it giving us rows
//			int cells = row.getPhysicalNumberOfCells(); // giving us cells how many cells in row
//			System.out.println("cells "+cells);
//
//			for (int j = 0; j < cells; j++) {
//				cell = row.getCell(j);
//				System.out.println("cell value "+cell.getStringCellValue());
//			}
//			System.out.println("un "+row.getCell(0).getStringCellValue());
//			System.out.println("ps "+row.getCell(1).getStringCellValue());
//			String username = row.getCell(0).getStringCellValue();
//			String password = row.getCell(1).getStringCellValue();
//			//lg.loginWithData(username,password);
//		}
//	}
	  @Test(dataProvider = "getLoginDetails")
	  public void loginToOHRM(String un, String ps) {
		  
		  System.out.println("username"+un+"\t"+"password"+ps); 
		  
		  driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys(un);
		  driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys(ps);
		  driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		  actUrl = driver.getCurrentUrl();
		//  Assert.assertTrue(driver.getCurrentUrl().contains("dash"), "Login fail because of invalid data");
			
		  Assert.assertEquals(actUrl,expUrl);
	  }
	  
	 @DataProvider
	  public Object[][] getLoginDetails() {
		  int rows = sheet.getPhysicalNumberOfRows();
		  System.out.println(rows); //6
		  String[][] loginData = new String[rows-1][2];
		  
		  for(i=0;i<rows-1;i++) { //0-5
			  
			  row = sheet.getRow(i+1); //1,2,3,4,5
			  
			  for(j=0;j<2;j++) {
				  
				  cell = row.getCell(j);
				  loginData[i][j] = cell.getStringCellValue();
				  System.out.println(loginData[i][j]);
			  } 
		  }
		  return loginData;
	  }

	@BeforeTest
	public void beforeTest() throws IOException {
		file = new File(fPath);
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis); // Create workbook
//	  sheet =wb.getSheet("MyFirstExcel1");  // we can use both function (if name remember)
		sheet = wb.getSheetAt(0);
	}

	@AfterTest
	public void afterTest() throws IOException {
		wb.close();
		fis.close();
	}
	
	@AfterMethod
	public void logout(ITestResult result)
	{
		if(driver.getCurrentUrl().contains("dash"))
		{
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/i")).click();
			driver.findElement(By.partialLinkText("Log")).click();
		}
		
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			test = report.createTest("Login with Valid Data");
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + ": Pass", ExtentColor.GREEN));
		}
		else if(result.getStatus() == ITestResult.FAILURE)
		{
			test = report.createTest("Login with Invalid Data");
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + ": Fail", ExtentColor.RED));
			test.fail(result.getThrowable());
		}
		if(result.getStatus() == ITestResult.SKIP)
		{
			test = report.createTest("Skipping Test Case");
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + ": Skipped", ExtentColor.YELLOW));
			test.skip(result.getThrowable()); //this give you error reason
		}
	}
}
