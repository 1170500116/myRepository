package P3;

import java.util.List;

public class ChessActions implements Actions{
	private final GoFields chess = new GoFields(Constant.cn);
	
	
	
	
	
			
	public Qizi fangzi(int id,float x,float y,String field,int belong) {
		return null;
	}
	 public  Qizi tizi(float x,float y) {
		 	Qizi ans = null;
		int i = (int)((x- Constant.corigin_x)/Constant.cbuchang);
		int j = (int)((y- Constant.corigin_y)/Constant.cbuchang);
		
		if(chess.getij(j, i)!=null&&chess.getij(j, i).getZhuangtai()==1) {			
			if(Constant.turn!=chess.getij(j, i).getBelong()) {
				ans = chess.getij(j, i);
				Qizi now = new  Qizi(ans.getField(), ans.getId() ,ans.getX(), ans.getY(),0,ans.getBelong());

				chess.setij(j, i,now);
			}
		}
		return ans;
		
	 }
	 @Override public  Qizi getnow(float x,float y) {
			Qizi ans = null;
			int i = (int)((x- Constant.corigin_x)/Constant.cbuchang);
			int j = (int)((y- Constant.corigin_y)/Constant.cbuchang);
			ans = chess.getij(j, i);
			return ans;
	 }
	 @Override public  Qizi getnow(int x,int y) {
			Qizi ans = null;			
			ans = chess.getij(y, x);
			return ans;
	 }
	 @Override public void fangzi_new(Qizi value,float x,float y) {
		 int i = (int)((x- Constant.corigin_x)/Constant.cbuchang);
		int j = (int)((y- Constant.corigin_y)/Constant.cbuchang);
		Qizi now;
		if(Constant.turn==0) {
			 now = new Qizi(value.getField(),value.getId(),i,j,1,1);
		}else {
			 now = new Qizi(value.getField(),value.getId(),i,j,1,0);
		}
	
		 chess.setij(j, i,now);
	 }
	 @Override public void chizi(Qizi value,float x,float y) {
		 
	 }
	public List<Qizi> getHistory(){
		return chess.getHistory();
	}
}
