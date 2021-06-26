package com.in28minutes.junit.helper;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuickBeforeAftertest {

	
	
	@BeforeClass
	public static void setup() {
	System.out.println("***Before execution of class\"Initializers & Precurssors\"");
}
	
	@AfterClass
	public static void dispose() {
	System.out.println("***After execution of class \"Dispossal\"");
}
	
	
	
	
	
	
	@Before
	public void initialize() {
	System.out.println("Before test \"Initializers & Precurssors\"");
}
	
	@After
	public void teardown() {
	System.out.println("After test \"Dispossal\"");
}
	
	
	@Test
	public void test1() {
		System.out.println("test 1 excuted");
	}

	
	
	@Test
	public void test2() {
		System.out.println("test 2 excuted");
	}

}