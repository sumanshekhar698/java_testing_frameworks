package com.in28minutes.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;

import org.junit.Test;

public class MockitoSpySample {

	@Test
	public void testDummy() {
		ArrayList arrayListMock = mock(ArrayList.class);// mock return default value ie 0
		assertEquals(0, arrayListMock.size());

		stub(arrayListMock.size()).toReturn(5);// stubbing will return 5 value
		arrayListMock.add("Dummy");// this will not change from 5|>6
		assertEquals(5, arrayListMock.size());
	}

	@Test
	public void testSpy() {
		ArrayList arrayListMock = spy(ArrayList.class);// mock return default value ie 0
		assertEquals(0, arrayListMock.size());
		arrayListMock.add("Dummy");// this will change from 0|>1
		assertEquals(1, arrayListMock.size());
		arrayListMock.remove("Dummy");// this will change from 1|>0
		assertEquals(0, arrayListMock.size());

//		Stubbing will override the normal functionality of size()
		stub(arrayListMock.size()).toReturn(5);// stubbing will return 5 value
		arrayListMock.add("Tummy");// this will not change from 5|>6 because
		assertEquals(5, arrayListMock.size());
		System.out.println(arrayListMock);// Tummy

//		Verification also works fine in Spy
		verify(arrayListMock).add("Tummy");
		verify(arrayListMock, never()).clear();
	}

}
