package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	
	public static void main(String[] args) throws InterruptedException {		

		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");		
		//Open the browser
		WebDriver driver = new ChromeDriver();	
	
		//Maximize the browser
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//Load the URL
		driver.get("http://www.leaftaps.com/opentaps");		
		
		//Enter the username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");		
		//Enter password
		driver.findElement(By.id("password")).sendKeys("crmsfa");		
		//Click Login button
		driver.findElement(By.className("decorativeSubmit")).click();	
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//label[text()='Lead ID:']/following::input[2]")).sendKeys("g");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		//WebDriverWait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")));
		//Thread.sleep(3000); - Java				
		
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();		
	}

}