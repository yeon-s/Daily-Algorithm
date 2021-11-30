package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_17827_달팽이리스트1_버퍼드리더 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		//링크드리스트 생성
		LinkedList<Node> list = new LinkedList<>();
//		ArrayList<Node> list = new ArrayList<>();
		//첫번째 노드 추가
		StringTokenizer str = new StringTokenizer(br.readLine());
		list.add(new Node(Integer.parseInt(str.nextToken()),null));
		//두번째 노드부터 마지막 노드까지 추가
		for(int i=1;i<N;i++) {
			list.add(new Node(Integer.parseInt(str.nextToken()), null));
			list.get(i-1).link =list.get(i);
		}
		
		//마지막 노드 링크에 V번째 노드 연결 
		list.getLast().link = list.get(V-1);
//		list.get(list.size()-1).link = list.get(V-1);
		//명령어 저장할 배열
		int[] arr = new int[M];
		for(int i=0;i<M;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		
		for (int i = 0; i < M; i++) {
			Node current = list.get(0);
			while (arr[i]-- > 0) {
				current = current.link;
			}
			sb.append(current.data+"").append("\n");
			
		}
		System.out.print(sb);
	
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
	static class SinglyLinkedList{
		private Node head;
		
		public void addFirst(int data) {
			Node newNode = new Node(data, head);
			head = newNode;
		}
		
		public Node getLastNode() {
			for(Node cur=head;cur!=null;cur = cur.link) {
				if(cur.link==null) {
					return cur;
				}
			}
			return null;
		}
		
		public void addLast(int data) {
			
			if(head==null) {
				addFirst(data);
				return;
			}
			
			Node lastNode = getLastNode();
			Node newNode = new Node(data, null);
			lastNode.link = newNode;
			
		}
	}
}
