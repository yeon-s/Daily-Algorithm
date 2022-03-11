package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2146_다리만들기 {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static List<Point> list;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int[][] Num;
	static int[][] D;
	static int answer;
	static Queue<Point> queue;
	static PriorityQueue<Point> pq;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		
		visited = new boolean[N][N];
		int landNum=1;
		list = new ArrayList<>();
		Num = new int[N][N];
		queue = new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j] && map[i][j]==1) {
					list.add(new Point(i,j,landNum,0));
					bfs(i,j,landNum);
					landNum++;
				}
			}
		}
		
		answer = Integer.MAX_VALUE;
		pq = new PriorityQueue<>();
		for(int i=0;i<list.size();i++) {
			for(int k=0;k<N;k++) {
				for(int j=0;j<N;j++) {
					visited[k][j]=false;
				}
			}
			bfs2(list.get(i).i,list.get(i).j,list.get(i).num);
		}

		System.out.println(answer);
	}
	
	static void bfs2(int si,int sj,int index) {
		pq.clear();
		pq.offer(new Point(si, sj, index, 0));
		visited[si][sj]=true;
		
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
			
			for(int d=0;d<4;d++) {
				int nexti = cur.i+di[d];
				int nextj = cur.j+dj[d];
				
				if(nexti<0 || nextj<0 || nexti>=N || nextj>=N || visited[nexti][nextj]) {
					continue;
				}
				
				visited[nexti][nextj]=true;
				if(Num[nexti][nextj]==index) {
					pq.offer(new Point(nexti, nextj, Num[nexti][nextj], cur.cnt));
				}else if(Num[nexti][nextj]==0){
					pq.offer(new Point(nexti, nextj, Num[nexti][nextj], cur.cnt+1));
				}else {
					answer = Math.min(answer, cur.cnt);
					return;
				}
			}
		}
		
	}
	
	static void bfs(int si,int sj,int num) {
		queue.clear();
		visited[si][sj]=true;
		queue.offer(new Point(si, sj));
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			Num[cur.i][cur.j]=num;
			for(int d=0;d<4;d++) {
				int nexti = cur.i+di[d];
				int nextj = cur.j+dj[d];
				
				if(nexti<0 || nextj<0 || nexti>=N || nextj>=N || visited[nexti][nextj] || map[nexti][nextj]==0) {
					continue;
				}
				
				queue.offer(new Point(nexti, nextj));
				visited[nexti][nextj]=true;
			}
		}
	}
	
	static class Point implements Comparable<Point>{
		int i;
		int j;
		int num;
		int cnt;
		
		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

		public Point(int i, int j, int num, int cnt) {
			super();
			this.i = i;
			this.j = j;
			this.num = num;
			this.cnt = cnt;
		}
		
		public int compareTo(Point o) {
			return this.cnt-o.cnt;
		}
	}

}
