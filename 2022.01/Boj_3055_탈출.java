package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_3055_탈출 {

	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int R;
	static int C;
	static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		//입력 끝
		
		boolean[][] water = new boolean[R][C];		//물 찰 예정이거나 차 있는 곳 
		boolean[][] visited = new boolean[R][C];	// 고슴도치 방문한 곳
		
		Queue<Point> waterQ = new LinkedList<>();	//물 찰 예정 큐
		Queue<Point> mouseQ = new LinkedList<>();	//고슴도치 이동 큐
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]=='*') {
					waterQ.offer(new Point(i, j));
					water[i][j] = true;	
				}
				if(map[i][j]=='S') {
					mouseQ.offer(new Point(i, j));
					visited[i][j] = true;
				}
			}
		}
		//초기 세팅
		
		int time=0;
		boolean flag = false;	//물이 다차기 전에 탈출했는지 여부
		
		while(true) {
			//물 찰 예정
			int size = waterQ.size();
			while(size-->0) {
				Point cur = waterQ.poll();
				
				for(int d=0;d<4;d++) {
					int nexti = cur.i+di[d];
					int nextj = cur.j+dj[d];
					
					if(nexti<0 || nextj<0 || nexti>=R || nextj>=C || water[nexti][nextj] || 
							map[nexti][nextj]=='X' || map[nexti][nextj]=='D') {
						continue;
					}
					
					waterQ.offer(new Point(nexti, nextj));
					water[nexti][nextj] = true;
					
				}
			}
			
			//고슴도치 이동
			int size2 = mouseQ.size();
			while(size2-->0) {
				Point cur = mouseQ.poll();
				
				if(map[cur.i][cur.j]=='D') {
					flag=true;
					break;
				}
				
				for(int d=0;d<4;d++) {
					int nexti = cur.i+di[d];
					int nextj = cur.j+dj[d];
					
					if(nexti<0 || nextj<0 || nexti>=R || nextj>=C || visited[nexti][nextj] ||
							water[nexti][nextj] || map[nexti][nextj]=='X') {
						continue;
					}
					
					mouseQ.offer(new Point(nexti, nextj));
					visited[nexti][nextj] = true;
				}
			}
			if(flag) {
				break;
			}
			if(waterQ.size()==0 && mouseQ.size()==0) {
				break;
			}
			
			//물 차기
			time++;			
		}
		
		if(flag) {
			System.out.println(time);
		}else {
			System.out.println("KAKTUS");
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
