package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Boj_1181_단어정렬 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Map<String, word> map = new HashMap<>();
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			map.put(str, new word(str.length(), str));
		}
		
		PriorityQueue<word> pq = new PriorityQueue<>();
		for(String key: map.keySet()) {
			pq.add(map.get(key));
		}
		
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			sb.append(pq.poll().str+"\n");
		}
		System.out.println(sb);
	}
	
	static class word implements Comparable<word>{
		int length;
		String str;
		public word(int length, String str) {
			super();
			this.length = length;
			this.str = str;
		}
		@Override
		public int compareTo(word o) {
			if(this.length==o.length) {
				return this.str.compareTo(o.str);
			}else {
				return this.length-o.length;				
			}
		}
		
	}

}
