/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.graph;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.Test;

/**
 * Tests for ConcreteVerticesGraph.
 * 
 * This class runs the GraphInstanceTest tests against ConcreteVerticesGraph, as
 * well as tests for that particular implementation.
 * 
 * Tests against the Graph spec should be in GraphInstanceTest.
 */
public class ConcreteVerticesGraphTest extends GraphInstanceTest {
    
    /*
     * Provide a ConcreteVerticesGraph for tests in GraphInstanceTest.
     */
    @Override public Graph<String> emptyInstance() {
        return new ConcreteVerticesGraph<String>();
        //return new ConcreteEdgesGraph<String>();
    }
    
    /*
     * Testing ConcreteVerticesGraph...
     */
    
    // Testing strategy for ConcreteVerticesGraph.toString()    
    //sources has 0,1,2 vertex
    //targets has 0,1,2 vertex
    // TODO tests for ConcreteVerticesGraph.toString()
    @Test
	  public void testToString() {
	  	 Graph<String> ceg = emptyInstance();  	 
	  	assertEquals("ConcreteVerticesGraph [vertices=\n" + 
	  			"]",ceg.toString());
	  	
	  	
	  	ceg.add("a");
	  	assertEquals("ConcreteVerticesGraph [vertices=\n" + 
  			"[a,sources=[],targets = []]\n" + 
  			"]",ceg.toString());
	  	
	  	ceg.add("bb");	  		
	  	assertEquals("ConcreteVerticesGraph [vertices=\n" + 
	  			"[a,sources=[],targets = []]\n" + 
	  			"[bb,sources=[],targets = []]\n" + 
	  			"]",ceg.toString());
		
	  	ceg.add("c");
		assertEquals("ConcreteVerticesGraph [vertices=\n" + 
				"[a,sources=[],targets = []]\n" + 
				"[bb,sources=[],targets = []]\n" + 
				"[c,sources=[],targets = []]\n" + 
				"]",ceg.toString());
	  	ceg.set("a", "bb", 1);		
	  	assertEquals("ConcreteVerticesGraph [vertices=\n" + 
	  			"[a,sources=[],targets = [[bb,1]]]\n" + 
	  			"[bb,sources=[[a,1]],targets = []]\n" + 
	  			"[c,sources=[],targets = []]\n" + 
	  			"]",ceg.toString());
	  	
	  	ceg.set("a", "cc", 2);	  	
		assertEquals("ConcreteVerticesGraph [vertices=\n" + 
				"[a,sources=[],targets = [[bb,1][cc,2]]]\n" + 
				"[bb,sources=[[a,1]],targets = []]\n" + 
				"[c,sources=[],targets = []]\n" + 
				"[cc,sources=[[a,2]],targets = []]\n" + 
				"]",ceg.toString());
		
	  	ceg.set("cc", "bb", 3);	  	
		assertEquals("ConcreteVerticesGraph [vertices=\n" + 
				"[a,sources=[],targets = [[bb,1][cc,2]]]\n" + 
				"[bb,sources=[[cc,3][a,1]],targets = []]\n" + 
				"[c,sources=[],targets = []]\n" + 
				"[cc,sources=[[a,2]],targets = [[bb,3]]]\n" + 
				"]",ceg.toString());	
	  	
    }
    
    /*
     * Testing Vertex...
     */
    
    // Testing strategy for Vertex
    // For Vertex(L vex, Map<L, Integer> sources, Map<L, Integer> targets)
    //			the sources is null or size = 0 or not
    //          the targets is null or size = 0 or not
    //          the vex is null or not
    // For getters, test if there is any rep exposure
    // For setters, test if the source  or target is setted successfully and if there is any rep exposure
    // For toString, test along within the tests for operations of Vertex as an anwser quiz
    
    // TODO tests for operations of Vertex   
    private Map<String, Integer> s = new HashMap<>() ;
    private Map<String, Integer> t =new HashMap<>() ;
   
    @Test
   	public void testVertex() {
       	String a = "a";     
        Vertex<String> vex = new Vertex<String>(a,s,t) ;
        s.put("b",0);
    	vex.addSources(s);	
    	assertEquals(vex.toString(),"Vertex [vex=a, sources=[b,0], targets=]");
    	vex.addSources("b",1);	
    	assertEquals(vex.toString(),"Vertex [vex=a, sources=[b,1], targets=]");
    	s.put("c",1);
    	assertEquals(vex.toString(),"Vertex [vex=a, sources=[b,1], targets=]");
    	t.put("c",1);
    	vex.addTargets(t);	
    	assertEquals(vex.toString(),"Vertex [vex=a, sources=[b,1], targets=[c,1]]");
    	vex.addTargets("d",0);	
    	assertEquals(vex.toString(),"Vertex [vex=a, sources=[b,1], targets=[c,1]]");
    	s.remove("c",1); 
    	s.replace("b", 1);
    	Map<String, Integer> ss= vex.getSources();    	
    	assertEquals(s,ss);
    	//ss.replace("b", 0);  ss is unmodifiable
    	Map<String, Integer> tt= vex.getTargets();  
    	assertEquals(t,tt);
    	//tt.replace("b", 0);  tt is unmodifiable       
    }     
    
	  

}
