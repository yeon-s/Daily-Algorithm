package practice;

import java.util.Scanner;

public class Boj_3040_백설공주와일곱난쟁이 {

	static int[] arr;
	static int[] result;
	static boolean flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		arr = new int[9];
		for(int i=0;i<9;i++) {
			arr[i] = sc.nextInt();
		}
		//입력 끝
		flag=false;
		result = new int[7];
		
		comb(0,0,0);
	}
	
	static void comb(int start,int cnt,int sum) {
		if(flag) {
			return;
		}
		if(sum>100) {
			return;
		}
		if(cnt==7) {
			if(sum==100) {
				flag=true;
				for(int i=0;i<7;i++) {
					System.out.println(result[i]);					
				}
			}
			return;
		}
		
		for(int i=start;i<9;i++) {
			result[cnt] = arr[i];
			comb(i+1,cnt+1,sum+arr[i]);
		}
	}

}
