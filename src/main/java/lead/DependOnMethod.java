package lead;

import org.testng.annotations.Test;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

public class DependOnMethod {
	@Test(expectedExceptions= {RuntimeException.class,NoSuchElementException.class})
	public void createLead() {		
		System.out.println("Create Lead");
		throw new RuntimeException();
	}	
	@Test(successPercentage=80)
	public void deleteLead() {
		System.out.println("delete Lead");
	}
	@Test(dependsOnMethods= {"leaf.Lead.DependOnMethod.deleteLead","leaf.Lead.DependOnMethod.createLead"},alwaysRun=true)
	public void beditLead() {
		System.out.println("edit Lead");
	}
	@Test(enabled=false)
	public void mergeLead() {
		System.out.println("Merge Lead");
	}
	
	
	
	
	
	
}
