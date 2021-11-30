package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2565_전깃줄_실패 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Chain[] chains = new Chain[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			chains[i] = new Chain(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		//입력 끝
		Arrays.sort(chains);
		int sum=0;
		for(int i=0;i<N;i++) {
			for(int j=i;j<N;j++) {
				if(chains[i].a<chains[j].a && chains[i].b>chains[j].b) {
					sum++;
					break;
				}
			}
		}
		System.out.println(sum);

	}

	static class Chain implements Comparable<Chain>{
		int a;
		int b;
		public Chain(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}
		@Override
		public int compareTo(Chain o) {
			// TODO Auto-generated method stub
			return this.a-o.a;
		}
		
	}
}
