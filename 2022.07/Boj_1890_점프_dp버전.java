package repeat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1890_점프_dp버전 {

	static long[][] D;
	static int[][] map;
	static int N;
	static int[] di = {1,0};
	static int[] dj = {0,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		D = new long[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		D[0][0]=1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(D[i][j]==0 || map[i][j]==0) continue;
				if(i+map[i][j]<N) D[i+map[i][j]][j] +=D[i][j];
				if(j+map[i][j]<N) D[i][j+map[i][j]]+=D[i][j];
			}
		}
		
		System.out.println(D[N-1][N-1]);
	}

}
