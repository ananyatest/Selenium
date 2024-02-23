import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;




public class Assignment1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		checkbox(driver);
		driver.quit();
	}
	
	public static void checkbox(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.id("checkBoxOption1")).click();
	//	Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());  //Checks if the checkbox is checked
		driver.findElement(By.id("checkBoxOption1")).click();
	//	Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());  //checks if the checkbox is  unchecked
		
		List<WebElement> check = driver.findElements(By.xpath("//div[@id='checkbox-example']/fieldset/label/input"));
		
		System.out.println("The number of checkboxes are "+check.size());  //counts the number of checkboxes
		
		return;
	}

}
