package com.epamTraining;

import com.epam.reportportal.testng.ReportPortalTestNGListener;
import com.github.javafaker.Faker;
import integration.enumProperty.ProjectId;
import integration.model.results.addResult.AddTestCaseResultModel;
import integration.model.runs.addOrUpdateRuns.AddOrUpdateRunsModel;
import integration.service.results.ResultsService;
import integration.service.runs.RunsService;
import listener.TestListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;

import java.util.ArrayList;
import java.util.List;

import static api.conditions.Conditions.statusCode;
import static listener.TestListener.autoTestResults;

@Listeners({ReportPortalTestNGListener.class, TestListener.class})
public class BaseTest {


    RunsService runsService = new RunsService();
    ResultsService resultsService = new ResultsService();

    @AfterSuite
    public void afterSuite(){
        AddOrUpdateRunsModel createTestRun = new AddOrUpdateRunsModel(
                "Run Id = " + new Faker().number().digits(5) + " Pre-release AutoTest run JavaTest ");

        int testRunId = Integer.parseInt(runsService.postAddTestRun(ProjectId.SENIOR_TRAINING, createTestRun)
                .shouldHave(statusCode(200))
                .getBodyByPath("id"));

        List<Integer> casesId = new ArrayList<>();
        for (AddTestCaseResultModel autoTestResult : autoTestResults) {
            casesId.add(autoTestResult.getCaseId());
        }

        AddOrUpdateRunsModel updateTestRun = new AddOrUpdateRunsModel()
                .setCaseIds(casesId);

        runsService.postUpdateTestRun(testRunId, updateTestRun)
                .shouldHave(statusCode(200));

        resultsService.postResultForCasesByTestRunId(testRunId, autoTestResults)
                .shouldHave(statusCode(200));
    }
}
