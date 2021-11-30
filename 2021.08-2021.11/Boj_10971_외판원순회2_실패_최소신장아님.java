package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_10971_외판원순회2_실패_최소신장아님 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] adjMatrix = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		int[] minEdge = new int[N];
		boolean[] visited = new boolean[N];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[1]=0;
		
		int result =0;
		//방문순서 저장할 배열
		int[] sequence = new int[N];
		
		
		for(int i=0;i<N;i++) {
			int current = -1;
			int min = Integer.MAX_VALUE;
			for(int j=0;j<N;j++) {
				if(!visited[j] && min>minEdge[j]) {
					min = minEdge[j];
					current = j;
				}
			}
			visited[current] = true;
			sequence[i] = current;
			result += min;
			//추가된 정점 기준으로 최소거리 갱신
			for(int j=0;j<N;j++) {
				if(!visited[j] && adjMatrix[current][j] !=0 && minEdge[j]>adjMatrix[current][j]) {
					minEdge[j]=adjMatrix[current][j];
					
				}
			}
		}
		System.out.println(Arrays.toString(sequence));
		//result += adjMatrix[sequence[N-1]][1];
		System.out.println(result);
	}

}
