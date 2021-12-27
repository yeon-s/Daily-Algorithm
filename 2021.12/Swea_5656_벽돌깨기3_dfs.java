package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Swea_5656_벽돌깨기3_dfs {

	static int N;
	static int W;
	static int H;
	static int[][] map;
	static int[] result;
	static int[][] copy;
	static boolean[][] visited;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static Stack<Integer> stack;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			map = new int[H][W];
			for(int i=0;i<H;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//입력 끝
			
			result = new int[N];
			stack = new Stack<>();
			min = 400;
			comb(0);
			
			System.out.println("#"+tc+" "+min);
		}

	}
	
	static void comb(int cnt) {
		if(cnt==N) {
			copy = new int[H][W];
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					copy[i][j]=map[i][j];
				}
			}
			
			simul();
			min = Math.min(min, count());
			
			return;
		}
		
		for(int i=0;i<W;i++) {
			result[cnt] = i;
			comb(cnt+1);
		}
		
	}
	
	static void simul() {

		for(int i=0;i<N;i++) {			//구슬 하나씩 쏘기
			int nowj = result[i];
			int nowi = 0;
			visited = new boolean[H][W];
			boolean flag = true;
			
			while(true) {
				if(copy[nowi][nowj]!=0) {
					break;
				}
				if(nowi==H-1) {
					flag=false;
					break;
				}
				nowi+=1;
			}
			if(!flag) {
				continue;
			}
			
			//터지고
			bomb(nowi,nowj,copy[nowi][nowj]);
			//지우고
			delete();
			//내리고
			down();
		}
	}
	
	static void bomb(int si,int sj,int power) {
		visited[si][sj]= true;
		if(power==1) {
			return;
		}
		for(int d=0;d<4;d++) {
			int nowi = si;
			int nowj = sj;
			int num = power;
			while(num-->1) {
				int nexti = nowi+di[d];
				int nextj = nowj+dj[d];
				
				if(nexti<0 || nextj<0 || nexti>=H || nextj>=W) {
					break;
				}
				
				if(!visited[nexti][nextj]) {
					bomb(nexti,nextj,copy[nexti][nextj]);
				}
				nowi=nexti;
				nowj=nextj;
			}
			
			
		}
		
	}
	
	static void delete() {
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				if(visited[i][j]) {
					copy[i][j]=0;
				}
			}
		}
	}
	
	static void down() {
		for(int j=0;j<W;j++) {
			for(int i=0;i<H;i++) {
				if(copy[i][j]>0) {
					stack.push(copy[i][j]);
					copy[i][j]=0;
				}
			}
			
			for(int i=H-1;i>=0;i--) {
				if(!stack.isEmpty()) {
					copy[i][j] = stack.pop();
				}else {
					break;
				}
			}
		}
	}
	
	static int count() {
		int count=0;
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				if(copy[i][j]>0) {
					count++;
				}
			}
		}
		return count;
	}
	
	static class Point{
		int i;
		int j;
		int weight;
		public Point(int i, int j, int weight) {
			super();
			this.i = i;
			this.j = j;
			this.weight = weight;
		}
		
	}
}
