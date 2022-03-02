package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1726_로봇 {

	static int[] di = {-1,0,1,0};	//북,동,남,서
	static int[] dj = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Point> queue = new LinkedList<>();
		boolean[][][] visited = new boolean[N][M][4];
		
		st = new StringTokenizer(br.readLine());
		int startI = Integer.parseInt(st.nextToken())-1;
		int startJ = Integer.parseInt(st.nextToken())-1;
		int startD = Integer.parseInt(st.nextToken());
		if(startD==4) {
			startD=0;
		}else if(startD==3) {
			startD=2;
		}else if(startD==2) {
			startD=3;
		}
		st = new StringTokenizer(br.readLine());
		int endI = Integer.parseInt(st.nextToken())-1;
		int endJ = Integer.parseInt(st.nextToken())-1;
		int endD = Integer.parseInt(st.nextToken());
		if(endD==4) {
			endD=0;
		}else if(endD==3) {
			endD=2;
		}else if(endD==2) {
			endD=3;
		}
		queue.offer(new Point(startI, startJ, startD));
		visited[startI][startJ][startD] = true;
		
		int cnt=0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				Point cur = queue.poll();
				
				if(cur.i==endI && cur.j==endJ && cur.d==endD) {
					System.out.println(cnt);
					return;
				}
				
				int nextD = cur.d-1;
				if(nextD<0) {
					nextD=3;
				}
				if(!visited[cur.i][cur.j][nextD]) {
					queue.offer(new Point(cur.i, cur.j, nextD));
					visited[cur.i][cur.j][nextD]=true;
				}
				nextD = cur.d+1;
				if(nextD>3) {
					nextD=0;
				}
				if(!visited[cur.i][cur.j][nextD]) {
					queue.offer(new Point(cur.i, cur.j, nextD));
					visited[cur.i][cur.j][nextD]=true;
				}
				
				for(int i=1;i<=3;i++) {
					int nexti = cur.i+(di[cur.d]*i);
					int nextj = cur.j+(dj[cur.d]*i);
					
					if(nexti<0 || nextj<0 || nexti>=N || nextj>=M || map[nexti][nextj]==1) {
						break;
					}
					
					if(!visited[nexti][nextj][cur.d] && map[nexti][nextj]==0) {
						queue.offer(new Point(nexti, nextj, cur.d));
						visited[nexti][nextj][cur.d]=true;
					}
				}
				
			}
			cnt++;
		}
		
	}
	
	static class Point{
		int i;
		int j;
		int d;
		public Point(int i, int j, int d) {
			super();
			this.i = i;
			this.j = j;
			this.d = d;
		}
		
	}

}
