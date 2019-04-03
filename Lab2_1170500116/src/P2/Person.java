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
			System.out.println("名字输入不合法，名字应该都是英文字母，且首字母大写,其他字母小写，且只能是一个单词");
			try {
				throw new Exception();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			this.name = new String( name);
		}else {
			for(int i = 1;i<name.length();i++) {
				if(name.charAt(i)<'a'||name.charAt(i)>'z') {
					System.out.println("名字输入不合法，名字应该都是英文字母，且首字母大写,其他字母小写，且只能是一个单词");
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

