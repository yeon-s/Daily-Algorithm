package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_11651_좌표정렬하기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Point> pq = new PriorityQueue<>();
		StringTokenizer st = null;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		//입력 끝
		
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			sb.append(p.j+" "+p.i).append("\n");
		}
		System.out.println(sb);
		
	}
	
	static class Point implements Comparable<Point>{
		int j;
		int i;
		public Point(int j, int i) {
			super();
			this.j = j;
			this.i = i;
		}
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			if(this.i>o.i) {
				return 1;
			}else if(this.i==o.i) {
				if(this.j<o.j) {
					return -1;
				}
				return 1;
			}else {
				return -1;
			}
		}
		
	}

}
