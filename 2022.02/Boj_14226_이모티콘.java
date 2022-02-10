package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_14226_이모티콘 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int S = Integer.parseInt(br.readLine());
		
		Queue<status> queue = new LinkedList<>();
		boolean[][] visited = new boolean[2000][2000];
		//방문했던 이모티콘 개수더라도 클립에 저장된게 다름 (다른경우)
		
		queue.offer(new status(0, 1));
		visited[0][1]=true;
		
		int time=0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				status current = queue.poll();
				int clip = current.clip;
				int num=current.num;
				
				if(num==S) {
					System.out.println(time);
					return;
				}
				
				if(num<2000 && !visited[num][num]) {
					queue.offer(new status(num, num));
					visited[num][num]=true;
				}
				if(clip<2000 & num+clip<2000 && clip!=0 && !visited[clip][num+clip]) {
					queue.offer(new status(clip, num+clip));
					visited[clip][num+clip]=true;
				}
				if(num-1>0 && clip<2000 && !visited[clip][num-1]) {
					queue.offer(new status(clip, num-1));
					visited[clip][num-1]=true;
				}
				
			}
			time++;
		}

	}
	
	static class status{
		int clip;
		int num;
		public status(int clip, int num) {
			super();
			this.clip = clip;
			this.num = num;
		}
		
	}

}
