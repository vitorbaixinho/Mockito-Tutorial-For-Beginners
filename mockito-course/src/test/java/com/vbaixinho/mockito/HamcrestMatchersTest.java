package com.vbaixinho.mockito;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestMatchersTest {

	@Test
	public void test() {
		
		List<Integer> scores = Arrays.asList(99,100,101,105);
		
		assertThat(scores, hasSize(4));
        assertThat(scores, hasItems(100, 101));
        assertThat(scores, everyItem(greaterThan(90)));
        assertThat(scores, everyItem(lessThan(200)));
        
        // String
        assertThat("", isEmptyString());
        assertThat(null, isEmptyOrNullString());
        
		// Arrays

	}

}
