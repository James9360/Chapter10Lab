package edu.carrollcc.cis232;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.Serializable;

import org.junit.Test;

public class Question2Test {
	@Test
	public void testTestScoresImplementsSerializable() {
		try {
			Class<?> scores = Class.forName("edu.carrollcc.cis232.TestScores");
			assertTrue("TestScores must implement Serializable", Serializable.class.isAssignableFrom(scores));
		} catch (ClassNotFoundException e) {
			fail("TestScores does not exist!");
		}
	}
}
