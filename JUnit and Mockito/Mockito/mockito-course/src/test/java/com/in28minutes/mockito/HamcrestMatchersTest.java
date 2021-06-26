package com.in28minutes.mockito;

//Matchers Library is more extendible than CoreMatchers
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.arrayWithSize;
//specific import
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestMatchersTest {

	@Test
	public void testHamcrestMatcher() {
		List<Integer> list = Arrays.asList(55, 22, 11, 59);
		// List
		assertThat(list, hasSize(4));
		assertThat(list, hasItems(11, 59));
		assertThat(list, everyItem(greaterThan(10)));

		// String
		assertThat("", isEmptyString());
		assertThat("", isEmptyOrNullString());

		// Array
		Integer[] marks = { 21, 12, 32, 52, 59, 22 };
		assertThat(marks, arrayWithSize(6));
		assertThat(marks, arrayContaining(21, 12, 32, 52, 59, 22));// order preservation is must
		assertThat(marks, arrayContainingInAnyOrder(21, 32, 12, 52, 59, 22));

	}
}
