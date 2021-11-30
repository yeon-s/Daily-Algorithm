package practice;

import java.util.Scanner;

public class Boj_1074_Z_2 {

	
	static int result;
	static int r;
	static int c;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		
		result=0;
		
		divide(r,c,0,1<<N);
		
		System.out.println(result);
	}
	
	static void divide(int r,int c,int startnum,int N) {
		if(N==1) {
			result = startnum;
			return;
		}
		
		if(r<N/2 && c<N/2) {
			divide(r,c,startnum,N/2);
		}else if(r<N/2 && c>=N/2) {
			divide(r,c-N/2,startnum+(N*N)/4,N/2);
		}else if(r>=N/2 && c<N/2) {
			divide(r-N/2,c,startnum+((N*N)/4)*2,N/2);
		}else if(r>=N/2 && c>=N/2) {
			divide(r-N/2,c-N/2,startnum+((N*N)/4)*3,N/2);
		}
	}

}
