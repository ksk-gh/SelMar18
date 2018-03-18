package testcases;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import wdMethods.SeMethods;

public class LoginLeafTaps extends SeMethods{
	@Test
	public void loginLeaftaps() {
		startApp("chrome", "http://leaftaps.com/opentaps/control/main");
		/*WebElement uName = locateElement("id", "username");
		type(uName, "DemoSalesManager");*/
		type(locateElement("id", "username"), "DemoSalesManager");
	//WebElement password = locateElement("id", "password");
		type(locateElement("id", "password"), "crmsfa");
		click(locateElement("class", "decorativeSubmit"));
		click(locateElement("class", "decorativeSubmit"));
		
	}
}





