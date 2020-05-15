package com.mindtree.kalinga.EasyBucks.test.EasyBucks;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.mindtree.kalinga.EasyBucks.base.BaseClass;
import com.mindtree.kalinga.EasyBucks.pages.CommonImplementation;

public class LoginTest extends BaseClass {

	int i = 0;

	@Test(invocationCount = 1, enabled = true)
	public void test1() throws Exception {

		caseList = read.getTestData("Login");
		this.repo = starts(caseList.get(i));
		CommonImplementation li = new CommonImplementation(driver, repo);
		li.implementationTestCases("Login", caseList.get(i));
		i++;
	}
/*
	@Test(enabled = false)
	public void temp() throws IOException, InterruptedException {

		caseList = read.getTestData("JustClick");
		System.out.println(caseList);
		this.repo = starts(caseList.get(i));
		CommonImplementation li = new CommonImplementation(driver, repo);
		li.implementationTestCases("JustClick", caseList.get(i));
		i++;

	}
*/
/*	
	@Test
	public void test1()
	{this.repo = starts("test1");
		assertTrue(true);
		
	}
	@Test
	public void test2()
	{
		this.repo = starts("test2");
		assertTrue(false);		
		
	}
	@Test
	public void test3()
	{
		this.repo = starts("test3");
		throw new SkipException("skipped by me");
	}*/
}
