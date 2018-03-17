package week3.day1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnAlert {
	public static void main(String[] args) throws IOException {		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");		
		ChromeDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.irctc.co.in/");
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		File des = new File("./snaps/img1.png");
		FileUtils.copyFile(src, des);
		
		driver.findElementById("loginbutton").click();
		File src1 = driver.getScreenshotAs(OutputType.FILE);
		File des1 = new File("./snaps/img2.png");
		FileUtils.copyFile(src1, des1);
		//driver.switchTo().alert().accept();		
		//to perform multiple actions with same alert		
		/*Alert myAlert = driver.switchTo().alert();
		myAlert.getText();
		myAlert.sendKeys("My Text");
		myAlert.accept();*/
		//or to dismiss the Alert
		//myAlert.dismiss();

	}

}





