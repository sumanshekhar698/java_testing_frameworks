package com.in28minutes.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;//important
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class) // Specific Runner for static methods
@PrepareForTest(SystemUnderTest.class)
public class MockingConstructorTest {
	/*
	 * Prepare the class for test => SystemUnderTest (class making use of the
	 * constructor) not the class with the constructor like -> ArrayList Override
	 * the constructor
	 */

	@Mock
	ArrayList mockList;

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
//		WHEN
		when(mockList.size()).thenReturn(stats.size()); // Static methods cannot be mocked normally

		PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(mockList);
		int size = systemUnderTest.methodUsingAnArrayListConstructor();
		assertEquals(4, size);

	}
}