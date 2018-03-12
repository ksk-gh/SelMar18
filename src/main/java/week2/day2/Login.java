package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	public static void main(String[] args) throws InterruptedException {		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");		
		//Open the browser
		ChromeDriver driver = new ChromeDriver();		
		//Maximize the browser
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Load the URL
		driver.get("http://www.leaftaps.com/opentaps");		
		
		//Enter the username
		driver.findElementById("username").sendKeys("DemoSalesManager");		
		//Enter password
		driver.findElementById("password").sendKeys("crmsfa");		
		//Click Login button
		driver.findElementByClassName("decorativeSubmit").click();	
		
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("//label[text()='Lead ID:']/following::input[2]").sendKeys("g");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		//WebDriverWait
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")));
		//Thread.sleep(3000); - Java				
		
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a").click();
		
		
		
		
		
		
		
		
		
		

	}

}