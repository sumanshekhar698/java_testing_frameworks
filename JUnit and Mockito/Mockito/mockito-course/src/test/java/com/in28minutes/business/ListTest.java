package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void letsMockListSize() {
		List<String> listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);
		assertEquals(2, listMock.size());
		assertEquals(2, listMock.size());

	}

	@Test
	public void letsMockListSizeFor2Scenario() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());

	}

	@Test
	public void letsMockListGet() {
		List listMock = mock(List.class);
		when(listMock.get(0)).thenReturn("BRAVO");
		assertEquals("BRAVO", listMock.get(0));

	}

	@Test
	public void letsMockListGetNiceMock() {
		List listMock = mock(List.class);
		when(listMock.get(0)).thenReturn("BRAVO");
		assertEquals(null, listMock.get(2));// NiceMock

	}

	@Test
	public void letsMockListGetArgumenMatcher() {
		List listMock = mock(List.class);
		when(listMock.get(0)).thenReturn("BRAV0");
//		ArgumentMatcher -> anyInt(), anyString() , anyObject()
		when(listMock.get(anyInt())).thenReturn("BRAVO"); // Overrides previous condition
		assertEquals("BRAVO", listMock.get(0));// Nice Mock
//		 ArgumentMatcher will override NiceMocks

	}

	@Test(expected = RuntimeException.class)
	public void letsMockListGetWithException() {
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Runtime Exception success"));
//		when(listMock.get(anyInt(),9)).thenThrow(new RuntimeException("Runtime Exception success"));
//		The above statement is invalid 

	}

	// BDD style
	@Test(expected = RuntimeException.class)
	public void letsMockListGet_usingBDD() {

		// given
		List<String> listMock = mock(List.class);
		given(listMock.get(anyInt())).willReturn("BDD");

		// when
		String element = listMock.get(0);

		// then
		assertThat(element, is("BDD"));

	}
}
