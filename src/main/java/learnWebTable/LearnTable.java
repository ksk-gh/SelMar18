package learnWebTable;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnTable {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("MS", Keys.TAB);

		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("SBC", Keys.TAB);
		WebElement table = driver.findElement(By.xpath("//table[@class='DataTable TrainList']"));
		// driver.findElementsByXPath("//table[@class='DataTable TrainList']");
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		// Row count
		System.out.println(rows.size());
		List<WebElement> columns = rows.get(0).findElements(By.tagName("td"));
		// Column Count
		System.out.println(columns.size());

		System.out.println(columns.get(1).getText());

	}

}
