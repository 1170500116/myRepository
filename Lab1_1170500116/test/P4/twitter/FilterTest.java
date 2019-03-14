/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P4.twitter;

import static org.junit.Assert.*;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FilterTest {

    /*
     * TODO: your testing strategies for these methods should go here.
     * See the ic03-testing exercise for examples of what a testing strategy comment looks like.
     * Make sure you have partitions.
     */
    
    private static final Instant d1 = Instant.parse("2016-02-17T10:00:00Z");
    private static final Instant d2 = Instant.parse("2016-02-17T11:00:00Z");
    
    private static final Tweet tweet1 = new Tweet(1, "alyssa", "is it reasonable to talk about rivest so much?", d1);
    private static final Tweet tweet2 = new Tweet(2, "bbitdiddle", "rivest talk in 30 minutes #hype", d2);
    private static final Tweet tweet3 = new Tweet(3, "Alyssa", "rivest talk in 30 minutes #hype", d2);
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test
    public void testWrittenByMultipleTweetsSingleResult() {
        List<Tweet> writtenBy = Filter.writtenBy(Arrays.asList(tweet1, tweet2), "alyssa");
        List<Tweet> writtenBy2 = Filter.writtenBy(Arrays.asList(tweet1, tweet2,tweet3), "alyssa");
        assertEquals("expected singleton list", 1, writtenBy.size());
        assertTrue("expected list to contain tweet", writtenBy.contains(tweet1));
        assertEquals("expected singleton list",2, writtenBy2.size());
        assertTrue("expected list to contain tweet", writtenBy2.contains(tweet1));
        assertTrue("expected list to contain tweet", writtenBy2.contains(tweet3));
    }
    
    @Test
    public void testInTimespanMultipleTweetsMultipleResults() {
        Instant testStart = Instant.parse("2016-02-17T09:00:00Z");
        Instant testEnd = Instant.parse("2016-02-17T12:00:00Z");
        
        List<Tweet> inTimespan = Filter.inTimespan(Arrays.asList(tweet1, tweet2), new Timespan(testStart, testEnd));
        
        assertFalse("expected non-empty list", inTimespan.isEmpty());
        assertTrue("expected list to contain tweets", inTimespan.containsAll(Arrays.asList(tweet1, tweet2)));
        assertEquals("expected same order", 0, inTimespan.indexOf(tweet1));
    }
    
    @Test
    public void testContaining() {
        List<Tweet> containing = Filter.containing(Arrays.asList(tweet1, tweet2), Arrays.asList("talk"));
        
        assertFalse("expected non-empty list", containing.isEmpty());
        assertTrue("expected list to contain tweets", containing.containsAll(Arrays.asList(tweet1, tweet2)));
        assertEquals("expected same order", 0, containing.indexOf(tweet1));
        
        List<Tweet> containing2 = Filter.containing(Arrays.asList(tweet1, tweet2), Arrays.asList("#hype","reasonable"));
        
        assertFalse("expected non-empty list", containing2.isEmpty());
        assertTrue("expected list to contain tweets", containing2.containsAll(Arrays.asList(tweet1, tweet2)));
        assertEquals("expected same order", 0, containing2.indexOf(tweet1));
        
       // List<Tweet> containing3 = Filter.containing(Arrays.asList(tweet1, tweet2), Arrays.asList("#h ype"));
       // List<Tweet> containing4 = Filter.containing(Arrays.asList(tweet1, tweet2), Arrays.asList("#hype",""));
    
        List<Tweet> containing5 = Filter.containing(Arrays.asList(tweet1, tweet2), Arrays.asList("is"));
        
        assertFalse("expected non-empty list", containing5.isEmpty());
        assertTrue("expected list to contain tweets", containing5.containsAll(Arrays.asList(tweet1)));
        assertEquals("expected same order", 0, containing5.indexOf(tweet1));
        
        
        List<Tweet> containing6 = Filter.containing(Arrays.asList(tweet1, tweet2), Arrays.asList("rivest"));
        
        assertFalse("expected non-empty list", containing6.isEmpty());
        assertTrue("expected list to contain tweets", containing6.containsAll(Arrays.asList(tweet1,tweet2)));
        assertEquals("expected same order", 0, containing6.indexOf(tweet1));
        
    }

    /*
     * Warning: all the tests you write here must be runnable against any Filter
     * class that follows the spec. It will be run against several staff
     * implementations of Filter, which will be done by overwriting
     * (temporarily) your version of Filter with the staff's version.
     * DO NOT strengthen the spec of Filter or its methods.
     * 
     * In particular, your test cases must not call helper methods of your own
     * that you have put in Filter, because that means you're testing a stronger
     * spec than Filter says. If you need such helper methods, define them in a
     * different class. If you only need them in this test class, then keep them
     * in this test class.
     */

}
