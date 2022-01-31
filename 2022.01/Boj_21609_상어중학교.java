package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_21609_상어중학교 {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int size;
	static int standardI;
	static int standardJ;
	static int rainbowNum;
	static int[] di= {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int answer;
	static PriorityQueue<Group> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		answer=0;
		findGroup();
		
		while(!pq.isEmpty()) {
			
			Group maxGroup = pq.poll();
			answer+=maxGroup.size*maxGroup.size;
			
			//제거하기
			visited = new boolean[N][N];
			remove(maxGroup.standardI,maxGroup.standardJ,map[maxGroup.standardI][maxGroup.standardJ]);
			
			//중력 작용
			gravity();
			
			//맵 90도 반시계회전
			int[][] copyMap = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					copyMap[i][j]= map[j][N-1-i];
				}
			}
			map=copyMap;
			
			//중력 작용
			gravity();

			pq.clear();
			findGroup();
		}
		System.out.println(answer);

	}
	
	static void gravity() {
		
		for(int j=0;j<N;j++) {
			for(int i=N-1;i>=0;i--) {
				int color = map[i][j];
				
				if(color>=0) {
					int nowi=i;
					int temp = map[i][j];
					map[i][j]=-5;		//빈칸으로 만들기
					while(true) {
						int nexti=nowi+1;
						if(nexti>=N) {
							break;
						}
						if(map[nexti][j]==-5) {
							nowi=nexti;
						}else {
							break;
						}
					}
					map[nowi][j]=temp;
				}
			}
		}
	}
	
	static void remove(int nowi,int nowj,int color) {
		visited[nowi][nowj]=true;
		map[nowi][nowj]=-5;

		for(int d=0;d<4;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];

			if(nexti<0 || nextj<0 || nexti>=N || nextj>=N || visited[nexti][nextj] || map[nexti][nextj]==-1) {
				continue;
			}
			if(map[nexti][nextj]==color || map[nexti][nextj]==0) {
				remove(nexti,nextj,color);				
			}
		}
	}
	
	static void findGroup() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]>0) {
					visited= new boolean[N][N];
					size=0;
					standardI=N;
					standardJ=N;
					rainbowNum=0;
					dfs(i,j,map[i][j]);
					
					if(size>=2) {
						pq.offer(new Group(standardI, standardJ, size, rainbowNum));
					}
				}
			}
		}
	}
	
	static void dfs(int nowi,int nowj,int color) {
		visited[nowi][nowj]=true;
		size++;
		if(map[nowi][nowj]==color) {
			if(standardI>nowi) {
				standardI=nowi;
				standardJ=nowj;
			}else if(standardI==nowi) {
				standardJ=nowj;
			}
		}else {
			rainbowNum++;
		}
		for(int d=0;d<4;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<0 || nextj<0 || nexti>=N || nextj>=N || visited[nexti][nextj] || map[nexti][nextj]==-1) {
				continue;
			}
			if(map[nexti][nextj]==color || map[nexti][nextj]==0) {
				dfs(nexti,nextj,color);				
			}
		}
		
	}
	
	static class Group implements Comparable<Group>{
		int standardI;
		int standardJ;
		int size;
		int rainbowNum;
		public Group(int standardI, int standardJ, int size, int rainbowNum) {
			super();
			this.standardI = standardI;
			this.standardJ = standardJ;
			this.size = size;
			this.rainbowNum = rainbowNum;
		}
		@Override
		public int compareTo(Group o) {
			if(this.size==o.size) {
				if(this.rainbowNum==o.rainbowNum) {
					if(this.standardI==o.standardI) {
						return o.standardJ-this.standardJ;
					}
					return o.standardI-this.standardI;
				}
				return o.rainbowNum-this.rainbowNum;
			}
			return o.size-this.size;
		}
		
	}

}
