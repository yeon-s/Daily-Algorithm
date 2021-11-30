package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_16926_배열돌리기1 {

	static int[] di = {0,1,0,-1};
	static int[] dj = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		
		int min = Math.min(N, M);
		min = min/2;
		
		while(R-->0) {

			for (int k = 0; k < min; k++) {		//k는 돌려야하는 줄 개수
				int temp = map[k][k];			//임시로 저장할 첫번째

				int nowi = k;
				int nowj = k;
				int d = 0;
				for (int i = 0; i < 2 * (N - (2*k)-1) + 2 * (M - (2*k)-1); i++) {
					int nexti = nowi + di[d];
					int nextj = nowj + dj[d];
					if (nexti < k || nextj < k || nexti >= N - k || nextj >= M - k) {
						d++;
						if (d > 3) {
							d = 0;
						}
						nexti = nowi + di[d];
						nextj = nowj + dj[d];
					}

					map[nowi][nowj] = map[nexti][nextj];
					nowi= nexti;
					nowj = nextj;
				}
				
				map[k+1][k] =temp;
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
