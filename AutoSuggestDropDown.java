package day27;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropDown {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		

		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("selenium");
	  //	Thread.sleep(3000);
		
		List<WebElement> list=driver.findElements(By.xpath("//div[contains(@class.'wM6W7D')]//span"));
		System.out.println("total num of suggestion:"+list.size());
		
		for(int i=0;i<list.size();i++)
		{
			String text=list.get(i).getText();
			//System.out.println(list.get(i).getText());  //read and total number
			
			if(text.equals("selenium tutorial"))
			{
				list.get(i).click();
				break;
			}
			
			
		}
	 }

}
