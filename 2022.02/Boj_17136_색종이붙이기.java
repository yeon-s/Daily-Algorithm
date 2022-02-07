package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_17136_색종이붙이기 {

	static int[][] map;
	static int answer;
	static boolean flag;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[10][10];
		for(int i=0;i<10;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<10;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		
		answer=200;
		flag=false;
		arr = new int[6];
		Arrays.fill(arr, 5);
		dfs(0,0,0);
		if(answer==200) {
			System.out.println(-1);
		}else {
			System.out.println(answer);			
		}
	}
	
	static void dfs(int nowi,int nowj,int cnt) {
		if(cnt>answer) {
			return;
		}
		
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(map[i][j]==1) {
					for(int k=5;k>=1;k--) {
						if(check(i,j,k) && arr[k]>0) {
							change(i,j,0,k);
							arr[k]--;
							dfs(i,j,cnt+1);
							change(i,j,1,k);
							arr[k]++;
						}
					}
					return;
				}
			}
		}
		
//		if(fin()) {
			answer = Math.min(answer, cnt);
//		}
		return;
	}
	
	static boolean fin() {
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(map[i][j]==1) {
					return false;
				}
			}
		}
		return true;
	}
	
	static void change(int nowi,int nowj,int num,int size) {
		
		for(int i=nowi;i<nowi+size;i++) {
			for(int j=nowj;j<nowj+size;j++) {
				map[i][j]=num;
			}
		}
	}
	
	static boolean check(int nowi,int nowj,int size) {
		
		for(int i=nowi;i<nowi+size;i++) {
			for(int j=nowj;j<nowj+size;j++) {
				if(i>=10 || j>=10 || map[i][j]==0) {
					return false;
				}
			}
		}
		return true;
	}

}
