import java.time.Duration;
import java.time.Month;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calendar {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		String day = "3";
		String month = "4";
		String year = "2027";
		int date = Integer.parseInt(month);  // converted month from string to integer
		String month1 = Month.of(date).name();  //uppercase month converted to string for number
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.xpath("//div[@class='react-date-picker__wrapper']/button[2]")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		//year selection
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		
		//couldn't use month1 below as the text on app is sentencecase
		
		List<WebElement> months = driver.findElements(By.cssSelector(".react-calendar__year-view__months__month"));
		months.get(Integer.parseInt(month)-1).click(); 
		List<WebElement> days = driver.findElements(By.xpath("//button[contains(@class,'react-calendar__month-view__days__day')]/abbr"));
	

		for(int i=0;i<days.size();i++)
			
		{
			System.out.println(days.get(i).getText());
			String[] m = days.get(i).getAttribute("aria-label").split(" ");  //extracting the month from website
			
			//using if clause because on some months date day number can occur twice due to previous month date or next month date
			
			if(days.get(i).getText().equalsIgnoreCase(day) & m[1].equalsIgnoreCase(month1))
			{
				days.get(i).click();
			}
		}
		driver.quit();
	}

}
