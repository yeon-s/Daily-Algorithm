package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1780_종이의개수 {

	static int N;
	static int[][] map;
	static int[] result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		result = new int[3];		//-1,0,1 종이개수
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0,0,N);
		for(int i=0;i<3;i++) {
			System.out.println(result[i]);
		}

	}
	
	static void divide(int si,int sj,int N) {
		
		int sum=0;
		boolean flag = true;
		for(int i=si;i<si+N;i++) {
			for(int j=sj;j<sj+N;j++) {
				sum+=map[i][j];
				if(flag && sum!=0) {
					flag= false;
				}
			}
		}
		
		if(sum==(N*N)*-1) {
			result[0]++;
		}else if(sum==0 && flag) {
			result[1]++;
		}else if(sum==N*N) {
			result[2]++;
		}else {
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					divide(si+((N/3)*i),sj+((N/3)*j),N/3);
				}
			}
		}
	}

}
