package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17406_배열돌리기4 {

	static int N;
	static int M;
	static int K;
	static String[] result;
	static boolean[] isSelected;
	static String[] command;
	static int[][] map;
	static int[] di = {1,0,-1,0};
	static int[] dj = {0,1,0,-1};
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		command = new String[K];
		for(int i=0;i<K;i++) {
			command[i] = br.readLine();
		}
		//입력 끝
		result = new String[K];
		isSelected = new boolean[K];
		answer = Integer.MAX_VALUE;
		perm(0);
		
		System.out.println(answer);

	}
	
	static void perm(int cnt) {
		if(cnt==K) {
			rotate();
			return;
		}
		
		for(int i=0;i<K;i++) {
			if(isSelected[i]) {
				continue;
			}
			
			isSelected[i] = true;
			result[cnt] = command[i];
			perm(cnt+1);
			isSelected[i] =false;
		}
	}
	
	static void rotate() {
		int[][] copy = new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				copy[i][j] = map[i][j];
			}
		}
		
		//회전
		for(int i=0;i<K;i++) {
			StringTokenizer st = new StringTokenizer(result[i]);
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			int si= r-s;
			int sj = c-s;
			int ei = r+s;
			int ej = c+s;
			
			while(true) {	//전체 회전
				int temp = copy[si][sj];
				int num = ((((ei-si)+(ej-sj))*2)-1);
				
				int nowi = si;
				int nowj = sj;
				int d=0;
				
				while(num-->0) {	//한바퀴 회전
					
					int nexti = nowi+di[d];
					int nextj = nowj+dj[d];
					if(nexti>ei || nextj>ej || nexti<si || nextj<sj) {
						d++;
						nexti = nowi+di[d];
						nextj = nowj+dj[d];
					}
					copy[nowi][nowj] = copy[nexti][nextj];
					nowi = nexti;
					nowj = nextj;
				}
				copy[si][sj+1] = temp;	
				si +=1;
				sj +=1;
				ei -=1;
				ej-=1;
				if(ei-si<2 || ej-sj<2) {
					break;
				}
			}
			
		}
		
		int min = Integer.MAX_VALUE;
		
		for(int i=1;i<=N;i++) {
			int sum=0;
			for(int j=1;j<=M;j++) {
				sum +=copy[i][j];
			}
			min = Math.min(min, sum);
		}
		
		answer = Math.min(min, answer);
	}

}
