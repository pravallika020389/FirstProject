package com.Testng.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNgTestClassOne {
	@Test
	public void testscript_1() {
		System.out.println("i am in TestNgTestOne class and testScript_1 ");
		
	}
	@Parameters({"browserName"})
	@Test
	public void testscript_2(String name1) {
		System.out.println("name from testngOne ="+name1);
		System.out.println("i am in TestNgTestOne class and testScript_2");
		
	}
}
