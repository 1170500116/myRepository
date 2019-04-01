package P3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoActions implements Actions{
	
		private final GoFields go = new GoFields(Constant.n);
		@Override public  Qizi getnow(float x,float y) {return null;}
		@Override public Qizi fangzi(int id,float x,float y,String field,int belong) {			
			Qizi now = new Qizi(field,id ,x, y,1,belong);
			if(now.getX()>=0&&now.getX()<Constant.n&&now.getY()>=0&&now.getY()<Constant.n) {
				

				if(go.getij(now.getX(), now.getY())==null||go.getij(now.getX(), now.getY()).getZhuangtai()==0) {				
					go.setij(now.getX(), now.getY(), now);
					return now;
				}				
			}
			return null;			
		}
		@Override public void chizi(Qizi value,float x,float y) {}
		@Override public void fangzi_new(Qizi value,float x,float y) {}
		 @Override public  Qizi getnow(int x,int y) {return null;}
		@Override public Qizi tizi(float x,float y) {	
		Qizi now = new Qizi("kong",-1 ,x, y,0,-1);
			if(now.getX()>=0&&now.getX()<Constant.n&&now.getY()>=0&&now.getY()<Constant.n) {
				Qizi emmm = go.getij(now.getX(), now.getY());
				
				
				if(emmm!=null&&emmm.getZhuangtai()==1) {
					
					if(Constant.turn!=emmm.getBelong()) {
						now = new Qizi(emmm.getField(),emmm.getId() ,emmm.getX(), emmm.getY(),0,emmm.getBelong());
					
						go.setij(emmm.getX(),emmm.getY(),now);
						return emmm;
					}
				}
			}
			return null;
		}
		@Override public List<Qizi> getHistory(){	
			
				return go.getHistory();
			}
	
//		@Override public void chizi() {
//					
//				}
//		@Override public void tizi() {
//			
//		}

}

