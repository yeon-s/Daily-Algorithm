package practice;

import java.util.Scanner;

public class Swea_1251_하나로 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc=1;tc<=TC;tc++) {
			int N = sc.nextInt();
			
			island[] arr = new island[N];
			double[] minEdge = new double[N];
			
			for(int i=0;i<N;i++) {
				arr[i] = new island(sc.nextInt(), 0);
				minEdge[i] = Double.MAX_VALUE;
			}
			for(int i=0;i<N;i++) {
				arr[i].y = sc.nextInt();
			}
			
			double E = sc.nextDouble();
			//입력 끝
			
			boolean[] visited = new boolean[N];
			minEdge[0] = 0;
			long sum=0;
			
			
			for(int i=0;i<N;i++) {
				double min = Double.MAX_VALUE;
				int current = -1;
				
				//거리가 최소인 정점 찾기
				for(int j=0;j<N;j++) {
					if(!visited[j] && min>minEdge[j]) {
						min = minEdge[j];
						current = j;
					}
				}
				
				sum +=min;
				visited[current] = true;
				
				//현재 추가로 선택된 정점 기준으로 최소거리 업데이트
				for(int j=0;j<N;j++) {
					if(!visited[j] && minEdge[j]> (Math.pow(Math.abs(arr[current].y-arr[j].y), 2)+Math.pow(Math.abs(arr[current].x-arr[j].x), 2))) {
						minEdge[j] = (Math.pow(Math.abs(arr[current].y-arr[j].y), 2)+Math.pow(Math.abs(arr[current].x-arr[j].x), 2));
					}
				}
			}
			System.out.println("#"+tc+" "+Math.round((E*sum)));
		
			
		}
		
	}

	static class island{
		int x;
		int y;
		public island(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
