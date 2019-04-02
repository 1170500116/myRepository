/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.poet;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * Tests for GraphPoet.
 */
public class GraphPoetTest {
    
    // Testing strategy
    //   TODO
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    // TODO tests
    @Test
    public void testGraphPoet() throws IOException {
    	File file = new File("test/P1/poet/myfirst.txt");    	
    	GraphPoet g= new GraphPoet(file);
    	//System.out.println(g.poem("Test the system."));
    	assertEquals("Test of the system.",g.poem("Test the system."));     	
    	assertEquals("really matter to me.",g.poem("really matter me."));    
    	
    }

	
    
}
