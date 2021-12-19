package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
//차례대로 방향 정해서 뻗을 수 있으면 뻗고 안되면 선택안하고 다음거로 넘어가기(코어,전선확인 다함)
public class Swea_1767_프로세서연결하기2 {

	static int num;
	static List<Core> cores;
	static int N;
	static int[][] map;
	static int[][] copy;
	static int[] di= {-1,1,0,0};
	static int[] dj= {0,0,-1,1};
	static int max;
	static List<Integer> sumLine;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T =Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			cores = new ArrayList<>();		//가장자리가 아닌 코어들
			
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==1 && i!=0 && i !=N-1 && j !=0 && j!=N-1) {		//가장자리가 아니면
						cores.add(new Core(i, j, 0));
					}
				}
			}
			//입력 끝
			num = cores.size(); 		//가장자리가 아닌 코어들 개수
			max=0;
			sumLine= new ArrayList<>();
			
			perm(0,0);
			Collections.sort(sumLine);
			System.out.println("#"+tc+" "+sumLine.get(0));
			
		}
	}
	static void perm(int cnt,int sum) {
		if(sum+num-cnt<max) {
			return;
		}
		
		if(cnt==num) {
			int connectSum=getLineSum();
			if(sum>max) {
				max= sum;
				sumLine.clear();
				sumLine.add(connectSum);
			}else if(sum==max) {
				sumLine.add(connectSum);
			}
			return;
		}

		for(int d=0;d<4;d++) {
			cores.get(cnt).d=d;
			if(check(cnt)) {
				proceed(cnt,2);
				perm(cnt+1,sum+1);
				proceed(cnt,0);
			}
		}
		perm(cnt+1,sum);
	}
	
	private static int getLineSum() {
		int sum=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==2) {
					sum++;
				}
			}
		}
		return sum;
	}

	static void proceed(int i,int change) {
		int nowi = cores.get(i).i;
		int nowj = cores.get(i).j;
		int d = cores.get(i).d;
		
		while(true) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			if(nexti<0 || nextj<0 || nexti>=N || nextj>=N) {
				break;
			}
			map[nexti][nextj]=change;
			nowi=nexti;
			nowj=nextj;
		}
	}
	
	static boolean check(int i) {
		boolean flag= true;
		int nowi = cores.get(i).i;
		int nowj = cores.get(i).j;
		int d = cores.get(i).d;
		while(true) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			if(nexti<0 || nextj<0 || nexti>=N || nextj>=N) {
				break;
			}
			if(map[nexti][nextj]==1 || map[nexti][nextj]==2) {
				flag=false;
				break;
			}
			nowi=nexti;
			nowj=nextj;
		}
		return flag;
	}
	
	static class Core{
		int i;
		int j;
		int d;
		public Core(int i, int j, int d) {
			super();
			this.i = i;
			this.j = j;
			this.d = d;
		}
		
	}
}
