package com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
//    private ExtentReport(){}
  private static ExtentReports extent;
  private   static ExtentSparkReporter spark;
  private static ExtentTest test;

    public static ExtentTest getTest() {
        return extTest.get();
    }

    public static void setExtTest(ExtentTest test) {
        extTest.set(test);
    }

    private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();





    public static void initReport(){
        extent  = new ExtentReports();
        spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
    }


    public static void tearDownReports(){
        extent.flush();
    }

//    @BeforeMethod
//    public void setup(Method m){
//        ExtentTest test=extent.createTest(m.getName());
//        test.log(Status.PASS, "This is a logging event for "+ m.getName()+", and it passed!");
//
//        //ExtentReport
//    }

    public static void createTest(String name){
       test= extent.createTest(name);
        setExtTest(test);
    }
}
