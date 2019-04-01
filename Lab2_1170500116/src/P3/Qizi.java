package P3;

import java.awt.Image;

public class Qizi {
   private String field;
   private int  id;
   private int  x;
   private int  y;
   private float positionx;
   private float positiony;
   private int zhuangtai ;
   private int belong;
   private Image img;
   private Image panimg;
   
	public Qizi(String field, int id, int x, int y,int zhangtai,int belong) {
		super();
		this.field = field;
		this.id = id;
		this.x = x;
		this.y = y;
		this.zhuangtai = zhangtai;
		this.belong = belong;
	
		if(Constant.ss.equals("go")) {
			this.positionx = Constant.origin_x+x*Constant.buchang;
			this.positiony = Constant.origin_y+y*Constant.buchang;
			if(zhangtai==1) {
				this.img =  GameUtil.getImage("P3/images/"+field+".png");
			}else {		
				this.img =  GameUtil.getImage("P3/images/kong.png");
			}
		}else {
			this.positionx = Constant.corigin_x+x*Constant.cbuchang;
			this.positiony = Constant.corigin_y+y*Constant.cbuchang;
		
			if(zhangtai==1) {
				this.img =  GameUtil.getImage("P3/images/"+field+".png");
				if(y%2==1) {
					if(x%2==1) {
						panimg =  GameUtil.getImage("P3/images/"+field+"0.png");
						
						
					}else {
						panimg =  GameUtil.getImage("P3/images/"+field+"1.png");						
						
					}
				}else {
					if(x%2==1) {
						panimg =  GameUtil.getImage("P3/images/"+field+"1.png");
						
					}else {
						panimg =  GameUtil.getImage("P3/images/"+field+"0.png");
					
					}
				}
				
			}else {
				if(y%2==1) {
					if(x%2==1) {
						this.img =  GameUtil.getImage("P3/images/kongbai.png");
						panimg =  GameUtil.getImage("P3/images/kongbai.png");
					}else {
						this.img =  GameUtil.getImage("P3/images/konghei.png");
						panimg =  GameUtil.getImage("P3/images/konghei.png");
					}
				}else {
					if(x%2==1) {
						this.img =  GameUtil.getImage("P3/images/konghei.png");
						panimg =  GameUtil.getImage("P3/images/konghei.png");
					}else {
						this.img =  GameUtil.getImage("P3/images/kongbai.png");
						panimg =  GameUtil.getImage("P3/images/kongbai.png");
					
					}
				}
			}
		}
		
		
		
		
	}
	
	
	public Qizi(String field, int id, float positionx, float positiony,int zhangtai,int belong) {
		super();
		this.field = field;
		this.id = id;	
		this.zhuangtai = zhangtai;
		this.belong = belong;
		if(Constant.ss.equals("go")) {
			this.x = (int)((positionx-Constant.origin_x)/Constant.buchang);
			this.y = (int)((positiony-Constant.origin_y)/Constant.buchang);
			this.positionx =Constant.origin_x+x*Constant.buchang;
			this.positiony =Constant.origin_y+y*Constant.buchang;
			if(zhangtai==1) {
				this.img =  GameUtil.getImage("P3/images/"+field+".png");
			}else {
				this.img =  GameUtil.getImage("P3/images/kong.png");
			}
		}else {
			this.x = (int)((positionx-Constant.corigin_x)/Constant.cbuchang);
			this.y = (int)((positiony-Constant.corigin_y)/Constant.cbuchang);
			this.positionx =Constant.corigin_x+x*Constant.cbuchang;
			this.positiony =Constant.corigin_y+y*Constant.cbuchang;
			if(zhangtai==1) {
				this.img =  GameUtil.getImage("P3/images/"+field+".png");
				if(y%2==1) {
					if(x%2==1) {
						panimg =  GameUtil.getImage("P3/images/"+field+"0.png");
						
					}else {
						panimg =  GameUtil.getImage("P3/images/"+field+"1.png");
					}
				}else {
					if(x%1==1) {
						panimg =  GameUtil.getImage("P3/images/"+field+"1.png");
					}else {
						panimg =  GameUtil.getImage("P3/images/"+field+"0.png");
					
					}
				}
			}else {
				if(y%2==1) {
					if(x%2==1) {
						this.img =  GameUtil.getImage("P3/images/kongbai.png");
						panimg =  GameUtil.getImage("P3/images/kongbai.png");
					}else {
						this.img =  GameUtil.getImage("P3/images/konghei.png");
						panimg =  GameUtil.getImage("P3/images/konghei.png");
					}
				}else {
					if(x%2==1) {
						this.img =  GameUtil.getImage("P3/images/konghei.png");
						panimg =  GameUtil.getImage("P3/images/konghei.png");
					}else {
						this.img =  GameUtil.getImage("P3/images/kongbai.png");
						panimg =  GameUtil.getImage("P3/images/kongbai.png");
					
					}
				}
			}
		}
	
	
	
	
		
	}


	public Image getPanimg() {
		return panimg;
	}


	public String getField() {
		return field;
	}	
	public int getId() {
		return id;
	}
	
	public int getX() {
		return x;
	}
	
	public int getBelong() {
		return belong;
	}



	public int getY() {
		return y;
	}

	public float getPositionx() {
		return positionx;
	}
	
	public float getPositiony() {
		return positiony;
	}


	public int getZhuangtai() {
		return zhuangtai;
	}


	public Image getImg() {
		return img;
	}
	

	   
}
