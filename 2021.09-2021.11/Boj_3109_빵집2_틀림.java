package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_3109_빵집2_틀림 {

	static int R;
	static int C;
	static char[][] map;
	static boolean[][] visited;
	static int[] di = {-1,0,1};
	static boolean flag; 		//끝까지 도착했는지 여부
	static int count;
	static Queue<Point> gil;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j]= str.charAt(j);
			}
		}
		//입력 끝
		
		visited = new boolean[R][C];
		count=0;
		gil = new LinkedList<>();
		
		for(int i=0;i<R;i++) {			//첫째행부터 시작열에서 끝열까지 가기(위쪽 우선순위)
			flag=false;
			gil.clear();
			
			bfs(i,0);
			if(!flag) {
				for(int j=0;j<gil.size();j++) {
					Point hunjeok = gil.poll();
					visited[hunjeok.i][hunjeok.j] = false;
				}
			}
		}

		
		System.out.println(count);
	}
	

	
	
	
	static void bfs(int si,int sj) {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		
		visited[si][sj]= true;
		queue.offer(new Point(si, sj));
		
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			gil.offer(new Point(current.i, current.j));
			int nowi = current.i;
			int nowj = current.j;
			
			if(nowj==C-1) {
				count++;
				flag=true;
				return;
			}
			
			for(int d=0;d<3;d++) {
				int nexti = nowi+di[d];
				int nextj = nowj+1; 
				
				if(nexti<0 || nexti>=R || nextj>=C || visited[nexti][nextj] || map[nexti][nextj]=='x') {
					continue;
				}
				
				queue.offer(new Point(nexti, nextj));
				visited[nexti][nextj] = true;
				break;
			}
		}
	}

	static class Point implements Comparable<Point>{
		int i;
		int j;
		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		@Override
		public int compareTo(Point o) {
			return this.i-o.i;
			 
		}
		
	}
}
