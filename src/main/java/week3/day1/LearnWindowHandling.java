package week3.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindowHandling {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");		
		ChromeDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://legacy.crystalcruises.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.linkText("GUEST CHECK-IN")).click();
		Set<String> allwindows = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>();
		winList.addAll(allwindows);
		driver.switchTo().window(winList.get(1));
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		/*driver.switchTo().window(winList.get(0));
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());*/
		/*for (String eachWindow : allwindows) {
		System.out.println(eachWindow);
	}*/
		
	}

}






