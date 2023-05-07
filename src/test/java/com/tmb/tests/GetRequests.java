package com.tmb.tests;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.reports.ExtentReport;
import com.requestbuilder.RequestBuilder;
import io.restassured.response.Response;
import static org.assertj.core.api.Assertions.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetRequests extends BaseTest  {

    @Test
    public void getEmployeeDetails123(){
      //  ExtentReport.getTest().assignAuthor("Shyam").assignCategory("Smoke");
        ExtentReport.getTest().assignAuthor("Ram").assignCategory("ABC");
        Response response= RequestBuilder.buildRequestForGetCalls()
                .get("/employees");

        response.prettyPrint();

        assertThat(response.getStatusCode())
                .as("Verify Status code").isEqualTo(200);

        assertThat(response.jsonPath().getList("$").size())
                .isPositive()
                .as("Validate size of employee array").isLessThan(100);
     //   ExtentReport.getTest().pass(response.asPrettyString());
    //    ExtentReport.getTest().pass(MarkupHelper.createCodeBlock(json, String.valueOf(CodeLanguage.JSON)));
        ExtentReport.getTest().pass(MarkupHelper.createCodeBlock(response.asPrettyString(), CodeLanguage.JSON));
//        ExtentReports.getTest().pass(response.asPrettyString());
    }

    @Test(dataProvider = "getData")
    public void getEmployee(Integer id, String fname){
      //  ExtentReport.getTest().assignAuthor("Shyam").assignCategory("Smoke");
        Response response  = RequestBuilder.buildRequestForGetCalls()
                .pathParams("id", id)
                .get("/employees/{id}");
        response.prettyPrint();
        ExtentReport.getTest().pass(MarkupHelper.createCodeBlock(response.asPrettyString(), CodeLanguage.JSON));

        assertThat(response.jsonPath().getMap("$").size())
                .isNotZero();
                //.as("is less than").isLessThan(5);

        assertThat(response.jsonPath().getString("first_name"))
                .as("Name is ").isEqualTo(fname)
                .hasSizeBetween(3, 15);
    }

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {1, "Sebastian"},
                {2,"Steve"},
                {3,"Ann"}
        };
    }

}
