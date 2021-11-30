package practice;

import java.util.LinkedList;
import java.util.Scanner;

public class Boj_17827_달팽이리스트_시간초과 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		//링크드리스트 생성
		LinkedList<Node> list = new LinkedList<>();
		//첫번째 노드 추가
		list.add(new Node(sc.nextInt(),null));
		//두번째 노드부터 마지막 노드까지 추가
		for(int i=1;i<N;i++) {
			list.add(new Node(sc.nextInt(), null));
			list.get(i-1).link =list.get(i);
		}
		
		//마지막 노드 링크에 V번째 노드 연결 
		list.getLast().link = list.get(V-1);
		//명령어 저장할 배열
		int[] arr = new int[M];
		for(int i=0;i<M;i++) {
			arr[i] = sc.nextInt();
		}
		
		
		for (int i = 0; i < M; i++) {
			Node current = list.get(0);
			while (arr[i]-- > 0) {
				current = current.link;
			}
			System.out.println(current.data);
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
