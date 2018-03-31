package reports;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LearnReport {

		public static void main(String[] args) throws IOException {
			ExtentHtmlReporter html = new ExtentHtmlReporter("./reports/result.html");
			html.setAppendExisting(true);
			
			ExtentReports extent = new ExtentReports();			
			extent.attachReporter(html);
			
			ExtentTest test = extent.createTest("TC002_EditLead", "Edit a Lead");
			test.assignAuthor("Gopi");
			test.assignCategory("Smoke");
			
			test.pass("Data DemoSalesManager Entered Succussfully"
					,MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/img1.png").build());
			test.pass("Data crmsfa Entered Succussfully"
					,MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/img2.png").build());
			test.fail("Login Button is not clicked");
			
			extent.flush();
			
			
		}
	
}
