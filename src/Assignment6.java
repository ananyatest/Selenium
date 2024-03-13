import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
		String name = driver.findElement(By.xpath("//input[@id='checkBoxOption1']/parent::label")).getText();
System.out.println(name.trim());
Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
s.selectByVisibleText(name);
driver.findElement(By.xpath("//input[@id='name']")).sendKeys(name);
driver.findElement(By.id("alertbtn")).click();
String alertinfo = driver.switchTo().alert().getText();
driver.switchTo().alert().accept();
System.out.println(alertinfo);
Assert.assertTrue(alertinfo.contains(name));
//driver.quit();
	}

}
