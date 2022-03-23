package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Boj_12852_1로만들기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean[] visited = new boolean[N+1];
		Queue<Num> queue = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		list.add(N);
		
		queue.offer(new Num(N, list));
		visited[N]=true;
		
		int time=0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				Num cur = queue.poll();
				
				if(cur.num==1) {
					System.out.println(time);
					StringBuilder sb = new StringBuilder();
					for(int i:cur.list) {
						sb.append(i+" ");
					}
					System.out.println(sb);
					return;
				}
				
				if(cur.num%3==0 && !visited[cur.num/3]) {
					int next = cur.num/3;
					List<Integer> temp = new ArrayList<>();
					for(int i=0;i<cur.list.size();i++) {
						temp.add(cur.list.get(i));
					}
					temp.add(next);
					queue.offer(new Num(next, temp));
					visited[next]=true;
				}
				
				if(cur.num%2==0 && !visited[cur.num/2]) {
					int next = cur.num/2;
					List<Integer> temp = new ArrayList<>();
					for(int i=0;i<cur.list.size();i++) {
						temp.add(cur.list.get(i));
					}
					temp.add(next);
					queue.offer(new Num(next, temp));
					visited[next]=true;
				}
				
				if(cur.num-1>0 &&!visited[cur.num-1]) {
					int next = cur.num-1;
					List<Integer> temp = new ArrayList<>();
					for(int i=0;i<cur.list.size();i++) {
						temp.add(cur.list.get(i));
					}
					temp.add(next);
					queue.offer(new Num(next, temp));
					visited[next]=true;
				}
			}
			time++;
		}
		
	}
	
	static class Num{
		int num;
		List<Integer> list;
		
		public Num(int num, List<Integer> list) {
			this.num=num;
			this.list = list;
		}
	}

}
