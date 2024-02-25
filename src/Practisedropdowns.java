import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
// import org.testng.Assert;

public class Practisedropdowns {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
		driver.manage().window().maximize();
		
		country(driver);
		city(driver);
		
	//	Assert.assertTrue(driver.findElement(By.xpath("//input[@id='autosuggest']")).getText().equalsIgnoreCase("India"));
		// driver.quit();

	}
	
	public static void country(WebDriver driver)
	{
		String ini = "IND";
		driver.findElement(By.id("autosuggest")).sendKeys(ini);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		List<WebElement> list = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
		
		for(WebElement e:list)
		{
			if(e.getText().equalsIgnoreCase("india")) {
				e.click();
				break;
			}
		}
	}

	public static void city(WebDriver driver) {
		WebDriverWait e = new WebDriverWait(driver,Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		driver.findElement(By.xpath("//div[@ID='glsctl00_mainContent_ddl_originStation1_CTNR']/table/tbody/tr[2]/td[2]/div[3]/div/div/ul[2]/li[6]")).click();
		e.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@ID='dropdownGroup1']/div/ul[3]/li[5])[2]")));
		driver.findElement(By.xpath("(//div[@ID='dropdownGroup1']/div/ul[3]/li[5])[2]")).click();
		
		
		
	}
	
}
