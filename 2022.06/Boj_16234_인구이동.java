package repeat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_16234_인구이동 {

	static boolean[][] visited;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int N,L,R;
	static int[][] map;
	static int[][] check;
	static int cnt,sum,num;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		L= Integer.parseInt(st.nextToken());
		R= Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		int day =0 ;
		while(true) {
			check = new int[N][N];
			num=1;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(check[i][j]==0) {
						cnt=0;
						sum=0;
						dfs(i,j);
						cal();
						num++;
					}
				}
			}
			if(num==(N*N)+1) break;
			day++;
		}
		
		System.out.println(day);

	}
	
	static void cal() {
		if(cnt==1) return;
		int number = sum/cnt;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(check[i][j]==num) {
					map[i][j]=number;
				}
			}
		}
	}
	
	static void dfs(int nowi,int nowj) {
		check[nowi][nowj]=num;
		cnt++;
		sum+=map[nowi][nowj];
		
		for(int d=0;d<4;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<0 || nextj<0 || nexti>=N || nextj>=N || check[nexti][nextj]!=0 || 
					Math.abs(map[nowi][nowj]-map[nexti][nextj])<L || Math.abs(map[nowi][nowj]-map[nexti][nextj])>R) {
				continue;
			}
			dfs(nexti,nextj);
		}
	}

}
