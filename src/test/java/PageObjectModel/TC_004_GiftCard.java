
package PageObjectModel;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

import test_Book.BaseClass;

@Listeners(utilities.ExtentReportManager.class)
public class TC_004_GiftCard extends BaseClass {

	WebDriver driver;

	// Constructor
	public TC_004_GiftCard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locators
	@FindBy(xpath = "//*[@id='header']/section/div/ul[2]/li[3]/a")
	WebElement giftcart;
	@FindBy(xpath = "//section[@class='_14QEd']//li[3]")
	WebElement bday;

	// Action
	public void GiftCard() throws InterruptedException, IOException {
		Thread.sleep(2000);
		logger.info("Starting TestCase 4");
		// Clicking giftcard option
		logger.info("Clicking giftcard option");
		giftcart.click();
		Thread.sleep(3000);

		// Scrolling down to click birthday option
		logger.info("Scrolling down ");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(2000);

		// Clicking birthday or anniversary
		logger.info("Clicking Birthday option");
		bday.click();
		Thread.sleep(2000);
		logger.info("Ending TestCase 4");
		logger.info("*************************");

	}

}
