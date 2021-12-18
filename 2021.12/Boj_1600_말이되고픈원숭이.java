package practice;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Boj_1600_말이되고픈원숭이 {

	static int[] di= {-1,1,0,0};
	static int[] dj= {0,0,-1,1};
	static int[] ji = {-1,-2,-2,-1,1,2,2,1};
	static int[] jj = {-2,-1,1,2,2,1,-1,-2};
	static int W;
	static int H;
	static int[][] map;
	static int[][][] D;
	static int K;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		
		for(int i=0;i<H;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<W;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		D = new int[H][W][K+1];
		int answer = bfs();
		System.out.println(answer);

	}
	
	static int bfs() {
		Queue<Point> queue = new LinkedList<>();
		
		queue.offer(new Point(0, 0, 0, 0));
		
		int depth=0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(size-->0) {
				Point current = queue.poll();
				int nowi = current.i;
				int nowj = current.j;
				int k = current.k;
				
				if(nowi==H-1 && nowj==W-1) {
					return depth;
				}
				
				for(int d=0;d<4;d++) {
					int nexti = nowi+di[d];
					int nextj = nowj+dj[d];
					
					if(nexti<0 || nextj<0 || nexti>=H || nextj>=W || map[nexti][nextj]==1) {
						continue;
					}
					if(D[nexti][nextj][k]==0) {
						queue.offer(new Point(nexti, nextj, depth+1, k));
						D[nexti][nextj][k]=depth+1;
					}
					
				}
				
				if(K>k) {
					for(int j=0;j<8;j++) {
						int nexti = nowi+ji[j];
						int nextj = nowj+jj[j];
						
						if(nexti<0 || nextj<0 || nexti>=H || nextj>=W || map[nexti][nextj]==1) {
							continue;
						}
						if(D[nexti][nextj][k+1]==0) {
							queue.offer(new Point(nexti, nextj, depth+1, k+1));
							D[nexti][nextj][k+1]=depth+1;
						}
						
					}			
				}
			}
			depth++;
		}
		return -1;
	}

	static class Point{
		int i;
		int j;
		int behavior;
		int k;
		public Point(int i, int j, int behavior, int k) {
			super();
			this.i = i;
			this.j = j;
			this.behavior = behavior;
			this.k = k;
		}
		
	}
}
