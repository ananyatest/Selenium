import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment4 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Multiple Windows")).click();
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(20));
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='example']/h3")));
		driver.findElement(By.linkText("Click Here")).click();
	//	w.until(ExpectedConditions.urlMatches("https://the-internet.herokuapp.com/windows/new"));
		Set<String> window = driver.getWindowHandles();
		Iterator<String> win = window.iterator();
		
		String parent = win.next();
		String child =win.next();
		driver.switchTo().window(child);
		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
		driver.switchTo().window(parent);
	
		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
		
	}

}
