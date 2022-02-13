package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Boj_7490_0만들기 {
	
	static int N;
	static int[] result;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			
			sb = new StringBuilder();
			result = new int[N];
			dfs(1,"");
			answer.append(sb+"\n");
		}
		System.out.println(answer);
	}
	
	static void dfs(int current, String str) {
		if(current==N) {
			str+=(current+"");
			
			List<Integer> list = new ArrayList<>();
			
			for(int i=1;i<=N;i++) {
				if(result[i-1]==0 || result[i-1]==1) {
					list.add(i);					
				}else if(result[i-1]==2) {
					list.add(i*-1);
				}else if(result[i-1]==3) {
					int num=list.get(list.size()-1);
					list.remove(list.size()-1);
					if(num<0) {
						list.add(num-i);
					}else {
						list.add(num+i);						
					}
				}
				if(i==N) {
					break;
				}
				if(result[i]==3) {
					int num=list.get(list.size()-1);
					list.remove(list.size()-1);
					list.add(num*10);
				}
			}
			
			int sum=0;
			for(int i:list) {
				sum+=i;
			}
			if(sum==0) {
				sb.append(str+"\n");
			}
			return;
		}
		
		str+=(current+"");
		
		result[current]=3;
		dfs(current+1,str+" ");
		result[current]=1;
		dfs(current+1,str+"+");
		result[current]=2;
		dfs(current+1,str+"-");
	}

}
