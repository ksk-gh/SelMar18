package week2.day1;

import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		//Open the browser
		ChromeDriver driver = new ChromeDriver();
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		//Load the URL
		driver.get("http://www.leaftaps.com/opentaps");
		
		//Enter the username
		driver.findElementById("username").sendKeys("DemoSalesManager");
		
		//Enter password
		driver.findElementById("password").sendKeys("crmsfa");
		
		//Click Login button
		driver.findElementByClassName("decorativeSubmit").click();
		
		Thread.sleep(5000);
		
		//Click Logout
		driver.findElementByClassName("decorativeSubmit").click();
		
		
		
		
		
		
		
		
		

	}

}
