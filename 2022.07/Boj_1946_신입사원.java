package repeat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1946_신입사원 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			
			newMan[] arr = new newMan[N];
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				arr[i] = new newMan(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			
			Arrays.sort(arr);
			int answer =1;
			int temp = arr[0].y;
			for(int i=1;i<N;i++) {
				if(arr[i].y<temp) {
					temp=arr[i].y;
					answer++;
				}
			}
			
			sb.append(answer+"\n");
		}
		System.out.println(sb);
	}
	
	static class newMan implements Comparable<newMan>{
		int x;
		int y;
		public newMan(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		public int compareTo(newMan o) {
			return this.x-o.x;
		}
	}

}
