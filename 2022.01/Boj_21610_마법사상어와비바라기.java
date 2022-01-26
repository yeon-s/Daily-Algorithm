package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_21610_마법사상어와비바라기 {

	static int[] di = {0,0,-1,-1,-1,0,1,1,1};
	static int[] dj = {0,-1,-1,0,1,1,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		
		boolean[][] check = new boolean[N][N];
		
		List<cloud> list = new ArrayList<>();
		list.add(new cloud(N-1, 0));
		list.add(new cloud(N-1, 1));
		list.add(new cloud(N-2, 0));
		list.add(new cloud(N-2, 1));
		
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			//구름 이동
			for(int i=0;i<list.size();i++) {
				int nowi = list.get(i).i;
				int nowj = list.get(i).j;
				
				int nexti = nowi+(di[d]*s);
				int nextj = nowj+(dj[d]*s);
				
				if(nexti>=N) {
					nexti = nexti%N;
				}else if(nexti<0) {
					nexti = N-(Math.abs(nexti)%N);
					if(nexti==N) {
						nexti=0;
					}
				}  
				if(nextj>=N) {
					nextj = nextj%N;
				}else if(nextj<0) {
					nextj = N-(Math.abs(nextj)%N);
					if(nextj==N) {
						nextj=0;
					}
				}
				
				check[nexti][nextj]=true;
				map[nexti][nextj]++;
				list.get(i).i=nexti;
				list.get(i).j=nextj;
			}
			
			//4.
			for(int i=0;i<list.size();i++) {
				int num=0;
				int nowi = list.get(i).i;
				int nowj = list.get(i).j;
				
				for(int dd=2;dd<=8;dd=dd+2) {
					int nexti = nowi+di[dd];
					int nextj = nowj+dj[dd];
					if(nexti<0 || nextj<0 || nexti>=N || nextj>=N) {
						continue;
					}
					if(map[nexti][nextj]>0) {
						num++;
					}
				}
				
				map[nowi][nowj]+=num;
			}
			
			list.clear();
			//5.
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]>=2 && !check[i][j]) {
						list.add(new cloud(i, j));
						map[i][j]-=2;
					}
				}
			}
			
			check = new boolean[N][N];
		}
		
		int answer=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				answer+=map[i][j];
			}
		}
		System.out.println(answer);
		
	}
	
	static class cloud{
		int i;
		int j;
		public cloud(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
	}

}
