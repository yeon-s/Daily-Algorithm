package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Swea_1249_보급로 {

	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N][N];
			int[][] D = new int[N][N];
			boolean[][] visited = new boolean[N][N];
			
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(str.substring(j, j+1));
					D[i][j] = Integer.MAX_VALUE;
				}
			}
			//입력 끝
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(0, 0, 0));
			D[0][0]=0;
			
			while(!pq.isEmpty()) {
				Node current = pq.poll();
				int nowi = current.i;
				int nowj = current.j;
				int w = current.w;		//아직 방문 안한 애들 중 최소 뽑은거
				
				if(nowi==N-1 && nowj==N-1) {
					break;
				}
				
				if(visited[nowi][nowj]) {
					continue;
				}
				
				visited[nowi][nowj]=true;
				
				for(int d=0;d<4;d++) {
					int nexti = nowi+di[d];
					int nextj = nowj+dj[d];
					
					if(nexti<0 || nextj<0 || nexti>=N || nextj>=N || visited[nexti][nextj]) {
						continue;
					}
					if(D[nexti][nextj]> w+map[nexti][nextj]) {
						D[nexti][nextj] = w+map[nexti][nextj];
						pq.offer(new Node(nexti, nextj, w+map[nexti][nextj]));
					}
				}
			}
			System.out.println("#"+tc+" "+D[N-1][N-1]);
		}
		
	}
	
	static class Node implements Comparable<Node>{
		int i;
		int j;
		int w;
		public Node(int i, int j, int w) {
			super();
			this.i = i;
			this.j = j;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.w-o.w;
		}
		
	}

}
