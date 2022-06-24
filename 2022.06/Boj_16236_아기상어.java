package repeat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16236_아기상어 {

	static Shark babyShark;
	static int[][] map;
	static int N;
	static List<Fish> list;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		list = new ArrayList<>();
		
		for(int i=0;i<N;i++) {			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					map[i][j]=0;
					babyShark = new Shark(i,j,2,0);
				}
			}
		}
		
		int time=0;
		
		while(true) {
			//1. 찾기
			if(!find()) {
				break;
			}
			
			Collections.sort(list, new Comparator<Fish>() {
				public int compare(Fish o1, Fish o2) {
					if(o1.dist==o2.dist) {
						if(o1.i==o2.i) {
							return o1.j-o2.j;
						}
						return o1.i-o2.i;
					}
					return o1.dist-o2.dist;
				}
			});
			
			Fish food = list.get(0);
			babyShark.i=food.i;
			babyShark.j=food.j;
			babyShark.cnt++;
			if(babyShark.cnt>=babyShark.size) {
				babyShark.size++;
				babyShark.cnt=0;
			}
			map[food.i][food.j]=0;
			time+=food.dist;
			
		}
		System.out.println(time);
	}
	
	static boolean find() {
		list.clear();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]>0 && map[i][j]<babyShark.size) {
					int dist = bfs(i,j);
					if(dist==-1) {
						continue;
					}
					list.add(new Fish(i, j, dist));
				}
			}
		}
		
		if(list.size()==0) {
			return false;
		}
		return true;
	}
	
	static int bfs(int nowi, int nowj) {
		
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		queue.offer(new Point(babyShark.i, babyShark.j));
		visited[babyShark.i][babyShark.j]=true;
		
		int dist = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				Point cur = queue.poll();
				
				if(cur.i==nowi && cur.j==nowj) {
					return dist;
				}
				
				for(int d=0;d<4;d++) {
					int nexti = cur.i+di[d];
					int nextj = cur.j+dj[d];
					
					if(nexti<0 || nextj<0 || nexti>=N || nextj>=N || map[nexti][nextj]>babyShark.size || visited[nexti][nextj]) {
						continue;
					}
					
					queue.offer(new Point(nexti, nextj));
					visited[nexti][nextj] = true;
				}
			}
			dist++;
		}
		
		//여기 왔다는 것은 먹이가 있지만 먹으러 못간다.
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
	
	static class Shark{
		int i;
		int j;
		int size;
		int cnt;
		public Shark(int i, int j, int size, int cnt) {
			super();
			this.i = i;
			this.j = j;
			this.size = size;
			this.cnt = cnt;
		}
	}
	
	static class Fish{
		int i;
		int j;
		int dist;
		public Fish(int i, int j, int dist) {
			super();
			this.i = i;
			this.j = j;
			this.dist = dist;
		}
		
	}
	
	

}
