import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Practisedropdowns {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
		driver.manage().window().maximize();
		
		country(driver);
		
	//	Assert.assertTrue(driver.findElement(By.xpath("//input[@id='autosuggest']")).getText().equalsIgnoreCase("India"));
		driver.quit();

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

}
