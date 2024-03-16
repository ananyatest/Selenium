import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Assignment8 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		String text = "uni";
		driver.findElement(By.id("autocomplete")).sendKeys(text);
		Actions a= new Actions(driver);
		a.keyDown(Keys.ARROW_DOWN).build().perform();
		a.keyDown(Keys.ARROW_DOWN).build().perform();
		List<WebElement> list = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
		Assert.assertEquals(driver.findElement(By.id("autocomplete")).getAttribute("value"), list.get(0).getText());
		driver.quit();
	}

}
