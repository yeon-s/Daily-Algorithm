package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17779_게리맨더링2 {

	static int[][] region;
	static int[][] map;
	static int N;
	static int[] di = {1,1,-1,-1};
	static int[] dj = {-1,1,1,-1};
	static boolean[][] visited;
	static int[] ni = {-1,1,0,0};
	static int[] nj = {0,0,-1,1};
	static int[] result = new int[6];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		region = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		
		int answer=Integer.MAX_VALUE;
		
		for(int i=1;i<=N-2;i++) {
			for(int j=2;j<=N-1;j++) {
				int x=i;
				int y=j;
				for(int a=1;a<=N-y;a++) {
					int d2=a;
					for(int b=1;b<=N-x-d2;b++) {
						int d1=b;
						if(d1>y-1) {
							continue;
						}
						
						region = new int[N+1][N+1];
						visited= new boolean[N+1][N+1];
						result = new int[6];
						//경계선 채우기
						fill(x,y,d2,d1);	//경계선				
						
						//1,2,3,4 구역 dfs로 채우기
						dfs(1,1,x,y,d1,d2);
						if(!visited[1][N]) {
							dfs(1,N,x,y,d1,d2);							
						}if(!visited[N][1]) {
							dfs(N,1,x,y,d1,d2);							
						}if(!visited[N][N]) {
							dfs(N,N,x,y,d1,d2);							
						}
						
						for(int n=1;n<=N;n++) {
							for(int m=1;m<=N;m++) {
								if(region[n][m]==5 || region[n][m]==0) {
									result[5]+=map[n][m];
								}
							}
						}
						
						//result 중 최대 최소 구하기
						int max=0;
						int min = Integer.MAX_VALUE;
						for(int k=1;k<=5;k++) {
							if(max<result[k]) {
								max = result[k];
							}
							if(min>result[k]) {
								min = result[k];
							}
						}
						
						answer = Math.min(answer, max-min);
					}
				}
			}
		}
		
		System.out.println(answer);
	}
	
	static void dfs(int nowi,int nowj,int x,int y,int d1,int d2) {
		visited[nowi][nowj]=true;
		if(nowi>=1 && nowi<x+d1 && nowj>=1 && nowj<=y) {
			region[nowi][nowj]=1;			
			result[1]+=map[nowi][nowj];
		}else if(nowi>=1 && nowi<=x+d2 && nowj>y && nowj<=N) {
			region[nowi][nowj]=2;
			result[2]+=map[nowi][nowj];
		}else if(nowi>=x+d1 && nowi<=N && nowj>=1 && nowj<y-d1+d2) {
			region[nowi][nowj]=3;
			result[3]+=map[nowi][nowj];
		}else if(nowi>x+d2 && nowi<=N && nowj>=y-d1+d2 && nowj<=N) {
			region[nowi][nowj]=4;
			result[4]+=map[nowi][nowj];
		}
		
		
		for(int d=0;d<4;d++) {
			int nexti = nowi+ni[d];
			int nextj = nowj+nj[d];
			
			if(nexti<1 || nextj<1 || nexti>N || nextj>N) {
				continue;
			}
			
			if(!visited[nexti][nextj] && region[nexti][nextj]==0) {
				dfs(nexti,nextj,x,y,d1,d2);
			}
		}
	}
	
	static void dfsFill() {
		
	}
	
	static void fill(int x,int y,int d2,int d1) {
		
		int num = (d1+d2)*2;
		int d=0;
		int cnt=0;
		while(cnt<num) {
			region[x][y] = 5;
			
			if(cnt==d1 || cnt==d1+d2 || cnt==d1+d2+d1) {
				d++;
			}
			x=x+di[d];
			y=y+dj[d];
			cnt++;
		}
	}

}
