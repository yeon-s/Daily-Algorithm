package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_9375_패션왕신해빈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=T;tc++) {
			Map<String, Integer> map = new HashMap<>();
			
			int num = Integer.parseInt(br.readLine());
			for(int i=0;i<num;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String what = st.nextToken();
				String sort = st.nextToken();
				map.put(sort, map.getOrDefault(sort, 0)+1);
			}
			
			int answer= 1;
			for(String key:map.keySet()) {
				answer = answer*(map.get(key)+1);
			}
			
			sb.append(answer-1+"\n");
			
		}
		System.out.println(sb);

	}

}
