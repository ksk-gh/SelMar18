package leaf.Lead;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class LearnAttributes {
	@Test(priority=-5)
	public void createLead() {
		System.out.println("Create Lead");
	}	
	@Test(priority=-1)
	public void deleteLead() {
		System.out.println("delete Lead");
	}
	@Test(priority=1)
	public void beditLead() {
		System.out.println("edit Lead");
	}

}
