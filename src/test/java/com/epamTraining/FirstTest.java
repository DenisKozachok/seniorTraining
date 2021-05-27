package com.epamTraining;

import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners({ReportPortalTestNGListener.class})
public class FirstTest {

    @Test
    public void test1(){
        assertEquals(1,1);
    }

    @Test
    public void test2(){
        assertEquals(1,1);
    }

    @Test
    public void test3(){
        assertEquals("1","1");
    }

    @Test
    public void test4(){
        assertEquals(5,5);
    }

    @Test
    public void test5(){
        assertEquals("String","String");
    }

    @Test
    public void test6(){
        assertEquals("String","String");
    }

    @Test
    public void test7(){
        assertEquals("String2","String");
    }

    @Test
    public void test8(){
        assertEquals("test2","String");
    }

    @Test
    public void test9(){
        assertEquals("test2","String");
    }

    @Test
    public void test10(){
        assertEquals("String","String");
    }

    @Test
    public void test11(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(true,false);
    }


}
