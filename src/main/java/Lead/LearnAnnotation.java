package leaf.Lead;

import org.testng.annotations.*;

public class LearnAnnotation {
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod");
	}
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite");
	}
	@BeforeTest()
	public void beforeTest() {
		System.out.println("beforeTest");
	}
	@Test
	public void test1() {
		System.out.println("test1");
	}
	@Test
	public void test2() {
		System.out.println("test2");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("afterClass");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("afterTest");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("afterSuite");
	}
	

}
