package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_15686_치킨배달_bfs안될거같았는데써봄 {

	static int N;
	static int M;
	static int[][] map;
	static int num;
	static List<Point> list;
	static Point[] result;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int distance;
	static int totald;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		list = new ArrayList<>();
		num = 0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					list.add(new Point(i, j));
					num++;
				}
			}
		}
		
		result = new Point[M];
		//입력 끝
		
		answer = Integer.MAX_VALUE;
		comb(0,0);
		System.out.println(answer);
		
		
	}
	
	static void comb(int start,int cnt) {
		if(cnt==M) {
			totald=0;
			calculate();
			answer = Math.min(answer, totald);
			return;
		}
		
		for(int i=start;i<num;i++) {
			result[cnt] = list.get(i);
			comb(i+1,cnt+1);
		}
	}
	
	static void calculate() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1) {
					distance=0;
					bfs(i,j);
					totald +=distance;
				}
			}
		}
	}
	
	static void bfs(int starti,int startj) {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		
		queue.offer(new Point(starti, startj));
		visited[starti][startj]=true;
		
		while(!queue.isEmpty()) {
			int size =queue.size();
			
			while(size-->0) {
				Point current = queue.poll();
				int nowi = current.i;
				int nowj = current.j;
				
				for(int i=0;i<M;i++) {
					if(nowi==result[i].i && nowj ==result[i].j) {
						return;
					}
				}
				
				for(int d=0;d<4;d++) {
					int nexti = nowi+di[d];
					int nextj = nowj+dj[d];
					
					if(nexti<0 || nextj<0 || nexti>=N || nextj>=N || visited[nexti][nextj]) {
						continue;
					}
					queue.offer(new Point(nexti, nextj));
					visited[nexti][nextj] = true;
				}
				
			}
			distance++;
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
