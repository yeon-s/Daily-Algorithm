package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1210_사다리 {

	static int[] di = {0,0,-1};			//밑에서부터 위로 찾아가므로 아래방향은 없음
	static int[] dj = {-1,1,0};
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1;tc<=10;tc++) {
			int T = Integer.parseInt(br.readLine());
			
			int nowi=-1;
			int nowj=-1;
			
			map = new int[100][100];
			for(int i=0;i<100;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<100;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==2) {			//출발하는 곳
						nowi =i;
						nowj = j;
					}
				}
			}
			
			boolean[][] visited = new boolean[100][100];		//방문체크
			
			while(true) {
				if(nowi==0) {					//i가 0이면 도착이므로 break;
					break;
				}
				visited[nowi][nowj] = true;
				
				int nexti = -1;
				int nextj = -1;
				
				for(int d=0;d<3;d++) {					//위랑 좌우 살피기
					nexti = nowi+di[d];
					nextj = nowj+dj[d];
					
					if(nexti<0 || nextj<0 || nexti>=100 || nextj>=100) {			//배열범위 벗어나면 컨티뉴
						continue;
					}
					
					if(!visited[nexti][nextj] &&map[nexti][nextj]==1 ) {			//방문하지 않았고 갈수있다면 방향탐색마치기
						break;
					}
				}
				
				nowi = nexti;				//다음위치로
				nowj = nextj;
			}
			System.out.println("#"+tc+" "+nowj);
		}

	}
}
