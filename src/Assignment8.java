import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;



public class Assignment8 {

	public static void main(String[] args) throws IOException {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		String text = "ind";
		driver.findElement(By.id("autocomplete")).sendKeys(text);
		Actions a= new Actions(driver);
		a.keyDown(Keys.ARROW_DOWN).build().perform();
		a.keyDown(Keys.ARROW_DOWN).build().perform();
		List<WebElement> list = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
		Assert.assertEquals(driver.findElement(By.id("autocomplete")).getAttribute("value"), list.get(0).getText());
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("\\screenshot1.jpg"));
		driver.quit();
	}

}
