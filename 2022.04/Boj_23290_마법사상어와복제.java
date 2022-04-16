package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_23290_마법사상어와복제 {

	static int sharki;
	static int sharkj;
	static int[] di = {0,-1,-1,-1,0,1,1,1};
	static int[] dj = {-1,-1,0,1,1,1,0,-1};
	static int[] si = {0,-1,0,1,0};
	static int[] sj = {0,0,-1,0,1};
	static List<Fish> fishList;
	static List<Fish> copyList;
	static int[][] smell;
	static int[][] map;		//칸에 물고기 몇마리있는지
	static boolean[][] visited;
	static int max;
	static int[] temp;
	static int[] result;
	static ArrayList<Fish>[][] fish;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		sharki = 0;
		sharkj = 0;
		fishList = new ArrayList<>();
		copyList = new ArrayList<>();
		smell = new int[4][4];
		map = new int[4][4];
		fish = new ArrayList[4][4];
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				fish[i][j] = new ArrayList<>();
			}
		}
		
		for(int k=0;k<M;k++) {
			st = new StringTokenizer(br.readLine());
			int i= Integer.parseInt(st.nextToken())-1;
			int j= Integer.parseInt(st.nextToken())-1;
			int d= Integer.parseInt(st.nextToken())-1;
			//fishList.add(new Fish(i, j, d));
			fish[i][j].add(new Fish(i, j, d));
			map[i][j]++;
		}
		
		st = new StringTokenizer(br.readLine());
		sharki= Integer.parseInt(st.nextToken())-1;
		sharkj= Integer.parseInt(st.nextToken())-1;
		
		while(S-->0) {
			//1.복제 시전
			copy();
			//2.물고기 이동
			fishMove();
			//System.out.println(Arrays.deepToString(map));
//			for(Fish f:fishList) {
//				System.out.println(f.i+" "+f.j+" "+f.d);
//			}
			//3.상어 이동
			sharkMove();
			//System.out.println(sharki+" "+sharkj);
			//4.냄새배열 순회
			decreaseSmell();
			//5.복제된 애들 격자 투입
			add();
			//System.out.println(Arrays.deepToString(map));
			
		}
		int answer=0;
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				answer+=fish[i][j].size();
			}
		}
		System.out.println(answer);
		
	}
	
	static void add() {
		for(Fish f:copyList) {
			map[f.i][f.j]++;
			fish[f.i][f.j].add(new Fish(f.i, f.j, f.d));
			//fishList.add(new Fish(f.i,f.j,f.d));
		}
	}
	
	static void decreaseSmell() {
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(smell[i][j]>0) {
					smell[i][j]--;
				}
			}
		}
	}
	
	static void sharkMove() {
		
		max=-1;
		temp = new int[3];
		result = new int[3];
		//Arrays.fill(result, 1);
		perm(0);
		
		
		int starti = sharki;
		int startj = sharkj;
		
		for(int i=0;i<3;i++) {
			int d = result[i];
			sharki+=si[d];
			sharkj+=sj[d];
			
			if(fish[sharki][sharkj].size()>0) {
				fish[sharki][sharkj].clear();
				smell[sharki][sharkj]=3;
				map[sharki][sharkj]=0;
			}
		}
		
	}
	
	static void perm(int cnt) {
		if(cnt==3) {
			visited = new boolean[4][4];
			int tempi = sharki;
			int tempj = sharkj;
			int num=0;
			
			for(int i=0;i<3;i++) {
				tempi+=si[temp[i]];
				tempj+=sj[temp[i]];
				
				if(out(tempi,tempj)) {
					return;
				}
				
				if(!visited[tempi][tempj]) {
					num+=map[tempi][tempj];
				}
				visited[tempi][tempj]=true;
			}
			
			if(max<num) {
				max=num;
				result[0]=temp[0];
				result[1]=temp[1];
				result[2]=temp[2];
			}
			return;
		}
		
		for(int i=1;i<5;i++) {
			
			temp[cnt]=i;
			perm(cnt+1);
		}
		
	}
	
	static void fishMove() {
		
		ArrayList<Fish>[][] temp;
		temp = new ArrayList[4][4];
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				temp[i][j] = new ArrayList<>();
			}
		}
		
		for(int k=0;k<4;k++) {
			for(int j=0;j<4;j++) {
				
				for(Fish f:fish[k][j]) {
					int fishi = f.i;
					int fishj = f.j;
					int d = f.d;
					boolean flag=false;
					for(int i=0;i<8;i++) {
						
						int nexti = fishi + di[d];
						int nextj = fishj + dj[d];
						
						if(out(nexti,nextj) || (nexti==sharki && nextj==sharkj) || smell[nexti][nextj]>0) {		//이동불가
							d--;
							if(d<0) {
								d=7;
							}
						}else {		//이동가능
							map[fishi][fishj]--;
							
							map[nexti][nextj]++;
							temp[nexti][nextj].add(new Fish(nexti, nextj, d));
							flag=true;
							break;
						}
					}
					if(!flag) {
						temp[k][j].add(new Fish(fishi, fishj, d));
					}
				}
			}
		}
		fish=temp;
	}
	
	static boolean out(int nexti,int nextj) {
		
		if(nexti<0 || nextj<0 || nexti>=4 || nextj>=4) {
			return true;
		}
		return false;
	}
	
	static void copy() {
		copyList.clear();
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
//				if(fish[i][j].size()==0) {
//					continue;
//				}
				for(Fish f: fish[i][j]) {
					copyList.add(new Fish(f.i, f.j, f.d));
				}
			}
		}
	}
	
	static class Fish{
		int i;
		int j;
		int d;
		public Fish(int i, int j, int d) {
			super();
			this.i = i;
			this.j = j;
			this.d = d;
		}
		
	}

}
