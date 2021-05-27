package com.epamTraining;

import integration.service.results.ResultsService;
import integration.service.runs.RunsService;
import io.qameta.allure.TmsLink;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UiTest extends BaseTest {

    RunsService runsService = new RunsService();
    ResultsService resultsService = new ResultsService();

    @Test
    @TmsLink("12")
    public void test1(){
        assertEquals(1,1);
    }

    @Test
    @TmsLink("13")
    public void test2(){
        assertEquals(1,1);
    }

    @Test
    @TmsLink("14")
    public void test3(){
        assertEquals("1","1");
    }

    @Test
    @TmsLink("15")
    public void test4(){
        assertEquals(5,5);
    }

    @Test
    @TmsLink("16")
    public void test5(){
        assertEquals("String","String");
    }


    @TmsLink("17")
    @Test(dataProvider = "Get All Values")
    public void test6(int num){
        assertEquals(num,4);
    }

    @DataProvider(name = "Get All Values")
    public static Object[][] getAllValues() {
        return new Object[][]{
                {3},
                {4},
                {5},
                {6},
                {12},
                {3},
        };
    }
}
