package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15661_링크와스타트 {

	static int N;
	static int[][] map;
	static boolean[] isSelected;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		
		isSelected = new boolean[N];
		min = Integer.MAX_VALUE;

		subset(0);
		System.out.println(min);
	}
	
	static void subset(int cnt) {
		if(cnt==N) {
			int start=0;
			int link =0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(isSelected[i] && isSelected[j]) {
						start+=map[i][j];
					}else if(!isSelected[i] && !isSelected[j]) {
						link+=map[i][j];
					}
				}
			}
			
			if(start==0 || link==0) {
				return;
			}
			min = Math.min(min, Math.abs(start-link));
			return;
		}
		
		isSelected[cnt] = true;
		subset(cnt+1);
		isSelected[cnt] = false;
		subset(cnt+1);
	}

}
