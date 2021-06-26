package com.in28minutes.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;//important
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

//@RunWith(MockitoJUnitRunner.class)
@RunWith(PowerMockRunner.class)// Specific Runner for static methods
public class InvokingPrivateMethodTest {
	

//	mocking with annotation
	@Mock
	Dependency dependency;

//	Automatically inject its dependencies if declared with @Mocks via ConstructorInjection
	@InjectMocks
	SystemUnderTest systemUnderTest;

	@Test
	public void testStaticMethod() throws Exception {
		/*
		 * Given -> When -> Then
		 * 
		 */

		List<Integer> stats = Arrays.asList(1, 2, 3, 4);
		given(dependency.retrieveAllStats()).willReturn(stats);
//		WHEN	
		long result = Whitebox.invokeMethod(systemUnderTest, "privateMethodUnderTest");
//		invokeMethod() can be used to test private/ innerclass methods
		//		THEN
		assertEquals(10,result);
		
	}
}