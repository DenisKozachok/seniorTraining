package com.epamTraining;

import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class ApiTest extends BaseTest {


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
}
