package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_18111_마인크래프트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		int max = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]>max) {
					max=map[i][j];
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		int answer=0;
		while(max>=0) {
			//블록 놓는 것 가능한지 확인
			int temp = B;
			int time=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]>max) {
						int num = map[i][j]-max;
						temp+=num;
						time+=2*num;
					}else if(map[i][j]==max){
						continue;
					}else {
						int num = max-map[i][j];
						temp-=num;
						time+=1*num;
					}
				}
			}
			
			if(temp<0) {
				max--;
				continue;
			}
			
			if(min>time) {
				min=time;
				answer=max;
			}
			max--;
		}
		
		System.out.println(min+" "+answer);
		
	}
}
