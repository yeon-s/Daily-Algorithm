package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16236_아기상어_시간초과 {
	
	static int N;
	static int[][] map;
	static int size;		//상어 크기
	static int nowi;		//상어 현재위치
	static int nowj;
	static int eatNum;		//먹은 개수
	static int time;		//혼자보낸시간
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					nowi=i;
					nowj=j;
				}
			}
		}
		//입력 끝
		
		size=2;
		eatNum=0;
		time=0;
		map[nowi][nowj]=0;
		while(true) {
			boolean flag = false;	//먹이 있는지 확인
			List<Point> list = new ArrayList<>();	//먹이리스트
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]<size && map[i][j]>0) {		//먹이 있는지 확인
						flag = true;
						list.add(new Point(i, j));
					}
				}
			}
			
			
			if(flag) {
				int[] distance = new int[list.size()];
				int min = Integer.MAX_VALUE;
				for(int i=0;i<list.size();i++) {
					distance[i]=bfs(nowi,nowj,list.get(i).i,list.get(i).j);
					min = Math.min(min, distance[i]);
				}
				
				Point minDistance = null;
				List<Point> findMin = new ArrayList<>();
				for(int i=0;i<list.size();i++) {
					if(distance[i]==min) {
						Point hubo = list.get(i);
						findMin.add(new Point(hubo.i, hubo.j));
					}
				}
				//최단거리가 여러마리 있으면 가장위에, 그다음으로 가장 왼쪽 선택하기
				
					Collections.sort(findMin);
					minDistance = findMin.get(0);
			
				
				nowi= minDistance.i;
				nowj = minDistance.j;
				
				map[nowi][nowj]=0;
				eatNum++;
				time +=min;
				
				if(eatNum==size) {
					size++;
					eatNum=0;
				}
				
			}else {
				break;
			}
		}
		
		System.out.println(time);
		
	}
	
	static int bfs(int starti,int startj,int endi,int endj) {
		boolean[][] visited = new boolean[N][N];
		Queue<Point> queue = new LinkedList<>();
		
		queue.offer(new Point(starti, startj));
		visited[starti][startj] = true;
		
		int distance=0;
		
		while(true) {
			int num = queue.size();
			while(num-->0) {
				Point current = queue.poll();
				int nowi = current.i;
				int nowj = current.j;
				
				if(nowi == endi && nowj==endj) {
					return distance;
				}
				
				for(int d=0;d<4;d++) {
					int nexti = nowi+di[d];
					int nextj = nowj+dj[d];
					
					if(nexti<0 || nextj<0 || nexti>=N || nextj>=N || map[nexti][nextj] >size || visited[nexti][nextj]) {
						continue;
					}
					
					queue.offer(new Point(nexti, nextj));
					visited[nexti][nextj] = true;
				}
			}
			distance++;
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
			if(this.i>o.i) {
				return 1;
			}else if(this.i==o.i){
				if(this.j>o.j) {
					return 1;
				}
			}
			return -1;
		}
		
	}

}
