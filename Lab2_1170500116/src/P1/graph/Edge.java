package P1.graph;
//package P1.graph;
/**
 * TODO specification
 * Immutable.
 * This class is internal to the rep of ConcreteEdgesGraph.
 * 
 * <p>PS2 intructions: the specification and implementation of this class is
 * up to you.
 */

public class Edge<L> {
    
    // TODO fields
	private final L source;
	private final L target;
	private final int weight;
    // Abstraction function:
    //    AF(source,target, weight) = a edge from the source to target at weight
    //                                 
    // Representation invariant:
    //  weight>0;
	//	source!=null;
	// 	target != null;
  
	// Safety from rep exposure
    //All fields are private and final  so are guaranteed immutable;
    //   getSource() ,getTarget() and getWeight()   make defensive copies to avoid sharing the rep's L object with clients.
   
    
    
    // TODO constructor
	/**
     * Make a new Edge
     * @param source the source of the edge
     * @param target the target of the edge
     * @throws ArithmeticException if weight == 0
     */
	public Edge( L source, L target, int weight) {
		super();			
		this.source = source;		
		this.target = target;		
		this.weight = weight;
		 checkRep();
	}
	
	
	
    // TODO checkRep
    private void checkRep() {
    	if(this.weight<=0) {
    		try {
				throw new Exception("weight=0");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	if(this.source==null) {
    		try {
				throw new Exception("source=null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	if(this.target==null) {
    		try {
				throw new Exception("target=null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }

	
    // TODO methods
    // get the source of the edge
    public L getSource() {
    	Edge<L> s = new Edge<L>(this.source,this.target,this.weight);
    	 checkRep();
    	return s.source;
	}

    // get the target of the edge
	public L getTarget() {
		Edge<L> s = new Edge<L>(this.source,this.target,this.weight);		
		 checkRep();
		return s.target;
	}
	
	// get the weight of the edge
	public int getWeight() {
		Edge<L> s = new Edge<L>(this.source,this.target,this.weight);		
		 checkRep();
		return s.weight;
	}
	
	
    
	// TODO toString()
	@Override
	public String toString() {
		 checkRep();
		return "Edge [source=" + source + ", target=" + target + ", weight=" + weight + "]";
	}
}
