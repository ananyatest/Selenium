import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class Practise2 {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
	/*	List<WebElement> links=   driver.findElements(By.cssSelector("li[class='gf-li'] a"));

	      SoftAssert a =new SoftAssert();
	      for(WebElement link : links)

	      {
	          String url= link.getAttribute("href");
	          HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();
	          conn.setRequestMethod("HEAD");
	          conn.connect();
	          int respCode = conn.getResponseCode();
	     //     System.out.println(respCode);
	          a.assertTrue(respCode<400, "The link with Text"+link.getText()+" is broken with code" +respCode);
	      }
	      a.assertAll(); */
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		SoftAssert a = new SoftAssert();
		
		for(int i=0;i<links.size();i++) {
			String link = links.get(i).getAttribute("href");
			
		
			HttpURLConnection c= (HttpURLConnection)new URL(link).openConnection();
			c.setRequestMethod("HEAD");
			c.connect();
			int code = c.getResponseCode();
			
			a.assertTrue(code<400," "+link+ "with name "+links.get(i).getText() +" is broken with response code "+code);
		
		}
		a.assertAll();
driver.quit(); 
	}

}
