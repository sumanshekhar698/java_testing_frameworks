package com.in28minutes.junit.helper;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class ArraysCompareTestJava {

	@Test
	public void testArraySort_RandomArray() {
		int sample[]=	{15,52,31,41,15,16,177};
		int expected[]= {15,15,16,31,41,52,177};
		Arrays.sort(sample);
//		assertEquals(expected,sample);// checks the reference so fails
		assertArrayEquals(expected,sample);// checks the values
	}

	
	
	@Test
	public void testArray_test2() {
		int sample[]=	{15,52,31,41,15,16,177};
		int expected[]= {15,15,16,41,31,52,177};//wrong
/* arrays first differed at element [3]; expected:<41> but was:<31> at org.junit.internal.ComparisonCriteria.arrayEquals(ComparisonCriteria.java:78)
*/
		Arrays.sort(sample);
		assertArrayEquals(expected,sample);// checks the reference
	
	}

	

	@Test(expected=NullPointerException.class)
	//if the mentioned exception will come then test pass
	public void testArray_test3() {
		int sample[]=	null;
//		int sample[]=	{};
		

		int expected[]= {15,15,16,41,31,52,177};//wrong
		Arrays.sort(sample);//NullPointerException
		assertArrayEquals(expected,sample);// checks the reference

	}
	
	
	
	@Test(timeout=1000)//Milliseconds
	//if the mentioned time limit will surpass , test will fail
	public void testSort_Performance() {
		int sample[]= {15,15,16,41,31,52,177};//wrong
		for (int i = 0; i < 1000000; i++) {
			sample[0]=i;
			Arrays.sort(sample);
		}
	}
}

