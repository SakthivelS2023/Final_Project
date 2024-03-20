
package PageObjectModel;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import test_Book.BaseClass;
 
@Listeners(utilities.ExtentReportManager.class)
public class TC_001_Verify_Website extends BaseClass {
	
	WebDriver driver;
	
	
	//Constructor
	public TC_001_Verify_Website(WebDriver driver)
	{
		this.driver=driver;
	}
	

	//Locators

	
	
	//Action
	public void Verify() throws InterruptedException, IOException {
		   Thread.sleep(10000);
		   System.out.println("Urban Ladder!! Verification Under Process!!");
					// Verify the appropriate site is opened.
		   				Thread.sleep(3000);
					    if (driver.getTitle().contains("Buy Furniture Online and Get up to 50% Off | Shop Now - Urban Ladder")) {
					        System.out.println("**Urban Ladder site is opened!!**");
					    } else {
					        System.out.println("Urban Ladder site is not opened!! :(");
					       }
					 //Capture Screenshot 1
					     Thread.sleep(2000);
					     
					     try {
					 		TakesScreenshot screenshot = (TakesScreenshot) driver;
					 		File source = screenshot.getScreenshotAs(OutputType.FILE);
					 		
					 		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
					 		String repName = "HomePage-SS-" + timeStamp + ".png";
					 	
					 			FileUtils.copyFile(source,
					 					new File(System.getProperty("user.dir")+"\\ScreenShot\\"+repName));
					 		} catch (IOException e) {
					 			// TODO Auto-generated catch block
					 			e.printStackTrace();
					 		}
					 		System.out.println("HomePage Screenshot is captured and saved successfully");				 
					   
				   }
		
	}
