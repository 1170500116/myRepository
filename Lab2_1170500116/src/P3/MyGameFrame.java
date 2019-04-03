package P3;

import java.awt.Frame;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class  MyGameFrame extends Frame implements MouseListener, MouseMotionListener{	
		
		private int period =0;	   
	    private int zhuangtai=-1;	  
		Image mouse =null;
		Image shang =null;
		Image xia =null;
		Image myshushang =null;
		Image myshuxia =null;
		Boolean shushang =false;
		Boolean shuxia =false;
		private int location_x, location_y;
		private static Actions mygame ;
		private int times =0;
		private long histimes =0;
		private List<Qizi>  myhis =null;
		Player  p1 = new Player();
		Player  p2 = new Player();
		private int lasttizix=0;
		private int lasttiziy=0;
		private int nn=0;
		private Qizi beitide ;
		@Override
		public void paint(Graphics g) {
			super.paint(g);
		
			g.setColor( Color.pink);	
			Font mf = new Font("Stylus BT", Font.PLAIN,90);
			Font mff = new Font("Stylus BT", Font.BOLD,90);
			g.setFont(mf);
	
//			g.drawRect(785, 106, 200, 200);
//			g.drawRect(800, 410, 200, 200);
//			g.drawRect(75, 78, 200, 200);
//			g.drawRect(675, 678, 200, 200);
			
//			for(int i=0;i<whites.size();i++) {
//				g.drawImage(Constant.bai,(int) whites.get(i).getX(), (int) whites.get(i).getY() , 32, 32, null);
//			}
//			for(int i=0;i<blacks.size();i++) {
//				g.drawImage(Constant.hei,(int) blacks.get(i).getX(), (int) blacks.get(i).getY() , 32, 32, null);
//			}
			if(period==0) {
				g.drawImage(Constant.jpg0, 0, 0 ,Constant.GAME_WIDTH, Constant.GAME_HEIGHT, null);
				if(650<=location_x&&location_x<=950&&200<=location_y&&location_y<=400) {					
						shang = Constant.chess1;	
						xia = Constant.go0;	
				}else if(650<=location_x&&location_x<=950&&500<=location_y&&location_y<=700){
					shang = Constant.chess0;	
					xia = Constant.go1;	
				}else {
					shang = Constant.chess0;	
					xia = Constant.go0;	
				}
				g.drawImage(shang, 650, 200,300, 200, null);
				g.drawImage(xia, 650, 500,300, 200, null);
			}else if(period==1) {
				
				g.drawImage(Constant.jpg1, 0, 0 ,Constant.GAME_WIDTH, Constant.GAME_HEIGHT, null);
				if(p1.getName().length()!=0) {					
					g.drawString(p1.getName(), 170, 470);
					
				}
				if(p2.getName().length()!=0) {
					
					g.drawString(p2.getName(), 170, 695);
				}
				if(shushang) {
					times++;
					if(times>10) {
						if(myshushang==null) {
							 myshushang = Constant.shu;
						}else {
							myshushang  = null;
						}	
						times=0;
					}
						
				}else {
					myshushang  = null;
				}
				if(shuxia) {
					times++;
					if(times>10) {
						if(myshuxia==null) {
							 myshuxia = Constant.shu;
						}else {
							myshuxia  = null;
						}	
						times=0;
					}
									
					
				}else {
					myshuxia  = null;
				}
				
				if(p1.getName().length()==0) {
					g.drawImage(myshushang, 155, 405 ,15, 70, null);					
				}else {
					
					g.drawImage(myshushang, 160+p1.getName().length()*48, 405 ,15, 70, null);	
				}
				if(p2.getName().length()==0) {
					g.drawImage(myshuxia, 155, 630 ,15, 70, null);				
				}else {
					g.drawImage(myshuxia, 160+p2.getName().length()*48, 630 ,15, 70, null);
				}
			
				if(780<=location_x&&location_x<=1080&&655<=location_y&&location_y<=887) {					
					g.drawImage(Constant.start, 780, 655 ,305, 235, null);
				}
				//g.drawRect(120, 390, 440, 95);
				//g.drawRect(115, 620, 450, 90);
				//g.drawRect(780, 655,300, 232);
			}else if(period==2) {
				if(Constant.ss.equals("go")) {					
				    g.drawImage(Constant.qipan,0,0,  null);			
				    g.drawImage(Constant.qipanxia,10,730,1090,170,  null);
				    if(Constant.turn ==0) {
						g.setFont(mff);
					}
					if(p1.getName().length()!=0) {	
						
						g.drawString(p1.getName(),750, 375);
						
					}else {					
						g.drawString("Player1",750, 375);
					}
					g.setFont(mf);
					 if(Constant.turn ==1) {
							g.setFont(mff);
					}
					if(p2.getName().length()!=0) {
						g.drawString(p2.getName(), 750, 700);
						
					}else {
						g.drawString("Player2",750, 700);
					}
					for(Qizi it:p1.getQizion()) {
						g.drawImage(it.getImg(), (int)it.getPositionx(), (int)it.getPositiony(), 32, 32, null);
					}
					for(Qizi it:p2.getQizion()) {
						g.drawImage(it.getImg(), (int)it.getPositionx(),(int)it.getPositiony(), 32, 32, null);
					}
					g.setFont(mf);
					if(843<=location_x&&location_x<=953&&745<=location_y&&location_y<=885) {
						 g.drawImage(Constant.skip,843, 745, 110, 140,  null);
					}	
					if(968<=location_x&&location_x<=1078&&745<=location_y&&location_y<=885) {
						 g.drawImage(Constant.end,968, 745, 110, 140, null);
					}
					
					g.drawString(""+p2.getQizion().size(), 210, 845);
					g.drawString(""+p1.getQizion().size(), 550, 845);
					//g.drawRect((int)Constant.corigin_x,(int)Constant.corigin_y, (int)Constant.cbuchang*8, (int)Constant.cbuchang*8);
					g.drawImage(mouse, location_x-16, location_y-16 , 32, 32, null);
				}else {
					g.drawImage(Constant.dabai,0,00,Constant.GAME_WIDTH,Constant.GAME_HEIGHT,  null);
					g.drawImage(Constant.cqipan,0,30,700,697,  null);
//					g.drawRect(20, 740, 120, 60);
//					g.drawRect(20, 810, 120, 60);
//					g.drawRect(150, 740, 120, 60);
//					g.drawRect(150, 810, 120, 60);
//					g.drawRect(280, 740, 120, 60);
//					g.drawRect(280, 810, 120, 60);
//					g.drawRect(280, 740, 120, 60);
//					g.drawRect(410, 810, 120, 60);
//					g.drawRect(410, 740, 120, 60);
//					g.drawRect(540, 810, 120, 60);
//					g.drawRect(540, 740, 120, 60);
//					g.drawRect(670, 740, 120, 60);
//					g.drawRect(670, 810, 120, 60);
					g.drawImage(Constant.king0,20, 740, 50, 60 , null);
					g.drawImage(Constant.king1,20, 810, 50, 60 , null);
					g.drawImage(Constant.queen0,150, 740, 50, 60 , null);
					g.drawImage(Constant.queen1,150,810, 50, 60 , null);
					g.drawImage(Constant.bishop0,280, 740, 50, 60 , null);
					g.drawImage(Constant.bishop1,280, 810, 50, 60 , null);
					g.drawImage(Constant.knight0,410, 740, 50, 60 , null);
					g.drawImage(Constant.knight1,410, 810, 50, 60 , null);
					g.drawImage(Constant.rook0,540, 740, 50, 60 , null);
					g.drawImage(Constant.rook1,540, 810, 50, 60 , null);
					g.drawImage(Constant.pawn0,670, 740, 50, 60 , null);
					g.drawImage(Constant.pawn1,670, 810, 50, 60 , null);
				
					
					  if(Constant.turn ==0) {
							g.setFont(mff);
					   }
					if(p1.getName().length()!=0) {								
							g.drawString(p1.getName(),706, 163);							
					}else {				
						g.drawString("Player1",706, 163);
					}
					g.setFont(mf);
					 if(Constant.turn ==1) {
							g.setFont(mff);
					}
					if(p2.getName().length()!=0) {
						g.drawString(p2.getName(), 706, 655);
						
					}else {
						g.drawString("Player2",706, 655);
					}
					
					if(843<=location_x&&location_x<=953&&745<=location_y&&location_y<=885) {
						 g.drawImage(Constant.skip,843, 745, 110, 140,  null);
					}else {
						 g.drawImage(Constant.skip0,843, 745, 110, 140,  null);
					}	
					if(968<=location_x&&location_x<=1078&&745<=location_y&&location_y<=885) {
						 g.drawImage(Constant.end,968, 745, 110, 140, null);
					}else {
						 g.drawImage(Constant.end0,968, 745, 110, 140, null);
					}
//					for(Qizi it:p1.getQizion()) {
//						g.drawImage(it.getImg(), (int)it.getPositionx(), (int)it.getPositiony(), 32, 32, null);
//					}
//					for(Qizi it:p2.getQizion()) {
//						g.drawImage(it.getImg(), (int)it.getPositionx(),(int)it.getPositiony(), 32, 32, null);
//					}
					int k0 = 0;
					int k1 = 0;
					int q0=0;
					int q1=0;
					int b0=0;
					int b1=0;
					int kk0=0;
					int kk1=0;
					int r0=0;
					int r1= 0;
					int pp0=0;
					int pp1=0;
					for(int i=0;i<8;i++) {
						for(int j=0;j<8;j++) {
							Qizi now =mygame.getnow(i, j);
							if(now!=null) {
								if(now.getZhuangtai()==1) {
									if(now.getField().equals("king0")){
										k0++;
									}else if(now.getField().equals("king1")) {
										k1++;
									}else if(now.getField().equals("queen0")) {
										q0++;
									}else if(now.getField().equals("queen1")) {
										q1++;
									}else if(now.getField().equals("bishop0")) {
										b0++;
									}else if(now.getField().equals("bishop1")) {
										b1++;
									}else if(now.getField().equals("knight0")) {
										kk0++;
									}else if(now.getField().equals("knight1")) {
										kk1++;
									}else if(now.getField().equals("rook0")) {
										r0++;
									}else if(now.getField().equals("rook1")) {
										r1++;
									}else if(now.getField().equals("pawn0")) {
										pp0++;
									}else if(now.getField().equals("pawn1")) {
										pp1++;
									}
								}
								g.drawImage(now.getPanimg(), (int)now.getPositionx(),(int)now.getPositiony(), (int)Constant.cbuchang, (int)Constant.cbuchang, null);
							}
							
						}
					}
//					g.drawImage(Constant.king0,20, 740, 50, 60 , null);
//					g.drawImage(Constant.king1,20, 810, 50, 60 , null);
//					g.drawImage(Constant.queen0,150, 740, 50, 60 , null);
//					g.drawImage(Constant.queen1,150,810, 50, 60 , null);
//					g.drawImage(Constant.bishop0,280, 740, 50, 60 , null);
//					g.drawImage(Constant.bishop1,280, 810, 50, 60 , null);
//					g.drawImage(Constant.knight0,410, 740, 50, 60 , null);
//					g.drawImage(Constant.knight1,410, 810, 50, 60 , null);
//					g.drawImage(Constant.rook0,540, 740, 50, 60 , null);
//					g.drawImage(Constant.rook1,540, 810, 50, 60 , null);
//					g.drawImage(Constant.pawn0,670, 740, 50, 60 , null);
//					g.drawImage(Constant.pawn1,670, 810, 50, 60 , null);
					Font linshi = g.getFont();
					Font mfff = new Font("Stylus BT", Font.BOLD,60);
					g.setFont(mfff);					
					g.drawString("x"+k0, 70, 800);
					g.drawString("x"+k1, 70, 870);
					g.drawString("x"+q0, 200, 800);
					g.drawString("x"+q1, 200, 870);
					g.drawString("x"+b0, 330, 800);
					g.drawString("x"+b1, 330, 870);
					g.drawString("x"+kk0, 460, 800);
					g.drawString("x"+kk1, 460, 870);
					g.drawString("x"+r0, 590, 800);
					g.drawString("x"+r1, 590, 870);
					g.drawString("x"+pp0, 720, 800);
					g.drawString("x"+pp1, 720, 870);
					g.drawImage(mouse, location_x-25, location_y-30 , 50, 60, null);
					g.setFont(linshi);
				}
			}else if(period==3) {
				if(Constant.ss.equals("go")) {	
					if(myhis==null) {
						g.drawImage(Constant.qipan,0,0,  null);					
					}else {
						if(nn==0) {
							g.drawImage(Constant.qipan,0,0,  null);	
							nn=1;
						}					
					}
					 g.drawImage(Constant.xia3,10,730,1090,170,  null);
					 g.setFont(mf);
					 if(p1.getName().length()!=0) {						
						g.drawString(p1.getName(),750, 375);					
					}else {					
						g.drawString("Player1",750, 375);
					}
					 if(p2.getName().length()!=0) {
						g.drawString(p2.getName(), 750, 700);					
					}else {
						g.drawString("Player2",750, 700);
					}
					
					if(843<=location_x&&location_x<=953&&745<=location_y&&location_y<=885) {
						 g.drawImage(Constant.history,843, 745, 110, 140,  null);
					}	
					if(968<=location_x&&location_x<=1078&&745<=location_y&&location_y<=885) {
						 g.drawImage(Constant.ret,968, 745, 110, 140, null);
					}
					g.drawString(""+p2.getQizion().size(), 210, 845);
					g.drawString(""+p1.getQizion().size(), 550, 845);
					
					 if(myhis==null) {
						 for(Qizi it:p1.getQizion()) {
								g.drawImage(it.getImg(), (int)it.getPositionx(), (int)it.getPositiony(), 32, 32, null);
							}
							for(Qizi it:p2.getQizion()) {
								g.drawImage(it.getImg(), (int)it.getPositionx(),(int)it.getPositiony(), 32, 32, null);
							}
					}else {
						
						int beishu = 10;
						
						if(histimes>Constant.n*Constant.n*20||histimes>(myhis.size()-1)*beishu) {
							histimes =0;
							myhis=null;
						}else {
							int i=(int)(histimes/beishu);
	//						if(i+1<=myhis.size()-1&&myhis.get(i+1).getZhuangtai()==0) {
	//							System.out.println("shenmaqingk");
	//							g.drawImage(myhis.get(i+1).getImg(), 900,100, 32, 32, null);
	//							g.drawImage(myhis.get(i+1).getImg(), (int)myhis.get(i+1).getPositionx(), (int)myhis.get(i+1).getPositiony(), 32, 32, null);
	//							System.out.println(myhis.get(i).getX()+""+myhis.get(i).getY());
	//						}
							//g.drawImage(myhis.get(i).getImg(), 900,100, 32, 32, null);
							
							g.drawImage(myhis.get(i).getImg(), (int)myhis.get(i).getPositionx(), (int)myhis.get(i).getPositiony(), 32, 32, null);
	//						if(myhis.get(i).getZhuangtai()==0) {
	//							g.drawImage(Constant.skip,(int)myhis.get(i).getPositionx(), (int)myhis.get(i).getPositiony(), 32, 32, null);
	//						}else {
	//							g.drawImage(Constant.end,(int)myhis.get(i).getPositionx(), (int)myhis.get(i).getPositiony(), 32, 32, null);
	//						}
							
						}
						histimes++;
					
						
					}
				}else {
					if(myhis==null) {
						g.drawImage(Constant.cqipan,0,30,700,697,  null);					
					}else {
						if(nn==0) {
							System.out.println("1234567");
							g.drawImage(Constant.cqipan,0,30,700,697,  null);
							nn=1;
						}					
					}
					  if(Constant.turn ==0) {
							g.setFont(mff);
					   }
					if(p1.getName().length()!=0) {								
							g.drawString(p1.getName(),706, 163);							
					}else {				
						g.drawString("Player1",706, 163);
					}
					g.setFont(mf);
					 if(Constant.turn ==1) {
							g.setFont(mff);
					}
					if(p2.getName().length()!=0) {
						g.drawString(p2.getName(), 706, 655);
						
					}else {
						g.drawString("Player2",706, 655);
					}
					if(843<=location_x&&location_x<=953&&745<=location_y&&location_y<=885) {
						 g.drawImage(Constant.history,843, 745, 110, 140,  null);
					}else {
						 g.drawImage(Constant.history0,843, 745, 110, 140,  null);
					}	
					if(968<=location_x&&location_x<=1078&&745<=location_y&&location_y<=885) {
						 g.drawImage(Constant.ret,968, 745, 110, 140, null);
					}else {
						 g.drawImage(Constant.ret0,968, 745, 110, 140, null);
					}
					
					 if(myhis==null) {
							for(int i=0;i<8;i++) {
								for(int j=0;j<8;j++) {
									Qizi now =mygame.getnow(i, j);
									if(now!=null) {
											
										g.drawImage(now.getPanimg(), (int)now.getPositionx(),(int)now.getPositiony(), (int)Constant.cbuchang, (int)Constant.cbuchang, null);
									}
									
								}
							}
						}else {
							
							int beishu = 10;
							
							if(histimes>Constant.cn*Constant.cn*20||histimes>(myhis.size()-1)*beishu) {
								histimes =0;
								myhis=null;
							}else {
								int i=(int)(histimes/beishu);
		//						if(i+1<=myhis.size()-1&&myhis.get(i+1).getZhuangtai()==0) {
		//							System.out.println("shenmaqingk");
		//							g.drawImage(myhis.get(i+1).getImg(), 900,100, 32, 32, null);
		//							g.drawImage(myhis.get(i+1).getImg(), (int)myhis.get(i+1).getPositionx(), (int)myhis.get(i+1).getPositiony(), 32, 32, null);
		//							System.out.println(myhis.get(i).getX()+""+myhis.get(i).getY());
		//						}
								//g.drawImage(myhis.get(i).getImg(), 900,100, 32, 32, null);
								
								g.drawImage(myhis.get(i).getPanimg(), (int)myhis.get(i).getPositionx(), (int)myhis.get(i).getPositiony(), (int)Constant.cbuchang, (int) Constant.cbuchang, null);
		//						if(myhis.get(i).getZhuangtai()==0) {
		//							g.drawImage(Constant.skip,(int)myhis.get(i).getPositionx(), (int)myhis.get(i).getPositiony(), 32, 32, null);
		//						}else {
		//							g.drawImage(Constant.end,(int)myhis.get(i).getPositionx(), (int)myhis.get(i).getPositiony(), 32, 32, null);
		//						}
								
							}
							histimes++;
						
							
						}
				
				}
				
			
			}
			
			
			

		}
		
		class PaintThread extends Thread{//内部类，可直接调用外部类的方法和属性			
			@Override
			public void run() {
				while(true) {
					repaint();
					//System.out.println("重画了一次");
					try {
						Thread.sleep(40);//1s25桢
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		 @Override
		 public void mouseDragged(MouseEvent e) {
		  // TODO Auto-generated method stub
		  // mouse = new ImageIcon("image/1.gif").getImage();
		  location_x = e.getX();
		  location_y = e.getY();
		 }

		 @Override
		 public void mouseMoved(MouseEvent e) {
		  // TODO Auto-generated method stub
		  location_x = e.getX();
		  location_y = e.getY();
		 }

		 @Override
		 public void mousePressed(MouseEvent e) {
				
				 if(period==0) {
					 if(650<=location_x&&location_x<=950&&200<=location_y&&location_y<=400) {					
							Constant.ss = "chess";
							period=1;
							 mygame= new ChessActions();
							//System.out.println("ennnnn");
							return;
					}else if(650<=location_x&&location_x<=950&&500<=location_y&&location_y<=700){
						Constant.ss = "go";
						period=1;
						mygame = new GoActions();
						//System.out.println("ennnnn11");
						return;
					}

				 }else if(period==1) {
						if(120<=location_x&&location_x<=560&&390<=location_y&&location_y<=485) {
							shushang = true;
							shuxia = false;					
						}else if(115<=location_x&&location_x<=565&&620<=location_y&&location_y<=710) {
							shushang = false;
							shuxia = true;					
						}else if(780<=location_x&&location_x<=1080&&655<=location_y&&location_y<=887) {					
							period = 2;
						}else {
							shushang = false;
							shuxia = true;	
						}						
				 }else if(period==2){
					if(Constant.ss.equals("go")) {					
						 if(Constant.turn==0&&Math.sqrt(((long)(location_x-885))*((long)(location_x-885))+((long)(location_y-206))*((long)(location_y-206)))<141) {
							 if(zhuangtai==-1) {
								 mouse =Constant.bai;							
								 zhuangtai=0;
								 return;
								// System.out.println(lastzhuangtai+""+zhuangtai);
							 }
							 if(zhuangtai==0) {
								 mouse = null;
						
								 zhuangtai=-1;
								 return;
							 }
							
						 }else if(Constant.turn==1&&Math.sqrt(((long)(location_x-885))*((long)(location_x-885))+((long)(location_y-206))*((long)(location_y-206)))<141) {
							 
							 if(zhuangtai ==2) {
								 mouse =null;						
								 zhuangtai=-1;
						
								 return;
							 }	
						 }else if(Constant.turn==1&&Math.sqrt(((long)(location_x-900))*((long)(location_x-900))+((long)(location_y-510))*((long)(location_y-510)))<141) {
						
							 if(zhuangtai==-1) {
								 mouse =Constant.hei;						
								 zhuangtai=1;
								 return;
							 }
							 if(zhuangtai==1) {
								 mouse = null;							 
								 zhuangtai=-1;
								 return;
							 }
							
							 
						 } else if(Constant.turn==0&&Math.sqrt(((long)(location_x-900))*((long)(location_x-900))+((long)(location_y-510))*((long)(location_y-510)))<141) {
							 if(zhuangtai ==3) {
								 mouse =null;						
								 zhuangtai=-1;
								 return;
							 }	
						 }else if(843<=location_x&&location_x<=953&&745<=location_y&&location_y<=885&&zhuangtai==-1) {
							 if(Constant.turn==0) {
								 Constant.turn=1; 
							 }else {
								 Constant.turn=0; 
							 }
						 }else if(968<=location_x&&location_x<=1078&&745<=location_y&&location_y<=885) {
							period = 3;
						}
						 if(zhuangtai==0||zhuangtai==2) {//p1   turn =0;
							 int belong;
							 belong = Constant.turn;
							 if(zhuangtai==2) {
								if(belong ==0) {
									belong=1;
								}else {
									belong=0;
								}
							 }
							 
							 if(zhuangtai==2&&(int)((location_x-Constant.origin_x)/Constant.buchang)==lasttizix&&(int)((location_y-Constant.origin_y)/Constant.buchang)==lasttiziy) {
								 Qizi now = mygame.fangzi(p1.getQizion().size()+p2.getQizion().size(),location_x, location_y,"bai",belong);
								 if(now!=null) {
									 p1.addqizi(now);
										
										zhuangtai=-1;
										Constant.turn = 1;
										mouse = null;
								}
								 return;
							 }
							 if(zhuangtai==0){
								 Qizi now = mygame.fangzi(p1.getQizion().size()+p2.getQizion().size(),location_x, location_y,"bai",belong);
								 if(now!=null) {
									 p1.addqizi(now);
								
										zhuangtai=-1;
										Constant.turn = 1;
										mouse = null;
								}
								 return;
							 }
								
						 }
						 if(zhuangtai==1||zhuangtai==3) {//p2  turn =1;
							 int belong;
							 belong = Constant.turn;
							 if(zhuangtai==3) {
								if(belong ==0) {
									belong=1;
								}else {
									belong=0;
								}
							 }
							
							 if(zhuangtai==3&&(int)((location_x-Constant.origin_x)/Constant.buchang)==lasttizix&&(int)((location_y-Constant.origin_y)/Constant.buchang)==lasttiziy) {
								 Qizi now = mygame.fangzi(p1.getQizion().size()+p1.getQizion().size(),location_x, location_y,"hei",belong);
								 if(now!=null) {
										p2.addqizi(now);									
										zhuangtai=-1;
										Constant.turn = 0;
										mouse = null;
								}
								 return;
							 }
							 if(zhuangtai==1){
								 Qizi now = mygame.fangzi(p1.getQizion().size()+p1.getQizion().size(),location_x, location_y,"hei",belong);
								 if(now!=null) {
										p2.addqizi(now);									
										zhuangtai=-1;
										Constant.turn = 0;
										mouse = null;
								}
								 return;
							 }
							
						 }
						 if(zhuangtai ==-1) {
							 Qizi now = mygame.tizi(location_x, location_y);
							 if(now!=null) {
								 if(Constant.turn==0) {
									 p2.removeqizi(now);
									 mouse = now.getImg();
									 lasttizix= now.getX();
									 lasttiziy= now.getY();		
							
									  zhuangtai=3;//hei
								 }else {
									p1.removeqizi(now);
									mouse = now.getImg();
									lasttizix= now.getX();
									 lasttiziy= now.getY();
								
									 zhuangtai=2;//bai
								 }
								
							 }
						 }
					}else {
						if(843<=location_x&&location_x<=953&&745<=location_y&&location_y<=885&&zhuangtai==-1) {
							 if(Constant.turn==0) {
								 Constant.turn=1; 
							 }else {
								 Constant.turn=0; 
							 }
						 }else if(968<=location_x&&location_x<=1078&&745<=location_y&&location_y<=885) {
							period = 3;
						}else if(Constant.corigin_x<=location_x&&location_x<=Constant.cend_x&&Constant.corigin_y<=location_y&&location_y<=Constant.cend_y) {
							if(zhuangtai==-1) {								
								Qizi now = mygame.tizi(location_x,location_y);
								if(now!=null) {									
									beitide =now;
									zhuangtai = 1;
									mouse = now.getImg();
								}
								return;
							}
							if(zhuangtai==1) {
								Qizi now = mygame.getnow((float)location_x,(float)location_y);
								if(now==null||now.getZhuangtai()==0) {
									mygame.fangzi_new(beitide,(float)location_x,(float)location_y);
									mouse =null;
									if(now==null) {
										if(Constant.turn==0) {
											 Constant.turn=1; 
										 }else {
											 Constant.turn=0; 
										 }
									}else {
										if(now.getX()!=beitide.getX()&&now.getY()!=beitide.getY()) {
											if(Constant.turn==0) {
												 Constant.turn=1; 
											 }else {
												 Constant.turn=0; 
											 }
										}
									}
									 
									 zhuangtai = -1;
								}else {
									if(now.getBelong()==Constant.turn) {
										mygame.fangzi_new(beitide,(float)location_x,(float)location_y);
										mouse =null;
										if(Constant.turn==0) {
											 Constant.turn=1; 
										 }else {
											 Constant.turn=0; 
										 }
										 zhuangtai = -1;
										
									}
								}
							}
							
						}
						
					}	 
				 	
				 }else if(period==3) {
					 if(968<=location_x&&location_x<=1078&&745<=location_y&&location_y<=885) {
						 period = 0;
						 p1 = new Player();
					     p2 = new Player();
					     mygame= new GoActions();					 
					    zhuangtai=-1;					 
						 mouse =null;
						 shang =null;
						 xia =null;
						 myshushang =null;
						 myshuxia =null;
						 shushang =false;
						 shuxia =false;
						 times = 0;
						 myhis =null;
					     lasttizix=0;
		         		  lasttiziy=0;
						  nn=0;
						 
					}else if(843<=location_x&&location_x<=953&&745<=location_y&&location_y<=885) {
						nn=0;
						myhis = mygame.getHistory();
					}	
				 }
		 		
		
	 
		  System.out.println("mouse has clicked   y="+location_y+"x="+location_x);
		 }

		 @Override
		 public void mouseEntered(MouseEvent e) {
		  // TODO Auto-generated method stub
		 // System.out.println("mouse has entered");
		 }

		 @Override
		 public void mouseExited(MouseEvent e) {
		  // TODO Auto-generated method stub
		 // System.out.println("mouse has exited");
		 }

		 @Override
		 public void mouseClicked(MouseEvent e) {
		  // TODO Auto-generated method stub
		 // mouse = new GameUtil.getImage("P3/images/bai.png");
		 }

		 @Override
		 public void mouseReleased(MouseEvent e) {
		  // TODO Auto-generated method stub
		//  mouse = new GameUtil.getImage("P3/images/bai.png");
		 }
	
		 
		 /**
			 * 定义键盘监听的内部类
			 * @author 豆豆
			 *
			 */
		class KeyMonitor extends KeyAdapter {
			//在这里alt+shift+s里面的override	
			@Override
			public void keyPressed(KeyEvent e) {
				if(period==1) {
					if(shushang) {
						char s =e.getKeyChar();
					
						if((s<='Z'&&'A'<=s)||(s<='z'&&'a'<=s)) {
							p1.addChar(s+"");
						}else {							
							switch(e.getKeyCode()){
	                        case KeyEvent.VK_BACK_SPACE:p1.delChar(); break;
	                        case KeyEvent. VK_ENTER:shushang=false; break;                  
							}
						}
					}
					if(shuxia) {
						char s =e.getKeyChar();
						if((s<='Z'&&'A'<=s)||(s<='z'&&'a'<=s)) {
							p2.addChar(s+"");
						}else {							
							switch(e.getKeyCode()){							
	                        case KeyEvent.VK_BACK_SPACE:p2.delChar(); break;
	                        case KeyEvent.VK_ENTER:shuxia=false; break;	                                
							}
						}
					}

				
				}
			}
			
		}
		 
		
		/**
		 * 初始化窗口
		 */
	    public void launchFrame(){
	    	
	        //在游戏窗口打印标题
	        setTitle("Miss Zhang's Game");
	        //窗口默认不可见，设为可见
	        setVisible(true);
	        //窗口大小：宽度500，高度500
	        setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
	        //窗口左上角顶点的坐标位置
	        setLocation(100, 100);
	         
	        //增加关闭窗口监听，这样用户点击右上角关闭图标，可以关闭游戏程序
	        addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent e) {
	                System.exit(0);
	            }
	        });
	        
	        new PaintThread().start();//启动重画窗口的线程	
	        addKeyListener(new KeyMonitor());//增加键盘的监听
	        
	        
	    }
	    
	     
	    public static void main(String[] args) {
	    	MyGameFrame f = new MyGameFrame();		        
	        f.launchFrame();
	        f.addMouseListener(f);
	        f.addMouseMotionListener(f);
	        
//	       GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
//	       Font[] fonts = e.getAllFonts();
//	       for (Font font : fonts) {
//	           String fontName = font.getFontName();
//	           System.out.println(fontName);
//	       }
	 
	      
	    }
	    /**
		 * 双缓冲技术解决闪的问题
		 */
		private Image offScreenImage = null;
		 
		public void update(Graphics g) {
		    if(offScreenImage == null)
		        offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);//这是游戏窗口的宽度和高度
		     
		    Graphics gOff = offScreenImage.getGraphics();
		    paint(gOff);
		    g.drawImage(offScreenImage, 0, 0, null);
		}
	
			
}


	 