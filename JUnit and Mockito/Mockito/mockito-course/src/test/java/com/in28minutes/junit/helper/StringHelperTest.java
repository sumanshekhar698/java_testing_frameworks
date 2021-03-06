package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringHelperTest {
	StringHelper helper = new StringHelper();

	@Test
	public void testTruncateAInFirst2Positions_AinFirst2Position() {
//		fail("Not yet implemented");
//		assertEquals("ABCD", "ABCD");
//						EA
		/*
		 * AACD -> CD ACD -> CD CDEF -> CDEF CDAA -. CDAA
		 */
		String expected = "CD";
		assertEquals(expected, helper.truncateAInFirst2Positions("AACD"));

	}

	
	@Test
	public void testTruncateAInFirst2Positions_AinFirstPosition() {
		String expected = "CD";
		assertEquals(expected, helper.truncateAInFirst2Positions("ACD"));
	}

	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario() {
//		assertEquals(false, helper.areFirstAndLastTwoCharactersTheSame("ABC"));
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("AB"));
		

	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicPositiveScenario() {
//		assertEquals(false, helper.areFirstAndLastTwoCharactersTheSame("ABC"));
		assertFalse("MSG: failed for 'true'",helper.areFirstAndLastTwoCharactersTheSame("ABA"));
	}	
}
