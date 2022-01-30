package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_1967_트리의지름 {

	static int[][] D;
	static LinkedList<Node>[] adjList;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		adjList = new LinkedList[n+1];
		for(int i=1;i<=n;i++) {
			adjList[i] = new LinkedList<>();
		}
		StringTokenizer st;
		for(int i=0;i<n-1;i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[parent].add(new Node(child, weight));
		}
		//입력 끝
		
		D = new int[n+1][2];
		for(int i=1;i<=n;i++) {
			D[i][0]=-1;
			D[i][1]=-1;
		}
			
		dfs(1);
		int answer =0;
		for(int i=1;i<=n;i++) {
			answer = Math.max(answer, D[i][0]+D[i][1]);
		}
		System.out.println(answer);
	}
	
	static int dfs(int current) {
		if(D[current][0]!=-1 || D[current][1]!=-1) {	//방문했다면 -1은 아니니까 내 최대간선 리턴
			return D[current][0];	
		}
		
		D[current][0]=0;
		D[current][1]=0;
		for(Node n : adjList[current]) {		//내 자식들 돌면서 해당 자식의 가장 긴 간선 받고 내가 그 자식한테 가는 길이를 더해서 가장 큰값과 두번째 큰값 저장
			int num = dfs(n.vertex)+n.weight;
			if(num>=D[current][0]) {
				D[current][1]=D[current][0];
				D[current][0]=num;
			}else if(num>=D[current][1]) {
				D[current][1]=num;
			}
		}
		
		return D[current][0];		//가장 긴 간선 리턴
	}
	
	static class Node{
		int vertex;
		int weight;
		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}
		
	}

}
