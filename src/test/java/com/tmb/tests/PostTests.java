package com.tmb.tests;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.constants.FrameworkConstants;
import com.listeners.TestListener;
import com.pojo.Employee;
import com.reports.ExtentReport;
import com.requestbuilder.RequestBuilder;
import com.tmb.utils.ApiUtils;
import com.tmb.utils.RandomUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static com.constants.FrameworkConstants.*;
import static org.assertj.core.api.Assertions.*;

public class PostTests extends BaseTest  {

    @Test
    public void createEmployeeTest(){
        ExtentReport.getTest().assignAuthor("Shyam").assignCategory("Regression");
        Employee employee = Employee.builder()
              //  .setEmail(RandomUtils.getEmail())
                .setFname(RandomUtils.getfName())
                .setLname(RandomUtils.getlName())
                .setId(RandomUtils.getID())
                .build();

       Response response= RequestBuilder.buildRequestforPostCalls()
                .body(employee)
                .post("/employees");

       response.prettyPrint();
        assertThat(response.getStatusCode()).isEqualTo(201);
        ExtentReport.getTest().pass(MarkupHelper.createCodeBlock(response.asPrettyString(), CodeLanguage.JSON));
    }

    @Test
    public void createEmployeeUsingExternalFile(Method method){
        ExtentReport.getTest().assignAuthor("Ram").assignCategory("Regression").info(MarkupHelper.createLabel("Author - Shyam", ExtentColor.AMBER));
        String resource=ApiUtils
                .readJsonAndGetString(FrameworkConstants.getRequestJsonFolderPath()+"request.json")
                .replace("fname", RandomUtils.getfName())
                .replace("id", String.valueOf(RandomUtils.getID()));

        Response response = RequestBuilder.buildRequestforPostCalls()
                .body(resource)
                .post("/employees");

        response.prettyPrint();

        ApiUtils.storeStringAsJsonFile(FrameworkConstants.getResponseJsonFloderPath()+method.getName()+"_"+"_response.json", response);
        assertThat(response.getStatusCode())
                .isEqualTo(201)
                .isPositive();

        ExtentReport.getTest().pass(MarkupHelper.createCodeBlock(response.asPrettyString(), CodeLanguage.JSON));

    }
/*


    @Test
    public void createEmployeeUsingExternalFile1(Method method){

       // FCwithSingleton.getInstance().getRequestJsonFolderPath()
        String resource=ApiUtils
                .readJsonAndGetString(requestJsonFolderPath+"request.json")
                .replace("fname", RandomUtils.getfName())
                .replace("id", String.valueOf(RandomUtils.getID()));

        Response response = RequestBuilder.buildRequestforPostCalls()
                .body(resource)
                .post("/employees");

        response.prettyPrint();

        ApiUtils.storeStringAsJsonFile(responseJsonFloderPath+method.getName()+"_"+"_response.json", response);
        assertThat(response.getStatusCode())
                .isEqualTo(201)
                .isPositive();



    }  */
}
