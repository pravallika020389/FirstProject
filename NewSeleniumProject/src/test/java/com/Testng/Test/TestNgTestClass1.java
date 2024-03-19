package com.Testng.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgTestClass1 {
	@BeforeClass
	public static void setUpForClass() {
		System.out.println("inside @Beforeclass setUpForClass");
	}
	@AfterClass
	public static void tearDownForClass() {
		System.out.println("inside @Afterclass tearDownForClass");
	}
	
	@BeforeMethod
	public static void setUpForMethod() {
		System.out.println("inside @BeforeMethod setUpForMethod");
	}
	
	@AfterMethod
	public static void tearDownForMethod() {
		System.out.println("inside @afterMethod tearDownForMethod");
	}
	
	@Test(priority = -6,enabled = true)
	public static void testMethod1() {
		System.out.println("inside TestNgTestClass1 class and test method 1");
		//throw new ArithmeticException();
	}
	
	@Test(priority = -3)
	public static void testMethod2() {
		System.out.println("inside TestNgTestClass1 class and test method 2");
	}
	@Test(priority = -10)
	public static void testMethod3() {
		System.out.println("inside TestNgTestClass1 class and test method 3");
	}

}
