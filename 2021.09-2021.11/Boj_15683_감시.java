package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_15683_감시 {

	static int R;
	static int[] result;
	static List<Cctv> list;
	static int N;
	static int M;
	static int[][] originMap;
	static int min;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();		//1,2,3,4번 cctv 담겨있는 리스트
		
		originMap = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				originMap[i][j] = Integer.parseInt(st.nextToken());
				if(originMap[i][j]==1 || originMap[i][j]==2 || originMap[i][j]==3 || originMap[i][j]==4) {
					list.add(new Cctv(i, j,originMap[i][j]));
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(originMap[i][j]==5) {
					simul(i,j,originMap,0);
					simul(i,j,originMap,1);
					simul(i,j,originMap,2);
					simul(i,j,originMap,3);
				}
			}
		}
		
		//입력 끝
		R = list.size();
		result = new int[R];
		min = 100;
		perm(0);
		System.out.println(min);
		
	}
	
	static void perm(int cnt) {
		if(cnt==R) {
			
			//1.맵 복사
			map = new int[N][M];
			for(int i =0;i<N;i++) {
				for(int j=0;j<M;j++) {
					map[i][j] = originMap[i][j];
				}
			}
			
			//2.복사된 맵에 구현해보기
			for(int i=0;i<R;i++) {		//cctv하나씩 꺼내서
				if(list.get(i).num==1) {
					simul(list.get(i).i,list.get(i).j,map,result[i]);
				}else if(list.get(i).num==2) {
					simul(list.get(i).i,list.get(i).j,map,result[i]);
					simul(list.get(i).i,list.get(i).j,map,result[i]+2);
				}else if(list.get(i).num==3) {
					simul(list.get(i).i,list.get(i).j,map,result[i]);
					simul(list.get(i).i,list.get(i).j,map,result[i]+1);
				}else if(list.get(i).num==4) {
					simul(list.get(i).i,list.get(i).j,map,result[i]);
					simul(list.get(i).i,list.get(i).j,map,result[i]+1);
					simul(list.get(i).i,list.get(i).j,map,result[i]+2);
				}
			}
			
			int sum=0;
			//3.0의개수 찾기(최소값 구해야함)
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]==0) {
						sum++;
					}
				}
			}
			min = Math.min(min, sum);
			
			return;
		}
		
		for(int i=0;i<4;i++) {
			
			result[cnt] = i;
			perm(cnt+1);
			
		}
	}
	
	static class Cctv{
		int i;
		int j;
		int num;
		public Cctv(int i, int j, int num) {
			super();
			this.i = i;
			this.j = j;
			this.num = num;
		}
		
		
	}
	
	static void simul(int si,int sj,int[][] map,int d){
		
		if(d>3) {
			d=d-4;
		}
		
		if (d == 0) {
			for (int j = sj; j >= 0; j--) {
				if (map[si][j] == 0) {
					map[si][j] = 8;
				} else if (map[si][j] == 6) {
					break;
				} else {
					continue;
				}
			}
		} else if (d == 1) {
			for (int i = si; i >= 0; i--) {
				if (map[i][sj] == 0) {
					map[i][sj] = 8;
				} else if (map[i][sj] == 6) {
					break;
				} else {
					continue;
				}
			}
		} else if (d == 2) {
			
			for (int j = sj; j < M; j++) {
				if (map[si][j] == 0) {
					map[si][j] = 8;
				} else if (map[si][j] == 6) {
					break;
				} else {
					continue;
				}
			}
		} else if (d == 3) {
			for (int i = si; i < N; i++) {
				if (map[i][sj] == 0) {
					map[i][sj] = 8;
				} else if (map[i][sj] == 6) {
					break;
				} else {
					continue;
				}
			}
		}
	}

}
