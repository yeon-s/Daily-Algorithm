package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Boj_7662_이중우선순위큐2_TreeMap {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=T;tc++) {
			int k = Integer.parseInt(br.readLine());
			
			TreeMap<Integer, Integer> map = new TreeMap<>();
			while(k-->0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				if(st.nextToken().equals("I")) {
					int number = Integer.parseInt(st.nextToken());
					map.put(number,map.getOrDefault(number, 0)+1);
				}else {
					int num = Integer.parseInt(st.nextToken());
					if(map.isEmpty()) {
						continue;
					}
					if(num==1) {
						if(map.get(map.lastKey())>1) {
							map.put(map.lastKey(), map.get(map.lastKey())-1);
						}else {
							map.remove(map.lastKey());							
						}
					}else {
						if(map.get(map.firstKey())>1) {
							map.put(map.firstKey(), map.get(map.firstKey())-1);
						}else {
							map.remove(map.firstKey());							
						}
					}
				}
			}
			
			if(map.isEmpty()) {
				sb.append("EMPTY").append("\n");
			}else {
				sb.append(map.lastKey());
				sb.append(" ");
				sb.append(map.firstKey());
				sb.append("\n");
			}
		}
		System.out.println(sb);

	}

}
