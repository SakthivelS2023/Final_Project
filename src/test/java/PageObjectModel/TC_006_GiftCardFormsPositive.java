
package PageObjectModel;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import test_Book.BaseClass;

@Listeners(utilities.ExtentReportManager.class)
public class TC_006_GiftCardFormsPositive extends BaseClass {

	WebDriver driver;

	// Constructor
	public TC_006_GiftCardFormsPositive(WebDriver driver) {
		this.driver = driver;
	}

	

	// Action
	public void GiftCardformPositive() throws InterruptedException, IOException {

		// Clearing the invalid input
		logger.info("Starting TestCase 6");
		Thread.sleep(5000);
		logger.info("Clearing invalid input");
		driver.findElement(By.name("recipient_email")).clear();

		// Sending new input
		logger.info("Giving valid input");
		driver.findElement(By.name("recipient_email")).sendKeys("Sakthi@gmail.com");

		// Clicking submit
		logger.info("Clicking submit");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(5000);

		// Taking screenshot of giftcard confirm page
		logger.info("Taking Screenshot");
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		String repName = "GiftCard-SS-" + timeStamp + ".png";
		try {
			FileUtils.copyFile(source, new File(System.getProperty("user.dir") + "\\ScreenShot\\" + repName));

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("GiftCard Screenshot is captured and saved successfully");
		logger.info("Ending TestCase 6");
		logger.info("********************");
	}

}
