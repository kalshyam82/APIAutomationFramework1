package com.listeners;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.reports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener, ISuiteListener {

//    @Override
//    public void onTestStart(ITestResult result) {
//        ExtentReport.createTest(result.getName());
//    }
//
//    /**
//     * Invoked each time a test succeeds.
//     *
//     * @param result <code>ITestResult</code> containing information about the run test
//     * @see ITestResult#SUCCESS
//     */
//    @Override
//    public void onTestSuccess(ITestResult result) {
//       // ExtentReport.getTest().pass(result.getName()+" is passed");
//    }
//
//    /**
//     * Invoked each time a test fails.
//     *
//     * @param result <code>ITestResult</code> containing information about the run test
//     * @see ITestResult#FAILURE
//     */
//    @Override
//    public void onTestFailure(ITestResult result) {
//      //  ExtentReport.getTest().fail(MarkupHelper.createLabel(String.valueOf(result.getThrowable()), ExtentColor.RED));
//
//
//        //MarkupHelper.createLabel(message, ExtentColor.RED
//    }
//
//    public void onStart(ISuite suite) {
//     //   ExtentReport.initReport();
//    }
//
//    /**
//     * This method is invoked after the SuiteRunner has run all the tests in the suite.
//     *
//     * @param suite The suite
//     */
//    public void onFinish(ISuite suite) {
//
//        //ExtentReport.tearDownReports();
//    }

}
