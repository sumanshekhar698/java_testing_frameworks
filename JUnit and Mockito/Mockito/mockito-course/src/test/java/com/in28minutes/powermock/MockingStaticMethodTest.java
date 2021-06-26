package com.in28minutes.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;//important
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

//@RunWith(MockitoJUnitRunner.class)
@RunWith(PowerMockRunner.class)// Specific Runner for static methods
@PrepareForTest(UtilityClass.class)
public class MockingStaticMethodTest {
	
	/*
	 * STEPS to mock a static method
 	 * => Specific Runner 
 	 * => Initialize which class is having the static method
	 */

//	mocking with annotation
	@Mock
	Dependency dependency;

//	Automatically inject its dependencies if declared with @Mocks via ConstructorInjection
	@InjectMocks
	SystemUnderTest systemUnderTest;

	@Test
	public void testStaticMethod() {
		/*
		 * Given -> When -> Then
		 * 
		 */

		List<Integer> stats = Arrays.asList(1, 2, 3, 4);
		given(dependency.retrieveAllStats()).willReturn(stats);
//		WHEN

		PowerMockito.mockStatic(UtilityClass.class);
		
		when(UtilityClass.staticMethod(10)).thenReturn(100); //Static methods cannot be mocked normally
		int result = systemUnderTest.methodCallingAStaticMethod();
//		THEN
		assertEquals(100,result);
		
		PowerMockito.verifyStatic();
		UtilityClass.staticMethod(10);
	}
}