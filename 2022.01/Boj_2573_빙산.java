package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2573_빙산 {

	static int N;
	static int M;
	static int[][] map;
	static int[][] store;
	static boolean[][] visited;
	static Queue<Point> queue;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		queue = new LinkedList<>();
		
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		
		int time=0;
		boolean flag=false;		//다녹을때까지 2덩어리 안되면
		
		while(true) {
			int num=0;
			visited = new boolean[N][M];
			store = new int[N][M];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(!visited[i][j] && map[i][j]>0) {
						bfs(i,j);
						num++;
					}
				}
			}
			
			if(num>1) {
				break;
			}else if(num==0){
				flag=true;
				break;
			}
			
			melt();
			time++;
		
		}
		
		if(flag) {
			System.out.println(0);
		}else {
			System.out.println(time);
		}
		
	}
	
	static void melt() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]>0) {
					map[i][j]-=store[i][j];
					if(map[i][j]<0) {
						map[i][j]=0;
					}
				}
			}
		}
	}
	
	static void bfs(int si,int sj) {
		queue.clear();
		queue.offer(new Point(si, sj));
		visited[si][sj]=true;
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			for(int d=0;d<4;d++) {
				int nexti = cur.i+di[d];
				int nextj = cur.j+dj[d];
				
				if(nexti<0 || nextj<0 || nexti>=N || nextj>=M || visited[nexti][nextj]) {
					continue;
				}
				
				if(map[nexti][nextj]>0) {
					queue.offer(new Point(nexti, nextj));
					visited[nexti][nextj]=true;
				}else {
					store[cur.i][cur.j]++;
				}
			}
		}
		
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
