package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1303_전쟁 {

	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static boolean[][] visited;
	static int N;
	static int M;
	static char[][] map;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[M][N];
		
		for(int i=0;i<M;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		//입력 끝
		visited = new boolean[M][N];
		cnt = 0;		//집합 각각의 수 저장할 변수
		int resultW =0;		//흰색 위력(답)
		int resultB =0;		//블루 위력(답)
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j] && map[i][j] =='W') {		//맵 모두 탐색하면서 방문 안했고 흰색이면
					cnt = 0;								//집합 초기화
					dfs(i,j,'W');							//흰색 매개변수로 주면서 탐색
					resultW += cnt*cnt;						//위력 더해주기
				}
				else if(!visited[i][j] && map[i][j] =='B') {	//맵 모두 탐색하면서 방문 안했고 블루면
					cnt=0;
					dfs(i,j,'B');
					resultB += cnt*cnt;
				}
			}
		}
		System.out.println(resultW+" "+resultB);
	}

	 static void dfs(int nowi,int nowj,char C) {
		 visited[nowi][nowj] = true;			 	//방문체크
		 cnt++;							//나라개수 더해주기
		 for(int d=0;d<4;d++) {
			 int nexti = nowi+di[d];
			 int nextj = nowj+dj[d];
			 
			 if(nexti<0 || nextj<0 || nexti>=M || nextj >=N) {
				 continue;
			 }
			 if(!visited[nexti][nextj] && map[nexti][nextj] == C) {		//매개변수로 받은 나라면 계속 탐색 이어가기
				 dfs(nexti,nextj,C);				 
			 }
		 }
	 }
}
