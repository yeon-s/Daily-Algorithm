package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2174_로봇시뮬레이션 {

	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[B][A];	//로봇번호 저장
		Robot[] arr = new Robot[N+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			int d = change(c);
			map[B-y][x-1] = i;
			arr[i] = new Robot(d, B-y, x-1);
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			int cnt = Integer.parseInt(st.nextToken());
			
			if(c=='F') {
				int si = arr[number].i;
				int sj = arr[number].j;
				int nexti = arr[number].i;
				int nextj = arr[number].j;
				int d = arr[number].d;
				while(cnt-->0) {	
					nexti +=di[d];
					nextj +=dj[d];
					if(nexti<0 || nextj<0 || nexti>=B || nextj>=A) {
						System.out.println("Robot "+number+" crashes into the wall");
						return;
					}
					if(map[nexti][nextj]!=0) {
						System.out.println("Robot "+number+" crashes into robot "+map[nexti][nextj]);
						return;
					}
					
				}
				Robot robot = arr[number];
				robot.i=nexti;
				robot.j=nextj;
				map[nexti][nextj]=number;
				map[si][sj]=0;
				
			}else {
				cnt%=4;
				Robot r = arr[number];
				if(c=='L') {
					int d= r.d-cnt;
					if(d<0) {
						d+=4;
					}
					r.d=d;
				}else {
					int d = r.d+cnt;
					if(d>3) {
						d-=4;
					}
					r.d=d;
				}
			}
		}
		System.out.println("OK");

	}
	
	static int change(char c) {
		int num=-1;
		switch(c) {
		case 'N':
			num=0;
			break;
		case 'E':
			num=1;
			break;
		case 'S':
			num=2;
			break;
		case 'W':
			num=3;
			break;
		}
		return num;
	}
	
	static class Robot{
		int d;
		int i;
		int j;
		public Robot(int d, int i, int j) {
			super();
			this.d = d;
			this.i = i;
			this.j = j;
		}
		
	}

}
