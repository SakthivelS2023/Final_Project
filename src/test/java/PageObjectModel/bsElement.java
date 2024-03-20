package PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test_Book.BaseClass;

public class bsElement extends BaseClass {
	
	public bsElement(WebDriver driver){
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	//Locators
	@FindBy(xpath = "//a[@href='/bookshelf?src=explore_categories']") WebElement bsElement;

	
	
	//Actions
	public void clickBookshelves() throws InterruptedException {
		Actions actions=new Actions(driver);
		actions.moveToElement(bsElement).click().perform();
		Thread.sleep(3000);
		//bsElement.click();
	}


}
