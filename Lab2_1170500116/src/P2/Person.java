package P2;


public class Person {
	private  final String name ;
	
	public Person() {
		super();
		name = null;
	}

	public Person(String name) {
		super();	
		if(name.isEmpty()||name.charAt(0)<'A'||name.charAt(0)>'Z') {
			System.out.println("�������벻�Ϸ�������Ӧ�ö���Ӣ����ĸ��������ĸ��д,������ĸСд����ֻ����һ������");
			try {
				throw new Exception();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			this.name = new String( name);
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
			this.name = new String( name);
		}
	}
	
	public String getName() {
		return new String(name);
	}


}

