package integration.service.сases;

import api.conditions.AssertableResponse;
import integration.service.TestRailAPIService;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class CasesService extends TestRailAPIService {

    @Step("Returns an existing test case.")
    public AssertableResponse getTestCaseById(int testCaseId) {
        Response register =
                baseSetupHeaders()
                        .when()
                        .param("api/v2/get_case/" + testCaseId, "")
                        .get()
                        .then().extract().response();
        return new AssertableResponse(register);
    }

}
