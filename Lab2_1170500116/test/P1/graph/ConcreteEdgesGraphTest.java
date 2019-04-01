/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.graph;

import static org.junit.Assert.*;



import org.junit.Test;

/**
 * Tests for ConcreteEdgesGraph.
 * 
 * This class runs the GraphInstanceTest tests against ConcreteEdgesGraph, as
 * well as tests for that particular implementation.
 * 
 * Tests against the Graph spec should be in GraphInstanceTest.
 */
public class ConcreteEdgesGraphTest extends GraphInstanceTest {
    
    /*
     * Provide a ConcreteEdgesGraph for tests in GraphInstanceTest.
     */
    @Override public Graph<String> emptyInstance() {
        return new ConcreteEdgesGraph<String>();
    }
    
    /*
     * Testing ConcreteEdgesGraph...
     */
    
    // Testing strategy for ConcreteEdgesGraph.toString()
    //vertices has 0,1,2 vertex
    //edges has 1,2,3 edge
   
    // TODO tests for ConcreteEdgesGraph.toString()
    @Test
	  public void testToString() {
	  	 Graph<String> ceg = emptyInstance();	
	  	assertEquals("ConcreteEdgesGraph [vertices=[], edges=[ ]]",ceg.toString());
	  	ceg.add("a");
	  	assertEquals("ConcreteEdgesGraph [vertices=[a], edges=[ ]]",ceg.toString());
	  	ceg.add("bb");
	  	assertEquals("ConcreteEdgesGraph [vertices=[bb, a], edges=[ ]]",ceg.toString());
		ceg.add("c");
		assertEquals("ConcreteEdgesGraph [vertices=[bb, a, c], edges=[ ]]",ceg.toString());
	  	ceg.set("a", "bb", 1);
	  	assertEquals("ConcreteEdgesGraph [vertices=[bb, a, c], edges=[ [a,bb,1,] ]]",ceg.toString());
	  	ceg.set("a", "cc", 2);
		assertEquals("ConcreteEdgesGraph [vertices=[bb, cc, a, c], edges=[ [a,bb,1,] [a,cc,2,] ]]",ceg.toString());
	  	ceg.set("cc", "bb", 3);
		assertEquals("ConcreteEdgesGraph [vertices=[bb, cc, a, c], edges=[ [a,bb,1,] [a,cc,2,] [cc,bb,3,] ]]",ceg.toString());	
	  	
    }
  
    /*
     * Testing Edge...
     */
    
    // Testing strategy for Edge
   
   
    	
    
    // TODO tests for operations of Edge
    
    
 


  	
    
    
}
