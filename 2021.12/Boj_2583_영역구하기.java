package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_2583_영역구하기 {

	static boolean[][] map;
	static int M;
	static int N;
	static int[] di= {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int boundary;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new boolean[M][N];
		for(int k=0;k<K;k++) {
			st = new StringTokenizer(br.readLine());
			int sj = Integer.parseInt(st.nextToken());
			int si = Integer.parseInt(st.nextToken());
			int ej = Integer.parseInt(st.nextToken());
			int ei = Integer.parseInt(st.nextToken());
			for(int i=si;i<ei;i++) {
				for(int j=sj;j<ej;j++) {
					map[i][j] = true;
				}
			}
		}
		//입력 끝
		
		int count = 0;
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(!map[i][j]) {
					count++;
					boundary=0;
					dfs(i,j);
					list.add(boundary);
				}
			}
		}
		
		Collections.sort(list);
		
		System.out.println(count);
		for(int b:list) {
			System.out.print(b+" ");
		}
		
	}
	
	static void dfs(int nowi,int nowj) {
		map[nowi][nowj] = true;
		boundary++;
		
		for(int d=0;d<4;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<0 || nextj<0 || nexti>=M || nextj>=N || map[nexti][nextj]) {
				continue;
			}
			dfs(nexti,nextj);
		}
	}

}
