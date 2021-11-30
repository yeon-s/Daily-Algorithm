package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea_1861_정사각형방 {

	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int cnt;
	static int N;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			int[] arr = new int[(N*N)+1];
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//입력 끝
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					cnt=0;
					int num = map[i][j];
					dfs(i,j,num);
					arr[num] = cnt;
				}
			}
			
			int max=0;
			for(int i=1;i<arr.length;i++) {
				max = Math.max(max, arr[i]);
			}
			
			
			int index =0;
			for(int i=1;i<arr.length;i++) {
				if(arr[i]==max) {
					index=i;
					break;
				}
			}
			System.out.println("#"+tc+" "+index+" "+max);
		}
	}

	static void dfs(int nowi,int nowj,int num) {
		cnt++;
		for(int d=0;d<4;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<0 || nextj<0 || nexti>=N || nextj >=N) {
				continue;
			}
			if(num+1==map[nexti][nextj]) {
				dfs(nexti,nextj,num+1);
			}
		}
	}
}
