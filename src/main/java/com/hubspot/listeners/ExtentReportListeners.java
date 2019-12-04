package com.hubspot.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ExtentReportListeners implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName()+"Test Case Is Started");
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName()+" Test Case Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("The name of the test case failed is : "+result.getName());
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("The name of the test case skipped is : "+result.getName());

		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		//System.out.println(context.getName());
		Reporter.log("About to begin executing test "+context.getName(),true);
		
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("Completed executing test "+context.getName(),true);

		
		
	}

}
