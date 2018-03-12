package week2.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnFindElements {
	public static void main(String[] args) throws InterruptedException {		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");		
		//Open the browser
		ChromeDriver driver = new ChromeDriver();		
		//Maximize the browser
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Load the URL
		driver.get("http://legacy.crystalcruises.com/Calendar.aspx");		
		List<WebElement> quotes = driver.
				findElementsByLinkText("Get-a-Quote");
		System.out.println(quotes.size());
		quotes.get(4).click();
		System.out.println(driver.getCurrentUrl());
		
		
		
		
		
		
		
		
		
		
		
		

	}

}