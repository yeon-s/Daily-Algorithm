package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_15686_치킨배달 {

	static int N;
	static int M;
	static int[][] map;
	static int num;
	static List<Point> list;
	static Point[] result;
	static int mind;
	static int totald;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		list = new ArrayList<>();
		num = 0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					list.add(new Point(i, j));
					num++;
				}
			}
		}
		
		result = new Point[M];
		//입력 끝
		
		answer = Integer.MAX_VALUE;
		comb(0,0);
		System.out.println(answer);
		
		
	}
	
	static void comb(int start,int cnt) {
		if(cnt==M) {
			totald=0;
			calculate();
			answer = Math.min(answer, totald);
			return;
		}
		
		for(int i=start;i<num;i++) {
			result[cnt] = list.get(i);
			comb(i+1,cnt+1);
		}
	}
	
	static void calculate() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1) {
					mind = Integer.MAX_VALUE;
					for(int k=0;k<M;k++) {
						mind = Math.min(mind, Math.abs(result[k].i-i)+Math.abs(result[k].j-j));
					}
					totald+=mind;
				}
			}
		}
	}
	
	
	static class Point{
		int i;
		int j;
		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
		
	}
	
	

}
