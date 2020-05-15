package com.mindtree.kalinga.EasyBucks.reports;

import java.io.File;

import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reporters {
	ExtentReports report;
	ExtentTest logger;
	/*
	 * public ExtentTest getObject(){ return logger; }
	 */

	public void getInitialConfig() {

		report = new ExtentReports(System.getProperty("user.dir") + "/ExtentReports/extent.html", true);

		report.addSystemInfo("Host Name", "Mindtree").addSystemInfo("Environment", "Automation Testing")
				.addSystemInfo("Tester Name", "Ravi Kumar Gupta");

		report.loadConfig(new File(System.getProperty("user.dir") + "/src/main/resources/extent-config.xml"));

	}

	public void startTest(String name) {
		logger = report.startTest(name);
	}

	int i = 0;

	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test case skipped is " + result.getName() + i);

			// logger.log(LogStatus.FAIL, "The test case failed is " +
			// result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test case skipped is " + result.getName() + i);

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			System.out.println("pass");
			logger.log(LogStatus.PASS, "Test case passed is " + result.getName() + i);
		}
		i++;
		report.endTest(logger);

	}

	public void addMsg(String msg) {
		logger.log(LogStatus.INFO, msg);
	}

	public void addErrorLog(Throwable throwable) {
		logger.log(LogStatus.INFO, throwable);
	}
	
	public void endReport() {
		report.flush();
		report.close();
	}

	public void addScreenShotToExtentReport(String imagePath, String status) {
		if (status.equalsIgnoreCase("fail"))
			logger.log(LogStatus.FAIL, "screenshot" + logger.addScreenCapture(imagePath));
		if (status.equalsIgnoreCase("pass"))
			logger.log(LogStatus.PASS, "screenshot" + logger.addScreenCapture(imagePath));
		if (status.equalsIgnoreCase("skip"))
			logger.log(LogStatus.SKIP, "screenshot" + logger.addScreenCapture(imagePath));
	}
}