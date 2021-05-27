package com.epamTraining;

import com.epam.reportportal.testng.ReportPortalTestNGListener;
import com.github.javafaker.Faker;
import integration.enumProperty.ProjectId;
import integration.model.results.addResult.AddTestCaseResultModel;
import integration.model.runs.addOrUpdateRuns.AddOrUpdateRunsModel;
import integration.service.results.ResultsService;
import integration.service.runs.RunsService;
import io.qameta.allure.TmsLink;
import listener.TestListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static api.conditions.Conditions.statusCode;
import static listener.TestListener.autoTestResults;
import static org.testng.Assert.assertEquals;

@Listeners({ReportPortalTestNGListener.class, TestListener.class})
public class FirstTest {

    RunsService runsService = new RunsService();
    ResultsService resultsService = new ResultsService();

    @Test
    @TmsLink("1")
    public void test1(){
        assertEquals(1,1);
    }

    @Test
    @TmsLink("2")
    public void test2(){
        assertEquals(1,1);
    }

    @Test
    @TmsLink("3")
    public void test3(){
        assertEquals("1","1");
    }

    @Test
    @TmsLink("4")
    public void test4(){
        assertEquals(5,5);
    }

    @Test
    @TmsLink("5")
    public void test5(){
        assertEquals("String","String");
    }

    @Test
    @TmsLink("6")
    public void test6(){
        assertEquals("String","String");
    }

    @Test
    @TmsLink("7")
    public void test7(){
        assertEquals("String2","String");
    }

    @Test
    @TmsLink("8")
    public void test8(){
        assertEquals("test2","String");
    }

    @Test
    @TmsLink("9")
    public void test9(){
        assertEquals("test2","String");
    }

    @Test
    @TmsLink("10")
    public void test10(){
        assertEquals("String","String");
    }

    @Test
    @TmsLink("11")
    public void test11(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(true,false);
    }

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
