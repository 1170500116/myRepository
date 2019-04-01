/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * An implementation of Graph.
 * 
 * <p>PS2 instructions: you MUST use the provided rep.
 */
public class ConcreteEdgesGraph<L> implements Graph<L> {
    
    private final Set<L> vertices = new HashSet<>();
    private final List<Edge<L>> edges = new ArrayList<>();
 
    // TODO constructor
    public ConcreteEdgesGraph() {
    	super();
	}
    public List<Edge<L>>  getEdges() {
    	return edges;
    }

	// Abstraction function:
    //   TODO
    // Representation invariant:
    //   TODO
    // Safety from rep exposure:
    //   TODO
    
    
    
    // TODO checkRep
    
    @Override public  boolean add(L vertex) {    
    	   return vertices.add(vertex);    	
    }

    @Override public int set(L source, L target, int weight) {
		
		vertices.add(source);		
		vertices.add(target);
    	
        if(weight==0) {
        	for(int i=0;i<edges.size();i++) {
        		if(edges.get(i).getSource().equals(source)&&edges.get(i).getTarget().equals(target)) {
        			int ans = edges.get(i).getWeight();
        			edges.remove(i);
        			return ans;
        		}
        	}
        	return 0;
        }else {        	
        	for(int i=0;i<edges.size();i++) {
        		if(edges.get(i).getSource().equals(source)&&edges.get(i).getTarget().equals(target)) {
        			int ans = edges.get(i).getWeight();
        			edges.get(i).setWeight(weight);
        			return ans;
        		}
        	}
        	edges.add(new Edge<L>(source,target,weight));        	
        	return 0;
        }
    }
    
    @Override public boolean remove(L vertex) {
    	if(vertices.contains(vertex)) {
			vertices.remove(vertex);
			Iterator<Edge<L>> iter = edges.iterator();
			while(iter.hasNext()) {
				Edge<L> test =  iter.next();
				if(test.getSource().equals(vertex)||test.getTarget().equals(vertex)) {
					iter.remove();
				}
			}			
			return true;
		}else {
			return false;
		}
    }
    
    @Override public Set<L> vertices() {
    	Set<L> myver = new HashSet<>();
    	Iterator<L> it = vertices.iterator();  
    	while (it.hasNext()) {  
    	  L str = it.next();  
    	  myver.add(str);
    	} 
        return myver;
    }
  //If vertices does not contains target,return a null map.
    @Override public Map<L, Integer> sources(L target) {
    	 Map<L, Integer>  map = new HashMap<>();
    	 if(!vertices.contains(target)) {
    		 return map;
    	 }
       for(int i=0;i<edges.size();i++) {
    	   if(edges.get(i).getTarget().equals(target)&&edges.get(i).getWeight()!=0) {
				map.put(edges.get(i).getSource(), edges.get(i).getWeight());
			}
       }
       return map;
    }
    //If vertices does not contains source,return a null map.
    @Override public Map<L, Integer> targets(L source) {
    	 Map<L, Integer>  map = new HashMap<>();
    	 if(!vertices.contains(source)) {
    		 return map;
    	 }
         for(int i=0;i<edges.size();i++) {
      	   if(edges.get(i).getSource().equals(source)&&edges.get(i).getWeight()!=0) {
  				map.put(edges.get(i).getTarget(), edges.get(i).getWeight());
  			}
         }
         return map;
    }

    // TODO toString()
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("");
		sb.append("ConcreteEdgesGraph [vertices=");
		sb.append(vertices);
		sb.append(", edges=[ ");
		for(int i=0;i<edges.size();i++) {
			sb.append("[");
			sb.append(edges.get(i).getSource()+",");
			sb.append(edges.get(i).getTarget()+",");
			sb.append(edges.get(i).getWeight()+",");
			sb.append("]");
			if(i==edges.size()-1) {
				sb.append(" ]");
			}else {
				sb.append(" ");
			}
		}
		if(edges.size()==0) {
			sb.append("]");
		}
		sb.append("]");
		String s = sb.toString();
		return s;
	}
    
  
    
    
}

