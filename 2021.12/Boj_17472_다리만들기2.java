package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17472_다리만들기2 {

	static int N;
	static int M;
	static int[][] map;
	static int islandNum;
	static int[][] islandMap;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int[][] adjMatrix;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		
		//1. 맵돌면서 섬 나누기(dfs)
		islandMap = new int[N][M];
		divide();
		
		//2. 모든 섬마다 섬의 각 칸들에서부터 다른섬으로 뻗어보기(만나면 뻗은 길이 중 최소(1보다는 큰)를 가중치로 하기)
		adjMatrix = new int[islandNum+1][islandNum+1];
		getWeight();
		
		//3. prim으로 최소신장트리 구하기
		int size = islandNum;
		boolean[] visited = new boolean[size+1];
		int[] minEdge = new int[size+1];
		
		for(int i=1;i<=size;i++) {
			minEdge[i] = Integer.MAX_VALUE;
		}
		
		minEdge[1]=0;
		int result=0;
		boolean flag = true;
		for(int i=0;i<size;i++) {
			int min = Integer.MAX_VALUE;
			int current = -1;
			for(int j=1;j<=size;j++) {
				if(!visited[j] && min>minEdge[j]) {
					min = minEdge[j];
					current=j;
				}
			}
			
			if(current==-1) {
				flag=false;
				break;
			}
			
			result+=min;
			visited[current]=true;
			
			for(int j=1;j<=size;j++) {
				if(!visited[j] && adjMatrix[current][j] !=0 && minEdge[j]>adjMatrix[current][j]) {
					minEdge[j] = adjMatrix[current][j];
				}
			}
		}
		
		if(flag) {
			System.out.println(result);			
		}else {
			System.out.println(-1);
		}
		
	}
	
	static void getWeight() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==1) {
					int from = islandMap[i][j];
					
					for (int d = 0; d < 4; d++) {
						int nowi=i;
						int nowj=j;
						int depth=0;
						int to=0;
						
						while(true) {
							int nexti = nowi + di[d];
							int nextj = nowj + dj[d];
							depth++;
							
							if (nexti < 0 || nextj < 0 || nexti >= N || nextj >= M) {
								break;
							}
							
							if(map[nexti][nextj]==1) {
								to = islandMap[nexti][nextj];
								if(to==from) {
									break;
								}
								if(depth-1>1) {
									if(adjMatrix[from][to]==0) {
										adjMatrix[from][to]=depth-1;
									}else {
										if(depth-1<adjMatrix[from][to]) {
											adjMatrix[from][to]=depth-1;
										}
									}									
								}
								break;
							}
							
							nowi= nexti;
							nowj= nextj;
						}
					}

				}
			}
		}
	}
	
	static void divide(){
		boolean[][] visited = new boolean[N][M];
		islandNum=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					islandNum++;
					dfs(i,j,visited);
				}
			}
		}
	}
	
	static void dfs(int nowi,int nowj,boolean[][] visited) {
		visited[nowi][nowj] = true;
		islandMap[nowi][nowj] = islandNum;
		
		for(int d=0;d<4;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<0 || nextj<0 || nexti>=N || nextj>=M || visited[nexti][nextj] || map[nexti][nextj]==0) {
				continue;
			}
			dfs(nexti,nextj,visited);
		}
	}

}
