package P1;
import java.io.*;
import java.util.*;
import java.util.regex.*;
public class MagicSquare {
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		String txt1 = new String("src/P1/txt/1.txt");
		boolean a1 = isLegalMagicSquare(txt1);
		System.out.println("1.txt\t"+a1);
		System.out.println();
		System.out.println();
		
		
		String txt2 = new String("src/P1/txt/2.txt");
		boolean a2 = isLegalMagicSquare(txt2);
		System.out.println("2.txt\t"+a2);
		System.out.println();
		System.out.println();
		
		String txt3 = new String("src/P1/txt/3.txt");
		boolean a3 = isLegalMagicSquare(txt3);
		System.out.println("3.txt\t"+a3);
		System.out.println();
		System.out.println();
		
		String txt4 = new String("src/P1/txt/4.txt");
		boolean a4 = isLegalMagicSquare(txt4);
		System.out.println("4.txt\t"+a4);
		System.out.println();
		System.out.println();
		
		String txt5 = new String("src/P1/txt/5.txt");
		boolean a5 = isLegalMagicSquare(txt5);
		System.out.println("5.txt\t"+a5);
		System.out.println();
		System.out.println();
		
		int n = 5;
		boolean b = generateMagicSquare(n) ;
		if(b) {
			boolean c = isLegalMagicSquare("src/P1/txt/6.txt");
			System.out.println("6.txt\t n="+n+"\t"+c);

			 
		}else{
			System.out.println("false");
		}
		
	}

	public static boolean isLegalMagicSquare(String fileName) {
		
		//System.out.println("File的文件名："+f.getName());
		ArrayList<String> arrayList = new ArrayList<>();
	
		try {
			File f = new File(fileName);
		    InputStreamReader input = new InputStreamReader(new FileInputStream(fileName));
			BufferedReader bf = new BufferedReader(input);
			// 按行读取字符串
			String str;
			while ((str = bf.readLine()) != null) {
				arrayList.add(str);
			}
			bf.close();
			input.close();
			int length = arrayList.size();
			int i;
			int width;
			String[][] line = new String[length][];		
			Integer[][]  array = new Integer[length][length];
			for(i=0;i<length;i++) {
				//System.out.print(arrayList.get(i));
						
				width = arrayList.get(i).split("\t").length;
				try {
					if(width!=length) {
						
						if(arrayList.get(i).indexOf(' ')!=-1) {
							
							System.out.println("数字之间并非使用\\t分割,而是使用空格分割");
						
							return false;
						}else {
							System.out.println("行数 = "+length+",第"+(i+1)+"行的列数 = "+width+"   矩阵行数和列数不相等");
						
							return false;
						}						
					}
				
					line[i] = arrayList.get(i).split("\t");		
					
				}catch(Exception e ) {
					e.printStackTrace();
				}
			}
			width = arrayList.get(0).split("\t").length;
			
				for (i = 0; i < length; i++) {
					for (int j = 0; j < width; j++) {
						//String s = arrayList.get(i).split("\t")[j];
						try {							
						array[i][j] = Integer.valueOf(line[i][j]);
						}catch(NumberFormatException e){
							if(line[i][j].indexOf('.')!=-1) {
								System.out.println("array["+i+"]["+j+"]="+line[i][j]+"   数字为小数");
								return false;
			
							}else {
								System.out.println("数字之间并非使用\\t分割");
								return false;
							}
							
						}	
						if(array[i][j]<0) {
							System.out.println("array["+i+"]["+j+"]="+array[i][j]+"    数字为负");
							return false;
						}
							
						
						
					}
				}
			
//			if(fileName.indexOf('6')!=-1) {
//					for(i=0;i<length;i++) {
//						int j;
//						for(j=0;j<length;j++) {
//							System.out.println(array[i][j]+"\t");
//						}
//					}
//			}
//				
			int sum = 0;
			for(i=0;i<length;i++) {
				sum += array[i][i];
			}
			int sum1 = 0;
			for(i=0;i<length;i++) {
				sum1 += array[i][length-1-i];
			}
			
			if(sum1!=sum) {
				return false;
			}else {
				sum1 = 0;
			}
			
		
			int j ;		
			for(i=0;i<length;i++) {
				for(j=0;j<length;j++) {
					sum1 += array[i][j];
				}
				if(sum1!=sum) {
					return false;
				}else {
					sum1 = 0;
				}
			}
			for(i=0;i<length;i++) {
				for(j=0;j<length;j++) {
					sum1 += array[j][i];
				}
				if(sum1!=sum) {
					return false;
				}else {
					sum1 = 0;
				}
			}		
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	
	}
	
	public static boolean generateMagicSquare(int n) {
		//String[][] array = new String[n][];		
		String txt6 = new String("src/P1/txt/6.txt");
		File file = new File(txt6);
		FileWriter fileWritter = null;
		
		int magic[][] = new int[n][n];
		try {
		int row = 0, col = n / 2, i, j, square = n * n;

		for (i = 1; i <= square; i++) {
			magic[row][col] = i;
			if (i % n == 0)//每n个数写在一条斜线上
				row++;
			else {
				//row--；如果row机减到0，row就=n-1
				if (row == 0)
					row = n - 1;
				else
					row--;
				//col++；如果col加到n-1，col就=0
				if (col == (n - 1))
					col = 0;
				else
					col++;
			}
		}

		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				System.out.print(magic[i][j] + "\t");
				String s = new String(""+magic[i][j]);
				try{
					if(i==0&&j==0) {
						fileWritter = new FileWriter(file.getAbsoluteFile());
					}else {
						fileWritter = new FileWriter(file.getAbsoluteFile(),true);
						
					}
					
					if(j==n-1) {
						fileWritter.write(magic[i][j]+"\n");
					}else {
						fileWritter.write(magic[i][j]+"\t");
					}
					
					fileWritter.close();
				}catch(IOException e){
				      e.printStackTrace();
				}

			}	
			System.out.println();
		}
		return true;
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("输入了偶数");
			return false;
		}catch(NegativeArraySizeException e) {
			System.out.println("输入了负数");
			return false;
		}


	}

}

