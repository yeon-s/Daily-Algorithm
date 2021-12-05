package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14889_스타트와링크 {

	static int N;
	static int[][] matrix;
	static boolean[] isSelected;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		matrix = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		
		isSelected = new boolean[N];
		min = Integer.MAX_VALUE;
		comb(0,0);
		System.out.println(min);

	}
	
	static void comb(int target,int cnt) {
		if(cnt==N/2) {
			int start=0;
			int link = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(isSelected[i] && isSelected[j]) {
						start+=matrix[i][j];
					}else if(!isSelected[i] && !isSelected[j]){
						link+=matrix[i][j];
					}
				}
			}
			
			min = Math.min(min, Math.abs(start-link));
			
			return;
		}
		if(target==N) {
			return;
		}
		
		isSelected[target] = true;
		comb(target+1,cnt+1);
		isSelected[target] = false;
		comb(target+1,cnt);
	}

}
