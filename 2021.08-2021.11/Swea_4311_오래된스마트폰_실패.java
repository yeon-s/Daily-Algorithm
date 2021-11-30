package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_4311_오래된스마트폰_실패 {

	static int N;
	static int[] number;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int O = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			number = new int[N];
			for(int i=0;i<N;i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			int[] oper = new int[O];
			for(int i=0;i<O;i++) {
				oper[i] = Integer.parseInt(st.nextToken());
			}
			
			int W = Integer.parseInt(br.readLine());
			//입력 끝
			
			boolean one = false;
			for(int i=0;i<N;i++) {
				if(W==number[i]) {
					one = true;
					break;
				}
			}
			if(one) {
				System.out.println("#"+tc+" "+"1");
				continue;
			}else {
				if(W>=10 && W<100) {
					perm(0,2,0,0);
				}else if(W>=100) {
					
				}
			}
			
			
		}
	}
	
	//중복순열
	static void perm(int target,int cnt,int ten,int one) {
		if(target==cnt) {
			
			return;
		}
		
		
		
		for(int i=0;i<N;i++) {
			if(target==0) {		
				perm(target+1,cnt,number[i],one);
			}else {
				perm(target+1,cnt,ten,number[i]);
			}
			
			
		}
	}

}
