package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_9205_맥주마시면서걸어가기 {

	static int n;
	static Point[] arr;
	static Point home;
	static Point festival;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=t;tc++) {
			n = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			arr = new Point[n+1];
			for(int i=0;i<=n;i++) {
				st = new StringTokenizer(br.readLine());
				arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			festival = arr[n];
			
			if(bfs()) {
				sb.append("happy"+"\n");
			}else {
				sb.append("sad"+"\n");
			}
			
		}
		System.out.println(sb);
	}
	
	static boolean bfs() {
		Queue<Point> queue = new LinkedList<>();
		boolean[] visited = new boolean[n+1];
		
		queue.offer(home);
		
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			int nx = current.x;
			int ny = current.y;
			
			if(current.equals(festival)) {
				return true;
			}
			
			for(int i=0;i<=n;i++) {
				if(!visited[i] && (Math.abs(arr[i].x-nx)+Math.abs(arr[i].y-ny))<=1000) {
					queue.offer(arr[i]);
					visited[i]=true;
				}
			}
			
		}
		return false;
	}
	
	
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}

}
