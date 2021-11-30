package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_3234_준환이의양팔저울 {

	static int N;
	static int[] arr;
	static boolean[] isSelected;
	static int answer;
	static int sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N];
			sum=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum +=arr[i];
			}
			//입력 끝
			
			isSelected = new boolean[N];
			answer=0;
			perm(0,0,0);
			System.out.println("#"+tc+" "+answer);
		}

	}
	
	static void perm(int cnt,int left,int right) {
		if(right>left) {
			return;
		}
		
		if(left>=sum-left) {
			answer+= (1<<(N-cnt))*factorial(N-cnt);
			return;
		}
		
		if(cnt==N) {
			answer++;
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(isSelected[i]) {
				continue;
			}
			
			isSelected[i]=true;
			perm(cnt+1,left+arr[i],right);
			perm(cnt+1,left,right+arr[i]);
			isSelected[i]=false;
		}
		
		
	}
	
	static int factorial(int n) {
		if(n<=1) {
			return 1;
		}
		
		return n*factorial(n-1);
	}
	
//	static int pow(int n) {
//		if(n==0) {
//			return 1;
//		}
//		int num=1;
//		for(int i=0;i<n;i++) {
//			num *=2;
//		}
//		return num;
//	}

}
