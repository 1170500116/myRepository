/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P4.twitter;

import static org.junit.Assert.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class MySocialNetworkTest {

    /*
     * TODO: your testing strategies for these methods should go here.
     * See the ic03-testing exercise for examples of what a testing strategy comment looks like.
     * Make sure you have partitions.
     */
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test
    public void testGuessFollowsGraphEmpty() {
    	 Instant d1 = Instant.parse("2016-02-17T10:00:00Z");
    	 Instant d2 = Instant.parse("2016-02-17T11:00:00Z");
    	    
    	 Tweet tweet1 = new Tweet(1, "alyssa", "is it reas@onable to talk about rivest so much?@bbitdiddle,@mamma@bbbttT.hit.edu.cn", d1);
    	 Tweet tweet2 = new Tweet(2, "bbitDiddle", "rivest talk in @mam @BBI  30 minutes #hype @bBBTTT.", d2);
    	 Tweet tweet3 = new Tweet(3, "mamma", "is it reasonable to @bbbttt talk about #hype rivest so much?@alyssa?", d1);
    	 Tweet tweet4 = new Tweet(4, "bbbttt", "rivest @bbbttttalk in 30 minutes @bbItdiddle", d2);
         Map<String, Set<String>> followsGraph = MySocialNetwork.myGuessFollowsGraph(Arrays.asList(tweet1,tweet2,tweet3,tweet4));

         assertFalse("expected empty graph", followsGraph.isEmpty());
        
         
         Map<String, Set<String>> ans = new HashMap<>();
         Set<String> s1 = new HashSet<>();
         s1.add("bbitdiddle");
         s1.add("mamma");
         ans.put("alyssa", s1);
         Set<String> s2 = new HashSet<>();
         s2.add("bbbttt");
         s2.add("mamma");
         ans.put("bbitdiddle", s2);
         Set<String> s3 = new HashSet<>();
         s3.add("bbbttt");
         s3.add("alyssa");
         s3.add("bbitdiddle");
         ans.put("mamma", s3);
         Set<String> s4 = new HashSet<>();
         s4.add("bbitdiddle");
         ans.put("bbbttt", s4);
      //  System.out.println(followsGraph);
      //   System.out.println(ans);
     
         assertEquals(ans,followsGraph);
     
         
    }
    
    @Test
    public void testInfluencersEmpty() {
        Map<String, Set<String>> followsGraph = new HashMap<>();
        List<String> influencers = MySocialNetwork.myInfluencers(followsGraph);
        
        assertTrue("expected empty list", influencers.isEmpty());
        
        
        Instant d1 = Instant.parse("2016-02-17T10:00:00Z");
   	 Instant d2 = Instant.parse("2016-02-17T11:00:00Z");
   	    
   	 Tweet tweet1 = new Tweet(1, "alyssa", "is it reas@onable to talk about rivest so much?@bbitdiddle,@mamma@bbbttT.hit.edu.cn", d1);
	 Tweet tweet2 = new Tweet(2, "bbitDiddle", "rivest talk in @mam @BBI  30 minutes #hype @bBBTTT.", d2);
	 Tweet tweet3 = new Tweet(3, "mamma", "is it reasonable to @bbbttt talk about #hype rivest so much?@alyssa?", d1);
	 Tweet tweet4 = new Tweet(4, "bbbttt", "rivest @bbbttttalk in 30 minutes @bbItdiddle", d2);
      Map<String, Set<String>> followsGraph1 = MySocialNetwork.myGuessFollowsGraph(Arrays.asList(tweet1,tweet2,tweet3,tweet4));
        
     List<String> influencers1 = MySocialNetwork.myInfluencers(followsGraph1);
    System.out.println(influencers1);
     List<String> ans = new ArrayList<>();
     ans.add("bbitdiddle");
     ans.add("mamma");
     ans.add("bbbttt");
     ans.add("alyssa");
     
     assertEquals(ans,influencers1);
     
    }

    /*
     * Warning: all the tests you write here must be runnable against any
     * SocialNetwork class that follows the spec. It will be run against several
     * staff implementations of SocialNetwork, which will be done by overwriting
     * (temporarily) your version of SocialNetwork with the staff's version.
     * DO NOT strengthen the spec of SocialNetwork or its methods.
     * 
     * In particular, your test cases must not call helper methods of your own
     * that you have put in SocialNetwork, because that means you're testing a
     * stronger spec than SocialNetwork says. If you need such helper methods,
     * define them in a different class. If you only need them in this test
     * class, then keep them in this test class.
     */

}
