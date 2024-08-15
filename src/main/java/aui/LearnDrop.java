package aui;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnDrop {
	int x ;
	int y;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("http://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		WebElement drag = driver.findElement(By.id("draggable"));
		
		WebElement drop = driver.findElement(By.id("droppable"));
		int x1 = drag.getLocation().getX();
		int y2 = drag.getLocation().getY();
		System.out.println("first location of X1"+x1);
		System.out.println("Y2"+y2);
		Actions builder = new Actions(driver);		
		builder.dragAndDrop(drag, drop).perform();
		WebElement drag1 = driver.findElement(By.id("draggable"));
		int x = drag1.getLocation().getX();
		System.out.println("x "+x);
		int y = drag1.getLocation().getY();
		System.out.println("y "+y);
		Thread.sleep(3000);
		builder.dragAndDropBy(drag, -(x-x1), -(y-y2)).perform();
		x = drag1.getLocation().getX();
		System.out.println("x "+x);
		y = drag1.getLocation().getY();
		System.out.println("y "+y);
	}

}






