package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Swea_1251_하나로_2_pq {

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
				islands[i] = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st2.nextToken()),0,i);
				minEdge[i] = Double.MAX_VALUE;
			}
			
			double E = Double.parseDouble(br.readLine());
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			
			minEdge[0]=0;
			pq.offer(new Node(islands[0].x, islands[0].y, 0,0));
			double result=0;
			
			while(!pq.isEmpty()) {
				Node curNode = pq.poll();
				int cx = curNode.x;
				int cy = curNode.y;
				double d = curNode.d;
				
				if(visited[curNode.index]) {
					continue;
				}
				
				result+=d;
				visited[curNode.index] = true;
				
				for(int i=0;i<N;i++) {
					if(!visited[i] && minEdge[i] > Math.pow(Math.abs(islands[i].x-cx), 2)+Math.pow(Math.abs(islands[i].y-cy), 2)) {
						minEdge[i] = Math.pow(Math.abs(islands[i].x-cx), 2)+Math.pow(Math.abs(islands[i].y-cy), 2);
						pq.offer(new Node(islands[i].x, islands[i].y, minEdge[i], i));
					}
				}
				
			}
			System.out.println("#"+tc+" "+Math.round(result*E));
		}

	}
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		double d;
		int index;
		public Node(int x, int y,double d,int index) {
			super();
			this.x = x;
			this.y = y;
			this.d=d;
			this.index=index;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if(this.d>o.d) {
				return 1;
			}else {
				return -1;
			}
		}
		
	}

}
