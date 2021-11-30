package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14503_로봇청소기 {

	static int[] di= {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	static boolean[][] visited;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int nowi = Integer.parseInt(st.nextToken());
		int nowj = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		
		visited = new boolean[N][M];
		answer=0;
		
		while(true) {		//1번
			
			if(!visited[nowi][nowj]) {		//후진해서 온놈 때문에
				visited[nowi][nowj] = true;			
				answer++;
			}
			boolean flag = false;
			
			for(int i=0;i<4;i++) {			//2번
				int check = d;
				check--;
				if(check<0) {
					check=3;
				}
				int nexti = nowi+di[check];
				int nextj = nowj+dj[check];
				if(nexti>=0 && nextj>=0 && nexti<N && nextj<M && map[nexti][nextj]==0 && !visited[nexti][nextj]) {
					nowi = nexti;
					nowj = nextj;
					d= check;
					flag = true;
					break;
				}else {
					d=check;
				}
			}
			
			if(!flag) {		//네방향 모두 청소됐거나 벽이면
				int check = d;
				if(check<2) {
					check+=4;
				}
				
				nowi = nowi+di[check-2];
				nowj = nowj+dj[check-2];
				if(nowi<0 || nowj<0 || nowi>=N || nowj>=M ||map[nowi][nowj]==1) {		//후진할 수 없다면
					break;
				}
			}
		}
		
		System.out.println(answer);
	}

}
