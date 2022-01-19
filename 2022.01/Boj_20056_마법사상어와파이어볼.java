package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_20056_마법사상어와파이어볼 {

	static int N;
	static List<Fire>[][] map;
	static List<Fire>[][] copy;
	static int[] di = {-1,-1,0,1,1,1,0,-1};
	static int[] dj = {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[N+1][N+1];
		copy = new ArrayList[N+1][N+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				map[i][j] = new ArrayList<>();
				copy[i][j] = new ArrayList<>();
			}
		}

		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int r= Integer.parseInt(st.nextToken());
			int c= Integer.parseInt(st.nextToken());
			int m= Integer.parseInt(st.nextToken());
			int s= Integer.parseInt(st.nextToken());
			int d= Integer.parseInt(st.nextToken());
			map[r][c].add(new Fire(r, c, m, s, d));
		}
		//입력 끝
		
		while(K-->0) {
			move();
			sumAndDivide();
//			map = copy;
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					map[i][j].clear();
//					for(Fire f:copy[i][j]) {
//						map[i][j].add(new Fire(f.r, f.c, f.m, f.s, f.d));
//					}
					map[i][j] = copy[i][j];
					copy[i][j] = new ArrayList<>();
				}
			}
		}
		
		int answer =0;
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				int size = map[i][j].size();
				for(int k=0;k<size;k++) {
					answer+= map[i][j].get(k).m;
				}
			}
		}
		System.out.println(answer);

	}
	
	static void sumAndDivide() {
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				int size = copy[i][j].size();
				if(size>=2) {
					int sumM=0;		//합쳐진 질량
					int sumS=0;		//합쳐진 속력
					boolean flag=true;		//방향정하기
					
					for(int k=0;k<size;k++) {
						sumM += copy[i][j].get(k).m;
						sumS += copy[i][j].get(k).s;
						if(k>=1) {
							int beforeD =copy[i][j].get(k-1).d;
							int nowD = copy[i][j].get(k).d;
							if((beforeD%2==1 && nowD%2==0) || (beforeD%2==0 && nowD%2==1)) {
								flag=false;
							}
						}
					}
					copy[i][j].clear();
					//계산해서 4개 넣기
					//나눠진 질량이 0이면 안넣기
					if(sumM/5==0) {
						continue;
					}
					int what = 0;
					if(!flag) {
						what=1;
					}
					while(what<8) {
						copy[i][j].add(new Fire(i, j, sumM/5, sumS/size, what));
						what+=2;
					}
				}
			}
		}
	}
	
	static void move() {
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				int size = map[i][j].size();
				for(int k=0;k<size;k++) {
					int d = map[i][j].get(k).d;
					int s = map[i][j].get(k).s;
					int m = map[i][j].get(k).m;
					//마이너스 처리도 해줘야함
					int tmp = s%N;
					int tempi = i+di[d]*tmp;
					int tempj = j+dj[d]*tmp;
					if(tempi<1) {
						tempi +=N;
					}else if(tempi>N) {
						tempi -=N;
					}
					if(tempj<1) {
						tempj +=N;
					}else if(tempj>N) {
						tempj -=N;
					}
					
					copy[tempi][tempj].add(new Fire(tempi, tempj, m, s, d));
				}
			}
		}
	}
	
	static class Fire{
		int r;
		int c;
		int m;
		int s;
		int d;
		public Fire(int r, int c, int m, int s, int d) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
		
	}

}
