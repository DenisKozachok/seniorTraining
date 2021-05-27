package integration.service.results;


import api.conditions.AssertableResponse;
import integration.model.results.addResult.AddTestCaseResultModel;
import integration.model.results.addResult.ResultsForCasesListModel;
import integration.service.TestRailAPIService;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.List;

public class ResultsService extends TestRailAPIService {

    @Step("Adds a new test result, comment or assigns a test.")
    public AssertableResponse postResultForCaseByTestByTestId(int testCaseId, AddTestCaseResultModel addTestCaseResult) {
        Response register =
                baseSetupHeaders()
                        .when()
                        .body(addTestCaseResult)
                        .queryParam("api/v2/add_result/" + testCaseId)
                        .post("")
                        .then().extract().response();
        return new AssertableResponse(register);
    }

    @Step("Adds a test case result, comment or assigns by Test Run id - {runId} and test case - {caseId}")
    public AssertableResponse postResultForCaseByTestRunIdByCaseID(int runId, int caseId, AddTestCaseResultModel addTestCaseResult) {
        Response register =
                baseSetupHeaders()
                        .when()
                        .body(addTestCaseResult)
                        .queryParam("api/v2/add_result_for_case/"+ runId + "/" + caseId)
                        .post("")
                        .then().extract().response();
        return new AssertableResponse(register);
    }

    @Step("Adds a test cases result, comment or assigns by Test Run id - {runId}")
    public AssertableResponse postResultForCasesByTestRunId(int runId, List<AddTestCaseResultModel> addTestCasesResult) {
        ResultsForCasesListModel testRunResult = new ResultsForCasesListModel()
                .setResults(addTestCasesResult);

        Response register =
                baseSetupHeaders()
                        .when()
                        .body(testRunResult)
                        .queryParam("api/v2/add_results_for_cases/"+ runId)
                        .post("")
                        .then().extract().response();
        return new AssertableResponse(register);
    }
}
