package P2;

import java.util.ArrayList;
import java.util.HashMap;


import java.util.List;
import java.util.Map;


import P1.graph.ConcreteEdgesGraph;

import P1.graph.Graph;

public class FriendshipGraph {
	/*private final*/public Graph<Person> g = new ConcreteEdgesGraph<Person>();
	protected  void addVertex(Person p){
		g.add(p);		
	}
	
	protected  void addEdge(Person p1, Person p2){
		g.set(p1, p2, 1);			
	}
	protected  int getDistance(Person p1, Person p2){
		
		if(p1.getName().toLowerCase().equals(p2.getName().toLowerCase())){
			return 0;
		}
		int a =calculateDistance( p1,  p2);
		int b =calculateDistance( p2,  p1);
		if(a==-1&&b==-1) {
			return -1;
		}else if(a==-1&&b!=-1) {
			System.out.println(p2.getName() +"通过距离"+b+"认识"+p1.getName()+"，但是"+p1.getName()+"不认识"+p2.getName());
			return -1;
		}else if(b==-1&&a!=-1) {
			System.out.println(p1.getName() +"通过距离"+a+"认识"+p2.getName()+"，但是"+p2.getName()+"不认识"+p1.getName());
			return -1;
		}else {
			if(a==b) {
				return a;
			}else {
				System.out.println(p1.getName() +"通过距离"+a+"认识"+p2.getName()+"，"+p2.getName() +"通过距离"+b+"认识"+p1.getName());
				return -1;
			}
		}
	}
	protected  int calculateDistance(Person p1, Person p2){
		List<Person> duilie = new ArrayList<>();
		Map<Person,Boolean> yn = new HashMap<>();
		for(Person it :g.vertices()) {
			yn.put(it,false); 
		}
		int dis = 0;
		int find = 0;
	
		for(Person temp:g.targets(p1).keySet()) {
			if(temp.getName().toLowerCase().equals(p2.getName().toLowerCase())) {				
				find=1;
			}
			duilie.add(temp);
		}
//		System.out.println("find="+find);
		List<Integer> next = new ArrayList<>();
		next.add(duilie.size());
		yn.remove(p1);
		yn.put(p1, true);
		
		dis++;
		int what =0;
		while(find==0&&!duilie.isEmpty()) {
			Person now = new Person();
			int i=0;
			while(i<duilie.size()&&yn.get(duilie.get(i))==true) {
				i++;
			}
			if(i>=duilie.size()) {
				find=0;
				break;
			}			
			now = duilie.get(i);
			//System.out.println(now.getName());
			for(Person temp:g.targets(now).keySet()) {
				if(temp.getName().toLowerCase().equals(p2.getName().toLowerCase())) {			
					find=1;
				}
//				System.out.println(temp.getName()+"234");
				duilie.add(temp);
			}
			next.add(duilie.size());
			if(find==0) {
				yn.remove(now);
				yn.put(now, true);
			}
			
			
			if(i>=next.get(what)-1||find==1) {
				dis++;
				what++;
			}
			
			if(dis>=g.vertices().size()) {
				break;
			}
			
		}
		if(find==1) {
			return dis;
		}else {
			return -1;
		}
	}
	
	
	public static void main(String[] args) {
		FriendshipGraph graph = new FriendshipGraph();
		Person rachel = new Person("Rachel");
		Person ross = new Person("Ross");
		Person ben = new Person("Ben");
		Person kramer = new Person("Kramer");
		
		graph.addVertex(rachel);
		graph.addVertex(ross);
		graph.addVertex(ben);
		graph.addVertex(kramer);
		
		graph.addEdge(rachel, ross);
		graph.addEdge(ross, rachel);
		graph.addEdge(ross, ben);
		graph.addEdge(ben, ross);

			
		
		System.out.println(graph.getDistance(rachel, ross)); 
	//should print 1
		System.out.println(graph.getDistance(rachel, ben)); 
	//should print 2
		System.out.println(graph.getDistance(rachel, rachel)); 
	//should print 0
		System.out.println(graph.getDistance(rachel, kramer)); 
	//should print -1
	}
	
}
