package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj_11656_접미사배열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		PriorityQueue<String> pq = new PriorityQueue<>();
		
		for(int i=0;i<str.length();i++) {
			pq.offer(str.substring(i,str.length()));
		}
		
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			sb.append(pq.poll()+"\n");
		}
		System.out.println(sb);
	}

}
