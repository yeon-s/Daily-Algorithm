package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2589_보물섬 {

	static boolean[][] visited;
	static Queue<Point> queue;
	static int r;
	static int c;
	static char[][] map;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		for(int i=0;i<r;i++) {
			String str = br.readLine();
			for(int j=0;j<c;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		//입력 끝
		
		visited = new boolean[r][c];
		queue = new LinkedList<>();
		max=0;
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(map[i][j]=='L') {
					bfs(i,j);
				}
			}
		}
		
		System.out.println(max);
	}
	
	static void bfs(int si,int sj) {
		queue.clear();
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				visited[i][j]=false;
			}
		}
		
		queue.offer(new Point(si, sj));
		visited[si][sj]=true;
		
		int time=-1;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				Point cur = queue.poll();
				
				for(int d=0;d<4;d++) {
					int nexti= cur.i+di[d];
					int nextj = cur.j+dj[d];
					
					if(nexti<0 || nextj<0 || nexti>=r || nextj>=c || visited[nexti][nextj] || map[nexti][nextj]=='W') {
						continue;
					}
					queue.offer(new Point(nexti, nextj));
					visited[nexti][nextj]=true;	
				}
			}
			time++;
		}
		
		max = Math.max(max, time);
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
