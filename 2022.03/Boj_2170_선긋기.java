package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_2170_선긋기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Number> pq = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.offer(new Number(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Number first = pq.poll();
		int min = first.min;
		int max = first.max;
		int sum=max-min;
		
		while(!pq.isEmpty()) {
			Number temp = pq.poll();
			int tempMin = temp.min;
			int tempMax = temp.max;
			
			if(tempMin<=max && tempMax<=max) {
				continue;
			}else if(tempMin<=max && tempMax>max) {
				sum+=tempMax-max;
				max= tempMax;
			}else if(tempMin>max) {
				min=tempMin;
				max=tempMax;
				sum+=max-min;
			}
		}
		
		System.out.println(sum);
		
	}
	
	static class Number implements Comparable<Number>{
		int min;
		int max;
		public Number(int min, int max) {
			super();
			this.min = min;
			this.max = max;
		}
		@Override
		public int compareTo(Number o) {
			if(this.min<o.min) {
				return -1;
			}else {
				return 1;
			}
		}
		
	}

}
