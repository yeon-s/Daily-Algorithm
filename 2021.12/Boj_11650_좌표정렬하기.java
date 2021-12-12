package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_11650_좌표정렬하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		Point[] arr = new Point[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(arr[i].x).append(" ").append(arr[i].y).append("\n");
		}
		System.out.println(sb);
	}
	
	static class Point implements Comparable<Point>{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Point o) {
			if(this.x<o.x) {
				return -1;
			}else if(this.x>o.x) {
				return 1;
			}
			return this.y-o.y;
		}
		
	}

}
