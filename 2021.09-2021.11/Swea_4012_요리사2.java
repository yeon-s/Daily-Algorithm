package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_4012_요리사2 {

	static int N;
	static int R;
	static int[][] map;
	static boolean[] isSelected;
	static int A;
	static int B;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//입력 끝
			
			R=N/2;
			isSelected= new boolean[N];
			min=Integer.MAX_VALUE;
			comb(0,0);
			System.out.println("#"+tc+" "+min);
		}
	}
	
	static void comb(int cnt,int target) {
		if(cnt==R) {
			A=0;
			B=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(isSelected[i] && isSelected[j]) {
						A+=map[i][j];
					}else if(!isSelected[i] && !isSelected[j]) {
						B+=map[i][j];
					}
				}
			}
			min = Math.min(min, Math.abs(A-B));
			return;
		}
		if(target==N) {
			return;
		}
		
		
		isSelected[target] = true;
		comb(cnt+1,target+1);
		isSelected[target] = false;
		comb(cnt,target+1);
	}

}
