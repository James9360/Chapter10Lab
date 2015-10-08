package edu.carrollcc.cis232;

import static com.jcabi.matchers.RegexMatchers.matchesPattern;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.io.File;
import java.io.Serializable;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

public class Question2Test {
	@Rule
	public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	@Rule
	public final ExpectedSystemExit exit = ExpectedSystemExit.none();
	
	
	
	@Test
	public void testTestScoresImplementsSerializable() {
		try {
			Class<?> scores = Class.forName("edu.carrollcc.cis232.TestScores");
			assertTrue("TestScores must implement Serializable", Serializable.class.isAssignableFrom(scores));
		} catch (ClassNotFoundException e) {
			fail("TestScores  does not exist!");
		}
	}
	
	@Test
    public void testWritingToNewFile()
    {
		exit.expectSystemExit();
		systemInMock.provideLines("scores.file", "90,72.4,80,100,99.9,90,76.2");
    	Question1.main(null);
    	String output = systemOutRule.getLogWithNormalizedLineSeparator();
    	assertThat(output, matchesPattern("(?smiu).*new file.*$"));
        assertThat(output, matchesPattern("(?smiu).*86\\.9%.*$"));
        File file = new File("scores.file");
        assertTrue("file was not created", file.exists());
        //clean up
        file.delete();
        System.exit(0);
    }
	
	@Test
	public void testAppendingToOldFile()
    {
		exit.expectSystemExit();
		//fill up a file with multiple scores
		systemInMock.provideLines("scores2.file", "90,72.4,80,100,99.9,90,76.2");
    	Question1.main(null);
    	systemInMock.provideLines("scores2.file", "99,hello,10,,100,100,100,double, number,   hi!,85.2222222");
    	Question1.main(null);
    	systemInMock.provideLines("scores2.file", "-.0001,12,20,10");
    	Question1.main(null);
    	systemInMock.provideLines("scores2.file", "90,90,90,90,90,90,90,100");
    	Question1.main(null);
    	
    	String output = systemOutRule.getLogWithNormalizedLineSeparator();
    	assertThat(output, matchesPattern("(?smiu).*new file.*$"));
        assertThat(output, matchesPattern("(?smiu).*86\\.9%.*82\\.4%.*91\\.3%.*$"));
        File file = new File("scores2.file");
        assertTrue("file was not created", file.exists());
        //clean up
        file.delete();
        System.exit(0);
    }
}
