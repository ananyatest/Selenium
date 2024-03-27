import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.collect.Streams;

public class Practise3 {

	public static void main(String[] args) {
		
		
		
		WebDriver driver = new ChromeDriver();
		// test1(driver);
		test2(driver);
		driver.quit();
		
	}

	private static String getprice(WebElement s) {
		String p= s.findElement(By.xpath("/following-sibling::td[1]")).getText();
		return p;
	}
	
	public static void test1(WebDriver driver)
	{

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		List<WebElement> pricelist = driver.findElements(By.xpath("//*[contains(@class,'table-bordered')]/tbody/tr/td[2]"));
		
		//print the prices of all the items in the list
	//	System.out.println(pricelist.stream().map(s->s.getText()).collect(Collectors.toList()).get(3)); 
		
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(@class,'table-bordered')]/tbody/tr/td[1]"));
		List<String> list1 = list.stream().filter(s->s.getText().contains("rice")).map(s->getprice(s)).collect(Collectors.toList());
		list1.forEach(a->System.out.println(a));
		driver.quit();
	}
	
	public static void test2(WebDriver driver)
	{
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		List<WebElement> items = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		List<WebElement> prices = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		
	// items.stream().map(m->m.getText()).forEach(m->System.out.println(m)); 
	//	prices.stream().map(a->a.getText()).forEach(a->System.out.println(a));
	Stream<String> z = Streams.concat(items.stream().map(m->m.getText()),prices.stream().map(a->a.getText()));
	z.forEach(e->System.out.println(e));
	}

	
}
