package com.mindtree.kalinga.EasyBucks.base;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.mindtree.kalinga.EasyBucks.reports.Reporters;
import com.mindtree.kalinga.EasyBucks.utils.PropertyUtil;
import com.mindtree.kalinga.EasyBucks.utils.ScreenShotsUtil;

public class BaseClass extends PropertyUtil {
	protected WebDriver driver;
	// Reporters repo;
	protected ArrayList<String> caseList = new ArrayList<String>();

	protected TestDataReader read = new TestDataReader();

	protected Reporters repo = new Reporters();
	// ExtentTest test = repo.getObject();

	public Reporters starts(String name) {
		repo.startTest(name);
		return repo;

	}

	@BeforeSuite
	public void beforeSuit(){
		repo.getInitialConfig();
	
	}

	
	//@Parameters("browser")
	@BeforeClass
	public void beforeClass() throws InterruptedException {

		CrossBrowser cb = new CrossBrowser(driver);
		driver = cb.multiBrowser("chrome");
		driver.manage().window().maximize();
		driver.get(getData("url"));

		//Thread.sleep(2000);
	}

	@BeforeMethod
	public void bmethod() throws InterruptedException {
		Thread.sleep(2000);
	}

	int i = 0;

	@AfterMethod(enabled = true)
	public void tearDown(ITestResult result) throws IOException {

		ScreenShotsUtil sShot = new ScreenShotsUtil();
		System.out.println(result.getStatus());
		if (ITestResult.FAILURE == result.getStatus()) {
			try {

				String imagePath = sShot.addScreenShot(driver, "/Fail/" + result.getName() + i);
				System.out.println("Screen Shots Taken");
				repo.addScreenShotToExtentReport(imagePath, "fail");

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
			repo.addErrorLog(result.getThrowable());
			repo.getResult(result);
		}

		if (ITestResult.SUCCESS == result.getStatus()) {
			try {
				String imagePath = sShot.addScreenShot(driver, "/Pass/" + result.getName() + i);
				System.out.println("Screen Shots Taken");
				repo.addScreenShotToExtentReport(imagePath, "pass");
			} catch (Exception e) {
				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
			System.out.println(result.getStatus());
			repo.getResult(result);
		}

		else if (ITestResult.SKIP == result.getStatus()) {
			try {
				String imagePath = sShot.addScreenShot(driver, "/Skip/" + result.getName() + i);
				System.out.println("Screen Shots Taken");
				repo.addScreenShotToExtentReport(imagePath, "skip");

			} catch (Exception e) {
				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
			System.out.println(result.getStatus());
			repo.getResult(result);
		}
		i++;
	}

	@AfterClass
	public void aclass() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}
	
	@AfterSuite
	public void aSuit() {
		repo.endReport();
	}
	// @BeforeTest
	// public void beforeTest() throws InterruptedException{
	// driver.manage().window().maximize();
	// driver.get(getData("DemoURL"));
	// Thread.sleep(2000);
	// }

}
