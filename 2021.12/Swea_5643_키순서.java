package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_5643_키순서 {

	static int N;
	static boolean[][] adjMatrix;
	static boolean[] visited;
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N  = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			adjMatrix = new boolean[N+1][N+1];
			
			for(int i=0;i<M;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				adjMatrix[from][to] = true; 
			}
			
			int answer=0;
			for(int i=1;i<=N;i++) {
				visited = new boolean[N+1];
				count=0;
				//앞에있는 애 숫자 구하기
				dfsFront(i);
				//뒤에 있는 애 숫자 구하기
				dfsBack(i);
				//더해서 N-1이면 answer++;
				if(count-1==N) {
					answer++;
				}
			}
			
			System.out.println("#"+tc+" "+answer);
					
		}

	}
	
	static void dfsFront(int current) {
		visited[current] = true;
		count++;
		
		for(int i=1;i<=N;i++) {
			if(!visited[i] && adjMatrix[current][i]) {
				dfsFront(i);
			}
		}
	}
	
	static void dfsBack(int current) {
		visited[current] = true;
		count++;
		
		for(int i=1;i<=N;i++) {
			if(!visited[i] && adjMatrix[i][current]) {
				dfsBack(i);
			}
		}
	}

}
