package com.in28minutes.junit.helper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringHelperParameterized {
	
	static StringHelper helper;
	private String input;
	private String expected;
	

	public StringHelperParameterized(String input, String expected) {
		super();
		this.input = input;
		this.expected = expected;
	}

	@BeforeClass
	public static void before() {
		helper = new StringHelper();
	}
	

	@Parameters
	public static Collection<String[]> testCondition() {
		String expectedOutputs [][]={{"AACD" ,"CD"},
		{"ACD","CD"},{"CDEF","CDEF"},{"CDAA","CDAA"}};
		return Arrays.asList(expectedOutputs);
		/*
		 * all the String arrays contents will be passes to constructor and a new test
		 * instance will be created
		 */
	}
	
//	AACD => CD, ACD => CD ,CDEF=> CDEF ,CDAA=> CDAA
	@Test
	public void testTruncateAInFirst2Positions_ConditionsOne() {
		assertEquals( expected,helper.truncateAInFirst2Positions(input));	
	}
	
	
	
}
