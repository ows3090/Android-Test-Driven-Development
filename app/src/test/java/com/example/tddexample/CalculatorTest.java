package com.example.tddexample;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
public class CalculatorTest {

    Calculator c = new Calculator();
    int a = 20;
    int b = 10;

    @BeforeClass
    public static void start(){
        System.out.println("start!");
    }

    @Before
    public void methodStart(){
        System.out.println("method start");
    }

    @Test
    public void sum() {
        Assert.assertEquals(30,c.sum(a,b));
    }

    @Test
    @Ignore
    public void sub() {
        Assert.assertEquals(10,c.sub(a,b));
    }

    @Test
    public void mul() {
        Assert.assertEquals(200,c.mul(a,b));
    }

    @Test
    public void div() {
        Assert.assertEquals(2,c.div(a,b));
    }

    @After
    public void methodFinish(){
        System.out.println("method finish");
    }

    @AfterClass
    public static void finish(){
        System.out.println("finish");
    }
}
