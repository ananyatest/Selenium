import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 WebDriver driver = new ChromeDriver();
 
 driver.get("https://rahulshettyacademy.com/angularpractice/");
 driver.manage().window().maximize();
 String s = assignment(driver);
 System.out.println(s);
 
 driver.quit();
	}
	
	public static String assignment(WebDriver driver)
	{
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(20));
		
		String name = "Ananya";
		String email = "anan@fee.com";
		String pass = "password";
		String gender = "Female";
		driver.findElement(By.xpath("//div[@class='form-group'] //input[@name='name']")).sendKeys(name);
		driver.findElement(By.xpath("//div[@class='form-group'] //input[@name='email']")).sendKeys(email);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(pass);
		Select s = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
		s.selectByVisibleText(gender);
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("12345678");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@class,'alert-success')]"))));
		String message = driver.findElement(By.xpath("//div[contains(@class,'alert-success')]")).getText();
		return(message);
	}

}
