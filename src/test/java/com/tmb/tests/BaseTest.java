package com.tmb.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.reports.ExtentReport;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BaseTest {

    @BeforeSuite
    public void setupSuite(){
            ExtentReport.initReport();
    }

    @AfterSuite
    public void tearDownSuite(){
        ExtentReport.tearDownReports();
    }

    @BeforeMethod
    public void setupTest(Method m){
        ExtentReport.createTest(m.getName());
    }

    @AfterMethod
    public void tearDownTest(ITestResult result){

    }

 //   @Test
 //   public void test(){
//
//      //  before suite
//        extent  = new ExtentReports();
//      //  ExtentSparkReporter
//         spark = new ExtentSparkReporter("target/Spark.html");
//        extent.attachReporter(spark);
//
//        //first test
//        ExtentTest test=extent.createTest("MyFirstTest");
//        test.log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
//
//        ExtentTest test1=extent.createTest("MySecondTest");
//        test1.log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
//
//        //Aftyer every test case if every script has passed/failed or need to log in report
//
//           //     after suite
//        extent.flush();
 //   }
}
