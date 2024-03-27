import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practise3 {

	public static void main(String[] args) {
		
		
		
		WebDriver driver = new ChromeDriver();
		test1(driver);
		driver.quit();
		
	}

	private static String getprice(WebElement s) {
		String p= s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return p;
	}
	
	public static void test1(WebDriver driver)
	{

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		List<WebElement> list = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		List<String> list1 = list.stream().filter(s->s.getText().contains("Rice")).map(s->getprice(s)).collect(Collectors.toList());
		list1.forEach(a->System.out.println(a));
		driver.quit();
	}

	
	

	
}
