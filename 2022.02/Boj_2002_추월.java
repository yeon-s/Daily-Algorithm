package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Boj_2002_추월 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Map<String, Integer> map = new HashMap<>();
		int index=1;
		
		for(int i=0;i<N;i++) {
			map.put(br.readLine(), index++);
		}
		
		int answer=0;
		int check=1;
		boolean[] visited = new boolean[N+1];
		for(int i=0;i<N;i++) {
			int num= map.get(br.readLine());
			visited[num]=true;
			boolean flag=true;
			for(int j=1;j<num;j++) {
				if(!visited[j]) {
					flag=false;
				}
			}
			
			if(!flag) {
				answer++;
			}
		}
		System.out.println(answer);
	}

}
