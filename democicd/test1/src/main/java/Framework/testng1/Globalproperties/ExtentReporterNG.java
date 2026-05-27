package Framework.testng1.Globalproperties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports getReport() {
		String path="C:\\Users\\Vijayalakshmi\\eclipse-workspace\\testng1\\Report\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("ECOM Results");
		reporter.config().setDocumentTitle("ECOM");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Thavithu");
		return extent;
		
	}

}
