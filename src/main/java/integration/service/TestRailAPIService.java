package integration.service;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestRailAPIService {

    String testRail = System.getProperty("test.rail.ulr");
    String userName = System.getProperty("test.rail.user.name");
    String userPass = System.getProperty("test.rail.password");

    protected RequestSpecification baseSetupHeaders() {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .auth().preemptive()
                .basic(userName, userPass)
                .baseUri(testRail)
                .filters(new RequestLoggingFilter(),
                        new ResponseLoggingFilter(),
                        new AllureRestAssured());
    }

}