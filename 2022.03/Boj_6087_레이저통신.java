package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_6087_레이저통신 {

	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	static PriorityQueue<Point> pq;
	static boolean[][] visited;
	static int W;
	static int H;
	static char[][] map;
	static Point[] startAndEnd;
	static int[] answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		startAndEnd = new Point[2];

		int index=0;
		for(int i=0;i<H;i++) {
			String str = br.readLine();
			for(int j=0;j<W;j++) {
				map[i][j]=str.charAt(j);
				if(map[i][j]=='C') {
					startAndEnd[index++] = new Point(i, j,0,0);
				}
			}
		}
		//입력 끝
		
		int min =100000;
		answer = new int[4];
		for(int d=0;d<4;d++) {
			dijkstra(d);
			min = Math.min(min, answer[d]);
		}
		
		System.out.println(min);
		
	}
	
	static void dijkstra(int d) {
		pq = new PriorityQueue<>();
		visited = new boolean[H][W];
		int si = startAndEnd[0].i;
		int sj = startAndEnd[0].j;
		int ei = startAndEnd[1].i;
		int ej = startAndEnd[1].j;
		pq.offer(new Point(si, sj, d, 0));
		int[][] D = new int[H][W];
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				D[i][j] = 100000;
			}
		}
		
		D[si][sj]=0;
		
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
			
			if(cur.i==ei && cur.j==ej) {
				break;
			}
			
			if(visited[cur.i][cur.j]) {
				continue;
			}
			
			visited[cur.i][cur.j]=true;
			
			for(int k=-1;k<=1;k++) {
				
				if(cur.i==si && cur.j==sj) {		//시작점이면 거울 못 놓으니까 직진만 해
					if(k==-1 || k==1) {
						continue;
					}
				}
				
				int nextD = cur.d+k;
				if(nextD<0) nextD=3;
				if(nextD>3) nextD=0;
				int weight=0;;
				if(k!=0) {
					weight=1;
				}
				
				int nexti = cur.i+di[nextD];
				int nextj = cur.j+dj[nextD];
				
				if(nexti<0 || nextj<0 || nexti>=H || nextj>=W || map[nexti][nextj]=='*' || visited[nexti][nextj]) {
					continue;
				}
				
				if(D[nexti][nextj]>cur.cnt+weight) {
					D[nexti][nextj]=cur.cnt+weight;
					pq.offer(new Point(nexti,nextj,nextD,cur.cnt+weight));
				}
					
			}
		}
		
		answer[d] = D[ei][ej];
	}
	
	static class Point implements Comparable<Point>{
		int i;
		int j;
		int d;
		int cnt;
		public Point(int i, int j, int d, int cnt) {
			super();
			this.i = i;
			this.j = j;
			this.d = d;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Point o) {
			return this.cnt-o.cnt;
		}
	}

}
