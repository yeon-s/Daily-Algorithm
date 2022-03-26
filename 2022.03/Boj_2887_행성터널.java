package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_2887_행성터널 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Node[] arr = new Node[N];
		LinkedList<Point>[] adjList = new LinkedList[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Node(i,Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			adjList[i]= new LinkedList<>();
		}
		
		for(int i=0;i<3;i++) {
			if(i==0) {
				Arrays.sort(arr,new Comparator<Node>() {
					public int compare(Node o1, Node o2) {
						return o1.x-o2.x;
					}
				});
			}else if(i==1) {
				Arrays.sort(arr,new Comparator<Node>() {
					public int compare(Node o1, Node o2) {
						return o1.y-o2.y;
					}
				});
			}else if(i==2) {
				Arrays.sort(arr,new Comparator<Node>() {
					public int compare(Node o1, Node o2) {
						return o1.z-o2.z;
					}
				});
			}
			
			for(int j=0;j<N-1;j++) {
				if(i==0) {
					adjList[arr[j].num].add(new Point(arr[j+1].num,Math.abs(arr[j].x-arr[j+1].x)));
					adjList[arr[j+1].num].add(new Point(arr[j].num,Math.abs(arr[j].x-arr[j+1].x)));
				}else if(i==1) {
					adjList[arr[j].num].add(new Point(arr[j+1].num,Math.abs(arr[j].y-arr[j+1].y)));
					adjList[arr[j+1].num].add(new Point(arr[j].num,Math.abs(arr[j].y-arr[j+1].y)));
				}else {
					adjList[arr[j].num].add(new Point(arr[j+1].num,Math.abs(arr[j].z-arr[j+1].z)));
					adjList[arr[j+1].num].add(new Point(arr[j].num,Math.abs(arr[j].z-arr[j+1].z)));
				}
			}
		}
		
		PriorityQueue<Point> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N];
		long[] d = new long[N];
		Arrays.fill(d, Long.MAX_VALUE);
		long answer=0;
		pq.offer(new Point(0, 0));
		d[0]=0;
		
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
			
			if(visited[cur.vertex]) {
				continue;
			}
			
			visited[cur.vertex]=true;
			answer+=cur.weight;
			
			for(Point p:adjList[cur.vertex]) {
				if(!visited[p.vertex] && d[p.vertex]>p.weight) {
					d[p.vertex] = p.weight;
					pq.offer(new Point(p.vertex, p.weight));
				}
			}
		}

		System.out.println(answer);
	}
	
	static class Node{		//좌표
		int num;	//정점 번호
		int x;
		int y;
		int z;
		public Node(int num,int x, int y, int z) {
			
			super();
			this.num=num;
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
	}
	
	static class Point implements Comparable<Point>{
		int vertex;
		long weight;
		public Point(int vertex, long weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}
		@Override
		public int compareTo(Point o) {
			if(this.weight>o.weight) {
				return 1;
			}else {
				return -1;
			}
		}
		
	}

}
