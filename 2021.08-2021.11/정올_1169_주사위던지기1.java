package practice;

import java.util.Scanner;

public class 정올_1169_주사위던지기1 {

	static int[] result;
	static boolean[] isSelected;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int M = sc.nextInt();
		
		result = new int[N];
		
		isSelected = new boolean[7];
		if(M==1) {
			perm(0);
		}else if(M==2) {
			comb(1,0);
		}else if(M==3) {
			perm2(0);
		}

	}
	
	static void perm(int cnt) {
		if(cnt==N) {
			for(int i=0;i<N;i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1;i<=6;i++) {
			result[cnt] = i;
			perm(cnt+1);
		}
	}
	
	static void comb(int start,int cnt) {
		if(cnt==N) {
			for(int i=0;i<N;i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
			
		}
		
		for(int i=start;i<=6;i++) {
			result[cnt] = i;
			comb(i,cnt+1);
		}
	}
	
	static void perm2(int cnt) {
		if(cnt==N) {
			for(int i=0;i<N;i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1;i<=6;i++) {
			if(isSelected[i]) {
				continue;
			}
			isSelected[i] = true;
			result[cnt]=i;
			perm2(cnt+1);
			isSelected[i] = false;
		}
	}

}
