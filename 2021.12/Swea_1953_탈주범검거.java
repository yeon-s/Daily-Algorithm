package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea_1953_탈주범검거 {

	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int answer;
	static int N;
	static int M;
	static int L;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//입력 끝
			answer = 0;
			bfs(R,C);
			
			System.out.println("#"+tc+" "+answer);		
		}
	}
	
	static void bfs(int si,int sj) {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		queue.offer(new Point(si, sj));
		visited[si][sj] = true;
		
		int time = 1;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				Point current = queue.poll();
				int nowi = current.i;
				int nowj = current.j;
				int now = map[nowi][nowj];
				
				answer++;
				
				for(int d=0;d<4;d++) {
					int nexti = nowi+di[d];
					int nextj = nowj+dj[d];
					
					if(nexti<0 || nextj<0 || nexti>=N || nextj>=M || visited[nexti][nextj] || map[nexti][nextj]==0) {
						continue;
					}
					
					int next = map[nexti][nextj];
				
					if(possible(d,now,next)) {
						queue.offer(new Point(nexti, nextj));
						visited[nexti][nextj] = true;
					}
				}
			}
			if(time==L) {
				break;
			}
			time++;
		}
	}
	
	static boolean possible(int d,int now,int next) {
		boolean flag=false;

		switch(d) {
		case 0:
			if(now==1 || now==2 || now==4 || now==7) {
				if(next==1 || next==2 || next==5 || next==6) {
					return true;
				}
			}
			break;
		case 1:
			if(now==1 || now==2 || now==5 || now==6) {
				if(next==1 || next==2 || next==4 || next==7) {
					return true;
				}
			}
			break;
		case 2:
			if(now==1 || now==3 || now==6 || now==7) {
				if(next==1 || next==3 || next==4 || next==5) {
					return true;
				}
			}
			break;
		case 3:
			if(now==1 || now==3 || now==4 || now==5) {
				if(next==1 || next==3 || next==6 || next==7) {
					return true;
				}
			}
			break;
		}
		
		return flag;
	}
	
	static class Point{
		int i;
		int j;
		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
	}

}
