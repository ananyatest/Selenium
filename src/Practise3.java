import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		int count=0;
		List<WebElement> list;
		List<String> list1;
		driver.findElement(By.xpath("//th[contains(@aria-label,'Veg/fruit name')]")).click();
		do {
		list = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		list1 = list.stream().filter(s->s.getText().contains("Rice")).map(s->getprice(s)).collect(Collectors.toList());  //test data rice
		count = list1.size();
		
		//clicking next
		if(count<1) {
		driver.findElement(By.xpath("//a[@aria-label='Next']")).click();}
		}while(count<1);
	
		
		Assert.assertTrue(list1.contains("37"));   //price of rice is 37
		
	//	list1.forEach(a->System.out.println(a));
		driver.quit();
	}

	
	

	
}
