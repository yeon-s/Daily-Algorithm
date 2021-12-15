package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1251_하나로_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			
			Node[] islands = new Node[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			double[] minEdge = new double[N];
			boolean[] visited = new boolean[N];
			
			for(int i=0;i<N;i++) {
				islands[i] = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st2.nextToken()));
				minEdge[i] = Double.MAX_VALUE;
			}
			
			double E = Double.parseDouble(br.readLine());
			
			minEdge[0]=0;
			double result=0;
			
			for(int i=0;i<N;i++) {
				double min = Double.MAX_VALUE;
				int minVertex = -1;
				for(int j=0;j<N;j++) {
					if(!visited[j] && min>minEdge[j]) {
						min = minEdge[j];
						minVertex = j;
					}
				}
				
				result+=min;
				visited[minVertex]=true;
				
				int cx = islands[minVertex].x;
				int cy = islands[minVertex].y;
				for(int j=0;j<N;j++) {
					if(!visited[j] && minEdge[j] > Math.pow(Math.abs(islands[j].x-cx), 2)+Math.pow(Math.abs(islands[j].y-cy), 2) ) {
						minEdge[j] = Math.pow(Math.abs(islands[j].x-cx), 2)+Math.pow(Math.abs(islands[j].y-cy), 2);
					}
				}
				
			}
			System.out.println("#"+tc+" "+Math.round(result*E));
		}

	}
	
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}

}
