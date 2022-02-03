package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1405_미친로봇 {

	static boolean[][] visited;
	static int N;
	static int[] direction;
	static int[][] map;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static double sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		direction = new int[4];
		for(int i=0;i<4;i++) {
			direction[i]=Integer.parseInt(st.nextToken());
		}
		//입려 끝
		
		sum=0;
		map = new int[50][50];
		visited = new boolean[50][50];
		visited[25][25]=true;
		
		
		dfs(25,25,1,0);
		System.out.println(sum);
	}
	
	static void dfs(int nowi,int nowj,double prob,int depth) {
		if(depth==N) {
			sum+=prob;
			return;
		}
		visited[nowi][nowj]=true;
		
		for(int d=0;d<4;d++) {
			if(direction[d]==0) {
				continue;
			}
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(!visited[nexti][nextj]) {
				dfs(nexti,nextj,prob*(double)direction[d]/100,depth+1);
				visited[nexti][nextj]=false;
			}
		}
	}

}
