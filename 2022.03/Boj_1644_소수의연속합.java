package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj_1644_소수의연속합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		if(N==1) {
			System.out.println(0);
			return;
		}
		
		boolean[] sosu = new boolean[N+1];	//false면 소수
		
		//에라토스테네스의 체
		for(int i=2;i*i<sosu.length;i++) {	
			if(!sosu[i]) {
				for(int j=i*i;j<sosu.length;j+=i) {
					sosu[j]=true;
				}
			}
		}
		
		List<Integer> list = new ArrayList<>();
		for(int i=2;i<sosu.length;i++) {
			if(!sosu[i]) {
				list.add(i);
			}
		}
		
		int start=0;
		int end=0;
		int sum=2;
		int answer=0;
		
		while(end<list.size()) {
			
			if(sum<N) {
				end++;
				if(end==list.size()) {
					break;
				}
				sum+=list.get(end);
			}else if(sum==N){
				answer++;
				end++;
				if(end==list.size()) {
					break;
				}
				sum+=list.get(end);
			}else {
				sum-=list.get(start);
				start++;
			}
		}
		
		System.out.println(answer);
		

	}

}
