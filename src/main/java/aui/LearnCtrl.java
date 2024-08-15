package aui;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnCtrl {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); Implicit depreciated
		//New ImplicitlyWait is below
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("http://jqueryui.com/selectable/");
		driver.switchTo().frame(0);
		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		Actions builder = new Actions(driver);
	
		builder.sendKeys(Keys.CONTROL).click(item1).click(item3).perform();
		
		

	}

}






