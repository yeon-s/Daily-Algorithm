package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10971_외판원순회2_dfs {

	static int N;
	static int[][] adjMatrix;
	static long min;
	static int last;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		adjMatrix = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());			//인접행렬
			}
		}
		//입력 끝
		
		min = Long.MAX_VALUE;				//모든 정점에서 출발해보고 최소값 갱신해야하므로 밖에서 선언 
		
		for(int i=0;i<N;i++) {				//출발점에 따라 거리비용 달라지므로 모든 정점에서 출발해보기
			boolean[] visited = new boolean[N];			//visited 새로 만들어주고
			last = -1;							//마지막 정점도 초기화 해주고
			dfs(i,i,visited,0,0);				//dfs 보내기
		}
		
			System.out.println(min);
	}
	
	static void dfs(int start,int current,boolean[] visited,int sum,int depth) {
		if(sum>min) {					//가지치기	 합이 최소값 넘어가면 앞으로 확인할 필요 없으므로 return
			return;
		}
		visited[current] = true;		//방문도장찍기
		if(depth==N-1) {				//마지막 정점 도착하면
			last = current;				//마지막 정점 저장하고
			if(adjMatrix[last][start] !=0) {		//마지막에서 처음노드로 갈수 있는지 보고
				sum += adjMatrix[last][start];		//갈수 있으면 비용 더하기
			}else {									//마지막에서 처음노드로 못가면
				return;								//빽
			}
			min = Math.min(min, sum);				//최소값 갱신
			return;									//빽해서 다른 길도 확인
		}
		
		for(int i=0;i<N;i++) {						
			if(!visited[i] && adjMatrix[current][i] !=0) {			//아직 방문 안했고 갈수 있는 정점 탐색
				dfs(start,i,visited,sum+adjMatrix[current][i],depth+1);		//dfs보내기
				visited[i]=false;											//어딘가에서 빽해서 왔으면 방금 왔던데 방문기록 지우기
			}
		}
	}
}
