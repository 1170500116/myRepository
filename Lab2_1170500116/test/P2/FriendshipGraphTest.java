package P2;

import static org.junit.Assert.*;


import org.junit.Test;

import P2.FriendshipGraph;
import P2.Person;
public class FriendshipGraphTest {

	@Test
	public void test() {
		FriendshipGraph g = new FriendshipGraph();
	
		Person a = new Person("A");
		Person b = new Person("B");
		Person c = new Person("C");
		Person d = new Person("D");
		Person e = new Person("E");
		Person f = new Person("F");
		Person h = new Person("H");
		Person i = new Person("I");
		Person j = new Person("J");
		Person k = new Person("K");
		
		g.addVertex(a);
		g.addVertex(b);
		g.addVertex(c);
		g.addVertex(d);
		g.addVertex(e);
		g.addVertex(f);
		g.addVertex(h);
		g.addVertex(i);
		g.addVertex(j);
		g.addVertex(k);
	
		g.addEdge(a, b);
		g.addEdge(b, a);
		g.addEdge(a, c);
		g.addEdge(c, a);
		g.addEdge(c, b);
		g.addEdge(b, c);		
		g.addEdge(c, d);
		g.addEdge(d, c);
		g.addEdge(d, e);
		g.addEdge(e, d);


		g.addEdge(f, h);
		g.addEdge(h, f);
		g.addEdge(f, k);
		g.addEdge(k, f);
		g.addEdge(h, k);
		g.addEdge(k, h);		
		g.addEdge(h, i);
		g.addEdge(i, h);
		g.addEdge(j, i);
		g.addEdge(i, j);
		g.addEdge(j, k);
		g.addEdge(k, j);
		
		
		assertEquals(1,g.getDistance(a, c));
		assertEquals(1,g.getDistance(a, b));
		assertEquals(1,g.getDistance(b, c));
		assertEquals(2,g.getDistance(e, c));
		assertEquals(3,g.getDistance(a, e));
		assertEquals(3,g.getDistance(b, e));
		
		assertEquals(2,g.getDistance(f, i));
		assertEquals(2,g.getDistance(k, i));

		
	
	}
	
	
	

}
