package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_3085_사탕게임 {

	static int[] di = {1,0};
	static int[] dj = {0,1};
	static int max = 0;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		char[][] map = new char[N][N];
		for(int i=0;i<N;i++) {
			String str= br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]= str.charAt(j);
			}
		}
		//입력 끝
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				change(i,j,map);
			}
		}
		
		
		System.out.println(max);
		
	}

	static void change(int nowi,int nowj,char[][] map) {
		
		
		for(int d=0;d<2;d++) {
			char origin = map[nowi][nowj];
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<0 || nextj<0 || nexti>=N || nextj>=N) {
				continue;
			}
			char next = map[nexti][nextj];
			map[nexti][nextj] = origin;
			map[nowi][nowj] = next;
			
			
			//개수 세기
			for(int i=0;i<N;i++) {
				char temp = map[i][0];
				int cnt =0;
				for(int j=0;j<N;j++) {
					if(map[i][j]==temp) {
						cnt++;
					}else {
						temp = map[i][j];
						cnt=1;
					}
					max = Math.max(cnt, max);
				}
			}
			
			for(int i=0;i<N;i++) {
				char temp = map[0][i];
				int cnt =0;
				for(int j=0;j<N;j++) {
					if(map[j][i]==temp) {
						cnt++;
					}else {
						temp = map[j][i];
						cnt=1;
					}
					max = Math.max(cnt, max);
				}
			}
			
			
			map[nexti][nextj] = next;
			map[nowi][nowj] = origin;
		}
	}
}
