package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16946_벽부수고이동하기4 {

	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visited;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static Queue<Point> queue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j]= str.charAt(j)-'0';
			}
		}
		//입력 끝
		
		int[][] memo = new int[n][m];	//구역이 몇칸인지
		int[][] sector = new int[n][m];	//몇번째 구역인지
		visited = new boolean[n][m];
		queue = new LinkedList<>();
		int num=1;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(!visited[i][j] && map[i][j]==0) {
					queue.clear();
					dfs(i,j);
					int size = queue.size();
					while(!queue.isEmpty()) {
						Point p = queue.poll();
						sector[p.i][p.j] = num;
						memo[p.i][p.j] = size;
					}
					num++;
				}
			}
		}
		
		int[][] answer = new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==1) {
					int cnt=0;
					Map<Integer, Integer> hashMap = new HashMap<>();
					for(int d=0;d<4;d++) {
						int nexti = i+di[d];
						int nextj = j+dj[d];
						
						if(nexti<0 || nextj<0 || nexti>=n || nextj>=m || map[nexti][nextj]==1) {
							continue;
						}
						
						int sec = sector[nexti][nextj];
						if(!hashMap.containsKey(sec)) {
							cnt+=memo[nexti][nextj];
							hashMap.put(sec, 1);
						}
					}
					answer[i][j]=(cnt+1)%10;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				sb.append(answer[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}
	static void dfs(int nowi,int nowj) {
		visited[nowi][nowj]=true;
		queue.offer(new Point(nowi, nowj));
		
		for(int d=0;d<4;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<0 || nextj<0 || nexti>=n || nextj>=m || visited[nexti][nextj] || map[nexti][nextj]==1) {
				continue;
			}
			
			dfs(nexti,nextj);
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
