package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_18870_좌표압축 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Num[] arr = new Num[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = new Num(Integer.parseInt(st.nextToken()), i);
		}
		//입력 끝
		
		Arrays.sort(arr, new Comparator<Num>() {
			
			public int compare(Num o1, Num o2) {
				return o1.i-o2.i;
			}
		});
		
		int[] answer = new int[N];
		answer[arr[0].index]=0;
		
		for(int i=1;i<N;i++) {
			if(arr[i].i>arr[i-1].i) {
				answer[arr[i].index]=answer[arr[i-1].index]+1;
			}else {
				answer[arr[i].index]=answer[arr[i-1].index];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i:answer) {
			sb.append(i+" ");
		}
		
		System.out.println(sb);

	}
	
	static class Num{
		int i;
		int index;
		public Num(int i, int index) {
			super();
			this.i = i;
			this.index = index;
		}
		
	}
	
	

}
