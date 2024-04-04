import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

public class practise4r3elativeLocators {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/angularpractice/");
		// driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("12345678");
		// driver.findElement(with(By.tagName("input")).below(driver.findElement(By.xpath("//label[text()='Email']")))).sendKeys("12221122");
		
		driver.switchTo().newWindow(WindowType.TAB);  //opening new tab
		Set<String> a = driver.getWindowHandles();
		Iterator<String> a1 = a.iterator();
		String parent = a1.next();
		String child = a1.next();
		driver.switchTo().window(child);  // switching to the new tab
		driver.get("https://www.rahulshettyacademy.com/");
		String course = driver.findElement(By.xpath("(//h2/a)[1]")).getText();
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//label[text()='Name']/following-sibling::input")).sendKeys(course);
	//	driver.findElement(with(By.tagName("input")).below(By.xpath("//label[text()='Name']"))).sendKeys(course);  //relative locator
		Thread.sleep(2000);
		driver.quit();
	}
}
	