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
	//	addtocart(driver);
		addtocart1(driver);
	//	checkout(driver);
	//	search(driver);

	}
	
	
	public static void addtocart(WebDriver driver)
	{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String[] s = {"cucumber","carrot","brinjal","tomato"};    //considering all data is entered using lowercase
	
		List<String> list1 = Arrays.asList(s);
	
		int count =0;
		List<WebElement> products =driver.findElements(By.xpath("//div[@class='product']/h4"));
		int size = list1.size();
		int totalproducts = products.size();
		
		for(int i=0;i<totalproducts;i++) {
			
			String[] p = products.get(i).getText().split("-");
			// System.out.println(p[0]);
			String product = p[0].trim().toLowerCase();
			
			if(list1.contains(product))
			{
				driver.findElements(By.xpath("//div[@class='product']/div[3]/button")).get(i).click();
				// System.out.println("Clicked for vegetable " + products.get(i).getText());
				count=count+1;
			}
			
			if(count==size)
			{
				break;
			}
			
		}
		
		
	}
	
	public static void addtocart1(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String[] s = {"2 cucumber","5 carrot","6 brinjal","1 tomato","1 beans"};   							 //considering all data is entered using lowercase
	
		List<String> list1 = Arrays.asList(s);  						 							 //converting grocery list to arraylist
		int size = list1.size();																	//number of grocery items
		
		
		int count =0;   							
		List<WebElement> products =driver.findElements(By.xpath("//div[@class='product']/h4"));  	//products on the site
		
		int totalproducts = products.size();														//total products on the site
		
		for(int i=0;i<totalproducts;i++) {															// looping through all products on the site
			String[] p = products.get(i).getText().split("-");
			String product = p[0].trim().toLowerCase();												//capturing clean product name from the site
			
			
			for(int j=0;j<size;j++)																	//looping through the whole grocery list
			{
				String[] a = list1.get(j).split(" ");												//separating grocery item and its count
				int howmany = Integer.parseInt(a[0]);
				
				if(a[1].equalsIgnoreCase(product)) {
					for (int round=1;round<howmany; round++)										//looping through the count of each item on the grocery list
					{
						driver.findElements(By.xpath("//a[@class='increment']")).get(i).click();
					}
					driver.findElements(By.xpath("//div[@class='product']/div[3]/button")).get(i).click();
					System.out.println(driver.findElements(By.xpath("//div[@class='product']/h4")).get(i).getText()+" " +howmany);
					count=count+1;
				}
			}
			
		
			
			if(count==size)
			{
				break;
			}
			
		}
	}

}
