package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2098_외판원순회 {

	static int N;
	static int[][] adjMatrix;
	static int[][] D;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		adjMatrix = new int[N+1][N+1];
		D = new int[N+1][1<<N];
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		
		for(int i=1;i<=N;i++) {
			Arrays.fill(D[i], -1);
		}
		
		System.out.println(dfs(1,1));

	}
	
	static int dfs(int current,int visited) {
		//모든 도시 방문(모두 1)
		if(visited == (1<<N)-1) {		
			return adjMatrix[current][1]!=0 ? adjMatrix[current][1] : 1000000000;
		}
		
		//방문 한적 있으면 메모한거 리턴
		if(D[current][visited]!=-1) {
			return D[current][visited];
		}
		
		int ret = 1000000000;
		
		for(int i=1;i<=N;i++) {
			//방문하지 않았고 다음 노드 가는 길이 있으면
			if((visited & (1<<(i-1)))==0 && adjMatrix[current][i] !=0) {	
				int temp = dfs(i,visited+(1<<(i-1)))+adjMatrix[current][i];
				ret = Math.min(ret, temp);
			}
		}
		
		D[current][visited]=ret;
		return ret;
	}
	


}
