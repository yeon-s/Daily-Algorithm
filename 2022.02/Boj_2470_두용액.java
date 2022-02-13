package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_2470_두용액 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer[] arr = new Integer[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<Integer>() {
			
			public int compare(Integer o1,Integer o2) {
				return Math.abs(o1)-Math.abs(o2);
			}

		});
		
		PriorityQueue<store> pq = new PriorityQueue<>();
		
		for(int i=0;i<N-1;i++) {
			pq.offer(new store(arr[i]+arr[i+1], arr[i], arr[i+1]));
		}
		
		store s = pq.poll();
		
		int one = s.one;
		int two = s.two;
		
		if(one<=two) {
			System.out.println(one);
			System.out.println(two);
		}else {
			System.out.println(two);
			System.out.println(one);
		}
		
	}
	
	static class store implements Comparable<store>{
		int num;
		int one;
		int two;
		public store(int num, int one, int two) {
			super();
			this.num = num;
			this.one = one;
			this.two = two;
		}
		@Override
		public int compareTo(store o) {
			if(Math.abs(this.num)<Math.abs(o.num)) {
				return -1;
			}else {
				return 1;
			}
		}
		
		
	}

}
