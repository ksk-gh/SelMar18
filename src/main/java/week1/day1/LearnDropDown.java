package week1.day1;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LearnDropDown {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		//Open the browser
		ChromeDriver driver = new ChromeDriver();

		//Maximize the browser
		driver.manage().window().maximize();

		//Load the URL
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		//driver.findElementById("userRegistrationForm:securityQ").sendKeys("What is your pet name?");
		WebElement securityQ = driver.findElementById("userRegistrationForm:securityQ");

		Select dd= new Select(securityQ);
		/*dd.selectByVisibleText("What was the name of your first school?");
		dd.selectByValue("2");		
		dd.selectByIndex(4);		
		System.out.println(allOptions.size());
		dd.selectByIndex(allOptions.size()-1);*/		
		List<WebElement> allOptions = dd.getOptions();
		for (WebElement eachOption : allOptions) {
			System.out.println(eachOption.getText());
		}










	}

}
