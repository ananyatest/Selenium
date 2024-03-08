import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actionclass {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		List<WebElement> w = driver.findElements(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td/ul/li/a"));
		System.out.println(w.size());
		Actions a = new Actions(driver);
		for(WebElement w1:w)
		{
			
			a.moveToElement(w1).keyDown(Keys.COMMAND).click().perform();
		}
		
		//driver.quit();
		
		
	}

}
