package P3;

import java.util.List;

public interface Actions {
	 public  Qizi getnow(float x,float y);
	 public void fangzi_new(Qizi value,float x,float y) ;
	public Qizi fangzi(int id,float x,float y,String field,int belong) ;
	public void chizi(Qizi value,float x,float y);
	 public  Qizi tizi(float x,float y);
     public  Qizi getnow(int x,int y) ;
	List<Qizi> getHistory();
	

	
}
