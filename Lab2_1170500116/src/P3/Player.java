package P3;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private List<Qizi> qizion =new ArrayList<>();
	private String name = "";
	public String getName() {
		return new String(name);
	}

	public void setName(String name) {
		this.name = new String(name);
	}
	public void addChar(String ch) {
		if(name.length()<8) {
			name = name+ch;
		}
		
	}
	public void delChar() {
		if(name.length()>0){
			name = name.substring(0, name.length()-1);
		}
		
	}
	public void addqizi(Qizi now) {		
		//Qizi copy = new Qizi(now.getField(),now.getId(),now.getX(),now.getY(),now.getZhuangtai(),now.getBelong());
		qizion.add(now);
	}
	public boolean removeqizi(Qizi now) {
		for(Qizi it : qizion) {
			if(it.getBelong()==now.getBelong()&&it.getField().equals(now.getField())) {
				if(it.getX()==now.getX()&&it.getY()==now.getY()&&it.getZhuangtai()==now.getZhuangtai()) {
					qizion.remove(it);
					return true;
				}
			}
			
		}
		return false;
	}

	public List<Qizi> getQizion() {
		List<Qizi>  copy  =new ArrayList<>();
		
		for (Qizi it :qizion) {
			copy.add(it);
		}
		return copy;
	}
	
	
	
}
