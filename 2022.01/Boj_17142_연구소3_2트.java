package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_17142_연구소3_2트 {

	static int N;
	static int M;
	static int[][] map;
	static int[][] copy;
	static Queue<Point> queue;
	static boolean[][] visited;
	static int[] di= {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int min;
	static boolean flag;
	static List<Point> list;
	static Point[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		copy = new int[N][N];
		queue = new LinkedList<>();
		visited = new boolean[N][N];
		min = Integer.MAX_VALUE;
		flag= false;
		list =new ArrayList<>();
		result = new Point[M];
		
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					map[i][j]=-2;	//벽
				}else if(map[i][j]==2) {
					map[i][j]=-3;	//비활성바이러스
					list.add(new Point(i, j));
				}else if(map[i][j]==0) {
					map[i][j] = -1;		//빈칸
				}
			}
		}
		//입력 끝
		
		comb(0,0);
		if(flag) {
			System.out.println(min);
		}else {
			System.out.println(-1);
		}
		
	}
	
	static void comb(int cnt,int start) {
		if(cnt==M) {
			doCopy();
			simul();
			return;
		}
		
		//이건 순열이다.
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<N;j++) {
//				if(map[i][j]==-3) {
//					map[i][j]=0;		//활성
//					comb(cnt+1);
//					map[i][j]=-3;
//				}
//			}
//		}
		
		for(int i=start;i<list.size();i++) {
			result[cnt] = list.get(i);
			comb(cnt+1,i+1);
		}
		
	}
	
	static void simul() {
		queue.clear();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				visited[i][j]=false;
			}
		}
		for(int i=0;i<M;i++) {
			Point p = result[i];
			queue.offer(new Point(p.i, p.j));
			visited[p.i][p.j]=true;
		}
		
		int time=0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				Point cur = queue.poll();
				
				for(int d=0;d<4;d++) {
					int nexti=cur.i+di[d];
					int nextj = cur.j+dj[d];
					
					if(nexti<0 || nextj<0 || nexti>=N || nextj>=N || visited[nexti][nextj] || copy[nexti][nextj]==-2) {
						continue;
					}
					if(copy[nexti][nextj]==-1) {	//빈칸이면
						copy[nexti][nextj] = time+1;
					}
					//비활성이면 큐에는 넣고 시간은 냅둬
					
					queue.offer(new Point(nexti, nextj));
					visited[nexti][nextj]=true;
					
				}
				
			}
			time++;
		}
		
		boolean check=true;
		
		int num=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(copy[i][j]>num) {
					num=copy[i][j];
				}
				if(copy[i][j]==-1) {		//빈칸이 하나라도 있으면
					check=false;
				}
			}
		}
		
		if(check) {
			flag=true;
		}else {
			return;
		}
		
		min = Math.min(min, num);
	}
	
	static void doCopy() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				copy[i][j] = map[i][j];
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
