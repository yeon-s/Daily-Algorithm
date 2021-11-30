package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_17827_달팽이리스트4_찐마지막 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<>();

		StringTokenizer str = new StringTokenizer(br.readLine());
		
		// 마지막 노드까지 추가
		for(int i=0;i<N;i++) {
			list.add(Integer.parseInt(str.nextToken()));
			
		}
		

		//명령어 저장할 배열
		int[] arr = new int[M];
		for(int i=0;i<M;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		
		for (int i = 0; i < M; i++) {
			if(arr[i]<N) {
				System.out.println(list.get(arr[i]));
				continue;
			}
				System.out.println(list.get(((arr[i]-N)%(N-V+1))+V-1));				
		}
	
	}
	
	static class Node {
		public int data;
		public Node link;
		public Node() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Node(int data, Node link) {
			super();
			this.data = data;
			this.link = link;
		}
		
	}
	
}
