package edu.carrollcc.cis232;

import static com.jcabi.matchers.RegexMatchers.matchesPattern;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

public class Question1Test {
	
	@Rule
    public final TextFromStandardInputStream systemInMock= emptyStandardInputStream();

    @Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();
	
	@Test
	public void testCustomExceptionExists() {
		try {
			Class<?> exception = Class.forName("edu.carrollcc.cis232.InvalidTestScoreException");
			assertNotNull("InvalidTestScoreException class does not exist", exception);
		} catch (ClassNotFoundException e) {
			fail("InvalidTestScoreException does not exist!");
		}
	}
	
	@Test
	public void testTestScoresExists() {
		try {
			Class<?> testScores = Class.forName("edu.carrollcc.cis232.TestScores");
			assertNotNull("TestScores class does not exist", testScores);
		} catch (ClassNotFoundException e) {
			fail("TestScores does not exist!");
		}
	}
	
	@Test
	public void testTestScoresHasConstructor() {
		try {
			Class<?> testScores = Class.forName("edu.carrollcc.cis232.TestScores");
			assertNotNull("TestScores class does not exist", testScores);
			Constructor<?> m = testScores.getConstructor(double[].class);
			assertNotNull("TestScores class must have constructor that accepts array of double", m);
		} catch (ClassNotFoundException e) {
			fail("TestScores does not exist!");
		} catch (NoSuchMethodException e) {
			fail("TestScores must have constructor that accepts array of double");
		} 
	}
	
	@Test
	public void testTestScoresHasGetAverageMethod() {
		try {
			Class<?> testScores = Class.forName("edu.carrollcc.cis232.TestScores");
			assertNotNull("TestScores class does not exist", testScores);
			Method m = testScores.getDeclaredMethod("getAverage");
			assertEquals("getAverage must return a double", m.getReturnType(), double.class);
		} catch (ClassNotFoundException e) {
			fail("TestScores does not exist!");
		} catch (NoSuchMethodException e) {
			fail("TestScores must have method getAverage");
		} 
	}
	
	@Test
    /**
	 * This input should result in average of 86.9%
	 */
    public void testInputOne()
    {
		exit.expectSystemExit();
        systemInMock.provideText("90,72.4,80,100,99.9,90,76.2");
    	Question1.main(null);
    	String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, matchesPattern("(?smiu).*86\\.9%.*$"));
        System.exit(0);
    }
	
	@Test
    /**
	 * This input should result in average of 82.4%
	 */
    public void testInputTwo()
    {
		exit.expectSystemExit();
        systemInMock.provideText("99,hello,10,,100,100,100,double, number,   hi!,85.2222222");
    	Question1.main(null);
    	String output = systemOutRule.getLogWithNormalizedLineSeparator();
    	assertThat(output, matchesPattern("(?smiu).*skip.*$"));
        assertThat(output, matchesPattern("(?smiu).*82\\.4%.*$"));
        System.exit(0);
    }
	
	@Test
    /**
	 * This input should result in an error message
	 */
    public void testInputThree()
    {
		exit.expectSystemExit();
        systemInMock.provideText("-.0001,12,20,10");
    	Question1.main(null);
    	String output = systemOutRule.getLogWithNormalizedLineSeparator();
    	//Looking for a message that includes at least one of these keywords
        assertThat(output, matchesPattern("(?smiu).*(invalid|must|between|error)[ a-zA-Z0-9.!]*\n?$"));
        System.exit(0);
    }
	
}
