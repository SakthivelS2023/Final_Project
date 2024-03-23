
package PageObjectModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import test_Book.BaseClass;

@Listeners(utilities.ExtentReportManager.class)
public class TC_005_GiftCardFormsNegative extends BaseClass {

	WebDriver driver;

	// Constructor
	public TC_005_GiftCardFormsNegative(WebDriver driver) {
		this.driver = driver;
	}

	// Action
	public void GiftCardformNegative() throws InterruptedException, IOException {
		// Typing Money
		
		logger.info("Starting TestCase 5");
		logger.info("Typing amount");
		driver.findElement(By.xpath("//input[@class='tDZNG _16Q29']")).sendKeys("5000"); // money
		Thread.sleep(1000);

		// Clicking month
		logger.info("Clicking month");
		driver.findElement(By.xpath("//select[@class='Upz18 _1hLiD UJU2v']")).click();
		driver.findElement(By.xpath("//select[@class='Upz18 _1hLiD UJU2v']/option[3]")).click();

		// Clicking date
		logger.info("Clicking date");
		driver.findElement(By.xpath("//select[@class='Upz18 _1hLiD UJU2v'][2]")).click();
		driver.findElement(By.xpath("//select[@class='Upz18 _1hLiD UJU2v'][2]/option[3]")).click();

		// Next Button
		logger.info("Click next");
		driver.findElement(By.xpath("//button[@class='_1IFIb _1fVSi action-button _1gIUf _1XfDi']")).click();

		// inserting values for from
		logger.info("Giving from details");
		XSSFWorkbook workbook1 = null;

		try {
			FileInputStream fileInputStream = new FileInputStream(
					System.getProperty("user.dir") + "\\excel\\input.xlsx");
			workbook1 = new XSSFWorkbook(fileInputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		XSSFSheet xssfSheet = workbook1.getSheet("Sheet1");

		// Inserting value for from
		logger.info("Giving to details");
		XSSFRow row = xssfSheet.getRow(0);
		XSSFCell cell = row.getCell(0);
		String c1 = cell.getStringCellValue();

		driver.findElement(By.name("recipient_name")).sendKeys(c1);
		row = xssfSheet.getRow(1);
		cell = row.getCell(0);
		String c2 = cell.getStringCellValue();
		driver.findElement(By.name("recipient_email")).sendKeys(c2);
		row = xssfSheet.getRow(2);
		cell = row.getCell(0);
		DataFormatter dFormatter = new DataFormatter();
		String c3 = dFormatter.formatCellValue(cell);
		driver.findElement(By.name("recipient_mobile_number")).sendKeys(c3);

		// inserting value for to

		row = xssfSheet.getRow(3);
		cell = row.getCell(0);
		String c4 = cell.getStringCellValue();
		driver.findElement(By.name("customer_name")).sendKeys(c4);
		row = xssfSheet.getRow(4);
		cell = row.getCell(0);
		String c5 = cell.getStringCellValue();
		driver.findElement(By.name("customer_email")).sendKeys(c5);
		row = xssfSheet.getRow(5);
		cell = row.getCell(0);
		String c6 = dFormatter.formatCellValue(cell);
		driver.findElement(By.name("customer_mobile_number")).sendKeys(c6);
		row = xssfSheet.getRow(6);
		cell = row.getCell(0);
		String c7 = (String) cell.getStringCellValue();
		driver.findElement(By.name("customer_address")).sendKeys(c7);
		row = xssfSheet.getRow(7);
		cell = row.getCell(0);
		String c8 = dFormatter.formatCellValue(cell);
		driver.findElement(By.name("zip")).sendKeys(c8);
		row = xssfSheet.getRow(8);
		cell = row.getCell(0);
		String c9 = cell.getStringCellValue();
		driver.findElement(By.name("message")).sendKeys(c9);
		Thread.sleep(3000);

		// click confirm button
		logger.info("Clicking confirm button");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(5000);

		// Taking screenshot of error message
		logger.info("Capture error message");
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		String repName = "Error_Message-SS-" + timeStamp + ".png";
		try {
			FileUtils.copyFile(source, new File(System.getProperty("user.dir") + "\\ScreenShot\\" + repName));

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Error Message Screenshot is captured and saved successfully");
		logger.info("Ending TestCase 5");
		logger.info("***********************");

	}

}
