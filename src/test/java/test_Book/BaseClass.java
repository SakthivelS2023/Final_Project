package test_Book;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import test_Book.POM.bsElement;
import test_Book.POM.TC_001_Verify_Website;
import test_Book.POM.TC_002_DisplayBookShelves;
import test_Book.POM.TC_003_FilterBookShelves;
import test_Book.POM.TC_004_GiftCard;
import test_Book.POM.TC_005_GiftCardFormsNegative;
import test_Book.POM.TC_006_GiftCardFormsPositive;

@Listeners(utilities.ExtentReportManager.class)
public class BaseClass  {
	static public WebDriver driver;
	protected bsElement pom;
	@BeforeTest
	@Parameters({ "Browser", "Url" })
	void setup_Browser(String browser, String appUrl) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			driver.quit();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(5));
		driver.get(appUrl);
		// Maximize the window.
		driver.manage().window().maximize();
	}
//*********************************************************************************************************************	
	
	
	@Test(priority = 1,groups = {"Sanity"})
	   void VerifyWebsite() throws InterruptedException, IOException {
		   System.out.println("==========================================================================");
		   System.out.println("TC_001_Verify_Website");
		   System.out.println("==========================================================================");
		   TC_001_Verify_Website pageObjectModel = new TC_001_Verify_Website(driver);
		   pageObjectModel.Verify();
	   }

	@Test(priority = 2 ,groups = {"Sanity","Regression"})
	void displayBookShelves() throws InterruptedException, IOException {
		System.out.println("==========================================================================");
		System.out.println("TC_002_DisplayBookShelves");
		System.out.println("==========================================================================");
		TC_002_DisplayBookShelves pageObjectModel = new TC_002_DisplayBookShelves(driver);
		   pageObjectModel.DisplayBookShelves();
		
	}

	@Test(priority = 3,groups = {"Sanity","Regression"})
	void ByAtHome() throws InterruptedException, IOException {
		System.out.println("==========================================================================");
		System.out.println("TC_003_FilterBookShelves");
		System.out.println("==========================================================================");
		TC_003_FilterBookShelves pageObjectModel = new TC_003_FilterBookShelves(driver);
		   pageObjectModel.FilterBookShelves();
		
	}

	@Test(priority = 4,groups = {"Sanity"} )
	void giftCard() throws InterruptedException, IOException {
		System.out.println("==========================================================================");
		System.out.println("TC_004_GiftCard");
		System.out.println("==========================================================================");
		TC_004_GiftCard pageObjectModel = new TC_004_GiftCard(driver);
		   pageObjectModel.GiftCard();
	}
	
	@Test(priority = 5 ,groups = {"Sanity","Regression"})
	void giftCardformNegative() throws InterruptedException, IOException {
		System.out.println("==========================================================================");
		System.out.println("TC_005_GiftCardFormNegative");
		System.out.println("==========================================================================");
		TC_005_GiftCardFormsNegative pageObjectModel = new TC_005_GiftCardFormsNegative(driver);
		   pageObjectModel.GiftCardformNegative();
	}
	
	@Test(priority = 6,groups = {"Sanity","Regression"})
	void giftCardformPositive() throws InterruptedException, IOException {
		System.out.println("==========================================================================");
		System.out.println("TC_006_GiftCardFormPositive");
		System.out.println("==========================================================================");
		TC_006_GiftCardFormsPositive pageObjectModel = new TC_006_GiftCardFormsPositive(driver);
		   pageObjectModel.GiftCardformPositive();
	}

	@AfterTest
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
