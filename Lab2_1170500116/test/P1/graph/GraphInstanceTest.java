/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.graph;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * Tests for instance methods of Graph.
 * 
 * <p>PS2 instructions: you MUST NOT add constructors, fields, or non-@Test
 * methods to this class, or change the spec of {@link #emptyInstance()}.
 * Your tests MUST only obtain Graph instances by calling emptyInstance().
 * Your tests MUST NOT refer to specific concrete implementations.
 */
public abstract class GraphInstanceTest {
    
    // Testing strategy
    //   TODO
    
    /**
     * Overridden by implementation-specific test classes.
     * 
     * @return a new empty graph of the particular implementation being tested
     */
    public abstract Graph<String> emptyInstance();
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test
    public void testInitialVerticesEmpty() {
        // TODO you may use, change, or remove this test
        assertEquals("expected new graph to have no vertices",
                Collections.emptySet(), emptyInstance().vertices());
    }
    
    
    // TODO other tests for instance methods of Graph
    // Testing strategy
    //testing strategy for each operation of Graph:
    //add(L vertex):
    //		"a","b"(a vertex is in the vertices),"a"(a vertex is not in the vertices)
    //set(L source, L target, int weight):
    //		source equals with target or not
    //		source is in the vertices or not,target is in the vertices or not
    //		weight is 0 or not
    //      the old weight between source and target is nonzero
    //      there is no edge between source and target
    //remove(L vertex):
    //		this vertex is in the vertices or not
    //		this vetrex is in the edges as source or target none ,once,twice,thirds
    //vertices():
    //		the vertices has 0,1,2 vertices
    //sources(L target):
    //		target is not in the vertices
    //		target is in the vertices:
    //      	target has 0,1,2 sources
    //target(L sources):
    //		sources is not in the vertices
    //		sources is in the vertices:
    //			source has 0,1,2 targets
   
    @Test
    public void testAddAndSet() {
    	Graph<String> ceg = emptyInstance();
    	
    	assertTrue(ceg.add("a"));
	    assertTrue(ceg.add("bb"));
	  	assertFalse(ceg.add("a"));	  
		ceg.add("cc");
		
		
		assertEquals(ceg.set("a", "bb", 0),0);		
		assertEquals(ceg.set("a", "bb", 1),0);		
		assertEquals(ceg.set("a", "cc", 2),0);		
		assertEquals(ceg.set("a", "dd", 3),0);
		assertEquals(ceg.set("ee", "dd", 3),0);	 			
	    assertEquals(ceg.set("a", "bb", 0),1);
		assertEquals( ceg.set("a", "dd", 2),3);		
		assertEquals( ceg.set("a", "a", 3),0);
		
	}

    @Test
    public void testOthers() {
    	Graph<String> ceg = emptyInstance();
	  	ceg.add("a");
	  	ceg.add("bb");
		ceg.add("cc");		
	    ceg.set("a", "bb", 1);
	    ceg.set("bb", "cc", 1);
	    Set<String> myvertices = new HashSet<>();
	    myvertices.add("a");
	    myvertices.add("bb");
	    myvertices.add("cc");
	    Map<String,Integer> asources =new HashMap<>();
	    Map<String,Integer> bbsources =new HashMap<>();
	    Map<String,Integer> ccsources =new HashMap<>();
	    Map<String,Integer> ddsources =new HashMap<>();
	    Map<String,Integer> atargets =new HashMap<>();
	    Map<String,Integer> bbtargets =new HashMap<>();
	    Map<String,Integer> cctargets =new HashMap<>();
	    Map<String,Integer> ddtargets =new HashMap<>();
	    bbsources.put("a", 1);
	    ccsources.put("bb", 1);
	    atargets.put("bb", 1);
	    bbtargets.put("cc", 1);
	    assertEquals(ceg.vertices(),myvertices);	 
	
	    assertEquals(ceg.sources("a"),asources);
	    assertEquals(ceg.sources("bb"),bbsources);
	    assertEquals(ceg.sources("cc"),ccsources);
	    assertEquals(ceg.targets("a"),atargets);
	    assertEquals(ceg.targets("bb"),bbtargets);
	    assertEquals(ceg.targets("cc"),cctargets);
	    
	    
	    
	  
	    assertTrue(ceg.remove("a"));	
	    bbsources.remove("a");
	    atargets.remove("bb");
	    myvertices.remove("a");    
	    
	    
	    assertEquals(ceg.vertices(),myvertices);	 
		
	    assertEquals(ceg.sources("a"),asources);
	    assertEquals(ceg.sources("bb"),bbsources);
	    assertEquals(ceg.sources("cc"),ccsources);
	    assertEquals(ceg.targets("a"),atargets);
	    assertEquals(ceg.targets("bb"),bbtargets);
	    assertEquals(ceg.targets("cc"),cctargets);
	   
	    ceg.set("a", "bb", 1);
	    ceg.set("a", "cc", 2);
	    
	    myvertices.add("a");
	    atargets.put("bb", 1);
	    atargets.put("cc", 2);
	    bbsources.put("a", 1);
	    ccsources.put("a", 2);
	    
	    assertEquals(ceg.vertices(),myvertices);	 
		
	    assertEquals(ceg.sources("a"),asources);
	    assertEquals(ceg.sources("bb"),bbsources);
	    assertEquals(ceg.sources("cc"),ccsources);
	    assertEquals(ceg.targets("a"),atargets);
	    assertEquals(ceg.targets("bb"),bbtargets);
	    assertEquals(ceg.targets("cc"),cctargets);
	    
	   
	    

	    assertTrue(ceg.remove("a"));	
	    
	    bbsources.remove("a");
	    ccsources.remove("a");
	    atargets.remove("bb");
	    atargets.remove("cc");
	    myvertices.remove("a"); 
	    
	 
	    assertEquals(ceg.vertices(),myvertices);	 
		
	    assertEquals(ceg.sources("a"),asources);
	    assertEquals(ceg.sources("bb"),bbsources);
	    assertEquals(ceg.sources("cc"),ccsources);
	    assertEquals(ceg.targets("a"),atargets);
	    assertEquals(ceg.targets("bb"),bbtargets);
	    assertEquals(ceg.targets("cc"),cctargets);
	    
	    
	    
	   
	   
	    
	    ceg.set("a", "bb", 1);	    
	    ceg.set("a", "cc", 1);	    
	    ceg.set("a", "dd", 1);
	    
	    myvertices.add("a");
	    myvertices.add("dd");
	    atargets.put("bb", 1);
	    atargets.put("cc", 1);
	    atargets.put("dd", 1);
	    bbsources.put("a", 1);
	    ccsources.put("a", 1);
	    ddsources.put("dd", 1);  
	    
	    assertEquals(ceg.vertices(),myvertices);	 
		
	    assertEquals(ceg.sources("a"),asources);
	    assertEquals(ceg.sources("bb"),bbsources);
	    assertEquals(ceg.sources("cc"),ccsources);
	    assertEquals(ceg.targets("a"),atargets);
	    assertEquals(ceg.targets("bb"),bbtargets);
	    assertEquals(ceg.targets("cc"),cctargets);
	   
	    assertTrue(ceg.remove("a"));	  
	   
	    bbsources.remove("a");
	    ccsources.remove("a");
	    ddsources.remove("a");
	    atargets.remove("bb");
	    atargets.remove("cc");
	    atargets.remove("dd");
	    myvertices.remove("a"); 
	    
	    assertEquals(ceg.vertices(),myvertices);	 
		
	    assertEquals(ceg.sources("a"),asources);
	    assertEquals(ceg.sources("bb"),bbsources);
	    assertEquals(ceg.sources("cc"),ccsources);
	    assertEquals(ceg.targets("a"),atargets);
	    assertEquals(ceg.targets("bb"),bbtargets);
	    assertEquals(ceg.targets("cc"),cctargets);
	   
	    
	   
	    assertFalse(ceg.remove("d"));	   

	    assertEquals(ceg.vertices(),myvertices);	 
		
	    assertEquals(ceg.sources("a"),asources);
	    assertEquals(ceg.sources("bb"),bbsources);
	    assertEquals(ceg.sources("cc"),ccsources);
	    assertEquals(ceg.targets("a"),atargets);
	    assertEquals(ceg.targets("bb"),bbtargets);
	    assertEquals(ceg.targets("cc"),cctargets);
		
		
		 assertTrue(ceg.remove("cc"));
		 
		 bbtargets.remove("cc");
	     ccsources.remove("bb");
	     myvertices.remove("cc"); 
	
	     assertEquals(ceg.vertices(),myvertices);	 
		
	    assertEquals(ceg.sources("a"),asources);
	    assertEquals(ceg.sources("bb"),bbsources);
	    assertEquals(ceg.sources("cc"),ccsources);
	    assertEquals(ceg.targets("a"),atargets);
	    assertEquals(ceg.targets("bb"),bbtargets);
	    assertEquals(ceg.targets("cc"),cctargets);
		
	
		 ceg.set("a", "cc", 1);
		 ceg.set("bb", "cc", 1);
		 
		
		 myvertices.add("a");	 
		 myvertices.add("cc");	 
		atargets.put("cc", 1);		
		bbtargets.put("cc", 1);
		ccsources.put("a", 1);
		ccsources.put("bb", 1); 
		
		
		assertEquals(ceg.vertices(),myvertices);	 
		
	    assertEquals(ceg.sources("a"),asources);
	    assertEquals(ceg.sources("bb"),bbsources);
	    assertEquals(ceg.sources("cc"),ccsources);
	    assertEquals(ceg.targets("a"),atargets);
	    assertEquals(ceg.targets("bb"),bbtargets);
	    assertEquals(ceg.targets("cc"),cctargets);
	    
	    
		 assertTrue(ceg.remove("cc"));	
		 
		 
		 myvertices.remove("cc");	 
		atargets.remove("cc", 1);		
		bbtargets.remove("cc", 1);
		ccsources.remove("a", 1);
		ccsources.remove("bb", 1); 
		
		assertEquals(ceg.vertices(),myvertices);	 
		
	    assertEquals(ceg.sources("a"),asources);
	    assertEquals(ceg.sources("bb"),bbsources);
	    assertEquals(ceg.sources("cc"),ccsources);
	    assertEquals(ceg.targets("a"),atargets);
	    assertEquals(ceg.targets("bb"),bbtargets);
	    assertEquals(ceg.targets("cc"),cctargets);
	    
	    
		
		 ceg.set("a", "cc", 1);
		 ceg.set("bb", "cc", 1);
		 ceg.set("dd", "cc", 1);
		 
		 
		 myvertices.add("cc");	 
		atargets.put("cc", 1);		
		bbtargets.put("cc", 1);
		ddtargets.put("cc", 1);
		ccsources.put("a", 1);
		ccsources.put("bb", 1); 
		ccsources.put("dd", 1); 
		
		assertEquals(ceg.vertices(),myvertices);	 
		
	    assertEquals(ceg.sources("a"),asources);
	    assertEquals(ceg.sources("bb"),bbsources);
	    assertEquals(ceg.sources("cc"),ccsources);
	    assertEquals(ceg.targets("a"),atargets);
	    assertEquals(ceg.targets("bb"),bbtargets);
	    assertEquals(ceg.targets("cc"),cctargets);
		
		 assertTrue(ceg.remove("cc"));	
		 
		 myvertices.remove("cc");	 
		atargets.remove("cc", 1);		
		bbtargets.remove("cc", 1);
		ddtargets.remove("cc", 1);
		ccsources.remove("a", 1);
		ccsources.remove("bb", 1); 
		ccsources.remove("dd", 1); 
		   
		
    }
}
