package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_9663_NQueen {

	static boolean[] isSelected;
	static int N;
	static int count;
	static int[] result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		boolean[][] map = new boolean[N][N];
		isSelected = new boolean[N];
		count=0;
		result = new int[N];
		check(0);
		System.out.println(count);
	}
	
	static void check(int cnt) {
		
		if(cnt==N) {
			count++;
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(isSelected[i]) {
				continue;
			}
			result[cnt]=i;
			if(!available(cnt)) {
				continue;
			}
			isSelected[i] = true;
			check(cnt+1);
			isSelected[i] = false;
		}
	}
	
	
	static boolean available(int cnt) {
		for(int j=0;j<cnt;j++) {
			if(cnt-j==Math.abs(result[cnt]-result[j])) {
				return false;
			}
		}
		return true;
	}

}
