import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		Assignment3 obj = new Assignment3();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		obj.assignment(driver);
		
	}
	
	public void assignment(WebDriver driver)
	{
		
		WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(20));
		String text = driver.findElement(By.xpath("//form[@id='login-form']/div[7]/p")).getText();
		String[] data = text.split(" ");
		String username = data[2];
		String pass = data[6];
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("(//input[@id='usertype'])[2]")).click();
		
		
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("myModal"))));
		driver.switchTo().alert().accept();
		Select s = new Select(driver.findElement(By.xpath("v")));
		s.selectByValue("consult");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
	}

}
