import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EcommerceBasic {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		addtocart(driver);
	//	checkout(driver);
	//	search(driver);

	}
	
	public static void addtocart(WebDriver driver)
	{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String[] s = {"Cucumber","Carrot","Brinjal","Tomato"};
		
		List<String> list = Arrays.asList(s);
		int count =0;
		List<WebElement> products =driver.findElements(By.xpath("//div[@class='product']/h4"));
		int size = list.size();
		int totalproducts = products.size();
		
		for(int i=0;i<totalproducts;i++) {
			
			String[] p = products.get(i).getText().split("-");
			System.out.println(p[0]);
			String product = p[0].trim();
			
			if(list.contains(product))
			{
				driver.findElements(By.xpath("//div[@class='product']/div[3]/button")).get(i).click();
				System.out.println("Clicked for vegetable " + products.get(i).getText());
				count=count+1;
			}
			
			if(count==size)
			{
				break;
			}
			
		}
		
		
	}

}
