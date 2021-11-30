package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_17827_달팽이리스트2_규칙 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		//링크드리스트 생성
		List<Integer> list= new ArrayList<>();
		//첫번째 노드 추가
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		//두번째 노드부터 마지막 노드까지 추가
		for(int i=0;i<N;i++) {
			list.add(Integer.parseInt(str.nextToken()));
		}
		
		//마지막 노드 링크에 V번째 노드 연결 
		
		//명령어 저장할 배열
		int[] arr = new int[M];
		for(int i=0;i<M;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		
//		for (int i = 0; i < M; i++) {
//			Node current = list.get(0);
//			while (arr[i]-- > 0) {
//				current = current.link;
//			}
//			System.out.println(current.data);
//		}
		
		for (int i = 0; i < M; i++) {
			if(V==N) {
				System.out.println(list.get(N-1));
				continue;
			}
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
