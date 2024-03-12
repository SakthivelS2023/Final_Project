
package test_Book.POM;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;

import test_Book.BaseClass;
@Listeners(utilities.ExtentReportManager.class)
public class TC_002_DisplayBookShelves extends BaseClass {
	
	WebDriver driver;
	
	//Constructor
	public TC_002_DisplayBookShelves(WebDriver driver)
	{
		this.driver=driver;
	}
	

	//Locators

	
	
	//Action
	public void DisplayBookShelves() throws InterruptedException, IOException {
		pom = new bsElement(driver);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(3000);
		// click on bookshelves icon.
		pom.clickBookshelves();
		// driver.findElement(By.xpath("//a[@href='/bookshelf?src=explore_categories']")).click();
		Thread.sleep(3000);
		// click to close login Pop up!
		// pom1.closePopup();
		driver.findElement(By.xpath("//*[@id=\"authentication_popup\"]/div/div/div[2]/a[1]")).click();
		Thread.sleep(5000);
		
		WebElement pricElement=driver.findElement(By.xpath("//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[1]"));
		Actions actions=new Actions(driver);
		actions.moveToElement(pricElement).build().perform();
		WebElement element = driver.findElement(By.xpath("//div[@class='noUi-handle noUi-handle-upper']"));
		actions.moveToElement(element).dragAndDropBy(element, -273, 0).perform();
		Thread.sleep(3000);
		
		// pom1.clickStorageType();
		driver.findElement(By.xpath("//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[2]/div[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value='Open']")).click();
		Thread.sleep(5000);
		// pom1.clickOutOfStack();
		driver.findElement(By.xpath("//input[@value='In Stock Only']")).click();
		Thread.sleep(5000);
		// Display the name and Price of available Bookshelves Excluding out of stock.
		List<WebElement> Nameofproduct = driver.findElements(By.xpath("//span[@class='name']"));
		List<WebElement> Priceofproduct = driver.findElements(By.xpath("//div[@class='price-number']/span"));
		System.out.println("Number of Product Available " + Nameofproduct.size());
		if (Nameofproduct.size() == 0) {
			System.out.println("No product");
		} else {
			// Top 3 Products.
			System.out.println("Name of Product: ");
			for (int i = 0; i < 3; i++) {
				System.out.println(Nameofproduct.get(i).getText() + "  " + Priceofproduct.get(i).getText());
			}
		}
		Thread.sleep(5000);
		// Extract the Name and Price of available product on the Excel Sheet.
		// Apache POI implemented here.
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\excel\\output1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		for (int i = 0; i < 3; i++) {
			String name = Nameofproduct.get(i).getText();
			String price = Priceofproduct.get(i).getText();
			XSSFRow currentrow = sheet.createRow(i);
			XSSFCell cell = currentrow.createCell(0);
			XSSFCell cell1 = currentrow.createCell(1);
			cell.setCellValue(name);
			cell1.setCellValue(price);
		}
		workbook.write(file);
		workbook.close();
		file.close();
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(3000);
		// Taking ScreenShot of Bookshelves
		try {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "BookShelves-SS-" + timeStamp + ".png";
	
			FileUtils.copyFile(source,
					new File(System.getProperty("user.dir")+"\\ScreenShot\\"+repName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("BookShelves Screenshot is captured and saved successfully");
	}
 }
		
