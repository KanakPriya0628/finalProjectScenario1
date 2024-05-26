package config;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {

public static void capture(WebDriver driver) {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"//Screenshot//OHRM"+System.currentTimeMillis()+".png");
		
		try {
			FileHandler.copy(temp, dest);
		}catch (IOException e) {
			e.printStackTrace();
		}
//		System.out.print("Screenshot Changes ");
	}

}
