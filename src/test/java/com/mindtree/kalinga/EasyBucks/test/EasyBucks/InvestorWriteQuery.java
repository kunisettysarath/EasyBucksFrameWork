package com.mindtree.kalinga.EasyBucks.test.EasyBucks;

import org.testng.annotations.Test;

import com.mindtree.kalinga.EasyBucks.base.BaseClass;
import com.mindtree.kalinga.EasyBucks.base.TestDataReader;
import com.mindtree.kalinga.EasyBucks.pages.CommonImplementation;
import com.mindtree.kalinga.EasyBucks.reports.Reporters;

public class InvestorWriteQuery extends BaseClass {

	Reporters repo;
	TestDataReader read = new TestDataReader();

	@Test(invocationCount = 1)
	public void investorLogin() throws Exception {

		// System.out.println(caseList);
		this.repo = starts("InvestorLogin");

		CommonImplementation li = new CommonImplementation(driver, repo);
		li.implementationTestCases("Login", "InvestorLogin");

	}

	@Test(invocationCount = 1)
	public void writeReview() throws Exception {
		//System.out.println(caseList);
		this.repo = starts("Assistance");

		CommonImplementation li = new CommonImplementation(driver, repo);
		li.implementationTestCases("SeekAssistance", "Assistance");

	}

	@Test(invocationCount = 1)
	public void adminLogin() throws Exception {

		// System.out.println(caseList);
		this.repo = starts("Valid Email and valid Password");

		CommonImplementation li = new CommonImplementation(driver, repo);
		li.implementationTestCases("Login", "Valid Email and valid Password");
	}
	
	@Test(invocationCount = 1)
	public void manageAssistance() throws Exception {
		//System.out.println(caseList);
		this.repo = starts("ManageAssistance");

		CommonImplementation li = new CommonImplementation(driver, repo);
		li.implementationTestCases("ManageAssistance", "Assistance");

	}

}
