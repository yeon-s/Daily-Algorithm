package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_7562_나이트의이동 {

	static int I;
	static int[][] map;
	static int[] di = {-2,-1,1,2,2,1,-1,-2};
	static int[] dj = {1,2,2,1,-1,-2,-2,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for(int tc=1;tc<=TC;tc++) {
			I = sc.nextInt();
			
			map = new int[I][I];
		
			Point start = new Point(sc.nextInt(), sc.nextInt());
			Point end = new Point(sc.nextInt(), sc.nextInt());
			
			int result = bfs(start,end);
			System.out.println(result);
			
		}

	}

	static int bfs(Point start,Point end) {
		Queue<Point> queue= new LinkedList<>();
		boolean[][] visited = new boolean[I][I];
		
		queue.offer(start);
		visited[start.i][start.j] = true;
		int depth = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(size-->0) {
				Point current = queue.poll();
				
				if(current.i == end.i && current.j==end.j) {
					return depth;
				}
				
				for(int d=0;d<8;d++) {
					int nexti = current.i+di[d];
					int nextj = current.j+dj[d];
					
					if(nexti<0 || nextj <0 || nexti>=I || nextj >=I) {
						continue;
					}
					if(!visited[nexti][nextj]) {
						queue.offer(new Point(nexti, nextj));
						visited[nexti][nextj] = true;
					}
					
				}
			}
			depth++;
		}
		return -1;
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
