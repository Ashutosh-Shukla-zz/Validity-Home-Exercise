package com.validity.duplicates;

import static org.junit.Assert.assertEquals;

import org.apache.commons.codec.language.DoubleMetaphone;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.validity.service.LevenshteinDistance;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	// test assert
	@Test
	public void testLevenshtein() {

		assertEquals(1, LevenshteinDistance.calculate("test", "tst"));
		assertEquals(0, LevenshteinDistance.calculate("firstname", "firstname"));
		assertEquals(0, LevenshteinDistance.calculate("", ""));
	}

	@Test
	public void testDoubleMetaphone() {
		DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
		assertEquals(true, doubleMetaphone.isDoubleMetaphoneEqual("firstname", "firstname"));
		assertEquals(true, doubleMetaphone.isDoubleMetaphoneEqual("barney", "barni"));
	}

}