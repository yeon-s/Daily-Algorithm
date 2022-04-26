package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_11497_통나무건너뛰기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return o2-o1;
				};
			}) ;
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				pq.offer(arr[i]);
			}
			
			int answer =1000000;
			int first =pq.poll();
			int temp1 = pq.poll();
			int temp2 = pq.poll();
			answer = Math.max(first-temp1, first-temp2);
			while(!pq.isEmpty()) {
				int one = pq.poll();
				answer = Math.max(answer, temp1-one);
				temp1=one;
				if(pq.isEmpty()) {
					break;
				}
				int two = pq.poll();
				answer = Math.max(answer, temp2-two);
				temp2=two;
			}
			
			answer = Math.max(Math.abs(temp2-temp1), answer);
			sb.append(answer+"\n");
			
		}
		System.out.println(sb);
	}

}
