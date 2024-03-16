import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment7 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		List<WebElement> rows = driver.findElements(By.xpath("(//table[@id='product'])[1]/tbody/tr"));
		System.out.println("Number of rows are "+rows.size());
		List<WebElement> columns = driver.findElements(By.xpath("(//table[@id='product'])[1]/tbody/tr/th"));
		System.out.println("Number of columns are "+columns.size());
		List<WebElement> secondrow = driver.findElements(By.xpath("(//table[@id='product'])[1]/tbody/tr[3]/td"));
		for(int i=0;i<secondrow.size();i++)
		{
			System.out.println(secondrow.get(i).getText());
		}
		
		driver.quit();
		
	}

}
