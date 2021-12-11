package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17143_낚시왕 {

	static int result;
	static Shark[][] copy;
	static int R;
	static int C;
	static Shark[][] map;
	static int[] di = {0,-1,1,0,0};
	static int[] dj = {0,0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());	//상어 수
		
		map = new Shark[R+1][C+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 
					new Shark(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		//입력 끝
		
		int time = 1;
		result=0;
		
		while(time<=C) {
			//1.가장 가까운 상어잡기
			for(int i=1;i<=R;i++) {
				if(map[i][time]!=null) {
					result+=map[i][time].z;
					map[i][time] = null;
					break;
				}
			}
			
			//2.상어 이동
			move();
			time++;
		}
		System.out.println(result);
	}
	
	static void move() {
		copy = new Shark[R+1][C+1];
		
		//이거 시간초과뜨면 리스트에 상어들 담아놓고 리스트돌면서 상어위치 바꾸자
		for(int i=1;i<=R;i++) {
			for(int j=1;j<=C;j++) {
				if(map[i][j] !=null) {
					Shark shark = map[i][j];
					int nexti = i+(di[shark.d]*shark.s);
					int nextj = j+(dj[shark.d]*shark.s);
					
					//위치 바꿔주기			
					if(nexti>R) {
						int num = (shark.s+i-1);
						int moc = (num-1)/(R-1);
						int nam = num%(R-1);
						if(moc%2==1) {
							shark.d = 1;
							nexti= R-nam;
							if(nam==0) {
								nexti=1;
							}
						}else {
							nexti = nam+1;	
							if(nam==0) {
								nexti=R;
							}
						}
					}
					if(nexti<1) {
						int num = (shark.s+R-i);
						int moc = (num-1)/(R-1);
						int nam = num%(R-1);
						if(moc%2==1) {
							shark.d = 2;
							nexti= nam+1;
							if(nam==0) {
								nexti=R;
							}
						}else {
							nexti = R-nam;
							if(nam==0) {
								nexti=1;
							}
						}
					}
					if(nextj>C) {
						int num = (shark.s+j-1);
						int moc = (num-1)/(C-1);
						int nam = num%(C-1);
						if(moc%2==1) {
							shark.d = 4;
							nextj= C-nam;
							if(nam==0) {
								nextj=1;
							}
						}else {
							nextj = nam+1;
							if(nam==0) {
								nextj=C;
							}
						}
						
					}
					if(nextj<1) {
						int num = (shark.s+C-j);
						int moc = (num-1)/(C-1);
						int nam = num%(C-1);
						if(moc%2==1) {
							shark.d = 3;
							nextj= nam+1;
							if(nam==0) {
								nextj=C;
							}
						}else {
							nextj = C-nam;
							if(nam==0) {
								nextj=1;
							}
						}
					}
						
					if(copy[nexti][nextj] !=null) {
						if(copy[nexti][nextj].z<shark.z) {
							copy[nexti][nextj] = new Shark(shark.s, shark.d, shark.z);
						}
					}else {
						copy[nexti][nextj] = new Shark(shark.s, shark.d, shark.z);						
					}
//					if(copy[nexti][nextj]==null || copy[nexti][nextj].z<shark.z) {
//						copy[nexti][nextj] = new Shark(shark.s, shark.d, shark.z);	
//					}
					map[i][j] = null;
				}
			}
		}
		map=copy;
	}
	
	static class Shark {
		int s;	//속력
		int d;	//방향
		int z;	//크기
		public Shark(int s, int d, int z) {
			super();
			this.s = s;
			this.d = d;
			this.z = z;
		}
		
	}

}
