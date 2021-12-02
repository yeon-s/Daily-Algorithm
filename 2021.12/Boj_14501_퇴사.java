package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14501_퇴사 {

	static int N;
	static int[] day;
	static int[] price;
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		day = new int[N];
		price = new int[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			day[i] = Integer.parseInt(st.nextToken());
			price[i] = Integer.parseInt(st.nextToken());
		}
		//입력 끝
		
		max = 0;
		comb(0,0,0);
		System.out.println(max);
	}
	
	static void comb(int start,int sum,int nowPrice) {
		if(start>N) {
			max = Math.max(max, sum-nowPrice);
			return;
		}else if(start==N) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=start;i<N;i++) {
			comb(i+day[i],sum+price[i],price[i]);
		}
	}
	
//	static void comb(int target,int sum) {
//		if(target==N) {
//			max = Math.max(max, sum);
//			return;
//		}
//		
//		if(target+day[target]<N) {
//			comb(target+day[target],sum+price[target]);		//현재 날을 뽑을때			
//		}else if(target+day[target]==N) {
//			max = Math.max(max, sum+price[target]);
//			return;
//		}else {
//			max = Math.max(max, sum);
//			return;
//		}
//		if(target+1<N) {
//			comb(target+1,sum);								//현재 날 안뽑을때			
//		}
//		
//		
//	}
	
//	static void comb2(int target,int sum) {
//		if(target==N) {
//			max = Math.max(max, sum);
//			return;
//		}
//		
//		if(target+day[target]<N) {
//			comb2(target+day[target],sum+price[target]);		//현재 날을 뽑을때			
//		}else {
//			max = Math.max(max, sum);
//			return;
//		}
//		comb2(target+1,sum);								//현재 날 안뽑을때
//		
//		
//	}

}
