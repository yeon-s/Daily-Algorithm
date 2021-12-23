package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14890_경사로 {

	static int answer;
	static int N;
	static int L;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		answer=0;
		for(int i=0;i<N;i++) {
			if(isPossible1(i)) {
				answer++;
			}
		}
		for(int j=0;j<N;j++) {
			if(isPossible2(j)) {
				answer++;
			}
		}
		
		System.out.println(answer);
		
	}
	
	static boolean isPossible1(int i) {
		int num = map[i][0];
		int count=0;
		
		for(int j=0;j<N;j++) {
			if(num!=map[i][j]) {
				if( (map[i][j]>num && count<L) || Math.abs(num-map[i][j])>1 || (map[i][j]<num && count<0)) {
					return false;
				}
				if(map[i][j]>num) {
					count=0;
				}else if(map[i][j]<num) {
					count=0;
					count -=L;
					
				}
				num=map[i][j];
			}
			count++;
		}
		
		if(count<0) {
			return false;
		}
		
		return true;
	}
	
	static boolean isPossible2(int j) {
		int num = map[0][j];
		int count=0;
		
		for(int i=0;i<N;i++) {
			if(num!=map[i][j]) {
				if( (map[i][j]>num && count<L) || Math.abs(num-map[i][j])>1 || (map[i][j]<num && count<0)) {
					return false;
				}
				if(map[i][j]>num) {
					count=0;
				}else if(map[i][j]<num) {
					count=0;
					count -=L;
					
				}
				num=map[i][j];
			}
			count++;
		}
		
		if(count<0) {
			return false;
		}
		
		return true;
	}

}
