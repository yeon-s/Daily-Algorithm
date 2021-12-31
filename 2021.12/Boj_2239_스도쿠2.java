package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Boj_2239_스도쿠2 {

	static int[][] map;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[9][9];
		for(int i=0;i<9;i++) {
			String str = br.readLine();
			for(int j=0;j<9;j++) {
				map[i][j] = (int)(str.charAt(j)-'0');
			}
		}
		//입력 끝
		dfs();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
	static void dfs() {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(map[i][j]==0) {
					for(int k=1;k<=9;k++) {
						if(check(i,j,k) && squareCheck(i,j,k)) {
							map[i][j]=k;							
							dfs();
							if(flag) {
								return;
							}
						}
					}
					map[i][j]=0;
					return;
				}
			}
		}
		flag=true;
		return;
	}
	
	static boolean check(int nowi,int nowj,int num) {
		for(int j=0;j<9;j++) {
			if(map[nowi][j]==num || map[j][nowj]==num ) {
				return false;
			}
		}
		return true;
	}
	
	static boolean squareCheck(int nowi,int nowj,int num) {
		int numi = (nowi/3)*3;
		int numj = (nowj/3)*3;
		for(int i=numi;i<numi+3;i++) {
			for(int j=numj;j<numj+3;j++) {
				if(map[i][j]==num ) {
					return false;
				}
			}
		}
		return true;
	}

}
