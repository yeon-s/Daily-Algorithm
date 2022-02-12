package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_20058_마법사상어와파이어스톰 {

	static int num;
	static int[][] map;
	static int[][] temp;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int max;
	static boolean[][] visited;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int size = 1<<N;
		map = new int[size][size];
		
		for(int i=0;i<size;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<size;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int[] stage = new int[Q];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<Q;i++) {
			stage[i]=Integer.parseInt(st.nextToken());
		}
		//입력 끝
		int index=0;
		while(Q-->0) {
			num = 1<<stage[index++];
			
			temp = new int[size][size];
			divide(0,0,size);
			map=temp;
			
			check(size);
		}
		
		int answer = 0;
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				answer+=map[i][j];
			}
		}
		System.out.println(answer);
		
		max=0;
		visited =new boolean[size][size];
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(!visited[i][j] && map[i][j]>0) {
					cnt=0;
					dfs(i,j,size);
					max = Math.max(max, cnt);
				}
			}
		}
		
		System.out.println(max);
	}
	
	static void dfs(int nowi,int nowj,int size) {
		visited[nowi][nowj]=true;
		cnt++;
		for(int d=0;d<4;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<0 || nextj<0 || nexti>=size || nextj>=size || visited[nexti][nextj] || map[nexti][nextj]==0) {
				continue;
			}
			dfs(nexti,nextj,size);
		}
	}
	
	static void check(int size) {
		boolean[][] map2 = new boolean[size][size];
		
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				int cnt=0;
				for(int d=0;d<4;d++) {
					int nexti = i+di[d];
					int nextj = j+dj[d];
					
					if(nexti<0 || nextj<0 || nexti>=size || nextj>=size || map[nexti][nextj]==0) {
						continue;
					}
					cnt++;	//얼음 있는 칸
				}
				
				if(cnt<3) {
					map2[i][j]=true;
				}
			}
		}
		
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(map2[i][j] && map[i][j]>0) {
					map[i][j]--;
				}
			}
		}
	}
	
	static void divide(int si,int sj,int size) {
		if(size==num) {
			//회전
			rotate(si,sj,size);
			return;
		}
		
		size=size/2;
		
		divide(si,sj,size);
		divide(si,sj+size,size);
		divide(si+size,sj,size);
		divide(si+size,sj+size,size);
		
	}
	
	static void rotate(int si,int sj,int size) {
		
		
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				temp[j+si][sj+size-1-i]=map[i+si][j+sj];
			}
		}
		
	}

}
