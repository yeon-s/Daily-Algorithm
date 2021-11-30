package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1247_최적경로2_가지치기버전 {

	static int N;
	static Point[] arr;
	static boolean[] isSelected;
	static int min;
	static Point start;
	static Point end;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new Point[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			for(int i=0;i<N;i++) {
				arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			//입력 끝
			isSelected = new boolean[N];
			min = Integer.MAX_VALUE;
			perm(0,0,start);
			System.out.println("#"+tc+" "+min);
		}
		

	}
	
	static void perm(int cnt,int sum,Point before) {
		if(sum>=min) {
			return;
		}
		
		if(cnt==N) {
			sum += (Math.abs(before.i-end.i)+Math.abs(before.j-end.j));
			min = Math.min(min, sum);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(isSelected[i]) {
				continue;
			}
			
			isSelected[i] = true;
			int distance = (Math.abs(arr[i].i-before.i)+Math.abs(arr[i].j-before.j));
			perm(cnt+1,sum+distance,arr[i]);
			isSelected[i]=false;
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
