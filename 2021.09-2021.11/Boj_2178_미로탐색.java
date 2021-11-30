package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2178_미로탐색 {

	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(str.substring(j, j+1));
			}
		}
		//입력 끝
		boolean[][] visited = new boolean[N][M];
		Queue<Point> queue = new LinkedList<>();
		
		queue.offer(new Point(0, 0));
		visited[0][0] = true;
		int num=0;
		boolean flag = false;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				Point current = queue.poll();
				int nowi = current.i;
				int nowj = current.j;
				if(nowi==N-1 && nowj==M-1) {
					flag=true;
					break;
				}
				
				for(int d=0;d<4;d++) {
					int nexti = nowi+di[d];
					int nextj = nowj+dj[d];
					
					if(nexti<0 || nextj <0 || nexti>=N || nextj>=M || visited[nexti][nextj] || map[nexti][nextj]==0) {
						continue;
					}
					
					queue.offer(new Point(nexti, nextj));
					visited[nexti][nextj]=true;
				}
			}
			num++;
			if(flag) {
				break;
			}
		}
		System.out.println(num);
		
		
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
