package com.requestbuilder;
import com.enums.PropertiesType;
import com.tmb.utils.PropertyUtils;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
public final class RequestBuilder {

    private RequestBuilder(){}

    public static RequestSpecification buildRequestForGetCalls(){
        return given()
                .baseUri(PropertyUtils.getValue(PropertiesType.BASEURI))
                .log()
                .all();

    }

    public static RequestSpecification buildRequestforPostCalls(){

        return buildRequestForGetCalls()
                .contentType(ContentType.JSON);
    }
}
