package wdMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.Reporter;

public class SeMethods extends Reporter implements WdMethods{
	
	public static RemoteWebDriver driver;
	public String sUrl,sHubUrl,sHubPort;
	public Properties prop;
	
	public SeMethods() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
			sHubUrl = prop.getProperty("HUB");
			sHubPort = prop.getProperty("PORT");
			sUrl = prop.getProperty("URL");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void startApp(String browser, String url) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			 driver = new ChromeDriver();
		}else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		//Maximize the browser
		driver.manage().window().maximize();
		//Load the URL
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("The "+browser+" browser launched successfully");
		takeSnap();
	}
	public void startApp(String browser, boolean bRemote) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			 driver = new ChromeDriver();
		}else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		//Maximize the browser
		driver.manage().window().maximize();
		//Load the URL
		//driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("The "+browser+" browser launched successfully");
		takeSnap();
	}
	public void startApp(String browser) {
		startApp(browser, false);
	}
	
	public WebElement locateElement(String locator, String locValue) {
		WebElement ele = null;
		switch (locator) {
		case "id":
			ele = driver.findElement(By.id(locValue));
			break;
		case "class":
			ele = driver.findElement(By.className(locValue));
			break;
		
		
		}
		return ele;
		
	}

	//Only for id Locator
	public WebElement locateElement(String locValue) {		
		return driver.findElement(By.id(locValue));
	}

	public void type(WebElement ele, String data) {
		ele.sendKeys(data);
		System.out.println("The given value is entered "+data);
		takeSnap();
	}

	public void click(WebElement ele) {
		ele.click();
		System.out.println("The element is clicked successfully");
		takeSnap();
	}
	
	public void clickWithNoSnap(WebElement ele) {
		ele.click();
		System.out.println("The element is clicked successfully");		
	}

	public String getText(WebElement ele) {
		String txt = ele.getText();
		System.out.println("");
		takeSnap();
		return txt;
	}

	public void selectDropDownUsingText(WebElement ele, String value) {
		new Select(ele).selectByVisibleText(value);
		System.out.println("");
		takeSnap();

	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		new Select(ele).selectByIndex(index);
		System.out.println("");
		takeSnap();

	}

	public boolean verifyTitle(String expectedTitle) {
		
		String title = driver.getTitle();
		if (title.equals(expectedTitle)) {
			System.out.println("");
		}
		return false;
	}

	public void verifyExactText(WebElement ele, String expectedText) {
		if(ele.getText().equals(expectedText)) {
			System.out.println("The text "+ele.getText()+" is matched with "+expectedText);
		} else {
			System.out.println("text not match");
		}
		takeSnap();
	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		if(ele.getText().contains(expectedText)) {
			System.out.println("The text "+ele.getText()+" is matched with "+expectedText);
		} else {
			System.out.println("text not match");
		}
		takeSnap();

	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		if(ele.getAttribute(attribute).equals(value)) {
			
		}

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	public void verifySelected(WebElement ele) {
		if (ele.isSelected()) {
			
		};

	}

	public void verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub

	}

	public void switchToWindow(int index) {
		Set<String> allwindows = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>();
		winList.addAll(allwindows);
		driver.switchTo().window(winList.get(index));
		System.out.println("");
		takeSnap();
	}

	//for WebElement
	public void switchToFrame(WebElement ele) {
		driver.switchTo().frame(ele);
		System.out.println("");
		takeSnap();
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
		System.out.println("");
		//takeSnap(); - 

	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
		System.out.println("");
	}

	public String getAlertText() {
		String text = driver.switchTo().alert().getText();
		System.out.println("");
		return text;
	}

	int i =1;
	
	public long takeSnap(){
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".jpg"));
		} catch (WebDriverException e) {
			System.out.println("The browser has been closed.");
		} catch (IOException e) {
			System.out.println("The snapshot could not be taken");
		}
		return number;
	}
	 

	public void closeBrowser() {
		driver.close();

	}

	public void closeAllBrowsers() {
		driver.quit();

	}

}
