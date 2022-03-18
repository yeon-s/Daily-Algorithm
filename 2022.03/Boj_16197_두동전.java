package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16197_두동전 {

	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N+1][M+1];
		Point start = new Point(0, 0, 0, 0);
		int index=0;
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j]=='o') {
					if(index==0) {
						start.oi=i;
						start.oj=j;
					}else {
						start.ti=i;
						start.tj=j;
					}
					index++;
				}
			}
		}
		//입력 끝
		
		Queue<Point> queue = new LinkedList<>();
		boolean[][][][] visited = new boolean[N+1][M+1][N+1][M+1];
		queue.offer(new Point(start.oi, start.oj, start.ti, start.tj));
		visited[start.oi][start.oj][start.ti][start.tj] =true;
		
		int cnt=0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				Point cur = queue.poll();
				
				if((cur.oi==N && cur.oj==M) || (cur.ti==N && cur.tj==M)) {
					System.out.println(cnt);
					return;
				}
				
				for(int d=0;d<4;d++) {
					int nextOi = cur.oi+di[d];
					int nextOj = cur.oj+dj[d];
					int nextTi = cur.ti+di[d];
					int nextTj = cur.tj+dj[d];
					
					if(nextOi<0 || nextOj<0 || nextOi>=N || nextOj>=M) {
						nextOi=N;
						nextOj=M;
					}
					if(nextTi<0 || nextTj<0 || nextTi>=N || nextTj>=M) {
						nextTi=N;
						nextTj=M;
					}
					
					if(nextOi==N && nextOj==M && nextTi==N && nextTj==M) {
						continue;
					}

					if(map[nextOi][nextOj]=='#') {
						nextOi=cur.oi;
						nextOj=cur.oj;
					}
					if(map[nextTi][nextTj]=='#') {
						nextTi=cur.ti;
						nextTj =cur.tj;
					}
					
					if(!visited[nextOi][nextOj][nextTi][nextTj]) {
						queue.offer(new Point(nextOi, nextOj, nextTi, nextTj));
						visited[nextOi][nextOj][nextTi][nextTj]=true;
					}
					
				}
			}
			cnt++;
			if(cnt>10) {
				break;
			}
		}
		
		System.out.println(-1);
	}
	
	static class Point{
		int oi;
		int oj;
		int ti;
		int tj;
		public Point(int oi, int oj, int ti, int tj) {
			super();
			this.oi = oi;
			this.oj = oj;
			this.ti = ti;
			this.tj = tj;
		}
	}

}
