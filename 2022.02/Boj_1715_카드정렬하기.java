package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Boj_1715_카드정렬하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		//입력 끝
		
		int sum=0;
		
		if(N==1) {
			System.out.println(0);
			return;
		}
		
		while(true) {
			
			int one = pq.poll();
			int two = pq.poll();
			
			int num=one+two;
			sum+=num;
			if(pq.isEmpty()) {
				break;
			}
			pq.offer(num);
		}
		System.out.println(sum);
	}

}
