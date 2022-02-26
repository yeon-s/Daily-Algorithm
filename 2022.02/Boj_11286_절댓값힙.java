package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Boj_11286_절댓값힙 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				int num1 = Math.abs(o1);
				int num2 = Math.abs(o2);
				
				if(num1==num2) {
					return o1-o2;
				}
				return num1-num2;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num!=0) {
				pq.offer(num);
			}else {
				if(pq.isEmpty()) {
					sb.append("0"+"\n");
					continue;
				}
				sb.append(pq.poll()+"\n");
			}
			
		}
		System.out.println(sb);
	}

}
