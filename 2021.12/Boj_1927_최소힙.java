package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj_1927_최소힙 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			int x = Integer.parseInt(br.readLine());
			if(x!=0) {
				pq.add(x);
			}else {
				if(pq.isEmpty()) {
					sb.append(0).append("\n");
					continue;
				}
				sb.append(pq.poll()).append("\n");
			}
		}
		System.out.println(sb);

	}

}
