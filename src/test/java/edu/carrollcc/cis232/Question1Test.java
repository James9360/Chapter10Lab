package edu.carrollcc.cis232;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.Rule;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

public class Question1Test {
	
	@Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();
}
