package practice;

import java.util.Scanner;

public class Boj_1074_Z_시간초과 {

	
	static int num;
	static int r;
	static int c;
	static boolean flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		
		num=0;
		flag = false;
		divide(0,0,1<<N);
		
		System.out.println(num-1);
	}
	
	static void divide(int si,int sj,int size) {
		if(flag) {
			return;
		}
		if(size==2) {
			for(int i=si;i<=si+1;i++) {
				for(int j=sj;j<=sj+1;j++) {
					num++;
					if(i==r && j==c) {
						flag= true;
						return;
					}
				}
			}
			return;
		}
		
		divide(si,sj,size/2);
		divide(si,sj+(size/2),size/2);
		divide(si+(size/2),sj,size/2);
		divide(si+(size/2),sj+(size/2),size/2);
		
//		divide(si,sj,size-1);
//		divide(si,sj+(int)Math.pow(2, size-1),size-1);
//		divide(si+(int)Math.pow(2, size-1),sj,size-1);
//		divide(si+(int)Math.pow(2, size-1),sj+(int)Math.pow(2, size-1),size-1);
		
	}

}
