package P3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FriendshipGraph {
	private List<Person> nameList = new ArrayList<>();
	private boolean existName(Person name){
		for(int i = 0;i<nameList.size();i++) {
			if(name.getName().equals(nameList.get(i).getName())) {
				return true;
			}
		}
		return false;
	}
	public void addVertex(Person name){
		if(existName(name)) {
			System.out.println("重名错误");
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			
		}
		name.setId(nameList.size());
		nameList.add(name);	
	}
	
	public void addEdge(Person name1, Person name2){
		int flag1= 0 ;
		int flag2 = 0;
		if(name1.getId()==name2.getId()) {
			System.out.println("自己和自己不可建立关系");
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i = 0;i<nameList.size();i++) {
			if(nameList.get(i).getId()==name1.getId()) {
				flag1 = 1;
			}
			if(nameList.get(i).getId()==name2.getId()) {
				flag2 = 1;
			}
			
		}
		if(flag1==0||flag2==0) {
			if(flag1==0) {
				System.out.println("图中不存在"+name1);
			}
			if(flag2==0) {
				System.out.println("图中不存在"+name2);
			}
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		name1.addfriends(name2);
	}
	public int getDistance(Person name1, Person name2){
		if(name1.getId()==name2.getId()) {
			return 0;
		}
		
		int a =calculateDistance( name1,  name2);
		int b =calculateDistance( name2,  name1);
		if(a==-1&&b==-1) {
			return -1;
		}else if(a==-1&&b!=-1) {
			System.out.println(name2.getName() +"通过距离"+b+"认识"+name1.getName()+"，但是"+name1.getName()+"不认识"+name2.getName());
			return -1;
		}else if(b==-1&&a!=-1) {
			System.out.println(name1.getName() +"通过距离"+a+"认识"+name2.getName()+"，但是"+name2.getName()+"不认识"+name1.getName());
			return -1;
		}else {
			if(a==b) {
				return a;
			}else {
				System.out.println(name1.getName() +"通过距离"+a+"认识"+name2.getName()+"，"+name2.getName() +"通过距离"+b+"认识"+name1.getName());
				return -1;
			}
		}
	}
	private int calculateDistance(Person name1, Person name2){
		List<Integer> stc = new ArrayList<>();
		List<Boolean> yn = new ArrayList<>();
		for(int i=0;i<nameList.size();i++) {
			yn.add(false); 
		}
		int dis = 0;
		int find = 0;
		//System.out.println(name1.getFriends());
		//System.out.println(name2.getFriends());
		for(Integer temp:name1.getFriends()) {
			if(temp.equals(name2.getId())) {				
				find=1;
			}
			stc.add(temp);
		}
		List<Integer> next = new ArrayList<>();
		next.add(stc.size());
		yn.set(name1.getId(), true);
		//System.out.println(stc);
		dis++;
		int what =0;
		while(find==0&&!stc.isEmpty()) {
			Person now = new Person();
			int i=0;
			while(i<stc.size()&&yn.get(stc.get(i))==true) {
				i++;
			}
			if(i>=stc.size()) {
				find=0;
				break;
			}
			//System.out.println(i);
			for(Person temp:nameList) {
				if(stc.get(i).equals(temp.getId())) {
					now = temp;
					break;	
				}
			}
					
			
		
			//System.out.println(now.getId());
			for(Integer temp:now.getFriends()) {
				if(temp.equals(name2.getId())) {			
					find=1;
				}
				stc.add(temp);
			}
			next.add(stc.size());
			if(find==0) {
				yn.set(now.getId(), true);
			}
			//System.out.println(stc);
			//System.out.println(next);
			
			if(i>=next.get(what)-1||find==1) {
				dis++;
				what++;
			}
			
			if(dis>=nameList.size()) {
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
		Person ross = new Person("Rachel");
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
