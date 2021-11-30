package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1247_최적경로 {

	static int N;
	static Point[] arr;
	static boolean[] isSelected;
	static Point[] result;
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
			result = new Point[N];
			min = Integer.MAX_VALUE;
			perm(0);
			System.out.println("#"+tc+" "+min);
		}
		

	}
	
	static void perm(int cnt) {
		if(cnt==N) {
			int distance = 0;
			distance += (Math.abs(result[0].i-start.i)+Math.abs(result[0].j-start.j));
			
			for(int i=1;i<N;i++) {
				distance += (Math.abs(result[i].i-result[i-1].i)+Math.abs(result[i].j-result[i-1].j));
			}
			
			distance += (Math.abs(result[N-1].i-end.i)+Math.abs(result[N-1].j-end.j));
			min = Math.min(min, distance);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(isSelected[i]) {
				continue;
			}
			
			isSelected[i] = true;
			result[cnt] = arr[i];
			perm(cnt+1);
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
