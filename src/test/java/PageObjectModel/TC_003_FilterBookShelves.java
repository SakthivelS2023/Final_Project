
package PageObjectModel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;

import test_Book.BaseClass;
@Listeners(utilities.ExtentReportManager.class)
public class TC_003_FilterBookShelves extends BaseClass {
	
	WebDriver driver;
	
	//Constructor
	public TC_003_FilterBookShelves(WebDriver driver)
	{
		this.driver=driver;
	}
	

	//Locators
	
	
	
	//Action
	public void FilterBookShelves() throws InterruptedException, IOException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value='In Stock Only']")).click();
		Thread.sleep(5000);
		WebElement priceElement=driver.findElement(By.xpath("//div[normalize-space()='Brand']"));
		Actions actions=new Actions(driver);
		actions.moveToElement(priceElement).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"filters_brand_name_By_Bahcane\"]")).click();
		Thread.sleep(3000);
		System.out.println("List of products in by at home:");
		List<WebElement> Nameofproduct = driver.findElements(By.xpath("//span[@class='name']"));
		List<WebElement> Priceofproduct = driver.findElements(By.xpath("//div[@class='price-number']/span"));
		System.out.println("Number of Product Available " + Nameofproduct.size());
		if (Nameofproduct.size() == 0) {
			System.out.println("No product");
		} else {
			// Top 3 Products.
			System.out.println("Name of Product: ");
			for (int i = 0; i < Nameofproduct.size(); i++) {
				System.out.println(Nameofproduct.get(i).getText() + "  " + Priceofproduct.get(i).getText());
			}
		}
		Thread.sleep(3000);
		// Extract the Name and Price of available product on the Excel Sheet.
		// Apache POI implemented here.
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\excel\\output2.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		for (int i = 0; i < Nameofproduct.size(); i++) {
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

		actions.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(10000);
		
}
}		
