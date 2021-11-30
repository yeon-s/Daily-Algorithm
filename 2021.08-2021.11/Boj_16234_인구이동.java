package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16234_인구이동 {

	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int N;
	static int L;
	static int R;
	static int[][] population;
	static int union;
	static int sum;
	static Queue<Point> queue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		population = new int[N][N];				// 각각 나라 인구 
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				population[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		
		queue = new LinkedList<>();			//연합별로 인구수 갱신해줘야해서 필요
		boolean[][] visited = new boolean[N][N];		//방문체크
		int day =0;							//날짜 변수(답)
		
		for (int k = 0; k < 2000; k++) {		//날짜 증가
			boolean flag = false;				// 이 날에 인구이동이 있는지 체크할 불린변수
			visited = new boolean[N][N];		//새로운 날이 되면 방문체크 새로만들기
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {	//나라들 돌면서
					if (!visited[i][j]) {		//방문하지 않은 나라라면
						union = 0;				//연합인 나라 수 초기화
						sum = 0;				//연합인 나라 인구 합 초기화
						dfs(i, j, visited); 	// 연합찾기
						if (union >1) {			//연합인 나라수가 2이상이면 그날은 인구이동을 하니까(1이면 연합없이 각자 독고다이) 
							flag = true;		//인구이동 트루
						}
						int each = sum / union;		//연합인 나라 가각에 배치할 인구
						while (!queue.isEmpty()) {		//연합인 나라들 저장된 큐
							Point point = queue.poll();		
							population[point.i][point.j] = each; // 연합국 인구 갱신
						}
					}

				}
			}
			if(!flag) {				//이 날에 인구이동이 없었다면
				System.out.println(day);		//답 출력
				break;				
			}
			day++;
		}
		
		
		
	}
	
	static void dfs(int nowi,int nowj, boolean[][] visited) {			//연합찾기
			
		visited[nowi][nowj] = true;					//방문체크
		union++;								//연합증가
		sum += population[nowi][nowj];			//연합 인구 증가
		queue.offer(new Point(nowi, nowj));		//큐에 연합인 나라들 넣기
		for(int d=0;d<4;d++) {					//현재 나라에서 인접나라 보면서 연합되는지 체크
			int nexti = nowi+di[d];	
			int nextj = nowj+dj[d];
			
			if(nexti<0 || nextj <0 || nexti>=N || nextj >=N) {
				continue;
			}
			if(!visited[nexti][nextj] && Math.abs(population[nexti][nextj]-population[nowi][nowj])>=L && Math.abs(population[nexti][nextj]-population[nowi][nowj])<=R) {
				dfs(nexti,nextj,visited);
				//연합 가능하고 아직 방문 안한 나라라면 그 나라에서 계속 탐색하러 들어가기
			}
			
			
		}
		
		
	}
	
	static class Point{
		int i;
		int j;
		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
	}
	
}
