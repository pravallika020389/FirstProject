package com.Testng.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNgTestClassTwo {
	@Parameters({"browserName","version"})
	@Test
	public void testscript_1(String name,String version1) {
		System.out.println("name="+name+ " and version="+version1);
		System.out.println("i am in TestNgTestTwo class and testScript_1 ");
		
	}
	@Test
	public void testscript_2() {
		System.out.println("i am in TestNgTestTwo class and testScript_2");
		
	}
}
