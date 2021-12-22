package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17144_미세먼지안녕 {

	static int R;
	static int C;
	static int[][] map;
	static int[] di= {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	static int[][] temp;
	static int airConditioner;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		airConditioner=0;		//공기청정기의 i 위치   j는 0
		map = new int[R][C];
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0;j<C;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) {
					airConditioner = i;
				}
			}
		}
		//입력 끝
		
		while(T-->0) {
			//1.미세먼지 확산
				spread();
				update();
			//2.공기청정기 작동
				implement1(airConditioner-1,0);
				implement2(airConditioner,0);
		}
		
		int sum = 0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				sum+=map[i][j];
			}
		}
		sum +=2;
		System.out.println(sum);

	}
	
	static void implement1(int si, int sj) {
		int nowi = si;
		int nowj = sj;
		int cnt = ((C-1)*2)+(si*2);
		int d=0;
		while(cnt-->0) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<0 || nextj<0 || nexti>si || nextj>=C) {
				d++;
				nexti = nowi+di[d];
				nextj = nowj+dj[d];
			}
			map[nowi][nowj] = map[nexti][nextj];
			nowi=nexti;
			nowj=nextj;
		}
		map[si][sj]=-1;
		map[si][sj+1]=0;
	}
	
	static void implement2(int si, int sj) {
		int nowi = si;
		int nowj = sj;
		int cnt = ((C-1)*2)+((R-si-1)*2);
		int d=2;
		while(cnt-->0) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<si || nextj<0 || nexti>=R || nextj>=C) {
				d--;
				if(d<0) {
					d=3;
				}
				nexti = nowi+di[d];
				nextj = nowj+dj[d];
			}
			map[nowi][nowj] = map[nexti][nextj];
			nowi=nexti;
			nowj=nextj;
		}
		map[si][sj]=-1;
		map[si][sj+1]=0;
	}
	
	static void spread() {
		temp = new int[R][C];
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j] != -1 && map[i][j] != 0) {
					int num = map[i][j];
					int cnt = 0;
					for(int d=0;d<4;d++) {
						int nexti = i+di[d];
						int nextj = j+dj[d];
						
						if(nexti<0 || nextj<0 || nexti>=R || nextj>=C || map[nexti][nextj]==-1) {
							continue;
						}
						temp[nexti][nextj] += num/5;
						cnt++;
					}
					map[i][j] = num-((num/5)*cnt); 
				}
			}
		}
	}
	
	static void update() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				map[i][j] += temp[i][j];
			}
		}
	}

}
