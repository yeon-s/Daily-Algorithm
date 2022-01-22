package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_21608_상어초등학교 {

	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int N;
	static int[][] map;
	static List<Integer>[] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		StringTokenizer st;
		list = new ArrayList[(N*N)+1];
		for(int i=1;i<list.length;i++) {
			list[i] = new ArrayList<>();
		}
		
		PriorityQueue<seat> pq = new PriorityQueue<>();
		
		for(int i=0;i<N*N;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());	//현재 학생
			
			for(int j=0;j<4;j++) {
				list[num].add(Integer.parseInt(st.nextToken()));
			}
			
			pq.clear();
			for(int n=0;n<N;n++) {
				for(int m=0;m<N;m++) {
					if(map[n][m]!=0) {
						continue;
					}
					
					int likeNum = find(n,m,0,num);
					int emptyNum = find(n,m,1,num);
					pq.offer(new seat(n, m, likeNum, emptyNum));
				}
			}
			seat s = pq.poll();
			map[s.i][s.j]=num;
		}
		
		int sum=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int likeNum = find(i,j,0,map[i][j]);
				if(likeNum==0) {
					continue;
				}
				sum+= Math.pow(10, likeNum-1);
			}
		}
		System.out.println(sum);
		
	}
	
	static int find(int nowi,int nowj,int type,int student) {
		int num=0;
		for(int d=0;d<4;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<0 || nextj<0 || nexti>=N || nextj>=N) {
				continue;
			}
			if(type==0) {
				for(int i=0;i<4;i++) {
					if(map[nexti][nextj]==list[student].get(i)) {
						num++;
					}
				}				
			}else {
				if(map[nexti][nextj]==0) {
					num++;
				}
			}
		}
		return num;
	}
	
	static class seat implements Comparable<seat>{
		int i;
		int j;
		int like;
		int empty;
		public seat(int i, int j, int like, int empty) {
			super();
			this.i = i;
			this.j = j;
			this.like = like;
			this.empty = empty;
		}
		@Override
		public int compareTo(seat o) {
			if(this.like!=o.like) {
				return o.like-this.like;
			}else if(this.empty!=o.empty) {
				return o.empty-this.empty;
			}else if(this.i !=o.i) {
				return this.i-o.i;
			}else {
				return this.j-o.j;
			}
		}
		
	}

}
