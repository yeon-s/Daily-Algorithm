package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1963_소수경로 {

	static boolean[] sosu;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		sosu = new boolean[10000];
		StringBuilder sb = new StringBuilder();
		
		for(int i=2;i*i<=10000;i++) {
			for(int j=i*i;j<10000;j+=i) {
				sosu[j]=true;
			}
		}
		//false면 소수
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			boolean[] visited = new boolean[10000];
			visited[start]=true;
			
			Queue<Integer> queue = new LinkedList<>();
			queue.offer(start);
			
			
			int cnt=0;
			boolean flag=false;
			while(!queue.isEmpty()) {
				int size = queue.size();
				while(size-->0) {
					int current = queue.poll();
					
					if(current==end) {
						sb.append(cnt+"\n");
						flag=true;
						break;
					}
					
					for(int i=1000;i<10000;i++) {
						if(!visited[i] && !sosu[i] && check(i,current)) {
							queue.offer(i);
							visited[i]=true;
						}
					}
				}
				if(flag) {
					break;
				}
				cnt++;
			}
			
			if(!flag) {
				sb.append("Impossible"+"\n");
			}
		}
		System.out.println(sb);
		
	}
	static boolean check(int num,int current) {
		
		int cnt=0;
		String one = (num+"");
		String two = (current+"");
		for(int i=0;i<4;i++) {
			if(one.charAt(i)!=two.charAt(i)) {
				cnt++;
			}
		}
		
		if(cnt==1) {
			return true;
		}
		
		return false;
	}
}
