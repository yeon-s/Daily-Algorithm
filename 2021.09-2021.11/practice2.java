package practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class practice2 {

	static int[][] map;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int num;
	public static void main(String[] args) {
		map = new int[4][5];
		
		map[0][1]=1;
		map[0][2]=1;
		map[0][3]=1;
		map[1][3]=1;
		map[2][1]=1;
		map[2][2]=1;
		map[2][3]=1;
		
		
		bfs();
		System.out.println(num);
		

	}
	
	static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[4][5];
		
		queue.offer(new Point(0, 0));
		visited[0][0] = true;
		
		num=0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				Point current = queue.poll();
				int nowi = current.i;
				int nowj = current.j;
				if(nowi == 0 && nowj ==4) {
					return;
				}
				
				for(int d=0;d<4;d++) {
					int nexti = nowi+di[d];
					int nextj = nowj+dj[d];
					
					if(nexti<0 || nextj<0 || nexti>=4 || nextj >=5 || map[nexti][nextj] ==1 || visited[nexti][nextj]) {
						continue;
					}
					
					queue.offer(new Point(nexti, nextj));
					visited[nexti][nextj] = true;
						
					}
				}
				num++;
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
