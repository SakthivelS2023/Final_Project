package test_Book;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjectModel.TC_001_Verify_Website;
import PageObjectModel.TC_002_DisplayBookShelves;
import PageObjectModel.TC_003_FilterBookShelves;
import PageObjectModel.TC_004_GiftCard;
import PageObjectModel.TC_005_GiftCardFormsNegative;
import PageObjectModel.TC_006_GiftCardFormsPositive;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(utilities.ExtentReportManager.class)
public class BaseClass  {
	static public WebDriver driver;
	public  static Logger logger;
	@BeforeSuite(alwaysRun = true)
	@Parameters({ "Browser", "Url" })
	void setup_Browser(String browser, String appUrl) {
		
		logger=LogManager.getLogger(this.getClass());
		
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			driver.quit();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
		driver.get(appUrl);
		// Maximize the window.
		driver.manage().window().maximize();
	}
//*********************************************************************************************************************	
	
	
	@Test(priority = 1,groups = {"Smoke test","Master test"})
	   void VerifyWebsite() throws InterruptedException, IOException {
		   System.out.println("==========================================================================");
		   System.out.println("TC_001_Verify_Website");
		   System.out.println("==========================================================================");
		   TC_001_Verify_Website pageObjectModel = new TC_001_Verify_Website(driver);
		   pageObjectModel.Verify();
	   }

	@Test(priority = 2,groups = {"Sanity test","Regression test","Master test"})
	void displayBookShelves() throws InterruptedException, IOException {
		System.out.println("==========================================================================");
		System.out.println("TC_002_DisplayBookShelves");
		System.out.println("==========================================================================");
		TC_002_DisplayBookShelves pageObjectModel = new TC_002_DisplayBookShelves(driver);
		   pageObjectModel.DisplayBookShelves();
		
	}

	@Test(priority = 3,groups = {"Regression test","Master test"})
	void ByAtHome() throws InterruptedException, IOException {
		System.out.println("==========================================================================");
		System.out.println("TC_003_FilterBookShelves");
		System.out.println("==========================================================================");
		TC_003_FilterBookShelves pageObjectModel = new TC_003_FilterBookShelves(driver);
		   pageObjectModel.FilterBookShelves();
		
	}

	@Test(priority = 4,groups = {"Sanity test","Master test" })
	void giftCard() throws InterruptedException, IOException {
		System.out.println("==========================================================================");
		System.out.println("TC_004_GiftCard");
		System.out.println("==========================================================================");
		TC_004_GiftCard pageObjectModel = new TC_004_GiftCard(driver);
		   pageObjectModel.GiftCard();
	}
	
	@Test(priority = 5,groups = {"Sanity test","Regression test","Master test"} )
	void giftCardformNegative() throws InterruptedException, IOException {
		System.out.println("==========================================================================");
		System.out.println("TC_005_GiftCardFormNegative");
		System.out.println("==========================================================================");
		TC_005_GiftCardFormsNegative pageObjectModel = new TC_005_GiftCardFormsNegative(driver);
		   pageObjectModel.GiftCardformNegative();
	}
	
	@Test(priority = 6,groups = { "Sanity test","Regression test","Master test"})
	void giftCardformPositive() throws InterruptedException, IOException {
		System.out.println("==========================================================================");
		System.out.println("TC_006_GiftCardFormPositive");
		System.out.println("==========================================================================");
		TC_006_GiftCardFormsPositive pageObjectModel = new TC_006_GiftCardFormsPositive(driver);
		   pageObjectModel.GiftCardformPositive();
	}
//******************************************************************************************************************
	@AfterSuite(alwaysRun = true)
	void close_Browser() {
		driver.quit();
	}

	public String captureScreen(String name) {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\ExtentReport-SS\\" +name+  "ExtentReport_SS" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}


	

}
