package leaf.Lead;


import org.testng.annotations.Test;

import learnRet.MyRetryAnalyzer;
import wdMethods.ProjectMethods;

public class CreateLeadRet extends ProjectMethods{

	int i = 0;
	@Test(retryAnalyzer=MyRetryAnalyzer.class)
	public void createLead() {	

		click(locateElement("linkText", "Create Lead"));			
	type(locateElement("id", "createLeadForm_companyName"), "TestLeaf");
	type(locateElement("id", "createLeadForm_firstName"), "Gopinath");
	type(locateElement("id", "createLeadForm_lastName"), "Jayakumar");
	type(locateElement("id", "createLeadForm_primaryEmail"), "gopinath@testleaf.com");
	type(locateElement("id", "createLeadForm_primaryPhoneNumber"), "9597704568");
	click(locateElement("name", "submitButton"));

}

}












