package P3;

import java.util.ArrayList;
import java.util.List;

public class GoFields{
	
	private Qizi[][] qizi;
	private int n;
	
	
	private List<Qizi> history = new ArrayList<>();
	public GoFields(int n) {
		this.n = n;
		if(n==8) {
			 qizi = new Qizi[n][n];
			Qizi q00 = new Qizi("rook1",0,0,0,1,1);			
			Qizi q01 = new Qizi("knight1",1,1,0,1,1);
			Qizi q02 = new Qizi("bishop1",2,2,0,1,1);
			Qizi q03 = new Qizi("king1",3,3,0,1,1);
			Qizi q04 = new Qizi("queen1",4,4,0,1,1);
			Qizi q05 = new Qizi("bishop1",5,5,0,1,1);
			Qizi q06 = new Qizi("knight1",6,6,0,1,1);
			Qizi q07 = new Qizi("rook1",7,7,0,1,1);
			
			Qizi q10 = new Qizi("pawn1",8,0,1,1,1);
			Qizi q11 = new Qizi("pawn1",9,1,1,1,1);
			Qizi q12 = new Qizi("pawn1",10,2,1,1,1);
			Qizi q13 = new Qizi("pawn1",11,3,1,1,1);
			Qizi q14 = new Qizi("pawn1",12,4,1,1,1);
			Qizi q15 = new Qizi("pawn1",13,5,1,1,1);
			Qizi q16 = new Qizi("pawn1",14,6,1,1,1);
			Qizi q17 = new Qizi("pawn1",15,7,1,1,1);
			
			Qizi q60 = new Qizi("pawn0",16,0,6,1,0);
			Qizi q61 = new Qizi("pawn0",17,1,6,1,0);
			Qizi q62 = new Qizi("pawn0",18,2,6,1,0);
			Qizi q63 = new Qizi("pawn0",19,3,6,1,0);
			Qizi q64 = new Qizi("pawn0",20,4,6,1,0);
			Qizi q65 = new Qizi("pawn0",21,5,6,1,0);
			Qizi q66 = new Qizi("pawn0",22,6,6,1,0);
			Qizi q67 = new Qizi("pawn0",23,7,6,1,0);
			
			Qizi q70 = new Qizi("rook0",24,0,7,1,0);
			Qizi q71 = new Qizi("knight0",25,1,7,1,0);
			Qizi q72 = new Qizi("bishop0",26,2,7,1,0);
			Qizi q73 = new Qizi("king0",27,3,7,1,0);
			Qizi q74 = new Qizi("queen0",28,4,7,1,0);
			Qizi q75 = new Qizi("bishop0",29,5,7,1,0);
			Qizi q76 = new Qizi("knight0",30,6,7,1,0);
			Qizi q77 = new Qizi("rook0",31,7,7,1,0);
			
			
			qizi[0][0] =q00;
			qizi[0][1] =q01;
			qizi[0][2] =q02;
			qizi[0][3] =q03;
			qizi[0][4] =q04;
			qizi[0][5] =q05;
			qizi[0][6] =q06;
			qizi[0][7] =q07;
			
			qizi[1][0] =q10;
			qizi[1][1] =q11;
			qizi[1][2] =q12;
			qizi[1][3] =q13;
			qizi[1][4] =q14;
			qizi[1][5] =q15;
			qizi[1][6] =q16;
			qizi[1][7] =q17;
			
			qizi[6][0] =q60;
			qizi[6][1] =q61;
			qizi[6][2] =q62;
			qizi[6][3] =q63;
			qizi[6][4] =q64;
			qizi[6][5] =q65;
			qizi[6][6] =q66;
			qizi[6][7] =q67;

			qizi[7][0] =q70;
			qizi[7][1] =q71;
			qizi[7][2] =q72;
			qizi[7][3] =q73;
			qizi[7][4] =q74;
			qizi[7][5] =q75;
			qizi[7][6] =q76;
			qizi[7][7] =q77;
			for(int i=2;i<6;i++) {
				for(int j=0;j<8;j++) {
					qizi[i][j]=null;
				}
			}	
		}
		if(n==19) {
		
		 qizi = new Qizi[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				qizi[i][j]=null;
			}
		}		
		}
	}
	
	public Qizi getij(int i,int j) {
		
		return qizi[i][j];
	}
	public  Qizi setij(int i,int j,Qizi value) {		
		Qizi last = qizi[i][j];
		qizi[i][j] =new Qizi(value.getField(),value.getId(),value.getX(),value.getY(),value.getZhuangtai(),value.getBelong());			
		history.add(value);			
		return last;		
	}

	public Qizi[][] getQizi() {
		return qizi;
	}

	public int getN() {
		return n;
	}


	public List<Qizi> getHistory() {
		return history;
	}
	
	
}