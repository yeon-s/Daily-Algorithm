package practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class practice {

	static int[] di= {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int[][] map;
	public static void main(String[] args) {
		
		map = new int[3][4];
		map[1][1]= 1;
		
		bfs();
		System.out.println(Arrays.deepToString(map));

	}
	
	static void bfs() {
		boolean[][] visited = new boolean[3][4];
		Queue<Point> queue = new LinkedList<>();
		
		visited[1][1] = true;
		queue.offer(new Point(1, 1));
		int day = 1;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				Point current = queue.poll();
				int nowi = current.i;
				int nowj = current.j;
				map[nowi][nowj] = day;
				
				for(int d=0;d<4;d++) {
					int nexti = nowi+di[d];
					int nextj = nowj+dj[d];
					
					if(nexti<0 || nextj<0 || nexti>=3 || nextj>=4) {
						continue;
					}
					
					if(!visited[nexti][nextj]) {
						queue.offer(new Point(nexti, nextj));
						visited[nexti][nextj] = true;
					}
				}
			}
			day++;
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
