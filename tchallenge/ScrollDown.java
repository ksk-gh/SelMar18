package tchallenge;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollDown {

	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://gromo.github.io/jquery.scrollbar/demo/basic.html");

		/*driver.get("https://www.naukri.com/");

		int y = driver.findElementByLinkText("Browse All Jobs").getLocation().getY();

		((JavascriptExecutor) driver).executeScript("scroll(0,"+y+");");*/


		driver.findElementByXPath("//input[@value='Use TAB to focus next input']").click();

		int y = driver.findElementByXPath("//h3[text()='Anchor']/preceding-sibling::input").getLocation().getY();
		
		((JavascriptExecutor) driver).executeScript("scroll(0,"+y+");");
	}
}
