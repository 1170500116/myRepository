package P3;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private String name ;
	private int id;
	private  List<Integer> friends = new ArrayList<>();
	public Person(String name) {
		super();
		if(name.isEmpty()||name.charAt(0)<'A'||name.charAt(0)>'Z') {
			System.out.println("�������벻�Ϸ�������Ӧ�ö���Ӣ����ĸ��������ĸ��д,������ĸСд����ֻ����һ������");
			try {
				throw new Exception();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}else {
			for(int i = 1;i<name.length();i++) {
				if(name.charAt(i)<'a'||name.charAt(i)>'z') {
					System.out.println("�������벻�Ϸ�������Ӧ�ö���Ӣ����ĸ��������ĸ��д,������ĸСд����ֻ����һ������");
					try {
						throw new Exception();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			this.name = name;
		}
		
	}

	public Person() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void addfriends(Person p) {
		for(int i =0;i<friends.size();i++) {
			if(friends.get(i).equals(p.getId())) {
				System.out.println(name+"��"+p.getName()+"�Ѿ�������ϵ�����ظ�����");
				try {
					throw new Exception();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		}
		friends.add(p.id);
	}

	public List<Integer> getFriends() {
		return friends;
	}
	
}

