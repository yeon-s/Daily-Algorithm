package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2206_벽부수고이동하기 {

	static int N;
	static int M;
	static boolean[][] map;
	static boolean[][][] visited;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				if(str.charAt(j)=='0') {
					map[i][j]= true;
					continue;
				}
				map[i][j]=false;
			}
		}
		//입력 끝
		System.out.println(bfs());
	}
	
	static int bfs() {
		Queue<Point> queue = new LinkedList<>();
		visited = new boolean[N][M][2];
		
		queue.offer(new Point(0,0,0));
		visited[0][0][0] = true;
		
		int distance=1;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				Point current = queue.poll();
				int skill = current.skill;
				
				if(current.i==N-1 && current.j==M-1) {
					return distance;
				}
				
				for(int d=0;d<4;d++) {
					int nexti = current.i+di[d];
					int nextj = current.j+dj[d];
					
					if(nexti<0 || nextj<0 || nexti>=N || nextj>=M) {
						continue;
					}
					
					if(!map[nexti][nextj]) {		//벽일때
						if(skill==1) {
							continue;
						}else {
							if(!visited[nexti][nextj][skill+1]) {
								queue.offer(new Point(nexti, nextj, skill+1));
								visited[nexti][nextj][skill+1]=true;								
							}
						}
					}else {							//아닐때
						if(!visited[nexti][nextj][skill]) {
							queue.offer(new Point(nexti, nextj, skill));
							visited[nexti][nextj][skill]=true;
						}
					}
					
				}
			}
			distance++;
		}
		
		return -1;
	}
	
	static class Point{
		int i;
		int j;
		int skill;
		public Point(int i, int j,int skill) {
			super();
			this.i = i;
			this.j = j;
			this.skill = skill;
		}
		
	}

}
