package com.Testng.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNgTestClassThree {
	@BeforeMethod
	public void setUpMethod(){
		System.out.println("inside beforeMethod-TestNgTestThree class - setUpMethod");		
	}
	
	@AfterMethod
	public static void tearDownMethod() {
		System.out.println("inside afterMethod -TestNgTestThree class- tearDownMethod");
	}	
	
	@BeforeTest
	public void setUpTest(){
		System.out.println("inside beforeTest -TestNgTestThree class setUpTest");		
	}
	
	@AfterTest
	public static void tearDownTest() {
		System.out.println("inside afterTest -TestNgTestThree class tearDownTest");
	}
	
	
	@Test
	public static void testScript_1() {
		System.out.println("i am in TestNgTestThree class and testScript_1 ");	
	}
	
}
