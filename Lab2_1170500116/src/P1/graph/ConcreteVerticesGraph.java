/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.graph;

import java.util.ArrayList;
import java.util.Collections;
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
public class ConcreteVerticesGraph<L> implements Graph<L> {
    
    private final List<Vertex<L>> vertices = new ArrayList<>();
    
    // Abstraction function:
    //  represent a graph with vertices,every vertrice has its vex,sources and targets
   
    // Representation invariant:
    //  vertices is not null
    
    // Safety from rep exposure:
    //  vertices is private final;
    //  vertices are mutable
    //  make defensive copies or make Collections.unmodifiableMap to avoid sharing the rep object with clients.
    
    // TODO constructor
    public  ConcreteVerticesGraph() {
    	super();
    	checkRep();
    }
    
    // TODO checkRep
    private void checkRep() {
    	if(vertices==null) {
    		try {
				throw new Exception("vertices=null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    
    @Override public boolean add(L vertex) {
    	int fa = 0;
        for(Vertex ver:vertices) {
        	if(ver.getVex().equals(vertex)) {
        		fa = 1;
        	}
        }
        if(fa==0) {
        	vertices.add(new Vertex(vertex));
        	checkRep();
        	return true;
        }
        checkRep();
        return false;
    }
    
    @Override public int set(L source, L target, int weight) {    	
        int ans =0;
        int flag1= 0;
        int flag2 = 0;
        
        if(weight!=0) {
        	for(int i=0;i<vertices.size();i++) {
        		if(vertices.get(i).getVex().equals(source)) {
        			flag1= 1;
        		}
        		if(vertices.get(i).getVex().equals(target)) {
        			 flag2 = 1;
        		}
        	}
        	if(flag1==0) {
               vertices.add(new Vertex(source));
            }
        	if(flag2==0) {
                vertices.add(new Vertex(target));
             }
        }
      
    	for(int i=0;i<vertices.size();i++) {
    		
    		if(vertices.get(i).getVex().equals(source)) {
    			
    			Map<L,Integer> map = vertices.get(i).getTargets();
    			if(map.size()==0) {
    				if(weight!=0) {
    					vertices.get(i).setTargets(target,weight);    
    				}
    			}else {
    				int f = 0;
    				Set<L> s = map.keySet();
        			for(L it:s) {
        				if(it.equals(target)) {
        					ans = map.get(it);
        					f=1;
        					vertices.get(i).setTargets(target,weight);   
        					break;
        				}
        			}  
        			if(f==0) {
        				ans=0;
        				vertices.get(i).setTargets(target,weight);   
        			}
    			}
    			      			
    		}
    		
    		if(vertices.get(i).getVex().equals(target)) {
    			Map<L,Integer> map = vertices.get(i).getSources();
    			if(map.size()==0) {
    				if(weight!=0) {
    					vertices.get(i).setSources(source,weight);    
    				}
    			}else {
    				int f = 0;
    				Set<L> s = map.keySet();
        			for(L it:s) {
        				if(it.equals(source)) { 
        					f=1;
        					vertices.get(i).setSources(source, weight);
        					break;
        				}
        			} 
        			if(f==0) {
        				ans=0;
        				vertices.get(i).setSources(source,weight);   
        			}
    			}
    			
    		}
    	}
    	checkRep();
    	return ans;
        
    }
    
    @Override public boolean remove(L vertex) {
    	int myf =0;
    	for(int i=0;i<vertices.size();i++) {
    		if(vertices.get(i).getVex().equals(vertex)) {
    			myf = 1;
    		}
    	}
    	if(myf==1) {
    		Iterator<Vertex<L>> iter = vertices.iterator();
        	while(iter.hasNext()) {
        		Vertex<L> it = iter.next();    		
        		if(it.getVex().equals(vertex)) {
        			iter.remove();
        		}else {
        			Map<L, Integer> map = it.getSources();
        			for(L ll :map.keySet()) {
        				if(ll.equals(vertex)) {
        					it.setSources(ll, 0);
        				}
        			}
        			Map<L, Integer> map1 = it.getTargets();
        			for(L ll :map1.keySet()) {
        				if(ll.equals(vertex)) {
        					it.setTargets(ll, 0);
        				}
        			}
        		}
        	}
        	checkRep();
        	return true;
    	}
    	checkRep();
    	return false;
    	
    }
    
    @Override public Set<L> vertices() {
    	Set<L> set =new HashSet<L>();
    	for(int i=0;i<vertices.size();i++) {
    		set.add(vertices.get(i).getVex());
    	}      
    	checkRep();
    	return set;
    }
    
    @Override public Map<L, Integer> sources(L target) {
    	Map<L, Integer> map = new HashMap<>();
    	    	for(int i=0;i<vertices.size();i++) {
    		if(vertices.get(i).getVex().equals(target)) {
    			map = vertices.get(i).getSources();
    		}
    	}  
    	checkRep();
    	return map;
    	
    }
    
    @Override public Map<L, Integer> targets(L source) {
    	Map<L, Integer> map = new HashMap<>();
    	for(int i=0;i<vertices.size();i++) {
			if(vertices.get(i).getVex().equals(source)) {
				map = vertices.get(i).getTargets();
			}
		}  
    	checkRep();
		return map;
    }

	public List<Edge<L>> getEdges(){
		checkRep();
		return null;
	}
	
    
    // TODO toString()
    @Override
	public String toString() {
    	StringBuffer sb = new StringBuffer();
    	sb.append("ConcreteVerticesGraph [vertices=\n");
    	for(int i=0;i<vertices.size();i++) {
    		sb.append("["+vertices.get(i).getVex()+",sources=[");
    		Map<L,Integer> map =  vertices.get(i).getSources();
    		for(L it:map.keySet()) {
    			sb.append("["+it+","+map.get(it)+"]");
    		}
    		sb.append("],targets = [");    	
    		Map<L,Integer> map1 =  vertices.get(i).getTargets();
    		for(L it:map1.keySet()) {
    			sb.append("["+it+","+map1.get(it)+"]");
    		}
    		sb.append("]]\n");
    		
    		
    	}
    	sb.append("]");
    	checkRep();
    	return sb.toString();    	
	}

    
    
}

/**
 * TODO specification
 * Mutable.
 * This class is internal to the rep of ConcreteVerticesGraph.
 * 
 * <p>PS2 instructions: the specification and implementation of this class is
 * up to you.
 */

class Vertex<L> {
	
    // TODO fields
	private final L vex;
	private final Map<L,Integer> sources = new HashMap<>();
	private  final Map<L,Integer> targets = new HashMap<>();
	
    
    // Abstraction function:
    //    AF(vex,sources,targets) =  represents the vertex with sources and targets 
    //                                 
    // Representation invariant:
    // the vex is not null
	
  
    // Safety from rep exposure:
    //   All fields are private and final,vex is immutable ;   
    //   sources and targets are  mutable 
    //   the other methods make defensive copies or make unmodifiableMap to avoid sharing the rep's L object with clients.
	
    // TODO constructor	
    public Vertex(L vex) {
		super();
		this.vex = vex;	
		checkRep();
	}

	public Vertex(L vex, Map<L, Integer> sources, Map<L, Integer> targets) {
		super();
		this.vex = vex;
		final Map<L,Integer> s = new HashMap<>();
		for(L it :sources.keySet()) {
			s.put(it, sources.get(it)); 
		}
		this.sources.putAll(s);
		final Map<L,Integer> t = new HashMap<>();
		for(L it :targets.keySet()) {
			s.put(it, targets.get(it)); 
		}
		this.targets.putAll(t);
		checkRep();
	}

	// TODO checkRep
	public void checkRep() {
		if(this.vex==null) {
    		try {
				throw new Exception("vex=null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
	}
    
    public L getVex() {    
    	Vertex<L> now =new Vertex<L>(this.vex);
    	checkRep();
		return now.vex;
	
	}    
    
    public Map<L, Integer> getSources() {    	
    	checkRep();
    	return Collections.unmodifiableMap(this.sources);    
		
	}
	public Map<L, Integer> getTargets() {	
		checkRep();
		return Collections.unmodifiableMap(this.targets);   
	}


	// TODO methods
    public void addSources(L now,Integer weight) {
    	if(weight!=0) {
    		this.sources.put(now, weight); 
    	}  
    	checkRep();
    }
    public void addSources(Map<L, Integer> sources) {
    	if(sources!=null) {
    		final Map<L,Integer> s = new HashMap<>();
    		for(L it :sources.keySet()) {
    			s.put(it, sources.get(it)); 
    		}
    		this.sources.putAll(s);
    	}		
    	checkRep();
	}
    public void addTargets(L now,Integer weight) {
    	if(weight!=0) {
    		this.targets.put(now, weight); 
    	}    	   
    	checkRep();
    }
    public void addTargets(Map<L, Integer> sources) {
    	if(targets!=null) {
    		final Map<L,Integer> s = new HashMap<>();
    		for(L it :sources.keySet()) {
    			s.put(it, sources.get(it)); 
    		}
    		this.targets.putAll(s);
    	}	
    	checkRep();
	}
    
    public void setSources(L now,Integer weight) {
    	if(weight==0) {
    		if(sources.keySet().contains(now)) {
    			sources.remove(now);
    		}
    	}else {
    		if(sources==null) {
    			sources.put(now, weight);
    		}else {
    			if(sources.keySet().contains(now)) {
        			sources.replace(now, weight);
        		}else {
        			sources.put(now, weight);
        		}  
    		}
    		  		
    	}
    	checkRep();
    }
  
    public void setTargets(L now,Integer weight) {
    	if(weight==0) {
    		if(targets.keySet().contains(now)) {
    			targets.remove(now);
    		}
    	}else {
    		if(targets==null) {
    			targets.put(now, weight);
    		}else {
    			if(targets.keySet().contains(now)) {
        			targets.replace(now, weight);
        		}else {
        			targets.put(now, weight);
        		}   
    		}
    		 		
    	}  
    	checkRep();
    }
   
    

	
	// TODO toString()
	@Override
	public String toString() {
		StringBuffer sb =new StringBuffer();
		sb.append("Vertex [vex=" + vex + ", sources=");
		
		for (L key : sources.keySet()) { 			  
			  sb.append("["+key+","+sources.get(key)+"]");
		}
		
    	sb.append(", targets=");
    	for (L key : targets.keySet()) { 			  
			  sb.append("["+key+","+targets.get(key)+"]");
		}
    	sb.append("]");
    	checkRep();
    	return sb.toString();	
    	
	}
    
}
