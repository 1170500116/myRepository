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
	private L source;
	private L target;
	private int weight;
    // Abstraction function:
    //   TODO
    // Representation invariant:
    //   TODO
  
	
    
    // TODO constructor
	public Edge() {
		super();
	}
	public Edge(L source, L target, int weight) {
		super();
		this.source = source;
		this.target = target;
		this.weight = weight;
	}
	
	
	
    // TODO checkRep
    

	// Safety from rep exposure
    public L getSource() {
    	Edge<L> s = new Edge<L>(this.source,this.target,this.weight);
		return s.source;
	}

	public void setSource(L source) {
		this.source = source;
	}
	public L getTarget() {
		Edge<L> s = new Edge<L>(this.source,this.target,this.weight);		
		return s.target;
	}
	public void setTarget(L target) {
		this.target = target;
	}
	public int getWeight() {
		Edge<L> s = new Edge<L>(this.source,this.target,this.weight);		
		return s.weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
    // TODO methods
	// TODO toString()
	@Override
	public String toString() {
		return "Edge [source=" + source + ", target=" + target + ", weight=" + weight + "]";
	}
}
