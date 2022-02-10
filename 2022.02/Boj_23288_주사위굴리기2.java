package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_23288_주사위굴리기2 {

	static int[] di = {0,1,0,-1};
	static int[] dj = {1,0,-1,0};
	static int cnt;
	static boolean[][] visited;
	static int N;
	static int M;
	static int[][] map;
	static int[] arr;
	static int d;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		
		arr = new int[]{1,5,3,2,4,6};		//초기 주사위
		d=0;		//초기 방향
		int nowi=0;
		int nowj=0;
		int answer=0;
		
		while(K-->0) {
			
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<0 || nextj<0 || nexti>=N || nextj>=M) {
				d+=2;
				if(d>3) {
					d-=4;
				}
			}
			nowi = nowi+di[d];
			nowj = nowj+dj[d];
			
			//점수 획득
			cnt=0;
			visited = new boolean[N][M];
			int arriveScore = map[nowi][nowj];
			dfs(nowi,nowj,arriveScore);
			answer+= arriveScore*cnt;
			
			//주사위 바꿔주기
			change();
			
			int under = arr[5];
			if(under>arriveScore) {
				d++;
				if(d>3) {
					d=0;
				}
			}else if(under<arriveScore) {
				d--;
				if(d<0) {
					d=3;
				}
			}
		}
		System.out.println(answer);
	}
	
	static void change() {
		int[] temp = new int[6];
		
		switch(d) {
		case 0:
			temp[0]=arr[4];
			temp[1]=arr[1];
			temp[2]=arr[0];
			temp[3]=arr[3];
			temp[4]=arr[5];
			temp[5]=arr[2];
			break;
		case 1:
			temp[0]=arr[3];
			temp[1]=arr[0];
			temp[2]=arr[2];
			temp[3]=arr[5];
			temp[4]=arr[4];
			temp[5]=arr[1];
			break;
		case 2:
			temp[0]=arr[2];
			temp[1]=arr[1];
			temp[2]=arr[5];
			temp[3]=arr[3];
			temp[4]=arr[0];
			temp[5]=arr[4];
			break;
		case 3:
			temp[0]=arr[1];
			temp[1]=arr[5];
			temp[2]=arr[2];
			temp[3]=arr[0];
			temp[4]=arr[4];
			temp[5]=arr[3];
			break;
		}
		
		arr =temp;
	}
	
	static void dfs(int nowi,int nowj,int num) {
		visited[nowi][nowj]=true;
		cnt++;
		
		for(int d=0;d<4;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<0 || nextj<0 || nexti>=N || nextj>=M || visited[nexti][nextj] || map[nexti][nextj] !=num) {
				continue;
			}
			dfs(nexti,nextj,num);
		}
	}

}
