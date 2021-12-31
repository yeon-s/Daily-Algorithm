package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17471_게리맨더링 {

	static int N;
	static int[] population;
	static boolean[][] adjMatrix;
	static boolean[] isSelected;
	static boolean[] visited;
	static int populationSum;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		population = new int[N+1];
		populationSum=0;
		min = 10000;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			population[i] = Integer.parseInt(st.nextToken());
			populationSum+=population[i];
		}
		adjMatrix = new boolean[N+1][N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j=0;j<num;j++) {
				adjMatrix[i][Integer.parseInt(st.nextToken())] = true;
			}
			
		}
		//입력 끝
		isSelected = new boolean[N+1];
		subset(1,0,0);
		
		if(min==10000) {
			System.out.println(-1);
		}else {
			System.out.println(min);			
		}
	}
	
	static void subset(int cnt,int num,int sum) {
		if(cnt>N) {
			if(num==0 || num==N) {
				return;
			}
			
			//두 구역 각각 연결 가능한지 확인
			if(!simul()) {
				return;
			}
			
			min = Math.min(min, Math.abs(populationSum-sum-sum));
			return;
		}
		
		isSelected[cnt]=true;
		subset(cnt+1,num+1,sum+population[cnt]);
		isSelected[cnt]=false;
		subset(cnt+1,num,sum);
	}

	static boolean simul() {
		int start=0;
		for(int i =1;i<=N;i++) {
			if(isSelected[i]) {
				start=i;
				break;
			}
		}
		visited = new boolean[N+1];
		dfs1(start);
		
		for(int i=1;i<=N;i++) {
			if(visited[i] != isSelected[i]) {
				return false;
			}
		}
		
		start=0;
		for(int i =1;i<=N;i++) {
			if(!isSelected[i]) {
				start=i;
				break;
			}
		}
		visited = new boolean[N+1];
		dfs2(start);
		
		for(int i=1;i<=N;i++) {
			if(visited[i] == isSelected[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	static void dfs1(int current) {
		visited[current] = true;
		
		for(int i=1;i<=N;i++) {
			if(!visited[i] && adjMatrix[current][i] && isSelected[i]) {
				dfs1(i);
			}
		}
	}
	static void dfs2(int current) {
		visited[current] = true;
		
		for(int i=1;i<=N;i++) {
			if(!visited[i] && adjMatrix[current][i] && !isSelected[i]) {
				dfs2(i);
			}
		}
	}
}
